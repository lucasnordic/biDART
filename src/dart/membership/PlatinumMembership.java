package dart.membership;

public class PlatinumMembership implements Membership{

    /**
     * Overridden methods:
     */

    @Override
    public double getDiscount() {
        return 0.25;
    }

    @Override
    public int getMaxAllowedRent() {
        return 7;
    }

    @Override
    public int getAdditionalCredit() {
        return 3;
    }

    @Override
    public String getMembershipClass() {
        return "Platinum";
    }

    @Override
    public double calculatePrice (double price) {
        return (1 - getDiscount()) * price;
    }
}