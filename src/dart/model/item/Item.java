package dart.model.item;

import dart.tool.InvalidDataInput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Item {

    //Mutual attributes of all rented Objects:

    private String id;
    private String title;
    private double dailyRent;
    private int releaseYear;
    private String rentStatus = "available";
    private LocalDate dateRented;
    private LocalDate dateReturned;
    private double totalRentProfit;
    private ArrayList<Value> rating = new ArrayList<>();
    private int counter;


    public Item( String title, double dailyRent,int releaseYear) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.dailyRent = dailyRent;
        this.releaseYear= releaseYear;
        this.totalRentProfit = 0.0;
        this.counter = 0;
        if (title.isEmpty() && dailyRent<0  ){
            throw new InvalidDataInput("Invalid data. Title cannot be empty and daily rent cannot be negative.");
        }
        if (title.isEmpty()) {
            throw new InvalidDataInput("Invalid data. Item name cannot be empty.");
        } if (dailyRent < 0) {
            throw new InvalidDataInput("Invalid data. Item daily rent cannot be negative.");
        }
      else{
        }}


    public Item (String[] savedAttributes) {
        this.id = savedAttributes[1];
        this.title = savedAttributes[2];
        this.releaseYear = Integer.parseInt(savedAttributes[4]);
        this.dailyRent = Double.parseDouble(savedAttributes[5]);
    }


    //Getters & setters:
    public LocalDate getDateRented() {
        return dateRented;
    }

    public double getTotalRentProfit() {
        return totalRentProfit;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter + this.counter;
    }

    public void setTotalRentProfit(double totalRentProfit) {
        this.totalRentProfit = totalRentProfit + this.totalRentProfit;
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

    public String getID() {return this.id; }

    public String getTitle() {
        return this.title;
    }

    public double getDailyRent() {
        return this.dailyRent;
    }

    public String getRentStatus() {
        return this.rentStatus;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setDailyRent(double dailyRent) {
//        this.dailyRent = dailyRent;
//    }

//    public void setRentStatus(String rentStatus) {
//        this.rentStatus = rentStatus;
//    }

    //Methods:

    public void addValue(Value value) {
        rating.add(value);
    }


    public double findAverageRating() {
        double averageRating = 0;
        int totalRating = 0;
        for (Value value : rating) {
            totalRating = value.getUserRating() + totalRating; }
        averageRating = (double) totalRating / rating.size();
        return averageRating;
    }


    public void rent(LocalDate dateRented) {
        rentStatus = "rented";
        this.dateRented = dateRented;
    }


    public void makeAvailableAgain(LocalDate dateReturned) {
        rentStatus = "available";this.dateReturned =dateReturned;
    }

    public long daysBetween () {
        if (dateReturned.isEqual(getDateRented()) || dateReturned.isBefore(getDateRented())){
            throw new InvalidDataInput("Invalid operation. Upon returning an item, the number of days rented must be positive.");
        }
        return ChronoUnit.DAYS.between(dateRented, dateReturned);
    }


    public String toString() {
        String review = ".\nReviews: \n";
        for (Value value : rating) {
            review = review + " " + value + ";\n";
        }
        return review + "\nAverage user rating: " + findAverageRating();
    }


    public static Comparator<Item> rentCompare() {
        return new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                    double rating1 = item1.getTotalRentProfit();
                    double rating2 = item2.getTotalRentProfit();
                    return (int) (rating2 - rating1);
                }
            };
    }

    public static Comparator<Item> frequencyCompare() {
        return new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double rating1 = item1.getTotalRentProfit();
                double rating2 = item2.getTotalRentProfit();
                return (int) (rating2 - rating1);
            }
        };
    }
}
