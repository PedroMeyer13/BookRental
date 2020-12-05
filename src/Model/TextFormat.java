package Model;

import Entity.Book;
import Entity.Borrowings;

import java.util.ArrayList;
import java.util.Map;


public class TextFormat {

    private String str = "";
    private int counter = 1;
    DataWriter dataWriter = new DataWriter();

    // get the String to store in a file
    public void AddBorrow(Map<Integer, Book> newMap){
        try{
            str = "";
            while (counter <= newMap.size()){
                str = str.concat(newMap.get(counter).getId()+","+newMap.get(counter).getTitle()+","+newMap.get(counter).getAuthor()+","+newMap.get(counter).getAvailable()+"\n");
                counter++;
            }
        }catch (Exception e){
            System.out.println("Borrowing file could not be completed");
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

    public void UpdateHistory(Map<Integer, ArrayList> history, Integer userId, String BookName){

        str = "";
        if (history.containsKey(userId)){

            history.get(userId).add(BookName);
        }else {
            ArrayList<String> newRent = new ArrayList<>();
            newRent.add(BookName);
            history.put(userId, newRent);
        }
        try{
            for (Integer key : history.keySet()){
                ArrayList<String> newList= history.get(key);
                str = str.concat(key.toString() + ",");
                for (String num : newList) {
                    str = str.concat(num + ",");
                }
                str = str.concat("\n");
            }
        }catch (Exception e){
            System.out.println("Borrowing file could not be updated");
        }
        dataWriter.HistoryUpdate(str);
    }
}
