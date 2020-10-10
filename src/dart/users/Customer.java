package dart.users;

/**
 * This class handles a single customer and the methods required:
 */

public class Customer extends User{


    private int maxAllowedRent;


    /**
     * Constructors:
     */

    public Customer(String name, String password, int maxAllowedRent) {
        super();
        this.maxAllowedRent = 1;
    }

    public Customer() {
    }

    /**
     * Getters and setters:
     */

    public int getMaxAllowedRent() {
        return maxAllowedRent;
    }

    public void setMaxAllowedRent(int maxAllowedRent) {
        this.maxAllowedRent = maxAllowedRent;
    }

    /**
     * Override:
     */

    @Override
    public String toString() {
        String var10000 = getName();
        return var10000 + " ---> " + super.getId();
    }


}