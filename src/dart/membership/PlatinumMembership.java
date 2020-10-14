package dart.membership;

public class PlatinumMembership implements Membership{


    /**
     * Attributes:
     * (Question, is it better to declare them like this?
     * I think it is better to keep the numbers upp here since,
     * if this class were to become very long then we can still change
     * these numbers easily.
     */

    private final double discount = 0.25;
    private final int maxAllowedRent = 7;
    private final int additionalCredit = 3;
    private final String membershipClass = "Platinum";


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