package CustomMade;

import Entity.Book;
import Entity.Reader;

import java.util.ArrayList;
import java.util.Map;

public class MySort {
    private int id;
    private String author, title, available, sorting;

    public ArrayList BookSort(Map<Integer, Book> map, int option) {
        ArrayList<Book> newArray = new ArrayList<>();

        for (Integer key : map.keySet()) {
            Book info = new Book(
                    id = map.get(key).getId(),
                    title = map.get(key).getTitle(),
                    author = map.get(key).getAuthor(),
                    available = map.get(key).getAvailable()
            );
            newArray.add(info);
        }
            for (int i = 0; i < newArray.size(); i++) {
                for(int j = 0; j < newArray.size() - 1; j++) {
                    if (option == 1){
                        if(newArray.get(j).getTitle().compareToIgnoreCase(newArray.get(j + 1).getTitle()) > 0) {
                            // Swap them!
                            Book temp = newArray.get(j);
                            newArray.set(j, newArray.get(j + 1));
                            newArray.set(j + 1, temp);

                        }
                }else{
                        if(newArray.get(j).getAuthor().compareToIgnoreCase(newArray.get(j + 1).getAuthor()) > 0) {

                            // Swap them!
                            Book temp = newArray.get(j);
                            newArray.set(j, newArray.get(j + 1));
                            newArray.set(j + 1, temp);


                        }
                    }
            }

        }
        return newArray;
    }

    public ArrayList ReaderSort(ArrayList<Reader> newReaders, int option){
        System.out.println(option);
        for (int i = 0; i < newReaders.size(); i++) {
            for(int j = 0; j < newReaders.size() - 1; j++) {
                if (option == 1){
                    if (newReaders.get(j).getId() > newReaders.get(j + 1).getId()) {
                        // Swap them!
                        Reader temp = newReaders.get(j);
                        newReaders.set(j, newReaders.get(j + 1));
                        newReaders.set(j + 1, temp);

                    }
                }else{
                    if (newReaders.get(j).getName().compareToIgnoreCase(newReaders.get(j + 1).getName()) > 0) {
                        // Swap them!
                        Reader temp = newReaders.get(j);
                        newReaders.set(j, newReaders.get(j + 1));
                        newReaders.set(j + 1, temp);

                    }
                }
            }

        }

        return newReaders;
    }

    public String PrintSortedBook(ArrayList<Book> books){

        for (int i = 0; i < books.size(); i++){
            System.out.println(books.get(i));
        }
        return "\nThese are the Books Available";
    }

    public String PrintSortedReaders(ArrayList<Reader> readers){

        for (int i = 0; i < readers.size(); i++){
            System.out.println(readers.get(i));
        }
        return "\nThese are the Readers ";
    }
}