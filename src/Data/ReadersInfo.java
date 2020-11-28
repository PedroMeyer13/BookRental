package Data;

import Entity.Book;
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

        ArrayList<Reader> records = new ArrayList<>();

        try {
            String filePath = new File("src\\Files\\Books").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();

            while (contentLine != null) {

                data = contentLine.split(",");
                id = Integer.parseInt(data[0]);
                name = data[1];
                address = data[2];
                records.add(new Reader(id, name, address));
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }

        return records;
    }

    public String linearSearch(String targetName){

        ArrayList<Reader> records = ReadersData();

        // Going one by one the elements in the array
        for(int i = 0; i < records.size(); i++){
            System.out.println("Found\n Name: " + records.get(i).getName() + " Address: " + records.get(i).getAddress());
            // When the element is found, stop the loop and return the index
            if(records.get(i).getName().equals(targetName)){
               return "Is this title available?  " + records.get(i);

            }
        }
        return "not Found";
    }

}
