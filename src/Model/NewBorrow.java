package Model;

import CustomMade.LinearSearch;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;
import View.WaitingList;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class NewBorrow {
    private String str = "";
    private int newBorrowId, Bname, Btitle;
    private int counter = 1;
    LinearSearch search = new LinearSearch();
    DataWriter dataWriter = new DataWriter();

    public String AddBorrow(Map<Integer, Book> newMap){
        try{
            str = Integer.toString(newMap.get(counter).getId());
            while (counter <= 10){
                str = str.concat(","+newMap.get(counter).getTitle()+","+newMap.get(counter).getAuthor()+","+newMap.get(counter).getAvailable()+"\n");
                counter++;
                str = str.concat( Integer.toString(newMap.get(counter).getId()));
            }
        }catch (Exception e){
        }
        return str;
    }

    public String updateBorrowings(Map<Integer,Borrowings> borrow){

        try{
            for (Integer key : borrow.keySet()){
                str = str.concat(Integer.toString(borrow.get(key).getReaderId()) +","+borrow.get(key).getReaderName()+","+borrow.get(key).getBookName()+"\n");
            }
        }catch (Exception e){
        }
        System.out.println(str);
        return str;
    }

    public void ValidateBorrow(ArrayList<Reader> readers, Map<Integer, Borrowings> borrowings, Map<Integer, Book> map){
        try {
            System.out.println("Enter the User's ID");
            Scanner userBorrowing = new Scanner(System.in);
            System.out.println("Enter the Book ID");
            Scanner bookBorrowed = new Scanner(System.in);
            Integer id = userBorrowing.nextInt() - 1;
            Integer bookId = bookBorrowed.nextInt();
            if (readers.get(id).getId() == id + 1){
                if (map.get(bookId).getId() == bookId){
                    if(search.BorrowSearch(readers.get(id).getId()) == null){
                       borrowings.put(id,new Borrowings(readers.get(id).getId(), readers.get(id).getName(), map.get(bookId).getTitle()));
                        if (map.get(bookId).getAvailable().equals("yes")){
                            System.out.println("Borrowing was registered in the system");
                            map.replace(bookId, new Book(bookId, map.get(bookId).getTitle(), map.get(bookId).getAuthor(), "no"));
                            dataWriter.FileUpdate(AddBorrow(map), "Books");
                            borrowings.put(readers.get(id).getId(), new Borrowings(readers.get(id).getId(),readers.get(id).getName(),map.get(bookId).getTitle()));
                            dataWriter.FileUpdate(updateBorrowings(borrowings), "Borrowings");
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
            System.out.println(e);
        }

    }


}
