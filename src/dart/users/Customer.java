package dart.users;


import dart.items.Item;
import dart.tools.InvalidDataInput;
import dart.users.membership.*;

import java.util.Comparator;

/**
 * This class handles a single customer and the methods required:
 */

public class Customer extends User /*implements Comparable<Customer>*/{

  
    /**
     * Attributes
     */

    private int credit;
    private Membership membership;
    private final String type = "Customer";
    private double totalPaidRent;

  
    /**
     * Constructors:
     */

    public Customer(String name, String password, Membership membership) {
        super(name, password);
        this.credit = 0;
        this.totalPaidRent = 0.0;
        this.membership = membership;

        if (name.isEmpty() && password.isEmpty()) {
            throw new InvalidDataInput("Invalid data. Name and password cannot be empty.");
        }if (name.isEmpty()) {
            throw new InvalidDataInput("Invalid data. Name cannot be empty.");
        }
         if (password.isEmpty()) {
            throw new InvalidDataInput("Invalid data. Password cannot be empty.");
        } else {}
        
    }

    public Customer(String name, String password) {
        this(name, password, new RegularMembership());
    }

    public Customer() {

    }


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
        return this.membership.getMaxAllowedRent();
    }

    public Membership getMembership() {
        return membership;
    }

    public void setTotalPaidRent(double totalPaidRent) {
        this.totalPaidRent = totalPaidRent + this.totalPaidRent;
    }

    public double getTotalPaidRent() {
        return totalPaidRent;
    }


    /**
     * Methods
     */

    public double payablePercent () {
        return (1 - this.membership.getDiscount());
    }

    public void addCredit(){
        credit = this.credit +this.membership.getAdditionalCredit();
    }

    public Membership membershipUpgrade() {

        // If a customer is either Regular, Silver or Gold we upgrade them.
        // Otherwise they keep their membership.
        if (membership instanceof RegularMembership) {
            membership = new SilverMembership();
        } else if (membership instanceof SilverMembership) {
            membership = new GoldMembership();
        } else if (membership instanceof GoldMembership) {
            membership = new PlatinumMembership();
        }

        // This becomes either one of the "ifs" or it will keep it's original membership type.
        // If it is in this instance a PlatinumMembership it won't go into any of the "ifs",
        // Thus it will stay "Platinum".
        return membership;
    }


    /**
     * Overrides
     */

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getId() + " ----> " + this.getName() + " has " + this.getCredit() + " credit. \n";
    }

    public static Comparator<Customer> activityCompare() {
        return new Comparator<Customer>() {
            @Override
            public int compare(Customer person1, Customer person2) {
                double rating1 = person1.getTotalPaidRent();
                double rating2 = person2.getTotalPaidRent();
                return (int) (rating2 - rating1);
            }
        };
    }
}




// OLD:
//    private static double discount = 0;
//    private static int maxAllowedRent = 1;
//    private static int additionalCredit = 0;


//    @Override
//    public int compareTo(Customer anotherCustomer) {
//        if(this.getTitle.equals("Regular")) {
//            return -1;
//        } else if(this.getTitle.equals("Silver")) {
//
//        } else if(this.getTitle.equals("Gold"))
//    }

//    public void addCredit() {
//        int newCredit = this.credit + this.membership.getAdditionalCredit();
//        this.setCredit(newCredit);
//    }