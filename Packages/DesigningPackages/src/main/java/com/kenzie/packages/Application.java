package com.kenzie.packages;

//import dependencies
import com.kenzie.packages.book.service.BookRequestService;
import com.kenzie.packages.logger.service.Logger;
import com.kenzie.packages.model.LibraryBook;

import java.util.ArrayList;


public class Application {

    /*
        This method should take in a response String as a parameter.
        It should instantiate a LibraryBook object and
        use the response string to set book info. Return the generated object.
     */
    public static LibraryBook convertResponseToLibraryBook(String response){
        return null;
    }

    /*
        This method should take in 5 formatted response Strings.
        Within the method, instantiate five LibraryBook objects.
        Create an `ArrayList<LibraryBook>` object, fill it with generated books,
        and return the resultant ArrayList.
     */
    public static ArrayList<LibraryBook> returnBookList(String response1,
                                                        String response2,
                                                        String response3,
                                                        String response4,
                                                        String response5) {
        return null;
    }

    public static void main(String[] args) {
        // Use these constant values as test input
        final String BOOK_1 = "The Hobbit|J.R.R. Tolkien||";
        final String BOOK_2 = "Dune|Frank Herbert||";
        final String BOOK_3 = "The Nonsense Book|Mr. Myzlplk||";
        final String BOOK_4 = "The Cat in the Hat|Dr. Seuss||";
        final String BOOK_5 = "The Art of War|Sun Tzu||";

        try {
            // Write code inside this try/catch block
            // 1. Instantiate Singleton Logger object to log: "Process starting"
            // 2. Repeat for all five books listed (you do not need to loop):
            //      a. Call BookRequestService.sendGetRequest()
            //      b. Get the String response as the return value
            //      c. Use Logger to log each response string
            // 3. Call the returnBookList() method with each response string
            //        and print the results with System.out.println()
            //        to make sure the method works and toString() is overridden.
            // 4. User Logger to log: "Process complete"

        }
        catch (Exception e){
            System.out.println("Error occurred: unable to request book info");
            System.out.println("Exception info:" + e.getMessage());
        }
    }

}