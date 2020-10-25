package dart.model.item;

import dart.model.user.Customer;

public class Transaction {


//    private String customerId;
//    private long daysRented;
//    private String itemId;
    private Integer ratingScore;  // should this be Integer or int??!
    private String review;
    private Item item;
    private Customer customer;


    public Transaction (Customer customer, Item item) {
        //this.id = UUID.randomUUID();
//        this.customerId = customerId;
//        this.daysRented = daysRented;
//        this.itemId = itemId;
        this.item = item;
        this.customer = customer;
        this.review = "";
        this.ratingScore = 0;
    }
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public long getDaysRented() {
//        return daysRented;
//    }
//
//    public String getItemId() {
//        return itemId;
//    }

    public int getRatingScore() {
        return ratingScore;
    }

    public String getReview() {
        return review;
    }


//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
//
//    public void setDaysRented(Long daysRented) {
//        this.daysRented = daysRented;
//    }
//
//    public void setItemId(String itemId) {
//        this.itemId = itemId;
//    }

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


    public String toString(){
        String s = "Customer ID: " + this.customer.getId() +", Renting duration: " + this.item.daysBetween() +
                ", Item ID: " + this.item.getID();

        if(this.ratingScore!=null && review!=null){
            s = s+ " Item score: "+this.ratingScore+" Review: "+this.review+"";
        }
        if(this.ratingScore!=null&& review==null){
            s=s+ " Item score: "+this.ratingScore+"";
        }

         return s;
    }
    public String getInfo(){
        return customer.getId()+";"+item.getID()+";"+item.getTitle()+";"+item.getTotalRentProfit();
    }}
