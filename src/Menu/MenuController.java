package Menu;

import CustomMade.LinearSearch;
import Data.BooksMaps;
import Data.BorrowingData;
import Data.DataWriter;
import Data.ReadersInfo;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;
import FilesUpdates.NewBorrow;
import sample.CustomerHistory;
import sample.WaitingList;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    public MenuController(int menuOption){

        NewBorrow myBorrow = new NewBorrow();
        LinearSearch search = new LinearSearch();
        MenuRepeat repeat = new MenuRepeat();
        DataWriter dataWriter = new DataWriter();
        Map<Integer, ArrayList> myHistory = new CustomerHistory().History();
        Map<Integer, Book>  myBooks = new BooksMaps().loadData();
        ArrayList<Reader> myReaders = new ReadersInfo().ReadersData();
        ArrayList<Borrowings> myBorrowings = new BorrowingData().BorrowsList();


        switch ( menuOption ) {
            case 1:
                System.out.println("Enter the name of the book");
                Scanner userChoice = new Scanner(System.in);
                String bookname = userChoice.next();
                System.out.println(search.ReadersSearch(bookname,myReaders));
                System.out.println("\nGoing back to the main menu in 15 sec");
                repeat.Repeat();
                break;

            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                try {
                    System.out.println("Enter the User's ID and Book ID");
                    Scanner userBorrowing = new Scanner(System.in);
                    Scanner bookBorrowed = new Scanner(System.in);
                    Integer id = userBorrowing.nextInt() - 1;
                    Integer bookId = bookBorrowed.nextInt();
                    if (myReaders.get(id).getId() == id + 1){
                        if (myBooks.get(bookId).getId() == bookId){
                            if(myBooks.get(bookId).getAvailable().equals("yes")){
                                System.out.println("Borrowing was registered in the system");
                                myBooks.replace(bookId, new Book(bookId, myBooks.get(bookId).getTitle(), myBooks.get(bookId).getAuthor(), "no"));
                                dataWriter.FileUpdate(myBorrow.AddBorrow(myBooks));
                            }else {
                                System.out.println("This book is not available. Would you like to be added to the Waiting List ? Y / N");
                                Scanner userInput = new Scanner(System.in);
                                String wait = userInput.next();
                                if (wait.toLowerCase().contains("y")){
                                    new WaitingList().InsertWaitingList(myBooks.get(bookId).getId(), myReaders.get(id).getName());
                                    System.out.println("You've been added to the list");
                                }
                            }
                        }
                    }else {
                        System.out.println("This ID is incorrect or user is not registered ");
                    }
                }catch (Exception e){
                    System.out.println("This ID is not in the system");
                }
                repeat.Repeat();
                break;
            case 6:

                break;
            case 7:

                break;
            case 8:
                System.out.println("Enter the Reader ID");
                Scanner userId = new Scanner(System.in);
                Integer bookHistory = userId.nextInt();

                if (myHistory.containsKey(bookHistory) == true){
                    System.out.println(myHistory.get(bookHistory));
                }else{
                    System.out.println("\nThe user Id is incorrect or the user has never rented a book in the store.");
                }
                repeat.Repeat();

                break;
            case 9:

                break;
            default:
                System.err.println ( "\nUnrecognized option, try again." );
                break;
        }

    }
}
