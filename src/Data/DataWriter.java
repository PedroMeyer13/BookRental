package Data;

import Entity.Book;

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

        }
    }
}
