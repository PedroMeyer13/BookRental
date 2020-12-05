package Data;

import CustomMade.MyQueue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WaitingList {

    private String[] data;
    private String user;
    private int counter = 0;

    // get the queue to be used in the program
    public MyQueue getWaitingList(Integer bookId){
        // create a new queue to store the information from the file
        MyQueue queue = new MyQueue();

        try{
            // read the file
            String filePath = new File("src\\BooksQueue\\Book"+bookId).getAbsolutePath();
            BufferedReader buffer = new BufferedReader(new FileReader(filePath));
            // store the content of the file in a String
            String contentLine = buffer.readLine();
            buffer.close();

            // if the content is not null, add the information on a queue
            if (contentLine != null){
                data = contentLine.split(",");

                // loop through the content and store on the queue
                while (counter <= data.length -1) {
                    queue.Enqueue(data[counter]);
                    counter++;
                }
            }

        }catch (Exception e){
            System.out.println("Your queue could not be generated");
        }

        // return the queue
        return queue;
    }
}
