package dart.tools;

import dart.items.Item;
import dart.users.Customer;

import java.util.UUID;

public class Transaction {

    //private UUID id;
    private String customerId;
    private Long daysRented;
    private UUID itemId;
    private int ratingScore;
    private String review;
    private Item item;
    private Customer customer;

  
    public Transaction(String customerId, Long daysRented, UUID itemId, Customer customer, Item item) {
        //this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.daysRented = daysRented;
        this.itemId = itemId;
        this.item = item;
        this.customer = customer;
        this.ratingScore = 0;
        this.review = null;
    }

    public Transaction() {

    }


    public String getCustomerId() {
        return customerId;
    }

    public Long getDaysRented() {
        return daysRented;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public String getReview() {
        return review;
    }


    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDaysRented(Long daysRented) {
        this.daysRented = daysRented;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Item getItem() {
        return item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String toString() {
        if(this.ratingScore == 0) {
            return "Customer ID: " + this.customerId + ", Renting duration: " + this.daysRented + ", Item ID: " + this.itemId + ", \n";
        } else if(this.ratingScore != 0 && this.review.equals(null)) {
            return "Customer ID: " + this.customerId + ", Renting duration: " + this.daysRented + ", Item ID: " + this.itemId + ", Item score: " + this.ratingScore + "\n";
        } else {
            return "Customer ID: " + this.customerId + ", Renting duration: " + this.daysRented + ", Item ID: " + this.itemId + ", Item score: " + this.ratingScore + ", Item review: " + this.review + "\n";
        }

    }
}
