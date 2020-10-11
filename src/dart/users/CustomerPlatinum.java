package dart.users;

public class CustomerPlatinum extends CustomerGold {

    private static final double discount = 0.25;
    private static final int maxAllowedRent = 7;
    private static final int additionalCredit = 3;

    public CustomerPlatinum(String name, String id) {
        super();
    }

    public CustomerPlatinum() {
    }

    @Override
    public int getMaxAllowedRent() {
        return this.maxAllowedRent;
    }

    @Override
    public double calculatePrice(double price) {
        return ( 1- this.discount) * price;
    }

    @Override
    public void addCredit() {
        int newCredit = super.getCredit() + this.additionalCredit;
        this.setCredit(newCredit);
    }
}
