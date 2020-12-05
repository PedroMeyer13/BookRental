package CustomMade;

import Entity.Book;
import Entity.Reader;

import java.util.ArrayList;
import java.util.Map;

public class MySort {
    private int id;
    private String author, title, available, sorting;

    public ArrayList BookSort(Map<Integer, Book> map, int option) {
        // create a new array list to stop the Book instances
        ArrayList<Book> newArray = new ArrayList<>();

        //for each loop to iterate over all the keys and get the book instances
        for (Integer key : map.keySet()) {
            //create a new book instance using the same information from the map
            Book info = new Book(
                    id = map.get(key).getId(),
                    title = map.get(key).getTitle(),
                    author = map.get(key).getAuthor(),
                    available = map.get(key).getAvailable()
            );
            // add to the new Array List
            newArray.add(info);
        }
            // for loop to iterate over each instance of the array list
            for (int i = 0; i < newArray.size(); i++) {
                //Array to iterate over the the information of the Book instances
                for(int j = 0; j < newArray.size() - 1; j++) {
                    // Condition to decide if we are going to organize by Title or Author
                    if (option == 1){
                        //condition to compare the value of the strings and organize in alphabetical order
                        if(newArray.get(j).getTitle().compareToIgnoreCase(newArray.get(j + 1).getTitle()) > 0) {
                            // Swap them!
                            Book temp = newArray.get(j);
                            newArray.set(j, newArray.get(j + 1));
                            newArray.set(j + 1, temp);

                        }
                }else{
                        //condition to compare the value of the strings and organize in alphabetical order
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

        // for loop to iterate over each instance of the array list
        for (int i = 0; i < newReaders.size(); i++) {
            //Array to iterate over the the information of the Book instances
            for(int j = 0; j < newReaders.size() - 1; j++) {
                // condition to decide if the user wants to organize by Id or Name
                if (option == 1){
                    // compare the ID value and Organize them
                    if (newReaders.get(j).getId() > newReaders.get(j + 1).getId()) {
                        // Swap them!
                        Reader temp = newReaders.get(j);
                        newReaders.set(j, newReaders.get(j + 1));
                        newReaders.set(j + 1, temp);

                    }
                }else{
                    // compare the ID value and Organize them
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

    // just two methods to print the result in a better format in order to make it clear
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