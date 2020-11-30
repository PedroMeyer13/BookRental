package MenuController;

import java.util.Scanner;

public class mainMenu {

    public mainMenu() throws InterruptedException {

        System.out.println("Select one operation to perform\n");
        System.out.println("Press 1 to Search for a book by title and/or author name.");
        System.out.println("Press 2 to List all books by title and/or author name alphabetical order.");
        System.out.println("Press 3 to Search for a specific reader by name and/or ID.");
        System.out.println("Press 4 to List all readers by alphabetical and/or ID order.");
        System.out.println("Press 5 to Register that a reader has borrowed a book.");
        System.out.println("Press 6 to add a Reader to a waiting list");
        System.out.println("Press 7 to Register that a reader has returned a book.");
        System.out.println("Press 8 to For a specific reader, list the books that they have borrowed.");
        //" 7 to If a book is returned and has a waiting queue, display to the user the next reader waiting for that book.


        Scanner userInput = new Scanner ( System.in );
        int menuOption = userInput.nextInt();

        new MenuController(menuOption);
    }
}
