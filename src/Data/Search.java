package Data;

import Entity.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Search {

    public Search(){
    }

    public ArrayList<Book> loadData() {

        ArrayList<Book> records = new ArrayList<>();

        try {
            String filePath = new File("src\\Files\\Books").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();

            String[] data;
            int id;
            String title;
            String author;
            String available;

            while (contentLine != null) {

                data = contentLine.split(",");
                id = Integer.parseInt(data[0]);
                title = data[1];
                author = data[2];
                available = data[3];
                records.add(new Book(id, title, author, available));
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }

        return records;
    }

    public String linearSearch(String targetName){

        ArrayList<Book> records = loadData();

        // Going one by one the elements in the array
        for(int i = 0; i < records.size(); i++){
            System.out.println("Found\n Book: " + records.get(i).getTitle() + " Author: " + records.get(i).getAuthor());
            // When the element is found, stop the loop and return the index
            if(records.get(i).getTitle().equals(targetName)){
               return "Is this title available?  " + records.get(i).getAvailable();

            }
        }
        return "not Found";
    }

}
