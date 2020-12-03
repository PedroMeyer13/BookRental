package MenuController;

import CustomMade.LinearSearch;
import Data.BooksMaps;
import Data.BorrowingData;
import Data.ReadersInfo;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;
import Model.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    public MenuController(int menuOption){

        NewBorrow myBorrow = new NewBorrow();
        LinearSearch search = new LinearSearch();
        MenuRepeat repeat = new MenuRepeat();
        Map<Integer, ArrayList> myHistory = new CustomerHistory().History();
        Map<Integer, Book>  myBooks = new BooksMaps().loadData();
        ArrayList<Reader> myReaders = new ReadersInfo().ReadersData();
        Map<Integer, Borrowings> myBorrowings = new BorrowingData().BorrowsList();
        AddQueue queue = new AddQueue();

        switch ( menuOption ) {
            case 1:
                System.out.println("Enter the name of the book");
                Scanner userChoice = new Scanner(System.in);
                String bookname = userChoice.next();
                System.out.println(search.ReadersSearch(bookname,myReaders));
                repeat.Repeat();
                break;

            case 2:
                TextFormat format = new TextFormat();
                format.UpdateHistory(myHistory,2,"Moby Dick");

                repeat.Repeat();
                break;
            case 3:
                repeat.Repeat();
                break;
            case 4:
                repeat.Repeat();
                break;
            case 5:
                myBorrow.ValidateBorrow(myReaders,myBorrowings,myBooks,myHistory);
                repeat.Repeat();
                break;
            case 6:

                System.out.println("Enter the Book Id");
                userChoice = new Scanner(System.in);
                int book = userChoice.nextInt();

                System.out.println("Enter the Reader name");
                userChoice = new Scanner(System.in);
                String rName = userChoice.next();

                queue.ChangeWaitingList(book,rName,1);
                System.out.println("You've been added to the list");

                repeat.Repeat();
                break;
            case 7:
                repeat.Repeat();
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
                repeat.Repeat();
                break;
            default:
                System.err.println ( "\nUnrecognized option, try again." );
                repeat.Repeat();
                break;
        }

    }
}
