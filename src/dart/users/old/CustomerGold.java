package dart.users.old;

public class CustomerGold extends CustomerSilver {

    private static double discount = 0.15;
    private static int maxAllowedRent = 5;
    private static int additionalCredit = 2;

    public CustomerGold(String name, String password) {
        super(name, password);
    }

    public CustomerGold() {
    }

    @Override
    public int getMaxAllowedRent() {
        return this.maxAllowedRent;
    }

    @Override
    public double calculatePrice(double price) {
        return ( 1 - this.discount) * price;
    }

    @Override
    public void addCredit() {
        int newCredit = this.getCredit() + this.additionalCredit;
        this.setCredit(newCredit);
    }
}
