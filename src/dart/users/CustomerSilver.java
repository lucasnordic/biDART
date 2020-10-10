package dart.users;

public class CustomerSilver extends Customer {

    private int credit;
    private int maxAllowedRent;
    private double discount;


    public CustomerSilver(String name, String password, int credit) {
        super();
        this.credit = credit;
        this.maxAllowedRent = 3;
        this.discount = 0.1;
    }


    public CustomerSilver() {
    }

    public int getCredit() {
        return credit;
    }

    public int getMaxAllowedRent() {
        return maxAllowedRent;
    }

    public double getDiscount() {
        return discount;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setMaxAllowedRent(int numberOfRent) {
        this.maxAllowedRent = numberOfRent;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }



    public double calculatePrice(double price) {
        double rent = price * (1 - this.discount);
        return rent;
    }


    public void addCredit(int credit) {
        int silverCredit = 1;
        int newCredit = credit + silverCredit;
        this.setCredit(newCredit);
    }
}
