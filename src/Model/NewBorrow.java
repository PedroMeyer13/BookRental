package Model;

import CustomMade.LinearSearch;
import Data.WaitingList;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class NewBorrow {
    TextFormat format = new TextFormat();
    LinearSearch search = new LinearSearch();
    WaitingList waitingList = new WaitingList();
    AddQueue AddQ = new AddQueue();

    // method to record when a user borrow a new Book
    public void ValidateBorrow(ArrayList<Reader> readers, Map<Integer, Borrowings> borrowings, Map<Integer, Book> map, Map<Integer, ArrayList> history){

        try {
            // Present the user with the information necessary to perform the task
            System.out.println("Enter the User's ID");

            // get the user input and store
            Scanner userBorrowing = new Scanner(System.in);
            Integer id = userBorrowing.nextInt() - 1;
            // Present the user with the information necessary to perform the task
            System.out.println("Enter the Book ID");

            // get the user input and store
            Scanner bookBorrowed = new Scanner(System.in);
            Integer bookId = bookBorrowed.nextInt();

            // first if to define if the ID is from a registered user
            if (readers.get(id).getId() == id + 1){
                // check if the book id is valid
                if (map.get(bookId).getId() == bookId){
                    // check if the user has a book rented currently
                    if(search.BorrowSearch(readers.get(id).getId()) == null){
                        // check if the book is available
                        if (map.get(bookId).getAvailable().equals("yes")){
                            // update the book Map to display that the book has been rented and is no longer available
                            map.replace(bookId, new Book(bookId, map.get(bookId).getTitle(), map.get(bookId).getAuthor(), "no"));
                            // update the map of borrowings
                            borrowings.put(readers.get(id).getId(), new Borrowings(readers.get(id).getId(), readers.get(id).getName(), map.get(bookId).getTitle()));
                            // update the file that show that the user has rented a book
                            format.updateBorrowings(borrowings);
                            //update the file of Books
                            format.AddBorrow(map);
                            // update the history file
                            format.UpdateHistory(history, readers.get(id).getId(),map.get(bookId).getTitle());

                            // check if the user is in the queue to rent the book, if yes, remove the name of the user from the list
                            if (waitingList.getWaitingList(bookId).First().equals(readers.get(id).getName())){
                                AddQ.ChangeWaitingList(map.get(bookId).getId(), readers.get(id).getName(),0);
                            }

                            //Print that the operation was completed successfully
                            System.out.println("Borrowing was registered in the system");
                        }else {
                            // if the book is not available, ask the user if he wants to enter the queue
                            System.out.println("This book is not available. Would you like to be added to the Waiting List ? Y / N");
                            Scanner userInput = new Scanner(System.in);
                            String wait = userInput.next();

                            // if the user wants to be put in the queue, add them and update the file
                            if (wait.toLowerCase().contains("y")){
                                AddQ.ChangeWaitingList(map.get(bookId).getId(), readers.get(id).getName(),1);
                                System.out.println("You've been added to the list");
                            }
                        }
                    }else {
                        System.out.println("The user needs to return a book before borrowing a new book.");
                    }
                }
            }else {
                System.out.println("This ID is incorrect or user is not registered ");
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
