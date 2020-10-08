package DART.Data.controllers;
import DART.Data.users.Customer;
import DART.UserInputHandler;

public class Customers {

    CustomerLibrary customerList = new CustomerLibrary();


    public void registration() {

        System.out.print("Creating a Customer. Please type the customer’s:\nID:  ");
        int ID = UserInputHandler.inputInt();

            System.out.print("Name:   ");
            String name = UserInputHandler.inputString();

            Customer customer = new Customer();
            customer.setID(ID);
            customer.setName(name);

            customerList.addCustomer(customer);
            System.out.println(customerList);

    }



    public void cancellation() {

        customerList.getCustomers();


        System.out.println("Which customer should be removed? ID:");
        int ID = UserInputHandler.inputInt();

        for (int i = 0; i < customerList.getSize(); i++) {

            int a = (customerList.get(i)).getID();

            if (a == ID) {

                customerList.removeCustomer(i);
                System.out.println(customerList);
            } else {
                System.out.println("Customer's ID not found");
            }
        }



    }
}



