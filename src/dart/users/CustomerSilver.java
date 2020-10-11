package dart.users;

public class CustomerSilver extends Customer {

    private static final double discount = 0.1;
    private static final int maxAllowedRent = 3;
    private static final int additionalCredit = 1;


    public CustomerSilver(String name, String id) {
        super();
    }

    public CustomerSilver() {
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
