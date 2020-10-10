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
}
