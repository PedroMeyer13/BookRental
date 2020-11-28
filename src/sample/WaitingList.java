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
    public void InsertWaitingList() {

        try {
            MyQueue newQueue = new MyQueue();

            System.out.println("Enter the name of the book");
            Scanner userInput = new Scanner(System.in);
            String bookname = userInput.next();

            String filePath = new File("src\\BooksQueue\\"+bookname).getAbsolutePath();
            BufferedReader buffer = new BufferedReader(new FileReader(filePath));
            String contentLine = buffer.readLine();

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
            writer.write("");
            writer.flush();

            if (contentLine != null){
                System.out.println("If statement");
                System.out.println(counter);
                data = contentLine.split(" ");
                System.out.println(data.length +" Here");

                while (counter <= data.length -1) {
                    newQueue.Enqueue(data[counter]);
                    counter++;
                }
            }

            System.out.println("Enter the name of user");
            Scanner userName = new Scanner(System.in);
            String username = userName.next();

            newQueue.Enqueue(username);

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
