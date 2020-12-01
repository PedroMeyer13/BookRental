package Model;

import Entity.Book;
import Entity.Borrowings;

import java.util.Map;


public class TextFormat {

    private String str = "";
    private int counter = 1;
    DataWriter dataWriter = new DataWriter();

    public void AddBorrow(Map<Integer, Book> newMap){
        try{
            str = "";
            while (counter <= 10){
                str = str.concat(newMap.get(counter).getId()+","+newMap.get(counter).getTitle()+","+newMap.get(counter).getAuthor()+","+newMap.get(counter).getAvailable()+"\n");
                counter++;
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("From Books");
        }
        dataWriter.FileUpdate(str);
    }

    public void updateBorrowings(Map<Integer, Borrowings> borrow){
        str = "";
        try{
            for (Integer key : borrow.keySet()){
                str = str.concat(borrow.get(key).getReaderId() +","+borrow.get(key).getReaderName()+","+borrow.get(key).getBookName()+"\n");
            }
        }catch (Exception e){
            System.out.println("Borrowing file could not be updated");
        }
        dataWriter.BorrowingUpdate(str);
    }
}
