package com.kenzie.packages;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class BookUMLTest {

    public static final String FILE_NAME = "src/test/java/com/kenzie/packages/LibraryApplication.puml";
    public static String fileContents = "";

    @BeforeAll
    static void before() throws IOException {
        Path path = Path.of(FILE_NAME);
        fileContents = Files.readString(path);
        fileContents = fileContents.replaceAll("\\s+","").toLowerCase();
    }

    @Test
    @Order(1)
    void bookUML_File_Exists_In_TestDirectory() throws IOException {
        assertNotNull(fileContents,
                "File not found. Please ensure your file has not been moved from here -" + FILE_NAME);
    }

    @Test
    @Order(3)
    void bookUML_File_Book_Properties() throws Exception {
        String bookClass = getUMLClassChonk("book");

        assertTrue(bookClass.contains("#author:string"),
                "Your book class does not contain the necessary properties " + bookClass);
        assertTrue(bookClass.contains("#title:string"),
                "Your book class does not contain the necessary properties " + bookClass);
    }

    @Test
    @Order(4)
    void bookUML_File_Book_Constructors() throws Exception {
        String bookClass = getUMLClassChonk("book");

        assertTrue(bookClass.contains("+book()"),
                "Your book class does not contain necessary empty constructor " + bookClass);
        assertTrue(bookClass.contains("+book(title:string,author:string)"),
                "Your book class does not contain necessary constructor " + bookClass);
    }

    @Test
    @Order(4)
    void bookUML_File_Book_Methods() throws Exception {
        String bookClass = getUMLClassChonk("book");

        assertTrue(bookClass.contains("+setbookinfo(responsestring:string)"),
                "Your book class does not contain setBookInfo " + bookClass);

        assertTrue(bookClass.contains("+tostring():string"),
                "Your book class does not contain toString " + bookClass);
    }

    @Test
    @Order(5)
    void bookUML_File_LibraryBook_Properties() throws Exception {
        String bookClass = getUMLClassChonk("librarybook");

        assertTrue(bookClass.contains("-subjectlist:string"),
                "Your library book class does not contain necessary elements " + bookClass);
        assertTrue(bookClass.contains("-isbn:string"),
                "Your library book class does not contain necessary elements " + bookClass);
    }

    @Test
    @Order(4)
    void bookUML_File_LibraryBook_Constructors() throws Exception {
        String bookClass = getUMLClassChonk("librarybook");

        assertTrue(bookClass.contains("+librarybook(title:string,author:string)"),
                "Your library book class does not contain necessary constructor " + bookClass);

        assertTrue(bookClass.contains("+librarybook()"),
                "Your library book class does not contain necessary constructor " + bookClass);
    }

    @Test
    @Order(4)
    void bookUML_LibraryFile_Book_Methods() throws Exception {
        String bookClass = getUMLClassChonk("librarybook");

        assertTrue(bookClass.contains("+tostring():string"),
                "Your library book class does not contain toString " + bookClass);
        assertTrue(bookClass.contains("+setbookinfo(responsestring:string)"),
                "Your library book class does not contain set book info " + bookClass);
    }


    @Test
    @Order(7)
    void bookUML_File_DocumentDTO_Properties() throws Exception {
        String bookClass = getUMLClassChonk("documentdto");

        assertTrue(bookClass.contains("-subject:list<string>"),
                "Your library book class does not contain necessary properties " + bookClass);

        assertTrue(bookClass.contains("-person:list<string>"),
                "Your library book class does not contain necessary properties " + bookClass);

        assertTrue(bookClass.contains("-authorname:list<string>"),
                "Your library book class does not contain necessary properties " + bookClass);

        assertTrue(bookClass.contains("-isbn:list<string>"),
                "Your library book class does not contain necessary properties " + bookClass);

        assertTrue(bookClass.contains("-title:string"),
                "Your library book class does not contain necessary properties " + bookClass);
    }

    @Test
    @Order(9)
    void bookUML_File_BookRequestDTO_Properties() throws Exception {
        String bookClass = getUMLClassChonk("bookrequestdto");

        assertTrue(bookClass.contains("-docs:arraylist<documentdto>"),
                "Book request DTO does not contain necessary properties" + bookClass);

        assertTrue(bookClass.contains("-numfound:int"),
                "Book request DTO does not contain necessary properties" + bookClass);

        assertTrue(bookClass.contains("-start:int"),
                "Book request DTO does not contain necessary properties" + bookClass);

        assertTrue(bookClass.contains("-numfoundexact:boolean"),
                "Book request DTO does not contain necessary properties" + bookClass);
    }

    @Test
    @Order(12)
    void bookUML_File_Logger_Properties() throws Exception {
        String bookClass = getUMLClassChonk("logger");

        assertTrue(bookClass.contains("-logfile:string"),
                "Your logger does not contain the necessary properties " + bookClass);

        assertTrue(bookClass.contains("-writer:printwriter"),
                "Your logger does not contain the necessary properties " + bookClass);

        assertTrue(bookClass.contains("-logger:logger"),
                "Your logger does not contain the necessary properties " + bookClass);
    }

    @Test
    @Order(12)
    void bookUML_File_Logger_Methods() throws Exception {
        String bookClass = getUMLClassChonk("logger");

        assertTrue(bookClass.contains("+getinstance():logger"),
                "Your logger does not contain an instance method " + bookClass);

        assertTrue(bookClass.contains("+logmessage(message:string)"),
                "Your logger does not contain a log message method " + bookClass);
    }

    @Test
    @Order(12)
    void bookUML_File_Logger_Constructors() throws Exception {
        String bookClass = getUMLClassChonk("logger");

        assertTrue(bookClass.contains("-logger()"),
                "Your logger does not contain an private constructor " + bookClass);
    }

    @Test
    @Order(13)
    void bookUML_File_BookRequestService_Properties() throws Exception {
        String bookClass = getUMLClassChonk("bookrequestservice");

        assertTrue(bookClass.contains("+logger:logger"),
                "Your book request service does not contain the necessary properties " + bookClass);

        assertTrue(bookClass.contains("+get_url:string"),
                "Your book request service does not contain the necessary properties " + bookClass);

        assertTrue(bookClass.contains("-debug:boolean"),
                "Your book request service does not contain the necessary properties " + bookClass);
    }


    @Test
    @Order(14)
    void bookUML_File_BookRequestService_Methods() throws Exception {
        String bookClass = getUMLClassChonk("bookrequestservice");

        assertTrue(bookClass.contains("+sendgetrequest(requeststring:string):string"),
                "Your book request service does not contain a correct send get request " + bookClass);

        assertTrue(bookClass.contains("+formatresponsestring(requeststring:string,isbn:string,subjectlist:arraylist<string>)"),
                "Your book request service does not contain a correct format response string " + bookClass);

        assertTrue(bookClass.contains("+formatsearchstring(requeststring:string):string"),
                "Your book request service does not contain a correct format search string " + bookClass);
    }

    @Test
    @Order(16)
    void bookUML_File_Application_Methods() throws Exception {
        String bookClass = getUMLClassChonk("application");

        assertTrue(bookClass.contains("+main(args:string[])"),
                "Your application class does not contain main " + bookClass);

        assertTrue(bookClass.contains("+returnbooklist(response1:string,response2:string,response3:string,response4:string,response5:string):arraylist<librarybook>"),
                "Your main class does not have the correct return book list " + bookClass);

        assertTrue(bookClass.contains("+convertresponsetolibrarybook(response:string):librarybook"),
                "Your application class does not contain log message " + bookClass);
    }


    /*
    Extract the individual class code so they can see what class we're testing
    Everything between 2 curlies around name
    class LibraryBook {
        +whatever
    }
 */
    private String getUMLClassChonk(String name) {


        String patternString = "class" + name + "[{][^}]*[}]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(fileContents.toLowerCase());
        boolean found = matcher.find();
        return matcher.group();
    }


}
