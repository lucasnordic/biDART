package dart.data.users;

import dart.data.users.parent.User;

public class Customer extends User {

    private int discount;
    private String membershipType;

    // Constructor:
    public Customer(String name, String membershipType) {
        super(name);
        this.membershipType = membershipType;
    }

    // Getters and setters:
    public int getDiscount(Customer customer) {
        return discount;
    }

    public String getMembershipType() {
        return membershipType;
    }

    // Methods:
    public void calculateDiscount() {
        discount = 0;
    }

    public String toString() {
        String var10000 = name;
        return var10000 + " ---> " + getId();
    }
}