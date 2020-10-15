package dart.users.membership;

public class GoldMembership implements Membership {


    /**
     * Attributes:
     */

    private final double discount = 0.15;
    private final int maxAllowedRent = 5;
    private final int additionalCredit = 2;
    private final String membershipClass = "Gold";


    /**
     * Overridden methods:
     */

    @Override
    public double getDiscount() {
        return this.discount;
    }

    @Override
    public int getMaxAllowedRent() {
        return this.maxAllowedRent;
    }

    @Override
    public int getAdditionalCredit() {
        return this.additionalCredit;
    }

    @Override
    public String getMembershipClass() {
        return this.membershipClass;
    }

    @Override
    public double calculatePrice (double price) {
        return (1 - getDiscount()) * price;
    }
}
