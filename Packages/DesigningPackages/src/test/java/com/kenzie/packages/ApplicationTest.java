package com.kenzie.packages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kenzie.packages.model.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
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
    @DisplayName("convertResponseToLibraryBook method defined correctly in Application")
    @Test
    void convertResponseToLibraryBook() throws Exception {
        try {
            //declare LibraryBook for testing
            @SuppressWarnings("unchecked")
            LibraryBook testBook = getLibraryBook();

            //prepare methods from Application
            @SuppressWarnings("unchecked")
            Method convertResponseToLibraryBook = Application.class.getMethod("convertResponseToLibraryBook", String.class);
            @SuppressWarnings("unchecked")
            Method getAuthor = LibraryBook.class.getMethod("getAuthor");
            @SuppressWarnings("unchecked")
            Method getTitle = LibraryBook.class.getMethod("getTitle");
            @SuppressWarnings("unchecked")
            Method getIsbn = LibraryBook.class.getMethod("getIsbn");
            @SuppressWarnings("unchecked")
            Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
            // end of method preparation


            final String TESTBOOK_1 = "The Hobbit|J.R.R. Tolkien|123456|[Fiction]";
            LibraryBook tempBook = (LibraryBook) convertResponseToLibraryBook.invoke(Application.class,TESTBOOK_1);
            assertEquals("The Hobbit", getTitle.invoke(tempBook),"Title matches expected value after converting from response String");
            assertEquals("J.R.R. Tolkien", getAuthor.invoke(tempBook),"Author matches expected value after converting from response String");
            assertEquals("123456", getIsbn.invoke(tempBook),"ISBN matches expected value after converting from response String");
            assertEquals("[Fiction]", getSubjectList.invoke(tempBook),"Subject List matches expected value after converting from response String");
        }
        catch(Exception e){
            fail("Missing or incorrect method definition: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @DisplayName("returnBookList defined correctly in Application")
    @Test
    void returnBookList() {
        final String TESTBOOK_1 = "The Hobbit|J.R.R. Tolkien|123456|[Fiction]";
        final String TESTBOOK_2 = "Dune|Frank Herbert|234567|[Science fiction, movie]";
        final String TESTBOOK_3 = "The Nonsense Book|Mr. Myzlplk||[]";
        final String TESTBOOK_4 = "The Cat in the Hat|Dr. Seuss|00000|[childrens, illustrated, award-winning]";
        final String TESTBOOK_5 = "The Art of War|Sun Tzu|999999|[historical, Chinese, Asian culture]";

        try {

            //declare LibraryBook for testing
            @SuppressWarnings("unchecked")
            LibraryBook testBook = getLibraryBook();

            //prepare methods from Application
            @SuppressWarnings("unchecked")
            Method returnBookList = Application.class.getMethod("returnBookList", String.class,
                    String.class,
                    String.class,
                    String.class,
                    String.class);
            @SuppressWarnings("unchecked")
            Method getAuthor = LibraryBook.class.getMethod("getAuthor");
            @SuppressWarnings("unchecked")
            Method getTitle = LibraryBook.class.getMethod("getTitle");
            @SuppressWarnings("unchecked")
            Method getIsbn = LibraryBook.class.getMethod("getIsbn");
            @SuppressWarnings("unchecked")
            Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
            // end of method preparation

            ArrayList<LibraryBook> bookList = (ArrayList<LibraryBook>) returnBookList.invoke(Application.class, TESTBOOK_1, TESTBOOK_2, TESTBOOK_3, TESTBOOK_4, TESTBOOK_5);
            assertEquals(5, bookList.size());
            assertTrue(bookList.get(0) instanceof LibraryBook);
            assertEquals("The Hobbit", getTitle.invoke(bookList.get(0)));

            assertTrue(bookList.get(1) instanceof LibraryBook);
            assertEquals("Dune", getTitle.invoke(bookList.get(1)));

            assertTrue(bookList.get(2) instanceof LibraryBook);
            assertEquals("The Nonsense Book", getTitle.invoke(bookList.get(2)));

            assertTrue(bookList.get(3) instanceof LibraryBook);
            assertEquals("The Cat in the Hat", getTitle.invoke(bookList.get(3)));

            assertTrue(bookList.get(4) instanceof LibraryBook);
            assertEquals("The Art of War", getTitle.invoke(bookList.get(4)));
        }
        catch(Exception e){
            fail("Missing or incorrectly defined method: " + e.getMessage());
        }
    }


}