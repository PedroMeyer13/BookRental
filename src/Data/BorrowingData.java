package Data;

import Entity.Borrowings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BorrowingData {

    private String[] data;
    private Integer readerId;
    private String readerName;
    private String bookName;


    public Map<Integer,Borrowings> BorrowsList(){

        // Create an Map to store the Borrows  file
        Map<Integer, Borrowings> borrowList = new HashMap<Integer, Borrowings>();

        try {
            // get the file path
            String filePath = new File("src\\Files\\Borrowings").getAbsolutePath();
            // read the file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // store the content on a String
            String contentLine = br.readLine();

            // loop through the file and create a new instance of Borrowings
            while (contentLine != null) {
                data = contentLine.split(",");
                Borrowings borrow = new Borrowings(
                        readerId = Integer.parseInt(data[0]),
                        readerName = data[1],
                        bookName = data[2]
                );
                // add the new instance to the map
                borrowList.put(readerId,borrow);
                // get the nest line
                contentLine = br.readLine();
            }
        }catch(IOException ex){
            System.out.println("File no Found");
        }
        // return the map
        return borrowList;
    }

}
