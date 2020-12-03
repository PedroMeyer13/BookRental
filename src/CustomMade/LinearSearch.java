package CustomMade;

import Data.BorrowingData;
import Entity.Book;
import Entity.Borrowings;
import Entity.Reader;

import java.util.ArrayList;
import java.util.Map;

public class LinearSearch {

    public Borrowings BorrowSearch(Integer userId){

        Map<Integer, Borrowings> borrowings = new BorrowingData().BorrowsList();
        try {
            // Going one by one the elements in the array
            for (Integer key : borrowings.keySet()) {
                if (borrowings.get(key).getReaderId().equals(userId) == true) {
                    return (borrowings.get(userId));
                }
            }

        }catch (Exception e){
        }
        return null;
    }

    public String ReadersSearch(String targetName, ArrayList<Reader> readers){

        ArrayList<Reader> records = readers;

        // Going one by one the elements in the array
        for(int i = 0; i < records.size(); i++){
            System.out.println("Found\n Name: " + records.get(i).getName() + " Address: " + records.get(i).getAddress());
            // When the element is found, stop the loop and return the index
            if(records.get(i).getName().equals(targetName)){
                return "Is this title available?  " + records.get(i);

            }
        }
        return "not Found";
    }

    public Integer BookSearch(String bookName, Map<Integer, Book> map){

        try {
            // Going one by one the elements in the array
            for (Integer key : map.keySet()) {
                if (map.get(key).getTitle().contains(bookName)) {
                    return (map.get(key).getId());
                }
            }

        }catch (Exception e){
        }
        return null;
    }
}
