package dart.items;

import java.util.UUID;

public class Item {

    /**
     *  Mutual attributes of all rented Objects:
     */

    private String ID;
    private String title;
    private double dailyRent;
    private String rentStatus = "available";

    /**
     *  Constructor:
     */

    public Item(String title, double dailyRent, String rentStatus) {

        this.ID = UUID.randomUUID().toString();
        this.title = title;
        this.dailyRent = dailyRent;
        this.rentStatus = rentStatus;

    }

    public Item() {

    }

    /**
     *  Getters and Setters:
     */

    protected String getID() { return this.ID; }
    protected String getTitle() { return this.title; }
    protected double getDailyRent() { return this.dailyRent; }
    protected String getRentStatus() { return this.rentStatus; }

    protected void setTitle(String title) { this.title = title; }
    protected void setDailyRent(double dailyRent) { this.dailyRent = dailyRent; }
    protected void setRentStatus(String rentStatus) { this.rentStatus = rentStatus; }

    /**
     *  Methods:
     */

    protected void rent (){
        rentStatus="rented";
    }
    protected void returnObject() { rentStatus="available";}
}
