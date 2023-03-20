package com.kenzie.packages.book.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

//import data transfer objects and logger
import com.kenzie.packages.book.model.*;
import com.kenzie.packages.logger.service.Logger;


/*
The Response String Format
title|author|isbn|[subject]

ex -
The Art of War|Sun Tzu|9781780282992|[Military art and science, early works to 1800]
 */


public class BookRequestService  {
    private static final boolean DEBUG = false;
    public static final String GET_URL = "http://openlibrary.org/search.json";

    public static Logger logger = Logger.getInstance();

    // Takes in delimited requestString and formats and returns search string
    // Search string contains "?" and is appended to the base GET_URL
    @org.jetbrains.annotations.NotNull
    public static String formatSearchString(String requestString) throws InvalidParameterException {
        try {
            String[] requestItems = requestString.split("\\|");
            if (requestItems.length < 2) {
                throw new Exception("Invalid format for requestString. Two elements required");
            } else if (requestItems[0] == "") {
                throw new Exception("Invalid format for requestString[0]. Title cannot be empty");
            } else if (requestItems[1] == "") {
                throw new Exception("Invalid format for requestString[1]. Author cannot be empty");
            } else {
                //replace all spaces in title and author with %20
                String title = requestItems[0].replaceAll("( )+", "%20");
                String author = requestItems[1].replaceAll("( )+", "%20");
                return "?q=" + title + "+" + author;
            }

        } catch (Exception e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }

    // Takes in request string, string ISBN and list of subjects
    // Returns a pipe-delimited response string
    public static String formatResponseString(String requestString,
                                              String isbn,
                                              ArrayList<String> subjectList) {

        String[] responseItems = new String[4];
        System.arraycopy(requestString.split("\\|"),0,responseItems,0,2);
        responseItems[2] = isbn;
        responseItems[3] = subjectList.toString();
        return String.join("|",responseItems);
    }

    public static String sendGetRequest(String requestString) throws IOException, InvalidParameterException {
        String returnString = null;
        String url = GET_URL + formatSearchString(requestString);
        URL URLobject = new URL(url);

        if(DEBUG){
            System.out.println(url);
        }

        HttpURLConnection connection = (HttpURLConnection) URLobject.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();

        logger.logMessage("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {

            InputStreamReader inputReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferReader = new BufferedReader(inputReader);

            String responseLine;
            StringBuffer response = new StringBuffer();
            while ((responseLine = bufferReader.readLine()) != null) {
                response.append(responseLine);
            }
            bufferReader.close();

            if (DEBUG) {
                System.out.println(response.toString());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            BookRequestDTO bookRequest = objectMapper.readValue(response.toString(), BookRequestDTO.class);

            if (DEBUG) {
                System.out.println("numFound");
                System.out.println(bookRequest.getNumFound());

                System.out.println("docs array");
                System.out.println(bookRequest.getDocs().toString());
            }

            String isbn = "";
            ArrayList<String> subjectList = new ArrayList<>();

            // Total hack: the first element is a master record that is really long.
            for (int index = 1; index < bookRequest.getDocs().size(); index++) {
                DocumentDTO currentDoc = bookRequest.getDocs().get(index);
                if (currentDoc.getIsbn() != null && currentDoc.getSubject() != null) {

                    // Just grabbing the first good response
                    isbn = currentDoc.getIsbn().get(0);
                    subjectList = (ArrayList<String>) currentDoc.getSubject();
                    break;
                }
            }

            returnString = formatResponseString(requestString,isbn,subjectList);

        } else {
            System.out.println("GET request did not work");
        }

        return returnString;
    }
}
