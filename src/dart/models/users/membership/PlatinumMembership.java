package dart.models.users.membership;

import java.io.Serializable;

public class PlatinumMembership implements Membership, Serializable {


    /**
     * Attributes:
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