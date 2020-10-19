package dart.items;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

public class Item {

    //Mutual attributes of all rented Objects:

    private UUID id;
    private String title;
    private double dailyRent;
    private int releaseYear;
    private String rentStatus = "available";
    private LocalDate dateRented;
    private LocalDate dateReturned;
    private double totalRentProfit;
    private ArrayList<Value> rating = new ArrayList<>();

//case 6 -> most profitable
            //case 7 -> most popular
            //case 8 -> best customer
    //Constructor:

    public Item( String title, double dailyRent,int releaseYear) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.dailyRent = dailyRent;
        this.releaseYear= releaseYear;
    }

//    public Item() {
//    }

    //Getters & setters:
    public LocalDate getDateRented() {
        return dateRented;
    }

    public double getTotalRentProfit() {
        return totalRentProfit;
    }

    public void setTotalRentProfit(double totalRentProfit) {
        this.totalRentProfit = totalRentProfit;
    }

    public void setDateRented(LocalDate dateRented) {
        this.dateRented = dateRented;
    }


    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

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

   // protected void makeAvailableAgain() {
//        rentStatus = "available";
//    }

    //here we add rating to arraylist of Values
    public void addValue(Value value) {
        rating.add(value);
    }

    public double findAverageRating() {
        double averageRating = 0;
        int totalRating = 0;
        for (Value value : rating) {
            totalRating = value.getUserRating() + totalRating; }
        averageRating = (double) totalRating / rating.size(); //(double) allows to convert int Userrating into doubles
        return averageRating;
    }

    public void storeDailyRent(double totalRent) {
        totalRentProfit = (totalRentProfit + totalRent);
    }

    public void menuShowTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }

    protected void rent(LocalDate dateRented) {
        rentStatus = "rented";
        this.dateRented = dateRented; // date of rent is changing when item changes its status from available to rented
    }
    public void makeAvailableAgain(LocalDate dateReturned) {
        rentStatus = "available";this.dateReturned =dateReturned;
    }

//    protected void dateReturned (LocalDate dateReturned){
//        this.dateReturned=dateReturned;
//    }
    public long daysBetween (){
//        LocalDate dateBefore = dateRented;
//        LocalDate dateAfter =dateReturned;
        return ChronoUnit.DAYS.between(dateRented, dateReturned);
    }


    public String toString() {
        String review = ".\nReviews: \n"; //empty String for further use adding all reviews
        for (Value value : rating) {
            review = review + " "+ value + ";\n";

        }
        return review+"\nAverage user rating: "+findAverageRating();
//        return ID + ": " + title + ". Price: " + dailyRent + " SEK. Status: " + rentStatus +
//                "\nAverage user rating: "+findAverageRating()+"\nReviews:\n"+review+"";

    }


    }


