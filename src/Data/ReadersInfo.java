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

        ArrayList<Reader> records = new ArrayList<>();

        try {
            String filePath = new File("src\\Files\\Readers").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();

            while (contentLine != null) {
                data = contentLine.split(",");
                Reader info = new Reader(
                    id = Integer.parseInt(data[0]),
                    name = data[1],
                    address = data[2]
                );
                records.add(info);
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }
        return records;
    }

}
