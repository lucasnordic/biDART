package dart.data.items;

import dart.data.items.parent.Customer;

public class CustomerPlatinum extends Customer {

    public CustomerPlatinum(String name) {
        super(name, "Platinum");
    }

    @Override
    public void calculateDiscount() {
        super.calculateDiscount();
    }
}
