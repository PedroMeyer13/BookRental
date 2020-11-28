package Entity;

public class Borrowings{

    private Integer readerId;
    private String readerName;
    private String bookName;

    public Borrowings(Integer readerId, String readerName, String bookName){
        this.readerId = readerId;
        this.readerName = readerName;
        this.bookName = bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getReaderName() {
        return readerName;
    }

    public String toString(){
        return " Reader Id: " + this.getReaderId() + " Reader Name: " + this.getReaderName() + " Book Name: " + this.getBookName() ;
    }
}
