package sample;

import Entity.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BooksMaps {


    public Map<Integer,Book> loadData() {

        Map<Integer,Book> records = new HashMap<Integer, Book>();

        try {
            String filePath = new File("src\\Files\\Books").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();

            String[] data;
            int id;
            String title;
            String author;
            String available;
            Integer counter = 1;

            while (contentLine != null) {
                data = contentLine.split(",");
                Book newBook = new Book(
                id = Integer.parseInt(data[0]),
                title = data[1],
                author = data[2],
                available = data[3]
                );
                records.put(id,newBook);
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }
        System.out.println(records);
        return records;
    }
}