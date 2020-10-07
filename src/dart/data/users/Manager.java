package dart.data.users;
import dart.data.CustomerController;
import dart.InputOutput;

public class Manager extends Employee {
    private static String password = "admin1234";

    public Manager(String name, int birthYear, double grossSalary) {
        super(name, birthYear, grossSalary, password);
    }



    CustomerController customerList = new CustomerController();


    public void registration() {

        System.out.print("Creating a Customer. Please type the customer’s:\nName: ");
        String name = InputOutput.inputString();

        Customer customer = new Customer(name, "regular");
        customer.setName(name);

        customerList.addCustomer();
        System.out.println(customerList);
    }



    public void cancellation() {

        customerList.getCustomers();

        System.out.println("Which customer should be removed? ID:");
        int ID = InputOutput.inputInt();

//        for (int i = 0; i < customerList.getSize(); i++) {
//
//            int a = (customerList.get(i)).getId();
//
//            if (a == ID) {
//
//                customerList.removeCustomer(i);
//                System.out.println(customerList);
//            } else {
//                System.out.println("Customer's ID not found");
//            }
//        }
    }
}



