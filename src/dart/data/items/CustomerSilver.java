package dart.data.items;

import dart.data.items.parent.Customer;

public class CustomerSilver extends Customer {

    public CustomerSilver(String name) {
        super(name, "Silver");
    }

    @Override
    public void calculateDiscount() {
        super.calculateDiscount();
    }
}
