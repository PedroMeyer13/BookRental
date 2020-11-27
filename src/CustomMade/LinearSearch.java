package CustomMade;

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

}
