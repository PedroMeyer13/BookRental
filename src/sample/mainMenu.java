package sample;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mainMenu {

    Search search = new Search();

    public mainMenu() throws InterruptedException {
        System.out.println("Select one operation to perform\n");
        System.out.println("Press 1 to Search for a book by title and/or author name.");
        System.out.println("Press 2 to List all books by title and/or author name alphabetical order.");
        System.out.println("Press 3 to Search for a specific reader by name and/or ID.");
        System.out.println("Press 4 to List all readers by alphabetical and/or ID order.");
        System.out.println("Press 5 to Register that a reader has borrowed a book.");
        System.out.println("Press 6 to add a Reader to a waiting list");
        System.out.println("Press 7 to Register that a reader has returned a book.");
        System.out.println("Press 8 to If a book is returned and has a waiting queue, display to the user the next reader\n" +
                "waiting for that book.");
        System.out.println("Press 9 to For a specific reader, list the books that they have borrowed.");

        Scanner userInput = new Scanner ( System.in );

        BooksMaps booksMaps = new BooksMaps();

        switch ( userInput.nextInt() ) {
            case 1:
                System.out.println("Enter the name of the book");
                Scanner userChoice = new Scanner(System.in);
                String bookname = userChoice.next();
                System.out.println(search.linearSearch(bookname));
                System.out.println("\nGoing back to the main menu in 15 sec");
                TimeUnit.SECONDS.sleep(15);
                new mainMenu();

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            default:
                System.err.println ( "Unrecognized option, try again." );
                break;
        }

    }
}
