package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DataWriter  {
    public void FileUpdate(String text, String location){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src\\Files\\"+ location).getAbsolutePath()));
            writer.write(text);
            writer.close();
        }catch (Exception e){
            System.out.println("FIle could not be updated");
        }
    }
}
