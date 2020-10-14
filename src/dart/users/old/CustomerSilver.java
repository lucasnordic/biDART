package dart.users.old;

import dart.users.Customer;

public class CustomerSilver extends Customer {

    private static double discount = 0.1;
    private static int maxAllowedRent = 3;
    private static int additionalCredit = 1;
//    private String type;


    public CustomerSilver(String name, String password) {
        super(name, password);
//        this.type = type;
    }

    public CustomerSilver() {
    }

    /**
     * Override:
     */

    @Override
    public int getMaxAllowedRent() {
        return this.maxAllowedRent;
    }

    @Override
    public double calculatePrice(double price) {
        return (1 - this.discount) * price;
    }

    @Override
    public void addCredit() {
        int newCredit = super.getCredit() + this.additionalCredit;
        this.setCredit(newCredit);
    }
}