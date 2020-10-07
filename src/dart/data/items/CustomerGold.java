package dart.data.items;

import dart.data.items.parent.Customer;

public class CustomerGold extends Customer {

    public CustomerGold(String name) {
        super(name, "Gold");
    }

    @Override
    public void calculateDiscount() {
        super.calculateDiscount();
    }
}
