package dart.membership;

public class RegularMembership implements Membership {

    /**
     * Overridden methods:
     */

    @Override
    public double getDiscount() {
        return 0;
    }

    @Override
    public int getMaxAllowedRent() {
        return 1;
    }

    @Override
    public int getAdditionalCredit() {
        return 0;
    }

    @Override
    public String getMembershipClass() {
        return "Regular";
    }

    @Override
    public double calculatePrice (double price) {
        return (1 - getDiscount()) * price;
    }
}
