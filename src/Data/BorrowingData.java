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

        Map<Integer, Borrowings> borrowList = new HashMap<Integer, Borrowings>();

        try {
            String filePath = new File("src\\Files\\Borrowings").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();


            while (contentLine != null) {
                data = contentLine.split(",");
                Borrowings borrow = new Borrowings(
                        readerId = Integer.parseInt(data[0]),
                        readerName = data[1],
                        bookName = data[2]
                );
                borrowList.put(readerId,borrow);
                contentLine = br.readLine();
            }
        }catch(IOException ex){
            System.out.println("File no Found");
        }
        return borrowList;
    }

}
