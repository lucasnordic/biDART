package DART.UserRoles;

import DART.PrintStuff;
import DART.ScannerInput;

public class Customer {

    private int ID;
    private String name;


    Customer( int ID, String name) {

        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }



}
