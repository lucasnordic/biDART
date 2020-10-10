package dart.items;

import java.util.ArrayList;
import java.util.UUID;

public class Item {

    //Mutual attributes of all rented Objects:

    private UUID id;
    private String title;
    private double dailyRent;
    private String rentStatus = "available";
    private double totalRentProfit;
    private ArrayList<Value> rating = new ArrayList<>();


    //Constructor:

    public Item( String title, double dailyRent) {

        this.id = UUID.randomUUID();
        this.title = title;
        this.dailyRent = dailyRent;

    }

    public Item() {
    }

    //Getters & setters:

    protected UUID getID() {return this.id; }

    protected String getTitle() {
        return this.title;
    }

    protected double getDailyRent() {
        return this.dailyRent;
    }

    protected String getRentStatus() {
        return this.rentStatus;
    }

    protected void setID(UUID ID) {
        this.id = ID;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setDailyRent(double dailyRent) {
        this.dailyRent = dailyRent;
    }

    protected void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    //Methods:

    protected void rent() {
        rentStatus = "rented";
    }

    protected void makeAvailableAgain() {
        rentStatus = "available";
    }

    //here we add rating to arraylist of Values
    public void addValue(Value value) {
        rating.add(value);

    }

    public double findAverageRating() {
        double averageRating = 0;
        int totalRating = 0;
        for (Value value : rating) {
            totalRating = value.getUserRating() + totalRating;
        }
        averageRating = (double) totalRating / rating.size(); //(double) allows to convert int Userrating into doubles
        return averageRating;
    }

    public void storeDailyRent(double totalRent) {
        totalRentProfit = (totalRentProfit + totalRent);
    }

    public void menuShowTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }

    public String toString() {
        String review = ".\nReviews: "; //empty String for further use adding all reviews
        for (Value value : rating) {
            review = review + " "+value;

        }
        return review+"\nAverage user rating: "+findAverageRating();
//        return ID + ": " + title + ". Price: " + dailyRent + " SEK. Status: " + rentStatus +
//                "\nAverage user rating: "+findAverageRating()+"\nReviews:\n"+review+"";

    }


    }


