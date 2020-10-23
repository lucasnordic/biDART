package dart.model.items;

public class Value {
    private int userRating;
    private String review;

    public Value(int userRating, String review) {
        this.userRating = userRating;
        this.review = review;
    }

    public int getUserRating() {
        return userRating;
    }

    public String getReview() {
        return review;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public void setReview(String review) {
        this.review = review;
    }

   public  String toString() {
        return userRating+" "+review;

    }
}
