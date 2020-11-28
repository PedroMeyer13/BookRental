package Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataWriter  {

    public DataWriter(){

        try{
            Scanner userInput= new Scanner(System.in);
            System.out.println("The readers name");

            String userName = userInput.nextLine();
            System.out.println("Username is :" + userName);


            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\pedro\\Desktop\\teste\\Userinput.txt")));
            writer.write(userName);
            writer.close();

        }catch (Exception e){

        }
    }
}
