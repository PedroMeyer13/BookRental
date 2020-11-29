package CustomMade;

import Entity.Borrowings;
import Entity.Reader;

import java.util.ArrayList;

public class LinearSearch {

    /*
     * This method will receive an array and a value to be searched in the array
     */
    public int linealSearch(ArrayList<Integer> array, int target){

        // Going one by one the elements in the array
        for(int i = 0; i < array.size(); i++){
            System.out.println("Testing: " + array.get(i));
            // When the element is found, stop the loop and return the index
            if(array.get(i) == target){
                return i;
            }
        }
        return -1;
    }

    public Borrowings BorrowSearch(Integer targetId, ArrayList<Borrowings>borrowList){

        ArrayList<Borrowings> records = borrowList;

        // Going one by one the elements in the array
        for(int i = 0; i < records.size(); i++){
            // When the element is found, stop the loop and return the index
            if(records.get(i).getReaderId().equals(targetId)){
                System.out.println(records.get(targetId).getReaderName());

                return (records.get(targetId));

            }
        }
        System.out.println("This Element is not in the Array");
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

}
