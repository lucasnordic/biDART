package dart.models.users.membership;

public interface Membership {
    double getDiscount();
    int getMaxAllowedRent();
    int getAdditionalCredit();
    String getMembershipClass();

    double calculatePrice (double price);
}