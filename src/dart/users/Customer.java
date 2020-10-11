package dart.users;

/**
 * This class handles a single customer and the methods required:
 */

public class Customer extends User{

//    private String membershipType;
    private int maxAllowedRent;
    private double discount;
    private int credit;
    private int creditBank;

    /**
     * Constructors:
     */

    public Customer(String name, String password) {
        super(name, password);
        this.maxAllowedRent = 1;
    }

    public Customer() {
        super();
    }

    /**
     * Getters and setters:
     */

    public int getMaxAllowedRent() {
        return maxAllowedRent;
    }

    public double getDiscount() {
        return discount = 0.0;
    }

    public int getCredit() {
        return credit = 0;
    }

    public int getCreditBank() {
        return creditBank = 0;
    }

    public void setCreditBank(int creditBank) {
        this.creditBank = creditBank;
    }

    /**
     * Methods:
     */

    public double calculateDiscount(double price) {
        return getDiscount();
    }

    public double storeCreditToBank(double credit) {
        return this.creditBank =+ 0;
    }

    public String toString (){
        return super.getId().toString()+" : "+ super.getName();
    }

    /**
     * Override:
     */
}