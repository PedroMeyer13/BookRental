package Model;

import CustomMade.LinearSearch;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ReturnBook {

    TextFormat format = new TextFormat();
    LinearSearch search = new LinearSearch();
    WaitingList waitingList = new WaitingList();

    public void BookReturn (ArrayList<Reader> readers, Map<Integer, Borrowings> borrowings, Map<Integer, Book> map){

        System.out.println("Enter the User's ID");
        Scanner userBorrowing = new Scanner(System.in);
        Integer id = userBorrowing.nextInt();

        if (readers.get(id -1).getId() == id){

            int IdBook = search.BookSearch(borrowings.get(id).getBookName(), map);
            map.replace(IdBook, new Book(IdBook, map.get(IdBook).getTitle(), map.get(IdBook).getAuthor(), "yes"));
            format.AddBorrow(map);

            borrowings.remove(id);
            format.updateBorrowings(borrowings);

            System.out.println("The Books was returned");
            System.out.println("The next in Line for the Books is : " + waitingList.getWaitingList(IdBook).First());

        }else{
            System.out.println("There is no user with this ID");
        }
    }
}
