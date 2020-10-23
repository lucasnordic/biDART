package dart.model.users.membership;

import java.io.Serializable;

public class SilverMembership implements Membership, Serializable {


    /**
     * Attributes:
     */

    private final double discount = 0.1;
    private final int maxAllowedRent = 3;
    private final int additionalCredit = 1;
    private final String membershipClass = "Silver";


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