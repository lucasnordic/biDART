package DART.UserRoles;
import DART.MainProgram;
import DART.PrintStuff;
import DART.ScannerInput;
import java.util.ArrayList;
import java.util.Iterator;


public class Customers {


    public static void registration() {


        System.out.println("Creating a Customer. Please type the customer’s:\n" + "ID:  ");

        int min = 0;
        int max = 10000000;
        int ID = ScannerInput.inputInt (min, max);

        System.out.print("\nName:   ");
        String name = ScannerInput.inputString();

        Customer person = new Customer(ID, name);

        ArrayList <Customer> allCustomers = new ArrayList <Customer>();
        allCustomers.add(person);

        MainProgram.employeeMenu();
        }
    }

