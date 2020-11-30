package MenuController;

import CustomMade.LinearSearch;
import Data.BooksMaps;
import Data.BorrowingData;
import Model.DataWriter;
import Data.ReadersInfo;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;
import Model.NewBorrow;
import View.CustomerHistory;
import View.WaitingList;

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
        Map<Integer, Borrowings> myBorrowings = new BorrowingData().BorrowsList();


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

                myBorrow.ValidateBorrow(myReaders,myBorrowings,myBooks);
                repeat.Repeat();
                break;
            case 6:

                System.out.println("Enter the Book Id");
                userChoice = new Scanner(System.in);
                Integer book = userChoice.nextInt();

                System.out.println("Enter the Reader name");
                userChoice = new Scanner(System.in);
                String rName = userChoice.next();

                new WaitingList().InsertWaitingList(book,rName);
                System.out.println("You've been added to the list");
                repeat.Repeat();

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
