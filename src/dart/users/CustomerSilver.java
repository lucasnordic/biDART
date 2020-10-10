package dart.users;

public class CustomerSilver extends Customer {

    /**
     *
     */

    private double discount;
    private int credit;

    public CustomerSilver(String name, String password) {
        super(name, password);
        discount = 0.10;
        credit = 1;
    }

    /**
     *  Getters and Setters:
     */

    public double getDiscount() {
        return discount;
    }

    public int getCredit() {
        return credit;
    }

    //    public String getMembershipType() {
//        return this.membershipType;
//    }
//
//    public void setMembershipType(String membershipType) {
//        this.membershipType = membershipType;
//    }


}
