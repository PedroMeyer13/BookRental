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

    public Reader ReadersSearch(Integer id,String targetName,ArrayList<Reader> readers){
        // Going one by one the elements in the array
        for(int i = 0; i < readers.size(); i++){
            // When the element is found, stop the loop and return the index
            if(readers.get(i).getId() == id  || readers.get(i).getName().equals(targetName)){
                return readers.get(i);

            }
        }
        return null;
    }

    public Book BookSearch(String bookName,Map<Integer, Book> map){

        try {
            // Going one by one the elements in the array
            for (Integer key : map.keySet()) {
                if (map.get(key).getTitle().contains(bookName) || map.get(key).getAuthor().contains(bookName) ) {
                    return (map.get(key));
                }
            }

        }catch (Exception e){
        }
        return map.get(bookName);
    }
}
