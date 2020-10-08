package DART.Data.items.item;

public class RentedObject {

    //Mutual attributes of all rented Objects:

    private int ID;
    private String title;
    private double dailyRent;
    private String rentStatus = "available";

    //Constructor:

    public RentedObject(int ID, String title, double dailyRent, String rentStatus) {

        this.ID = ID;
        this.title = title;
        this.dailyRent = dailyRent;
        this.rentStatus = rentStatus;

    }

    public RentedObject() {}

    //Getters & setters:

    protected int getID() { return this.ID; }
    protected String getTitle() { return this.title; }
    protected double getDailyRent() { return this.dailyRent; }
    protected String getRentStatus() { return this.rentStatus; }

    protected void setID(int ID) { this.ID = ID; }
    protected void setTitle(String title) { this.title = title; }
    protected void setDailyRent(double dailyRent) { this.dailyRent = dailyRent; }
    protected void setRentStatus(String rentStatus) { this.rentStatus = rentStatus; }

    //Methods:

    protected void rent (){
        rentStatus="rented";
    }
    protected void returnObject() { rentStatus="available";}
}
