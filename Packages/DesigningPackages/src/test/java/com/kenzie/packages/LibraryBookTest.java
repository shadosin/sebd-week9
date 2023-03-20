package com.kenzie.packages;

import com.kenzie.packages.model.LibraryBook;
import com.kenzie.packages.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Locale;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryBookTest {

    @Order(1)
    @Test
    void libraryBookClass_isbnField_usesPrivateModifier_Test() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        String field = getFieldValueInClassUsingReflection("isbn");
        assertTrue(field.toLowerCase().contains("private"), "Make sure your variable is private");
    }

    @Order(2)
    @Test
    void libraryBookClass_subjectListField_usesPrivateModifier_Test() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        String field = getFieldValueInClassUsingReflection("subjectList");
        assertTrue(field.toLowerCase().contains("private"), "Make sure your class variable is private");

    }

    @Order(3)
    @Test
    void libraryBookClass_All_GettersAndSetters_Exist() throws NoSuchMethodException {
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method setIsbn = LibraryBook.class.getMethod("setIsbn", String.class);
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
        Method setSubjectList = LibraryBook.class.getMethod("setSubjectList", String.class);

    }

    @Order(4)
    @Test
    void libraryBookClass_All_ExcludingGettersAndSetters_Exist() throws NoSuchMethodException {
        assertTrue(doesClassContainOverriddenStringMethod(LibraryBook.class));
        Method setIsbn = LibraryBook.class.getMethod("setBookInfo", String.class);
    }

    @Order(5)
    @Test
    void libraryBookClass_Extends_BookClass() throws Exception {
        assertTrue(doesChildClassExtendParentClass(LibraryBook.class, Book.class), "The LibraryBook class should extend the Book class.");

    }

    @Order(7)
    @Test
    void libraryBookClass_hasTwo_Parameter_Constructor() throws Exception {
        String titleExpected = "My Title";
        String authorListExpected = "My Author";

        Object[] LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_VALUES = {titleExpected, authorListExpected};
        Class<?>[] LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_TYPES = {String.class, String.class};

        LibraryBook libraryBook = getClassToConstruct(LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_VALUES, LIBRARY_BOOK_CLASS_TWO_PARAMETER_CONSTRUCTOR_TYPES, LibraryBook.class);

        Method getTitle = Book.class.getMethod("getTitle");
        String titleResult = (String) getTitle.invoke(libraryBook);
        assertEquals(titleExpected, titleResult, "title Should be initialized to the correct value, double check your constructor.");

        Method getAuthor = Book.class.getMethod("getAuthor");
        String authorResult = (String) getAuthor.invoke(libraryBook);
        assertEquals(authorListExpected, authorResult, "author Should be initialized to the correct value, double check your constructor.");

        Method getisbn = LibraryBook.class.getMethod("getIsbn");
        String getIsbnResult = (String) getisbn.invoke(libraryBook);
        assertEquals("", getIsbnResult, "isbn Should be initialized, double check your constructor.");

        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
        String getSubjectListResult = (String) getSubjectList.invoke(libraryBook);
        assertEquals("", getSubjectListResult, "subjectList Should be initialized, double check your constructor.");



    }

    @Order(8)
    @SuppressWarnings("unchecked")
    @DisplayName("LibraryBook class can be instantiated with title and author")
    @Test
    void canCreateLibraryBookTitleAuthor() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        LibraryBook book = getLibraryBook("The Invisible Man", "H.G. Wells");

        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

        assertEquals("H.G. Wells", (String) getAuthor.invoke(book), "getAuthor() returns correct result");
        assertEquals("The Invisible Man", (String) getTitle.invoke(book), "getTitle() returns correct result");
        assertEquals("", (String) getIsbn.invoke(book), "getIsbn() returns empty string after constructor");

        assertEquals("", (String) getSubjectList.invoke(book), "getSubjectList returns empty string after constructor");

    }

    @Order(9)
    @SuppressWarnings("unchecked")
    @DisplayName("toString() method in LibraryBook class overridden with correct format")
    @Test
    void testToString() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
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


        LibraryBook book = getLibraryBook("The Invisible Man", "H.G. Wells");

        Method setAuthor = LibraryBook.class.getMethod("setAuthor", String.class);
        Method setTitle = LibraryBook.class.getMethod("setTitle", String.class);
        Method setIsbn = LibraryBook.class.getMethod("setIsbn", String.class);
        Method setSubjectList = LibraryBook.class.getMethod("setSubjectList", String.class);
        Method toString = LibraryBook.class.getMethod("toString");


        setAuthor.invoke(book, AUTHOR1);
        setTitle.invoke(book, TITLE1);
        setIsbn.invoke(book, ISBN1);
        setSubjectList.invoke(book, SUBJECT1);
        String result1 = (String) toString.invoke(book);
        assertEquals(testString1, result1, "toString() method returns expected format. Required: All getter/setter methods must be defined correctly.");


        setAuthor.invoke(book, AUTHOR2);
        setTitle.invoke(book, TITLE2);
        setIsbn.invoke(book, ISBN2);
        setSubjectList.invoke(book, SUBJECT2);
        String result2 = (String) toString.invoke(book);
        assertEquals(testString2, result2, "toString() method returns expected format. Required: All getter/setter methods must be defined correctly.");


    }

    @Order(10)
    @DisplayName("LibraryBook class has setBookInfo() method defined correctly")
    @Test
    void setBookInfo() throws RuntimeException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
        Method setBookInfo = LibraryBook.class.getMethod("setBookInfo", String.class);

        String bookDetails1 = "The Hobbit|J.R.R. Tolkien|0871294273|[Juvenile fiction," +
                "Middle Earth (Imaginary place),Fiction]";
        String bookDetails2 = "The Nonsense Book|Mr. Myzlplk||[]";
        String subjectList1 = "[Juvenile fiction,Middle Earth (Imaginary place),Fiction]";
        LibraryBook book = getLibraryBook();

        setBookInfo.invoke(book, bookDetails1);
        assertEquals("The Hobbit", getTitle.invoke(book));
        assertEquals("J.R.R. Tolkien", getAuthor.invoke(book));
        assertEquals("0871294273", getIsbn.invoke(book));
        assertEquals(subjectList1, getSubjectList.invoke(book));
        setBookInfo.invoke(book, bookDetails2);
        assertEquals("The Nonsense Book", getTitle.invoke(book));
        assertEquals("Mr. Myzlplk", getAuthor.invoke(book));
        assertEquals("", getIsbn.invoke(book));
        assertEquals("[]", getSubjectList.invoke(book));

    }

    public static LibraryBook getLibraryBook(String title, String author) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructor = LibraryBook.class.getConstructor(String.class, String.class);
        LibraryBook book = (LibraryBook) constructor.newInstance(title, author);
        return book;
    }


    public static LibraryBook getLibraryBook() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor constructor = LibraryBook.class.getConstructor();
        LibraryBook book = (LibraryBook) constructor.newInstance();
        return book;
    }

    private <T> T getClassToConstruct(Object[] params, Class<?>[] paramTypes, Class<?> classToConstruct) throws Exception {
        if (params == null || paramTypes == null || classToConstruct == null) {
            throw new Exception("params, paramTypes, and classToConstruct parameters must be provided to use this method.");
        } else {
            Constructor constructor = classToConstruct.getConstructor(paramTypes);
            return (T) constructor.newInstance(params);
        }
    }

    private String getFieldValueInClassUsingReflection(String variableName) throws NoSuchFieldException {
            Class<LibraryBook> myClass = LibraryBook.class;
            Field field = myClass.getDeclaredField(variableName);
            return field.toString();
    }

    private boolean doesChildClassExtendParentClass(Class<?> childClass, Class<?> parentClassToCheck) throws Exception {
            if (childClass == null || parentClassToCheck == null) {
                throw new Exception("You need to provide a parent and child class to check if a child class extends a given parent class.");
            }

            if (childClass.getSuperclass() == parentClassToCheck) {
                return true;
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



}
