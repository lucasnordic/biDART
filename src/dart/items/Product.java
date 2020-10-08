package DART.Data;

import java.util.UUID;

public class Product {

    //private String type;
    private UUID id;
    private String title;
    private double dailyRent;
    private String rentStatus = "available";
    private int userRatings ;
    private String review;
    private double totalRentProfit ;
    private int totalUserRating ;
    private int averageUserRating;


    public Product() {
        this.id = UUID.randomUUID();
    }

    public Product(String title, double dailyRent) {

        this.id = UUID.randomUUID();
        this.title = title;
        this.dailyRent = dailyRent;
    }



    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public int getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(int userRatings) {
        this.userRatings = userRatings;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void rent() {
        rentStatus = "rented";
    }

    public void makeAvailableAgain() {
        rentStatus = "available";
    }

    public void storeDailyRent(double totalRent) {
        totalRentProfit = (totalRentProfit + totalRent);
    }

    public void menuShowTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }


    //  public void menuGiveARating()
}
