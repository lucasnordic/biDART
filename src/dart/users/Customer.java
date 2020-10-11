package dart.users;

/**
 * This class handles a single customer and the methods required:
 */

public class Customer extends User{

    /**
     * Attributes
     */

    private static final double discount = 0;
    private static final int maxAllowedRent = 1;
    private static final int additionalCredit = 0;
    private int credit;

    /**
     * Constructor
     */

    public Customer(String name, String id) {
        super();
        this.credit = 0;
    }

    public Customer() {}

    /**
     * Getters and setters
     */

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getMaxAllowedRent() {
        return this.maxAllowedRent;
    }



    /**
     * Methods
     */

    public double calculatePrice (double price) {
        return (1 - this.discount) * price;
    }

    public void addCredit() {
        int newCredit = this.credit + this.additionalCredit;
        this.setCredit(newCredit);
    }

    public String toString() {
        return this.getId() + " ----> " + this.getName() + " has " + this.getCredit() + " credit. \n";
    }
}
