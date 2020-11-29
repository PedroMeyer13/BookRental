package Data;

import Entity.Borrowings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BorrowingData {

    private String[] data;
    private Integer readerId;
    private String readerName;
    private String bookName;


    public ArrayList<Borrowings> BorrowsList(){

        ArrayList<Borrowings> borrowList = new ArrayList<>();

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
                borrowList.add(borrow);
                contentLine = br.readLine();
            }
        }catch(IOException ex){
            System.out.println("File no Found");
        }
        return borrowList;
    }

}
