package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerHistory {

    private int id;
    private int counter;
    private String[] data;

    public Map<Integer,ArrayList> History(){

        // create a map to store the history of the users
        Map<Integer, ArrayList> borrowed = new HashMap<Integer, ArrayList>();

        try {
            // read the file and get the content
            String filePath = new File("src\\Files\\History").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String contentLine = br.readLine();

            // loop the content and store on a ArrayList
            while (contentLine != null) {
                ArrayList<String> history = new ArrayList<>();
                data = contentLine.split(",");
                id = Integer.parseInt(data[0]);
                counter = 1;
                while (counter < data.length){
                    history.add(data[counter]);
                    counter++;
                }
                // add the new arraylist on the map
                borrowed.put(id,history);
                // go to the next line
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            //Logger.getLogger(SearchFromFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No file found");
        }
        // return the map
        return borrowed;
    }
}
