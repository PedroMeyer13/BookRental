package FilesUpdates;

import Entity.Book;

import java.util.Map;

public class NewBorrow {
    private String str;

    public String AddBorrow(Map<Integer, Book> newMap){
        try{
            int counter = 1;
            str = Integer.toString(newMap.get(counter).getId());
            while (counter <= 10){
                str = str.concat(","+newMap.get(counter).getTitle()+","+newMap.get(counter).getAuthor()+","+newMap.get(counter).getAvailable()+"\n");
                counter++;
                str = str.concat( Integer.toString(newMap.get(counter).getId()));
            }
        }catch (Exception e){
      }
        return str;
    }
}
