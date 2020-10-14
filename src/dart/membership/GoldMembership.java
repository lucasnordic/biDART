package dart.membership;

public class GoldMembership implements Membership {

    /**
     * Overridden methods:
     */

    @Override
    public double getDiscount() {
        return 0.15;
    }

    @Override
    public int getMaxAllowedRent() {
        return 5;
    }

    @Override
    public int getAdditionalCredit() {
        return 2;
    }

    @Override
    public String getMembershipClass() {
        return "Gold";
    }

    @Override
    public double calculatePrice (double price) {
        return (1 - getDiscount()) * price;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
