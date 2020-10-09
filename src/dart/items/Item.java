package dart.items;

public class Item {

    /**
     *  Mutual attributes of all rented Objects:
     */

    private String ID;
    private String title;
    private double dailyRent;
    private String rentStatus = "available";
    private double totalRentProfit;
    private ArrayList<Value> rating = new ArrayList<>();


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
        String review = ""; //empty String for further use adding all reviews
        for (Value value : rating) {
            review = review + value;
        }
        return review;
    }
}
