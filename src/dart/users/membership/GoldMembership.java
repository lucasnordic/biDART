package dart.users.membership;

public class GoldMembership implements Membership {


    /**
     * Attributes:
     * (Question, is it better to declare them like this?
     * I think it is better to keep the numbers upp here since,
     * if this class were to become very long then we can still change
     * these numbers easily.
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
