package dart.users;

public class CustomerGold extends CustomerSilver {

    private static final double discount = 0.15;
    private static final int maxAllowedRent = 5;
    private static final int additionalCredit = 2;

    public CustomerGold(String name, String id) {
        super();
    }

    public CustomerGold() {
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
