package dart.tools;

import java.util.UUID;

public class Transaction {

    private String customerId;
    private Long daysRented;
    private UUID itemId;
    private int ratingScore;
    private String review;


    public Transaction(String customerId, Long daysRented, UUID itemId) {
        this.customerId = customerId;
        this.daysRented = daysRented;
        this.itemId = itemId;
        this.ratingScore = 0;
        this.review = null;
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


    public String toString() {
        if(this.ratingScore == 0) {
            return this.customerId + ", " + this.daysRented + ", " + this.itemId + ", \n";
        } else if(this.ratingScore != 0 && this.review.equals(null)) {
            return this.customerId + ", " + this.daysRented + ", " + this.itemId + ", " + this.ratingScore + "\n";
        } else {
            return this.customerId + ", " + this.daysRented + ", " + this.itemId + ", " + this.ratingScore + ", " + this.review + "\n";
        }

    }
}
