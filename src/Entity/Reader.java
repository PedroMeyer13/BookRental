package Entity;

public class Reader {
    private int id;
    private String name;
    private String address;

    public Reader(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString(){
        return " Id: " + this.getId() + " Name: " + this.getName() + " Address: " + this.getAddress() ;
    }
}


