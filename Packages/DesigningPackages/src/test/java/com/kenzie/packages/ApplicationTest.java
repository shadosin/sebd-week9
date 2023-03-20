package com.kenzie.packages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.kenzie.packages.model.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Order(1)
    public static LibraryBook getLibraryBook() {
        try {
            @SuppressWarnings("unchecked")
            Constructor constructor = LibraryBook.class.getConstructor();
            @SuppressWarnings("unchecked")
            LibraryBook book = (LibraryBook) constructor.newInstance();
            return book;
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Order(2)
    @Test
    void convertResponseToLibraryBook_TEST1() throws Exception {
        LibraryBook testBook = getLibraryBook();

        Method convertResponseToLibraryBook = Application.class.getMethod("convertResponseToLibraryBook", String.class);
        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

        final String TESTBOOK_1 = "The Hobbit|J.R.R. Tolkien|123456|[Fiction]";
        LibraryBook tempBook = (LibraryBook) convertResponseToLibraryBook.invoke(Application.class, TESTBOOK_1);
        assertEquals("The Hobbit", getTitle.invoke(tempBook), "Title matches expected value after converting from response String");
        assertEquals("J.R.R. Tolkien", getAuthor.invoke(tempBook), "Author matches expected value after converting from response String");
        assertEquals("123456", getIsbn.invoke(tempBook), "ISBN matches expected value after converting from response String");
        assertEquals("[Fiction]", getSubjectList.invoke(tempBook), "Subject List matches expected value after converting from response String");

    }

    @Order(3)
    @Test
    void convertResponseToLibraryBook_TEST2() throws Exception {
        LibraryBook testBook = getLibraryBook();

        Method convertResponseToLibraryBook = Application.class.getMethod("convertResponseToLibraryBook", String.class);
        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");


        final String TESTBOOK_1 = "The Lord of the Rings|J.R.R. Tolkien|5678920|[Fiction]";
        LibraryBook tempBook = (LibraryBook) convertResponseToLibraryBook.invoke(Application.class, TESTBOOK_1);
        assertEquals("The Lord of the Rings", getTitle.invoke(tempBook), "Title matches expected value after converting from response String");
        assertEquals("J.R.R. Tolkien", getAuthor.invoke(tempBook), "Author matches expected value after converting from response String");
        assertEquals("5678920", getIsbn.invoke(tempBook), "ISBN matches expected value after converting from response String");
        assertEquals("[Fiction]", getSubjectList.invoke(tempBook), "Subject List matches expected value after converting from response String");

    }

    @Order(4)
    @Test
    void convertResponseToLibraryBook_TEST3() throws Exception {
        LibraryBook testBook = getLibraryBook();

        Method convertResponseToLibraryBook = Application.class.getMethod("convertResponseToLibraryBook", String.class);
        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

        final String TESTBOOK_1 = "Harry Potter and the Chamber of Secrets|J.K. Rowling|1098765|[Fiction]";
        LibraryBook tempBook = (LibraryBook) convertResponseToLibraryBook.invoke(Application.class, TESTBOOK_1);
        assertEquals("Harry Potter and the Chamber of Secrets", getTitle.invoke(tempBook), "Title matches expected value after converting from response String");
        assertEquals("J.K. Rowling", getAuthor.invoke(tempBook), "Author matches expected value after converting from response String");
        assertEquals("1098765", getIsbn.invoke(tempBook), "ISBN matches expected value after converting from response String");
        assertEquals("[Fiction]", getSubjectList.invoke(tempBook), "Subject List matches expected value after converting from response String");
    }

    @Order(5)
    @Test
    void returnBookList_TEST1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final String TESTBOOK_1 = "The Hobbit|J.R.R. Tolkien|123456|[Fiction]";
        final String TESTBOOK_2 = "Dune|Frank Herbert|234567|[Science fiction, movie]";
        final String TESTBOOK_3 = "The Nonsense Book|Mr. Myzlplk||[]";
        final String TESTBOOK_4 = "The Cat in the Hat|Dr. Seuss|00000|[childrens, illustrated, award-winning]";
        final String TESTBOOK_5 = "The Art of War|Sun Tzu|999999|[historical, Chinese, Asian culture]";


        LibraryBook testBook = getLibraryBook();

        Method returnBookList = Application.class.getMethod("returnBookList", String.class,
                String.class,
                String.class,
                String.class,
                String.class);
        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

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

    @Order(6)
    @Test
    void returnBookList_TEST2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        final String TESTBOOK_1 = "The Lord of the Rings|J.R.R. Tolkien|5678920|[Fiction]";
        final String TESTBOOK_2 = "Harry Potter and the Chamber of Secrets|Frank Herbert|234567|[Science fiction, movie]";
        final String TESTBOOK_3 = "The Nonsense Book|Mr. Myzlplk||[]";
        final String TESTBOOK_4 = "Green Eggs and Ham|Dr. Seuss|203921|[childrens, illustrated]";
        final String TESTBOOK_5 = "Holes|Louis Sachar|010101|[Fiction, movie]";

        LibraryBook testBook = getLibraryBook();


        Method returnBookList = Application.class.getMethod("returnBookList", String.class,
                String.class,
                String.class,
                String.class,
                String.class);
        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");

        ArrayList<LibraryBook> bookList = (ArrayList<LibraryBook>) returnBookList.invoke(Application.class, TESTBOOK_1, TESTBOOK_2, TESTBOOK_3, TESTBOOK_4, TESTBOOK_5);
        assertEquals(5, bookList.size());
        assertTrue(bookList.get(0) instanceof LibraryBook);
        assertEquals("The Lord of the Rings", getTitle.invoke(bookList.get(0)));

        assertTrue(bookList.get(1) instanceof LibraryBook);
        assertEquals("Harry Potter and the Chamber of Secrets", getTitle.invoke(bookList.get(1)));

        assertTrue(bookList.get(2) instanceof LibraryBook);
        assertEquals("The Nonsense Book", getTitle.invoke(bookList.get(2)));

        assertTrue(bookList.get(3) instanceof LibraryBook);
        assertEquals("Green Eggs and Ham", getTitle.invoke(bookList.get(3)));

        assertTrue(bookList.get(4) instanceof LibraryBook);
        assertEquals("Holes", getTitle.invoke(bookList.get(4)));
    }

    @Order(7)
    @Test
    void returnBookList_TEST3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final String TESTBOOK_1 = "Holes|Louis Sachar|010101|[Fiction, movie]";
        final String TESTBOOK_2 = "Green Eggs and Ham|Dr. Seuss|203921|[childrens, illustrated]";
        final String TESTBOOK_3 = "The Nonsense Book|Mr. Myzlplk||[]";
        final String TESTBOOK_4 = "Harry Potter and the Chamber of Secrets|Frank Herbert|234567|[Science fiction, movie]";
        final String TESTBOOK_5 = "The Lord of the Rings|J.R.R. Tolkien|5678920|[Fiction]";


        LibraryBook testBook = getLibraryBook();

        Method returnBookList = Application.class.getMethod("returnBookList", String.class,
                String.class,
                String.class,
                String.class,
                String.class);
        Method getAuthor = LibraryBook.class.getMethod("getAuthor");
        Method getTitle = LibraryBook.class.getMethod("getTitle");
        Method getIsbn = LibraryBook.class.getMethod("getIsbn");
        Method getSubjectList = LibraryBook.class.getMethod("getSubjectList");
        // end of method preparation

        ArrayList<LibraryBook> bookList = (ArrayList<LibraryBook>) returnBookList.invoke(Application.class, TESTBOOK_1, TESTBOOK_2, TESTBOOK_3, TESTBOOK_4, TESTBOOK_5);
        assertEquals(5, bookList.size());
        assertTrue(bookList.get(0) instanceof LibraryBook);
        assertEquals("Holes", getTitle.invoke(bookList.get(0)));

        assertTrue(bookList.get(1) instanceof LibraryBook);
        assertEquals("Green Eggs and Ham", getTitle.invoke(bookList.get(1)));

        assertTrue(bookList.get(2) instanceof LibraryBook);
        assertEquals("The Nonsense Book", getTitle.invoke(bookList.get(2)));

        assertTrue(bookList.get(3) instanceof LibraryBook);
        assertEquals("Harry Potter and the Chamber of Secrets", getTitle.invoke(bookList.get(3)));

        assertTrue(bookList.get(4) instanceof LibraryBook);
        assertEquals("The Lord of the Rings", getTitle.invoke(bookList.get(4)));

    }
}