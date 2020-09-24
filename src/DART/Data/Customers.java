package DART.Data;
import DART.Dart;
import DART.UserInputHandler;

import java.util.ArrayList;
import java.util.Iterator;

public class Customers {

    public void registration() {

        Dart dart = new Dart();

        ArrayList<Customer> allCustomers = new ArrayList();
        int ID = 0;
        String name = "";

        while(ID != -1) {

            System.out.println("Creating a Customer. Please type the customer’s (Insert -1 to get back to employee menu):\nID:  ");

            ID = UserInputHandler.inputInt();

            if (ID > 0) {

                System.out.print("Name:   ");
                name = UserInputHandler.inputString();

                Customer person = new Customer();
                person.setID(ID);
                person.setName(name);

                allCustomers.add(person);

            } else if (ID == -1) {

                dart.employeeMenu();

            } else {

                System.out.println("Insert a valid ID.");
            }
        }

        Iterator itr = allCustomers.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
