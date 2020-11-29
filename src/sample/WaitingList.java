package sample;

import CustomMade.MyQueue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WaitingList {

    private String[] data;
    private String user;
    private int counter = 0;


    public void InsertWaitingList(int bookId, String readerName) {
        try {
            MyQueue newQueue = new MyQueue();

            String filePath = new File("src\\BooksQueue\\Book"+bookId).getAbsolutePath();
            BufferedReader buffer = new BufferedReader(new FileReader(filePath));
            String contentLine = buffer.readLine();

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.write("");
            writer.flush();

            if (contentLine != null){
                data = contentLine.split(" ");

                while (counter <= data.length -1) {
                    newQueue.Enqueue(data[counter]);
                    counter++;
                }
            }

            newQueue.Enqueue(readerName);

            while (!newQueue.isEmpty()){
                FileWriter fr = new FileWriter(filePath, true);
                BufferedWriter br = new BufferedWriter(fr);
                user = newQueue.First();
                br.write(user+" ");
                newQueue.Dequeue();

                br.close();
                fr.close();
            }
        } catch (IOException ex) {
      }
    }

    public void ExcludeWaitingList(){

    }

}
