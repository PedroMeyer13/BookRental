package Model;

import Entity.Borrowings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class DataWriter  {

    public void FileUpdate(String text){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src\\Files\\Books").getAbsolutePath()));
            writer.write(text);
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void BorrowingUpdate(String txt){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src\\Files\\Borrowings").getAbsolutePath()));
            writer.write(txt);
            writer.close();
        }catch (Exception e){
            System.out.println("FIle could not be updated");
        }
    }
}
