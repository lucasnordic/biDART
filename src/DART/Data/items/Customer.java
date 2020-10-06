package DART.Data.items;

import DART.Data.items.parent.grandparent.Item;

public class Customer extends Item {
    private int discount;
    private String membershipType;

    public Customer(String name, String membershipType) {
        super(name);
        this.membershipType = membershipType;
    }

    public int getDiscount(Customer customer) {
        return discount;
    }

    public void calculateDiscount() {
        discount = 0;
    }

    public String toString() {
        String var10000 = name;
        return var10000 + " ---> " + getId();
    }
}