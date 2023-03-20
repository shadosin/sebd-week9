package com.kenzie.packages;

import com.kenzie.packages.model.LibraryBook;
import com.kenzie.packages.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kenzie.packages.model.Book;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryBookTest {

    public static final boolean TEST_SUCCESS = true;

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
    @DisplayName("LibraryBook class can be instantiated with no arguments")
    @Test
    void canCreateLibraryBookDefault() {

        try {
            @SuppressWarnings("unchecked")
            Constructor bookConstructor = LibraryBook.class.getConstructor();
            @SuppressWarnings("unchecked")

            LibraryBook book = (LibraryBook) getLibraryBook();
            //assertTrue(book instanceof Book, "LibraryBook is instance of Book" );

        }
        catch(Exception e){
            fail("Missing or incorrectly defined method: " + e.getMessage());

        }
    }

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
}
