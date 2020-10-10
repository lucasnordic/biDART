package dart.users;

/**
 * This class handles a single customer and the methods required:
 */

public class Customer extends User{

    private double discount;
    private String membershipType;
    private int maxAllowedRent;
    private int credit;

    /**
     * Constructors:
     */

    public Customer(String name, String password) {
        super(name, password);
        this.discount = 0;
        this.membershipType = "regular";
        this.maxAllowedRent = 1;
        this.credit = 0;
    }

    public Customer() {
    }

    /**
     * Getters and setters:
     */

    public double getDiscount() {
        return discount;
    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /**
     * Methods:
     */

    // TODO: calculate discount
//    public void calculateDiscount() {
//        getDiscount() * 0.90;
//    }

    /**
     * Override:
     */

    //@Override
//    public String toString() {
//        String var10000 = getName();
//        return var10000 + " ---> " + this.getID();
//    }


}