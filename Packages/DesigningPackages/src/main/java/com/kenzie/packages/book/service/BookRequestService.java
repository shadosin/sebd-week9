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

public class BookRequestService  {
    //debug flag turns on verbose console logging
    private static final boolean DEBUG = false;
    //base URL is set as constant
    public static final String GET_URL = "http://openlibrary.org/search.json";

    //Singleton instance - everyone uses the same logger
    public static Logger logger = Logger.getInstance();

    //takes in delimited requestString and formats and returns search string
    //search string contains "?" and is appended to the base GET_URL
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

    //takes in request string, string ISBN and list of subjects
    //returns a pipe-delimited response string
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
        if (responseCode == HttpURLConnection.HTTP_OK) { // success

            InputStreamReader inputReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferReader = new BufferedReader(inputReader);

            String responseLine;
            StringBuffer response = new StringBuffer();
            while ((responseLine = bufferReader.readLine()) != null) {
                response.append(responseLine);
            }
            bufferReader.close();
            // print result
            if (DEBUG) {
                System.out.println(response.toString());
            }
            //Parse out response
            ObjectMapper objectMapper = new ObjectMapper();
            //convert json string to object
            BookRequestDTO bookRequest = objectMapper.readValue(response.toString(), BookRequestDTO.class);

            if (DEBUG) {
                System.out.println("numFound");
                System.out.println(bookRequest.getNumFound());

                System.out.println("docs array");
                System.out.println(bookRequest.getDocs().toString());

            }

            String isbn = "";
            ArrayList<String> subjectList = new ArrayList<>();

            //total hack: the first element is a master record that is really long.
            //don't want it so starting index at 1
            for (int index = 1; index < bookRequest.getDocs().size(); index++) {
                //get current document
                DocumentDTO currentDoc = bookRequest.getDocs().get(index);
                if (currentDoc.getIsbn() != null && currentDoc.getSubject() != null) {
                    //this is a total hack for this assignment - just grabbing the first good response
                    isbn = currentDoc.getIsbn().get(0);
                    subjectList = (ArrayList<String>) currentDoc.getSubject();
                    break;
                }
            }
            //create response string. If nothing was found, the isbn and subjects are empty
            returnString = formatResponseString(requestString,isbn,subjectList);

        } else {
            System.out.println("GET request did not work");
        }

        return returnString;
    }
}
