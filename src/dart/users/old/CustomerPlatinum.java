//package dart.users.old;
//
//public class CustomerPlatinum extends CustomerGold {
//
//    private static double discount = 0.25;
//    private static int maxAllowedRent = 7;
//    private static int additionalCredit = 3;
//
//    public CustomerPlatinum(String name, String password) {
//        super(name, password);
//    }
//
//    public CustomerPlatinum() {
//    }
//
//    @Override
//    public int getMaxAllowedRent() {
//        return this.maxAllowedRent;
//    }
//
//    @Override
//    public double calculatePrice(double price) {
//        return ( 1- this.discount) * price;
//    }
//
//    @Override
//    public void addCredit() {
//        int newCredit = super.getCredit() + this.additionalCredit;
//        this.setCredit(newCredit);
//    }
//}
