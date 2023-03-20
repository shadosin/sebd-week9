package com.kenzie.packages;

import com.kenzie.packages.model.LibraryBook;
import com.kenzie.packages.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryBookTest {

    public static final boolean TEST_SUCCESS = true;

    String CLASSNAME = "LibraryBook";

    Object [] LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES = {};

    Class<?> [] LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES = {};

    @Order(1)
    @Test
    void libraryBookClass_isbnField_usesPrivateModifier_Test() {
        String EXPECTED_MODIFIER = "PRIVATE";
        String fieldNameToFind = "isbn";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES);
            assertTrue(doesClassFieldUseCorrectModifier(fieldNameToFind, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER), "Please Double check that your field " + fieldNameToFind + " uses the " + EXPECTED_MODIFIER + "modifier.  You must also have a constructor.");
        }
        catch (Exception e) {
            assertTrue(false, "Double check that you have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the " + CLASSNAME + " class that has the " + EXPECTED_MODIFIER + " Modifier.");
        }
    }

    @Order(2)
    @Test
    void libraryBookClass_subjectListField_usesPrivateModifier_Test() {
        String EXPECTED_MODIFIER = "PRIVATE";
        String fieldNameToFind = "subjectList";
        String fieldType = "String";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES);
            assertTrue(doesClassFieldUseCorrectModifier(fieldNameToFind, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER), "Please Double check that your field " + fieldNameToFind + " uses the " + EXPECTED_MODIFIER + "modifier.  You must also have a constructor.");
        }
        catch (Exception e) {
            assertTrue(false, "Double check that you have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the " + CLASSNAME + " class that has the " + EXPECTED_MODIFIER + " Modifier.");
        }
    }

    @Order(3)
    @Test
    void libraryBookClass_All_GettersAndSetters_Exist() {
        try {
            Method getIsbn = LibraryBook.class.getMethod("getIsbn");

            Method setIsbn = LibraryBook.class.getMethod("setIsbn", String.class);

            Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

            Method setSubjectList = LibraryBook.class.getMethod("setSubjectList", String.class);
        }
        catch(Exception e) {
            assertTrue(false, "Please double check your LibraryBook Class has the correct Constructors and that you have methods for getIsbn, setIsbn, getSubjectList, and setSubjectList in your LibraryBook Class.");
        }
    }

    @Order(4)
    @Test
    void libraryBookClass_All_ExcludingGettersAndSetters_Exist() {
        try {
            assertTrue(doesClassContainOverriddenStringMethod(LibraryBook.class));

            Method setIsbn = LibraryBook.class.getMethod("setBookInfo", String.class);
            assertTrue(true);

        }
        catch(Exception e) {
            assertTrue(false, "Please double check your LibraryBook Class has the correct Constructors and that you have methods for toString, and setBookInfo in your LibraryBook Class. This excludes getter and setter methods for this test.");
        }
    }

    @Order(5)
    @Test
    void libraryBookClass_Extends_BookClass() throws NoSuchElementException{
        try {
            assertTrue(doesChildClassExtendParentClass(LibraryBook.class, Book.class), "The LibraryBook class should extend the Book class.");
        }
        catch(Exception e){
            assertTrue(false, "The Doctor class should extend the Traveler class.");
        }
    }

    @Order(6)
    @Test
    void libraryBookClass_hasZero_Parameter_Constructor() throws NoSuchElementException{
        try {
            LibraryBook libraryBook = getClassToConstruct(LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES, LibraryBook.class);

            try {

                String getIsbnResult = (String)getFieldValueInClassUsingReflection("isbn", LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES);

                String getSubjectListResult = (String)getFieldValueInClassUsingReflection("subjectList", LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_ZERO_PARAMETER_CONSTRUCTOR_TYPES);

                assertEquals("", getIsbnResult, "isbn Should be initialized, double check your constructor.");

                assertEquals("", getSubjectListResult, "subjectList Should be initialized, double check your constructor.");

            }
            catch(Exception e) {
                assertTrue(false, "Please double check you are initializing isbn and subjectList to the correct values.");
            }

            assertTrue(true);
        }
        catch(Exception e){
            assertTrue(false, "The LibraryBook class should have a Parameterless Constructor.");
        }
    }

    @Order(7)
    @Test
    void libraryBookClass_hasTwo_Parameter_Constructor() throws NoSuchElementException{
        try {
            String titleExpected = "My Title";

            String authorListExpected = "My Author";

            Object [] LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_VALUES = {titleExpected, authorListExpected};

            Class<?> [] LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_TYPES = {String.class, String.class};

            LibraryBook libraryBook = getClassToConstruct(LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_TYPES, LibraryBook.class);

            try {
                Method getTitle = Book.class.getMethod("getTitle");

                String titleResult = (String) getTitle.invoke(libraryBook);

                Method getAuthor = Book.class.getMethod("getAuthor");

                String authorResult = (String) getAuthor.invoke(libraryBook);
                String getIsbnResult = (String)getFieldValueInClassUsingReflection("isbn", LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_TYPES);

                String getSubjectListResult = (String)getFieldValueInClassUsingReflection("subjectList", LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_TYPES);

                assertEquals("", getIsbnResult, "isbn Should be initialized, double check your constructor.");

                assertEquals("", getSubjectListResult, "subjectList Should be initialized, double check your constructor.");


                assertEquals(titleExpected, titleResult, "title Should be initialized to the correct value, double check your constructor.");

                assertEquals(authorListExpected, authorResult, "author Should be initialized to the correct value, double check your constructor.");

            }
            catch(Exception e) {
                assertTrue(false, "Please double check you are initializing isbn and subjectList to the correct values.");
            }

            assertTrue(true);
        }
        catch(Exception e){
            assertTrue(false, "The LibraryBook class should have a Parameterless Constructor.");
        }
    }

    @Order(8)
    @SuppressWarnings("unchecked")
    @DisplayName("LibraryBook class can be instantiated with title and author")
    @Test
    void canCreateLibraryBookTitleAuthor() {
        try {
            LibraryBook book = getLibraryBook("The Invisible Man","H.G. Wells");
            //assertEquals(true, (book instanceof Book), "LibraryBook is instance of Book" );

            //prepare methods
            @SuppressWarnings("unchecked")
            Method getAuthor = LibraryBook.class.getMethod("getAuthor");
            @SuppressWarnings("unchecked")
            Method getTitle = LibraryBook.class.getMethod("getTitle");
            @SuppressWarnings("unchecked")
            Method getIsbn = LibraryBook.class.getMethod("getIsbn");
            @SuppressWarnings("unchecked")
            Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

            assertEquals("H.G. Wells",(String)getAuthor.invoke(book),"getAuthor() returns correct result");
            assertEquals("The Invisible Man",(String)getTitle.invoke(book),"getTitle() returns correct result");
            assertEquals("",(String)getIsbn.invoke(book),"getIsbn() returns empty string after constructor");

            assertEquals("", (String)getSubjectList.invoke(book),"getSubjectList returns empty string after constructor");
        }
        catch(Exception e){
            fail("Missing or incorrectly defined method or class constructor: " + e.getMessage());
        }
    }

    @Order(9)
    @SuppressWarnings("unchecked")
    @DisplayName("toString() method in LibraryBook class overridden with correct format")
    @Test
    void testToString() {
        String testString1 = "LibraryBook{title='The Hobbit', author='J.R.R. Tolkien', isbn='0871294273', subjectList='[Juvenile fiction]'}";
        String testString2 = "LibraryBook{title='The Nonsense Book', author='Mr. Myzlplk', isbn='', subjectList='[]'}";
        String bookDetails1 = "The Hobbit|J.R.R. Tolkien|0871294273|[Juvenile fiction]";
        String bookDetails2 = "The Nonsense Book|Mr. Myzlplk||[]";
        final String TITLE1 = "The Hobbit";
        final String AUTHOR1 = "J.R.R. Tolkien";
        final String ISBN1 = "0871294273";
        final String SUBJECT1 = "[Juvenile fiction]";
        final String TITLE2 = "The Nonsense Book";
        final String AUTHOR2 = "Mr. Myzlplk";
        final String ISBN2 = "";
        final String SUBJECT2 = "[]";


        try {
            LibraryBook book = getLibraryBook("The Invisible Man","H.G. Wells");
            //assertEquals(true, book instanceof Book, "LibraryBook is instance of Book" );

            //prepare methods
            //Method setBookInfo = LibraryBook.class.getMethod("setBookInfo", String.class);

            Method setAuthor = LibraryBook.class.getMethod("setAuthor", String.class);
            Method setTitle = LibraryBook.class.getMethod("setTitle", String.class);
            Method setIsbn = LibraryBook.class.getMethod("setIsbn", String.class);
            Method setSubjectList = LibraryBook.class.getMethod("setSubjectList", String.class);
            @SuppressWarnings("unchecked")
            Method toString = LibraryBook.class.getMethod("toString");


            setAuthor.invoke(book,AUTHOR1);
            setTitle.invoke(book,TITLE1);
            setIsbn.invoke(book,ISBN1);
            setSubjectList.invoke(book,SUBJECT1);
            String result1 = (String)toString.invoke(book);
            assertEquals(testString1,result1,"toString() method returns expected format. Required: All getter/setter methods must be defined correctly.");


            setAuthor.invoke(book,AUTHOR2);
            setTitle.invoke(book,TITLE2);
            setIsbn.invoke(book,ISBN2);
            setSubjectList.invoke(book,SUBJECT2);
            String result2 = (String)toString.invoke(book);
            assertEquals(testString2,result2,"toString() method returns expected format. Required: All getter/setter methods must be defined correctly.");

        }
        catch(Exception e){
            fail("Missing or incorrectly defined method: " + e.getMessage());
        }

    }

    @Order(10)
    @SuppressWarnings("unchecked")
    @DisplayName("LibraryBook class has setBookInfo() method defined correctly")
    @Test
    void setBookInfo() throws RuntimeException {
        try {
            //prepare methods
            @SuppressWarnings("unchecked")
            Method getAuthor = LibraryBook.class.getMethod("getAuthor");
            @SuppressWarnings("unchecked")
            Method getTitle = LibraryBook.class.getMethod("getTitle");
            @SuppressWarnings("unchecked")
            Method getIsbn = LibraryBook.class.getMethod("getIsbn");
            @SuppressWarnings("unchecked")
            Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
            @SuppressWarnings("unchecked")
            Method setBookInfo = LibraryBook.class.getMethod("setBookInfo",String.class);

            String bookDetails1 = "The Hobbit|J.R.R. Tolkien|0871294273|[Juvenile fiction," +
                    "Middle Earth (Imaginary place),Fiction]";
            String bookDetails2 = "The Nonsense Book|Mr. Myzlplk||[]";
            String subjectList1 = "[Juvenile fiction,Middle Earth (Imaginary place),Fiction]";
            String subjectList2 = "[]";
            LibraryBook book = getLibraryBook();
            //assertEquals(true, book instanceof Book, "LibraryBook is instance of Book");

            setBookInfo.invoke(book, bookDetails1);
            assertEquals("The Hobbit", getTitle.invoke(book));
            assertEquals("J.R.R. Tolkien", getAuthor.invoke(book));
            assertEquals("0871294273", getIsbn.invoke(book));
            assertEquals(subjectList1, getSubjectList.invoke(book));
            setBookInfo.invoke(book,bookDetails2);
            assertEquals("The Nonsense Book", getTitle.invoke(book));
            assertEquals("Mr. Myzlplk", getAuthor.invoke(book));
            assertEquals("", getIsbn.invoke(book));
            assertEquals("[]", getSubjectList.invoke(book));
        }
        catch(NoSuchElementException e){
            fail("Missing or incorrect definition for: " + e.getMessage());
        }
        catch (Exception e){
            fail("Missing or incorrectly defined method: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static LibraryBook getLibraryBook(String title, String author) {
        try {
            @SuppressWarnings("unchecked")
            Constructor constructor = LibraryBook.class.getConstructor(String.class, String.class);
            @SuppressWarnings("unchecked")
            LibraryBook book = (LibraryBook) constructor.newInstance(title, author);
            return book;
        }
        catch(Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

    }


    @SuppressWarnings("unchecked")
    public static LibraryBook getLibraryBook() {
        try {
            @SuppressWarnings("unchecked")
            Constructor constructor = LibraryBook.class.getConstructor();
            @SuppressWarnings("unchecked")
            LibraryBook book = (LibraryBook) constructor.newInstance();
            return book;
        }
        catch(Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

    }

    private Class<?> getClassByClassPath(String classNameToFind) throws NoSuchElementException {
        try {
            Class<?> classRetrieved = Class.forName(classNameToFind);
            return classRetrieved;
        }
        catch(Exception e){
            throw new NoSuchElementException("The class " + classNameToFind + " has not been created yet. Please ensure you have created the appropriate classes per the assingment instructions before continuing.");
        }
    }

    private <T> T getClassToConstruct(Object[] params, Class<?>[] paramTypes, Class<?> classToConstruct) throws Exception {

        if(params == null || paramTypes == null || classToConstruct == null) {
            throw new Exception("params, paramTypes, and classToConstruct parameters must be provided to use this method.");
        }
        else {
            Constructor constructor = classToConstruct.getConstructor(paramTypes);
            return (T) constructor.newInstance(params);
        }
    }

    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?> [] paramTypes) {
        try {
            Class<LibraryBook> myClass = LibraryBook.class;

            Constructor constructor = myClass.getConstructor(paramTypes);
            LibraryBook book = (LibraryBook) constructor.newInstance(params);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            field.setAccessible(true);
            if (field.get(book) == null){
                return "";
            }
            return field.get(book).toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean doesChildClassExtendParentClass(Class<?> childClass, Class<?> parentClassToCheck) throws NoSuchElementException {
        try {
            if(childClass == null || parentClassToCheck == null) {
                throw new Exception("You need to provide a parent and child class to check if a child class extends a given parent class.");
            }

            if(childClass.getSuperclass() == parentClassToCheck) {
                return true;
            }
        }
        catch(Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

        return false;
    }

    private boolean doesChildClassImplementInterface(Class<?> classThatShouldHaveInterface, Class<?> interfaceClass) throws NoSuchElementException {
        try {
            if(classThatShouldHaveInterface == null || interfaceClass == null) {
                throw new Exception("You need to provide a a valid Interface and Class Name to check.");
            }
            else {
                Class x = classThatShouldHaveInterface; //
                Class[] interfaces = x.getInterfaces();

                for (Class i : interfaces) {
                    if (i.toString().equals(interfaceClass.toString())) {
                        return true;
                    }
                }
            }
        }
        catch(Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

        return false;
    }

        public static boolean doesClassContainOverriddenStringMethod(Class<?> classToCheck) {
        Method m;
        try {
            m = classToCheck.getMethod("toString");
        } catch (NoSuchMethodException e) {
            // Can't be thrown since every class has a toString method through Object
            return false;
        }
        return (m.getDeclaringClass() != Object.class);
    }


    private boolean doesClassFieldUseCorrectModifier(String variableName, Object[] params, Class<?> [] paramTypes, String expectedModifier) {
        try {
            if(paramTypes == null || expectedModifier == null || expectedModifier.isEmpty() || expectedModifier.isBlank() ) {
                throw new Exception("paramTypes and expectedModifier parameters must be provided and must be valid.");
            }

            Class<LibraryBook> myClass = LibraryBook.class;

            Constructor constructor = myClass.getConstructor(paramTypes);
            LibraryBook book = (LibraryBook) constructor.newInstance(params);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            int modifiers = field.getModifiers();

            String expectedModifierToLower = expectedModifier.toLowerCase();

            if(Modifier.isProtected(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("protected")) {
                    return true;
                }
            }
            else if(Modifier.isPrivate(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("private")) {
                    return true;
                }
            }
            else if(Modifier.isPublic(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("public")) {
                    return true;
                }
            }
            else if(Modifier.isAbstract(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("abstract")) {
                    return true;
                }
            }
            else if(Modifier.isFinal(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("final")) {
                    return true;
                }
            }
            else if(Modifier.isInterface(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("interface")) {
                    return true;
                }
            }
            else if(Modifier.isStatic(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("static")) {
                    return true;
                }
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
