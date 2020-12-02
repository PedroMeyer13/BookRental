package Model;

import CustomMade.MyQueue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddQueue {
    private String user;
    WaitingList wait = new WaitingList();

    public void ChangeWaitingList(int bookId, String readerName,Integer option) {

        MyQueue newQueue = wait.getWaitingList(bookId);
        if (option == 1){
            newQueue.Enqueue(readerName);
        }else {
            newQueue.Dequeue();
        }

        try {
            String filePath = new File("src\\BooksQueue\\Book"+bookId).getAbsolutePath();
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.close();


            while (!newQueue.isEmpty()){
                FileWriter fr = new FileWriter(filePath, true);
                BufferedWriter br = new BufferedWriter(fr);
                user = newQueue.First();
                br.write(user+",");
                newQueue.Dequeue();

                br.close();
                fr.close();
            }
        } catch (IOException ex) {
            System.out.println("Could not add the user in the waiting list");
        }
    }
}
