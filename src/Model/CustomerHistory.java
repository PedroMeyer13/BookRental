package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerHistory {

    private int id;
    private int counter = 1;
    private String[] data;

    public Map<Integer,ArrayList> History(){


        Map<Integer, ArrayList> borrowed = new HashMap<Integer, ArrayList>();
        ArrayList<String> history = new ArrayList<>();

        try {
            String filePath = new File("src\\Files\\History").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();

            while (contentLine != null) {
                data = contentLine.split(",");
                id = Integer.parseInt(data[0]);
                while (counter < data.length){
                    history.add(data[counter]);
                    counter++;
                }
                borrowed.put(id,history);
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }
        return borrowed;
    }
}
