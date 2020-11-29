package Entity;

public class Book {
    private int id;
    private String title;
    private String author;
    private String available;

    public Book(int id, String title, String author, String available){
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getAvailable() {
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String toString(){
        return " Id: " + this.getId() + " Title: " + this.getTitle() + " Author: " + this.getAuthor()+ " Availability: " + this.getAvailable()+" " ;
    }
}

