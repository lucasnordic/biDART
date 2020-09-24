package DART.Data;


public class CustomerLibrary {
    public CustomerLibrary() {
    }

    public void customerLib() {
    }
}
/*
public class CustomerLibrary {
    private Customer[] customers;
    private int nextPosition;
    public CustomerLibrary(){
        this.customers=new Customer[5];
    }
    public void addCustomer(Customer customer) {
        if (nextPosition< this.customers.length) {
            customers[nextPosition] = customer;
            nextPosition++;
        }else {
            Customer[] moreCustomers = new Customer[customers.length + 1];
            for (int i = 0; i < customers.length; i++) {
                moreCustomers[i] = customers[i];
            }
            this.customers = moreCustomers;
            moreCustomers[nextPosition] = customer;
            nextPosition++;
        }



    }
    public void removeACustomer(int id){
        for (int i = 0; i< customers.length;i++){
            if (customers [i] !=null && customers[i].getId()==id){
                customers[i]=null;
                System.out.println("Customer is removed!");
                return;
            }
        }
        System.out.println("Customer with id #" +id+ " not found");
    }

}
 */


