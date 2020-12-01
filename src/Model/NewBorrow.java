package Model;

import CustomMade.LinearSearch;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class NewBorrow {
    TextFormat format = new TextFormat();
    LinearSearch search = new LinearSearch();

    public void ValidateBorrow(ArrayList<Reader> readers, Map<Integer, Borrowings> borrowings, Map<Integer, Book> map){
        try {
            System.out.println("Enter the User's ID");
            Scanner userBorrowing = new Scanner(System.in);
            Integer id = userBorrowing.nextInt() - 1;
            System.out.println("Enter the Book ID");
            Scanner bookBorrowed = new Scanner(System.in);
            Integer bookId = bookBorrowed.nextInt();
            if (readers.get(id).getId() == id + 1){
                if (map.get(bookId).getId() == bookId){
                    if(search.BorrowSearch(readers.get(id).getId()) == null){
                        if (map.get(bookId).getAvailable().equals("yes")){
                            System.out.println("Borrowing was registered in the system");
                            map.replace(bookId, new Book(bookId, map.get(bookId).getTitle(), map.get(bookId).getAuthor(), "no"));
                            borrowings.put(readers.get(id).getId(), new Borrowings(readers.get(id).getId(), readers.get(id).getName(), map.get(bookId).getTitle()));
                            format.updateBorrowings(borrowings);
                            format.AddBorrow(map);
                        }else {
                            System.out.println("This book is not available. Would you like to be added to the Waiting List ? Y / N");
                            Scanner userInput = new Scanner(System.in);
                            String wait = userInput.next();
                            if (wait.toLowerCase().contains("y")){
                                new WaitingList().InsertWaitingList(map.get(bookId).getId(), readers.get(id).getName());
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
            System.out.println("User ID or Book ID are Not in the System.");
        }
    }
}
