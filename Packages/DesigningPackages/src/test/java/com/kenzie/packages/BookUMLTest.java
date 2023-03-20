package com.kenzie.packages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BookUMLTest {

    public static final String BASE_FILENAME_TO_FIND = "BookUML";

    public static final String BOOK_TEMPLATE_FILENAME_TO_FIND = "BookUMLTemplate.drawio.xml";

    public static final String DEFAULT_PROPERTIES_TEXT = "Enter your class properties here";

    public static final String DEFAULT_METHODS_TEXT = "Enter class methods, constructors, getters/setters here";

    public static final String BOOK_PROPERTIES_UNIQUEID = "BookProperties";

    public static final String BOOK_METHODS_UNIQUEID = "BookMethods";

    public static final String LIBRARYBOOK_PROPERTIES_UNIQUEID = "LibraryBookProperties";

    public static final String LIBRARYBOOK_METHODS_UNIQUEID = "LibraryBookMethods";

    public static final String LOGGER_PROPERTIES_UNIQUEID = "LoggerProperties";

    public static final String LOGGER_METHODS_UNIQUEID = "LoggerMethods";

    public static final String BOOKREQUESTSERVICE_PROPERTIES_UNIQUEID = "BookRequestServiceProperties";

    public static final String BOOKREQUESTSERVICE_METHODS_UNIQUEID = "BookRequestServiceMethods";

    public static final String APPLICATION_PROPERTIES_UNIQUEID = "ApplicationProperties";

    public static final String APPLICATION_METHODS_UNIQUEID = "ApplicationMethods";

    public static final String DOCUMENTDTO_PROPERTIES_UNIQUEID = "DocumentDTOProperties";

    public static final String DOCUMENTDTO_METHODS_UNIQUEID = "DocumentDTOMethods";

    public static final String BOOKREQUESTDTO_PROPERTIES_UNIQUEID = "BookRequestDTOProperties";

    public static final String BOOKREQUESTDTO_METHODS_UNIQUEID = "BookRequestDTOMethods";

    static HashMap<String, Integer>  lookupTable = new HashMap<>();

    @BeforeEach
    void beforeEach() {
        lookupTable.put(BOOK_PROPERTIES_UNIQUEID,0);
        lookupTable.put(BOOK_METHODS_UNIQUEID,1);
        lookupTable.put(LIBRARYBOOK_PROPERTIES_UNIQUEID,2);
        lookupTable.put(LIBRARYBOOK_METHODS_UNIQUEID,3);
        lookupTable.put(LOGGER_PROPERTIES_UNIQUEID,4);
        lookupTable.put(LOGGER_METHODS_UNIQUEID,5);
        lookupTable.put(BOOKREQUESTSERVICE_PROPERTIES_UNIQUEID,6);
        lookupTable.put(BOOKREQUESTSERVICE_METHODS_UNIQUEID,7);
        lookupTable.put(APPLICATION_PROPERTIES_UNIQUEID,8);
        lookupTable.put(APPLICATION_METHODS_UNIQUEID,9);
        lookupTable.put(DOCUMENTDTO_PROPERTIES_UNIQUEID,10);
        lookupTable.put(DOCUMENTDTO_METHODS_UNIQUEID,11);
        lookupTable.put(BOOKREQUESTDTO_PROPERTIES_UNIQUEID,12);
        lookupTable.put(BOOKREQUESTDTO_METHODS_UNIQUEID,13);
    }

    @Test
    @Order(1)
    void bookUML_File_Exists_In_TestDirectory() throws IOException {

        File fileFound = getFileByFolder();
        assertNotNull(fileFound, "Please ensure your BookUML file exported from draw.io exists in the DesingingPackages Directory / Module before continuing.");

    }

    @Test
    @Order(2)
    void bookUML_File_HasNot_AlteredDefaultFields_In_TestDirectory() throws Exception {

        File fileFound = getFileByFolder();

        String bookProperties = getDecodedValueOfXmlNode(BOOK_PROPERTIES_UNIQUEID, lookupTable.get(BOOK_PROPERTIES_UNIQUEID));

        assertNotNull(bookProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String bookMethods = getDecodedValueOfXmlNode(BOOK_METHODS_UNIQUEID, lookupTable.get(BOOK_METHODS_UNIQUEID));

        assertNotNull(bookMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String libraryBookProperties = getDecodedValueOfXmlNode(LIBRARYBOOK_PROPERTIES_UNIQUEID, lookupTable.get(LIBRARYBOOK_PROPERTIES_UNIQUEID));

        assertNotNull(libraryBookProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String libraryBookMethods = getDecodedValueOfXmlNode(LIBRARYBOOK_METHODS_UNIQUEID, lookupTable.get(LIBRARYBOOK_METHODS_UNIQUEID));

        assertNotNull(libraryBookMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String loggerProperties = getDecodedValueOfXmlNode(LOGGER_PROPERTIES_UNIQUEID, lookupTable.get(LOGGER_PROPERTIES_UNIQUEID));

        assertNotNull(loggerProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String loggerMethods = getDecodedValueOfXmlNode(LOGGER_METHODS_UNIQUEID, lookupTable.get(LOGGER_METHODS_UNIQUEID));

        assertNotNull(loggerMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String bookRequestServiceProperties = getDecodedValueOfXmlNode(BOOKREQUESTSERVICE_PROPERTIES_UNIQUEID, lookupTable.get(BOOKREQUESTSERVICE_PROPERTIES_UNIQUEID));

        assertNotNull(bookRequestServiceProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String bookRequestServiceMethods = getDecodedValueOfXmlNode(BOOKREQUESTSERVICE_METHODS_UNIQUEID, lookupTable.get(BOOKREQUESTSERVICE_METHODS_UNIQUEID));

        assertNotNull(bookRequestServiceMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String applicationProperties = getDecodedValueOfXmlNode(APPLICATION_PROPERTIES_UNIQUEID, lookupTable.get(APPLICATION_PROPERTIES_UNIQUEID));

        assertNotNull(applicationProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String applicationMethods = getDecodedValueOfXmlNode(APPLICATION_METHODS_UNIQUEID, lookupTable.get(APPLICATION_METHODS_UNIQUEID));

        assertNotNull(applicationMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String documentDTOProperties = getDecodedValueOfXmlNode(DOCUMENTDTO_PROPERTIES_UNIQUEID, lookupTable.get(DOCUMENTDTO_PROPERTIES_UNIQUEID));

        assertNotNull(documentDTOProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String documentDTOMethods = getDecodedValueOfXmlNode(DOCUMENTDTO_METHODS_UNIQUEID, lookupTable.get(DOCUMENTDTO_METHODS_UNIQUEID));

        assertNotNull(documentDTOMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String bookRequestDTOProperties = getDecodedValueOfXmlNode(BOOKREQUESTDTO_PROPERTIES_UNIQUEID, lookupTable.get(BOOKREQUESTDTO_PROPERTIES_UNIQUEID));

        assertNotNull(bookRequestDTOProperties, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        String bookRequestDTOMethods = getDecodedValueOfXmlNode(BOOKREQUESTDTO_METHODS_UNIQUEID, lookupTable.get(BOOKREQUESTDTO_METHODS_UNIQUEID));

        assertNotNull(bookRequestDTOMethods, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

    }

    @Test
    @Order(3)
    void bookUML_File_Book_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(BOOK_PROPERTIES_UNIQUEID, lookupTable.get(BOOK_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_PROPERTIES_TEXT, "Please ensure you have made updates to the Book Properties textbox input before continuing.");


        assertEquals(2,numTimesCharInString(valueFromXml, '#'),  "Expected to find 2 protected properties.");

        assertEquals(2,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "string"),  "There are two string properties in Book");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "title"),  "Book should have a title property");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "author"),  "Book should have an author property");

    }


    @Test
    @Order(4)
    void bookUML_File_Book_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(BOOK_METHODS_UNIQUEID, lookupTable.get(BOOK_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the Book Methods textbox input before continuing.");

        assertTrue(numTimesCharInString(valueFromXml, '+') > 3, "Expected to find 3 public properties.");

        assertTrue(numTimesWordFoundInString(valueFromXml.toLowerCase(), "book(") > 1, "Be sure to include constructors!");

        assertTrue(numTimesWordFoundInString(valueFromXml.toLowerCase(), "string") > 4, "You did not include all necessary references to String");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "tostring()"),  "Expected to find only 2 toString() method");

        assertTrue(numTimesCharInString(valueFromXml, ':') > 0, "When you list a return type, it is separated by a :");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "setbookinfo"),  "Expected to find 1 setBookInfo method");
    }

    @Test
    @Order(5)
    void bookUML_File_LibraryBook_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(LIBRARYBOOK_PROPERTIES_UNIQUEID, lookupTable.get(LIBRARYBOOK_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_PROPERTIES_TEXT,"Please ensure you have made updates to the Library Book properties textbox input before continuing.");

        assertEquals(2,numTimesCharInString(valueFromXml, '-'),  "Expected to find 2 private properties.");


        assertEquals(2,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "string"),  "There are two String properties");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "isbn"),  "LibraryBook should have an isbn property name");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "subjectlist"),  "LibraryBook should have a subjectList property name");

    }


    @Test
    @Order(6)
    void bookUML_File_LibraryBook_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(LIBRARYBOOK_METHODS_UNIQUEID, lookupTable.get(LIBRARYBOOK_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the Library Book Properties methods textbox input before continuing.");

        assertTrue(numTimesCharInString(valueFromXml, '+') > 2, "Expected to find 2 public properties.");


        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "librarybook("),  "Be sure to include the constructor.");


        assertTrue(numTimesWordFoundInString(valueFromXml.toLowerCase(), "string") > 2, "You did not include the String dataType as many times as necessary");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "tostring()"),  "Expected to find 1 toString() method");

        assertTrue(numTimesCharInString(valueFromXml, ':') > 0, "A : separates return types from the method name");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "setbookinfo"),  "Expected to find 1 setBookInfo method");
    }

    @Test
    @Order(7)
    void bookUML_File_DocumentDTO_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(DOCUMENTDTO_PROPERTIES_UNIQUEID, lookupTable.get(DOCUMENTDTO_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_PROPERTIES_TEXT,"Please ensure you have made updates to the DocumentDTO Properties textbox input before continuing.");

        assertEquals(5,numTimesCharInString(valueFromXml, '-'),  "Expected to find 5 private properties.");


        assertEquals(5,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");

        assertEquals(4,numTimesWordFoundInString(valueFromXml.toLowerCase(), "list"),  "Expected to find 4 list propeties");

        assertEquals(5,numTimesWordFoundInString(valueFromXml.toLowerCase(), "string"),  "There are 5 String datatypes");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "subject"),  "DocumentDTO has a property called subject");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "person"),  "DocumentDTO has a property called person");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "authorname"),  "DocumentDTO has a property called authorname");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "isbn"),  "DocumentDTO has a property called isbn");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "title"),  "DocumentDTO has a property called title");

    }


    @Test
    @Order(8)
    void bookUML_File_DocumentDTO_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(DOCUMENTDTO_METHODS_UNIQUEID, lookupTable.get(DOCUMENTDTO_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the DocumentDTO Methods textbox input before continuing.");

    }

    @Test
    @Order(9)
    void bookUML_File_BookRequestDTO_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(BOOKREQUESTDTO_PROPERTIES_UNIQUEID, lookupTable.get(BOOKREQUESTDTO_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_PROPERTIES_TEXT,"Please ensure you have made updates to the BookRequestDTO properties textbox input before continuing.");

        assertEquals(4,numTimesCharInString(valueFromXml, '-'),  "Expected to find 4 private properties.");


        assertEquals(4,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");


        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "boolean"),  "Expected to find 1 boolean properties.");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "int"),  "Expected to find 2 int properties.");


        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "list"),  "Expected to find 1 list properties.");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "numfoundexact"),  "BookRequestDTO has a property called numfoundexact");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "start"),  "BookRequestDTO has a property called start");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "numfound"),  "BookRequestDTO has a property called numfound");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "docs"),  "BookRequestDTO has a property called docs");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "documentdto"),  "The list property should have DocumentDTO as its data type");

    }


    @Test
    @Order(10)
    void bookUML_File_BookRequestDTO_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(BOOKREQUESTDTO_METHODS_UNIQUEID, lookupTable.get(BOOKREQUESTDTO_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the BookRequestDTO methods textbox input before continuing.");

    }

    @Test
    @Order(11)
    void bookUML_File_Logger_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(LOGGER_PROPERTIES_UNIQUEID, lookupTable.get(LOGGER_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_PROPERTIES_TEXT,"Please ensure you have made updates to the Logger properties textbox input before continuing.");

        assertEquals(3,numTimesCharInString(valueFromXml, '-'),  "Expected to find 3 private properties.");


        assertEquals(3,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "logfile"),  "Logger has a property called logFile");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "writer"),  "Logger has a property called writer");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "printwriter"),  "Logger has a property of type printwriter");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "logger"),  "Logger has a property called logger of type Logger");


        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "string"),  "Expected to find 1 String properties.");

    }


    @Test
    @Order(12)
    void bookUML_File_Logger_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(LOGGER_METHODS_UNIQUEID, lookupTable.get(LOGGER_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the Logger methods textbox input before continuing.");


        assertEquals(1,numTimesCharInString(valueFromXml, '-'),  "Expected to find 1 private constructor.");

        assertEquals(1,numTimesCharInString(valueFromXml, ':'),  "Separate return types from the method name with a :");

        assertEquals(2,numTimesCharInString(valueFromXml, '+'),  "Expected to find 2 public methods.");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "logger"),  "Be sure to include the constructor and return type from getInstance");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "logger()"),  "Be sure to include the private constructor");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "getinstance()"),  "Be sure to include the getInstance method");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "logmessage"),  "Be sure to include a logMessage method");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "string"),  "There should be a String parameter");

    }
    @Test
    @Order(13)
    void bookUML_File_BookRequestService_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(BOOKREQUESTSERVICE_PROPERTIES_UNIQUEID, lookupTable.get(BOOKREQUESTSERVICE_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_PROPERTIES_TEXT,"Please ensure you have made updates to the BookRequestDTO properties textbox input before continuing.");

        assertEquals(1,numTimesCharInString(valueFromXml, '-'),  "Expected to find 1 private properties.");

        assertEquals(2,numTimesCharInString(valueFromXml, '+'),  "Expected to find 2 public properties.");


        assertEquals(3,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "debug"),  "BookRequestService should have a property named DEBUG");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "boolean"),  "BookRequestService should have a property of type boolean");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "logger"),  "BookRequestService should have a property named and typed logger");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "string"),  "Expected to find 1 String properties.");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "get_url"),  "BookRequestService should have a property named GET_URL");

    }


    @Test
    @Order(14)
    void bookUML_File_BookRequestService_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(BOOKREQUESTSERVICE_METHODS_UNIQUEID, lookupTable.get(BOOKREQUESTSERVICE_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the BookRequestService methods textbox input before continuing.");


        assertEquals(3,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");


        assertEquals(3,numTimesCharInString(valueFromXml, '+'),  "Expected to find 3 public properties.");

        assertTrue(numTimesWordFoundInString(valueFromXml.toLowerCase(), "string") > 9, "Be sure to include String for parameters and return types");


        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "formatsearchstring"),  "Be sure to include the formatSearchString method");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "formatresponsestring"),  "Be sure to include the formatResponseString method");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "list"),  "Expected to find 2 List properties.");

    }

    @Test
    @Order(15)
    void bookUML_File_Application_Properties() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(APPLICATION_PROPERTIES_UNIQUEID, lookupTable.get(APPLICATION_PROPERTIES_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the Application properties textbox inputs provided.");

    }


    @Test
    @Order(16)
    void bookUML_File_Application_Methods() throws Exception {

        File fileFound = getFileByFolder();

        String valueFromXml = getDecodedValueOfXmlNode(APPLICATION_METHODS_UNIQUEID, lookupTable.get(APPLICATION_METHODS_UNIQUEID));

        assertNotNull(valueFromXml, "Please ensure you have not altered anything in your UML template outside of the textbox inputs provided.");

        assertNotEquals(valueFromXml.toLowerCase(), DEFAULT_METHODS_TEXT,"Please ensure you have made updates to the Application Properties textbox input before continuing.");


        assertEquals(3,numTimesCharInString(valueFromXml, '+'),  "Expected to find 3 public properties.");

        assertEquals(3,numTimesCharInString(valueFromXml, ':'),  "Property names and datatypes should be separated by a :");


        assertTrue(numTimesWordFoundInString(valueFromXml.toLowerCase(), "string") > 6, "Be sure to include String for parameters and return types");


        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "returnbooklist"),  "Application should have a method called returnBookList");

        assertEquals(2,numTimesWordFoundInString(valueFromXml.toLowerCase(), "list"),  "ReturnBookList should return an ArrayList");

        assertEquals(3,numTimesWordFoundInString(valueFromXml.toLowerCase(), "librarybook"),  "Be sure to use LibraryBook as a parameter or return type where appropriate");

        assertEquals(1,numTimesWordFoundInString(valueFromXml.toLowerCase(), "convertresponsetolibrarybook"),  "Missing convertResponseToLibraryBook method");

    }

    private String getDecodedValueOfXmlNode(String uniqueID, int atIndex) throws Exception {
        File xmlFileFound = getFileByFolder();

        URI firstPathFound = xmlFileFound.toURI();

        File inputFile = new File(firstPathFound);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList base = doc.getElementsByTagName("object");
        Node basenode = base.item(atIndex);

        NamedNodeMap children = basenode.getAttributes();

        String nodeValue = children.getNamedItem("label").getNodeValue();

        if(isNodeCorrectVerified(uniqueID, children)) {
            return nodeValue;
        }
        else {
            return null;
        }
    }

    private boolean isNodeCorrectVerified(String expectedNodeUniqueId, NamedNodeMap map) {
        try {

            if(expectedNodeUniqueId != null && map != null) {
                int mapLength = map.getLength();

                for (int i = 0; i < mapLength ; i++) {

                    if(map.item(i).hasChildNodes()) {
                        String nodeValue = map.item(i).getNodeValue();

                        if(nodeValue.equals(expectedNodeUniqueId)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    private Collection<Path> findFilePaths(String fileName, boolean excludeTemplate) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        if(excludeTemplate) {
            try (Stream<Path> files = Files.walk(Paths.get(s))) {
                return files
                        .filter(f -> f.getFileName().toString().toLowerCase().contains(fileName.toString().toLowerCase()) &&
                                f.getFileName().toString().toLowerCase().contains("xml") && !f.getFileName().toString().toLowerCase().contains("com.kenzie.packages")
                                && !f.getFileName().toString().toLowerCase().contains("template"))
                        .collect(Collectors.toList());

            }
        }
        else {
            try (Stream<Path> files = Files.walk(Paths.get(s))) {
                return files
                        .filter(f -> f.getFileName().toString().toLowerCase().contains(fileName.toString().toLowerCase()) && f.getFileName().toString().toLowerCase().contains("xml") && !f.getFileName().toString().toLowerCase().contains("com.kenzie.packages"))
                        .collect(Collectors.toList());

            }
        }

    }

    private File getFileByFolder() throws IOException {
        List<File> aList = new ArrayList<File>();

        Collection<Path> filesPaths =  findFilePaths(BASE_FILENAME_TO_FIND, true);

        if(filesPaths == null || filesPaths.isEmpty() || filesPaths.size() == 0) {
            filesPaths = findFilePaths(BOOK_TEMPLATE_FILENAME_TO_FIND, false);
        }

        for (Path p : filesPaths) {

            File f = new File(p.toUri());

            if (f.isFile()) {
                aList.add(f);
            }
        }

        return new File(aList.get(0).toURI());
    }

    private int numTimesCharInString(String stringToCheck, char charToFind) {
        int count = 0;

        String stringTrimmed = runStringCleanup(stringToCheck);

        for (int i = 0; i < stringTrimmed.length(); i++) {
            if (stringTrimmed.charAt(i) == charToFind) {
                count++;
            }
        }

        return count;
    }

    public static int numTimesWordFoundInString(String sentence, String findWord) {
        String stringTrimmed = runStringCleanup(sentence);

        int length = stringTrimmed.length();
        int lengthWithoutFindWord = stringTrimmed.replace(findWord, "").length();
        return (int) Math.round((length - lengthWithoutFindWord)/(double)findWord.length());

    }

    private static String runStringCleanup(String stringToClean){
        String lowerCaseStringToClean = stringToClean.toLowerCase();

        String returnStringStep1 = lowerCaseStringToClean.replaceAll(" ", "");
        String returnStringStep2 = returnStringStep1.replaceAll("border-color", "");
        String returnStringStep3 = returnStringStep2.replaceAll("var(--border-color);", "");
        String returnStringStep4 = returnStringStep3.replaceAll("font-size", "");
        String returnStringStep5 = returnStringStep4.replaceAll("</u>", "");
        String returnStringStep6 = returnStringStep5.replaceAll("<u>", "");
        String returnStringStep7 = returnStringStep6.replaceAll("<br>", "");
        String returnStringStep8 = returnStringStep7.replaceAll("</br>", "");
        String returnStringStep9 = returnStringStep8.replaceAll("background-color", "");
        String returnStringStep10 = returnStringStep9.replaceAll("</font>", "");
        String returnStringStep11 = returnStringStep10.replaceAll("<font>", "");
        String returnStringStep12 = returnStringStep11.replaceAll("<", "");
        String returnStringStep13 = returnStringStep12.replaceAll(">", "");
        String returnStringStep14 = returnStringStep13.replaceAll("&nbsp;", "");
        String returnStringStep15 = returnStringStep14.replaceAll(":2", "");
        String returnStringStep16 = returnStringStep15.replaceAll("/", "");
        String returnStringStep17 = returnStringStep16.replaceAll("=22", "");
        String returnStringStep18 = returnStringStep17.replaceAll("\"", "");
        String returnStringStep19 = returnStringStep18.replaceAll("fontstyle", "");
        String returnStringStep20 = returnStringStep19.replaceAll("ustyle", "");
        String returnStringStep21 = returnStringStep20.replaceAll("readonly", "");
        String returnStringStep22 = returnStringStep21.replaceAll("span", "");
        String returnStringStep23 = returnStringStep22.replaceAll("px", "");
        String returnStringStep24 = returnStringStep23.replaceAll(";", "");
        String returnStringStep25 = returnStringStep24.replaceAll("\\{", "");
        String returnStringStep26 = returnStringStep25.replaceAll("}", "");
        String returnStringStep27 = returnStringStep26.replaceAll("readOnly", "");
        String returnStringStep28 = returnStringStep27.replaceAll("readonly", "");
        String returnStringStep29 = returnStringStep28.replaceAll("=", "");
        String returnStringStep30 = returnStringStep29.replaceAll("2", "");
        String returnStringStep31 = returnStringStep30.replaceAll("style:initial", "");
        String returnStringStep32 = returnStringStep31.replaceAll(":initial", "");
        String returnStringStep33 = returnStringStep32.replaceAll("style=", "");
        String returnStringStep34 = returnStringStep33.replaceAll("style", "");
        String returnStringStep35 = returnStringStep34.replaceAll("var(--)", "");
        String returnStringStep36 = returnStringStep35.replaceAll("brstyle:", "");
        String returnStringStep37 = returnStringStep36.replaceAll("&ltdocumentdto&gt", "");
        String returnStringStep38 = returnStringStep37.replaceAll("&lt", "");
        String returnStringStep39 = returnStringStep38.replaceAll("&gt", "");
        String returnStringStep40 = returnStringStep39.replaceAll("brstyle:var(--)", "");
        String returnStringStep41 = returnStringStep40.replaceAll("br:", "");
        String returnStringStep42 = returnStringStep41.replaceAll("br:var(--)", "");
        String returnStringStep43 = returnStringStep42.replaceAll("(--)", "");
        String returnStringStep44 = returnStringStep43.replaceAll("var", "");

        return returnStringStep44;
    }
}
