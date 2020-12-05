package Model;

import CustomMade.MyQueue;
import Data.WaitingList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddQueue {

    private String user;
    WaitingList wait = new WaitingList();

    //Create a Waiting list to store the reader waiting to rent a specific book
    public void ChangeWaitingList(int bookId, String readerName,Integer option) {

        // create a new instance of the custom made queue
        MyQueue newQueue = wait.getWaitingList(bookId);
        // if the value of option is 1, we add a new user to the list
        if (option == 1){
            newQueue.Enqueue(readerName);
            // if the value is different we remove a user from the list
        }else {
            newQueue.Dequeue();
        }

        try {
            // get the file that is store the queues for each book
            String filePath = new File("src\\BooksQueue\\Book"+bookId).getAbsolutePath();
            // clean the file to store the new modified queue
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.close();

            // loop trough the queue and store on the file
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
