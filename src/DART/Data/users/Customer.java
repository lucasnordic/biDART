package DART.Data.users;

public class Customer {
    private int ID;
    private String name;

    public Customer(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    Customer() {
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public int setID(int ID) {
        this.ID = ID;
        return this.ID;
    }

    public String toString() {
        String var10000 = this.getName();
        return var10000 + " ---> " + this.getID();
    }


}