package Data;

import Entity.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadersInfo {

    private int id;
    private String name;
    private String address;
    private String[] data;

    public ArrayList<Reader> ReadersData() {

        // create an ArrayList to store the content
        ArrayList<Reader> records = new ArrayList<>();

        try {
            // get the file path
            String filePath = new File("src\\Files\\Readers").getAbsolutePath();
            // read the file
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // store the content as a String
            String contentLine = br.readLine();

            // create a new instance of Reader
            while (contentLine != null) {
                data = contentLine.split(",");
                Reader info = new Reader(
                    id = Integer.parseInt(data[0]),
                    name = data[1],
                    address = data[2]
                );
                // add to the Array List
                records.add(info);
                // go to the next line
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }
        // return the list
        return records;
    }

}
