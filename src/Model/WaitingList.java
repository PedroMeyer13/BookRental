package Model;

import CustomMade.MyQueue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WaitingList {

    private String[] data;
    private String user;
    private int counter = 0;

    public MyQueue getWaitingList(Integer bookId){
        MyQueue queue = new MyQueue();

        try{
            String filePath = new File("src\\BooksQueue\\Book"+bookId).getAbsolutePath();
            BufferedReader buffer = new BufferedReader(new FileReader(filePath));
            String contentLine = buffer.readLine();

            buffer.close();

            if (contentLine != null){
                data = contentLine.split(",");

                while (counter <= data.length -1) {
                    queue.Enqueue(data[counter]);
                    counter++;
                }
            }

        }catch (Exception e){
            System.out.println("Your queue could not be generated");
        }

        return queue;
    }
}
