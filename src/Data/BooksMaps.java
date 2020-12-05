package Data;

import Entity.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BooksMaps {

    private String title;
    private String author;
    private String available;
    private int id;
    private String[] data;


    public Map<Integer,Book> loadData() {
        // create a hash map to store the the Book instances
        Map<Integer,Book> records = new HashMap<Integer, Book>();

        try {
            //get the file path
            String filePath = new File("src\\Files\\Books").getAbsolutePath();
            // read the file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // save the content a a String
            String contentLine = br.readLine();

            // loop trough the content and use the value to create a new instance of a Book
            while (contentLine != null) {
                data = contentLine.split(",");
                Book newBook = new Book(
                id = Integer.parseInt(data[0]),
                title = data[1],
                author = data[2],
                available = data[3]
                );
                // add the book on the Map
                records.put(id,newBook);
                // go to the next line on the file
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            System.out.println("No file found");
        }
        // return the Map
        return records;
    }
}