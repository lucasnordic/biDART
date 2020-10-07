package dart.data.items;
import dart.data.CustomerController;
import dart.data.items.parent.Customer;
import dart.UserInputOutput;

public class Manager extends Employee {
    public Manager(String name, int birthYear, double grossSalary) {
        super(name, birthYear, grossSalary);
    }



    CustomerController customerList = new CustomerController();


    public void registration() {

        System.out.print("Creating a Customer. Please type the customer’s:\nName: ");
        String name = UserInputOutput.inputString();

        Customer customer = new Customer(name, "regular");
        customer.setName(name);

        customerList.addCustomer();
        System.out.println(customerList);
    }



    public void cancellation() {

        customerList.getCustomers();

        System.out.println("Which customer should be removed? ID:");
        int ID = UserInputOutput.inputInt();

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



