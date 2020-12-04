package MenuController;

import CustomMade.LinearSearch;
import CustomMade.MySort;
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
        ReturnBook returnBook = new ReturnBook();
        MySort mySort = new MySort();
        Scanner userChoice = new Scanner(System.in);

        switch ( menuOption ) {
            case 1://Search for a specific book by title and/or author name.
                System.out.println("Enter the name of the title or author");
                userChoice = new Scanner(System.in);
                String optionGiven = userChoice.next();
                System.out.println(search.BookSearch(optionGiven, myBooks));
                repeat.Repeat();
                break;
            case 2:
                System.out.println("Would you like the books listed by Author or Title");
                System.out.println(" Title: 1 \n Author: 2");
                userChoice = new Scanner(System.in);
                Integer in = userChoice.nextInt();
                if (in == 1 || in == 2){
                    System.out.println(mySort.PrintSortedBook(mySort.BookSort(myBooks, in)));
                }else{
                    System.out.println("This option is not recognized. Try again and enter the correct number !!");
                }
                repeat.Repeat();
                break;
            case 3:
                System.out.println("Would you like to search by ID or Name");
                System.out.println(" ID: 1  \n Name: 2");
                userChoice = new Scanner(System.in);
                Integer userOp= userChoice.nextInt();

                if (userOp == 1){
                    System.out.println("Enter the User ID");
                    userChoice = new Scanner(System.in);
                    Integer userId= userChoice.nextInt();
                    System.out.println(search.ReadersSearch(userId,null,myReaders));
                }else{
                    System.out.println("Enter the User Name");
                    userChoice = new Scanner(System.in);
                    String userName= userChoice.next();
                    System.out.println(search.ReadersSearch(0,userName,myReaders));
                }

                repeat.Repeat();
                break;
            case 4:
                System.out.println("Would you like the Readers listed by ID or Name");
                System.out.println(" ID: 1  \n Name: 2");
                userChoice = new Scanner(System.in);
                Integer userIn = userChoice.nextInt();
                if (userIn == 1 || userIn == 2){
                    System.out.println(mySort.PrintSortedReaders(mySort.ReaderSort(myReaders, userIn)));
                }else {
                    System.out.println("This option is not recognized. Try again and enter the correct number !!");
                }
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
                returnBook.BookReturn(myReaders,myBorrowings,myBooks);
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
            default:
                System.err.println ( "\nUnrecognized option, try again." );
                repeat.Repeat();
                break;
        }

    }
}
