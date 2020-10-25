package dart.controller;

import dart.model.item.Game;
import dart.model.item.Item;
import dart.model.item.Song;
import dart.model.item.Value;
import dart.tool.InvalidDataInput;
import dart.model.item.Transaction;
import dart.tool.UserInputHandler;
import dart.model.user.Customer;
import dart.view.CustomerView;
import dart.view.DartView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ItemController {


    private ArrayList<Item> dartProducts = new ArrayList<Item>();
    private ArrayList<Transaction> transactionList = new ArrayList<>(); // We add values to this arrayList in rateItem
    double totalRentProfit = 0;
    private final int coolCredit = 5;
    private Item item;
    private Customer customer;


    /**
     * Adding and deleting items
     */
    public void addItem(Item item) {
        dartProducts.add(item);
        System.out.println(item);
    }

    public String removeItem(String id) {
        for (int i = 0; i < dartProducts.size(); i++) {

            if (dartProducts.get(i).getID().equals(id)) {
                dartProducts.remove(i);
                return "Removed";
            }
        }
        return "ID " + id + " is not found";
    }



    /**
     * Renting and returning items
     */


    public void rentProcess(Customer customer, String id) {
        int maxAllowedRent = customer.getMaxAllowedRent();

        if (maxAllowedRent == 1) {
            rentItem(customer, id);
        } else {
            int counter;
            String yesOrNo = "";
            do {
                counter = 0;
                rentItem(customer, id);
                System.out.println("Do you wish to rent again? press 'Y' for yes and 'N' for no: ");
                yesOrNo = UserInputHandler.inputString();
                counter = counter + 1;

            } while (yesOrNo.equalsIgnoreCase("y") && counter < maxAllowedRent);
        }
    }


    public void rentItem(Customer customer, String id) {
        Item item = findItem(id);
        if (item == null) {
            return;
        }
        if (item.getRentStatus().equalsIgnoreCase("rented")) {
            System.out.println("Product ID" + id + " is already rented");
        } else {
            System.out.print("Please enter the date the item was rented (yyyy-mm-dd): ");
            LocalDate dateRented = LocalDate.parse(UserInputHandler.inputString());

            item.rent(dateRented);
            System.out.println("Yay! Rented!");
            customer.addCredit();
        }
    }


    public void returnProcess(Customer customer, String id) { //why we here didnt call just a customer

        int credit = customer.getCredit();

        Item returnee = findItem(id);

        // We should check if the customers credit is high enough to rent items for free
        if (credit < coolCredit) {

            returnItem(returnee, customer);
            rateItem(returnee, customer);

        } else {
            System.out.print("Please enter the date the item was returned (yyyy-mm-dd): ");
            LocalDate dateReturned = LocalDate.parse(UserInputHandler.inputString());

            returnee.makeAvailableAgain(dateReturned);
            System.out.println("The total rent is 0. ");
            customer.setCredit(credit - coolCredit);
            rateItem(returnee, customer);
        }
    }


    public void returnItem(Item item, Customer customer) {
        try {
            System.out.print("Please enter the date the item was returned (yyyy-mm-dd): ");
            LocalDate dateReturned = LocalDate.parse(UserInputHandler.inputString());
            item.makeAvailableAgain(dateReturned);
            //TODO change payable percent to useCalculatePrice in membership
            double payablePercent = customer.payablePercent();  //In this line we use a method from membership classes to reduce the price of each item depending on customer membership discount.

            double dailyRent = item.getDailyRent(); //This is Item's price without discount implementation'
            double finalDailyRent = payablePercent * dailyRent; // price after discount

            double totalRent = dailyRent * item.daysBetween();
            double finalTotalRent = payablePercent * totalRent;

            customer.setTotalPaidRent(finalTotalRent); //
            item.setTotalRentProfit(finalTotalRent);
            item.setCounter(1);

            System.out.println("The total rent is " + finalDailyRent + " * " + item.daysBetween() + " = " + finalTotalRent);
            storeDailyRent(finalTotalRent);
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }
    }


    public void storeDailyRent(double finalTotalRent) {
        totalRentProfit = (totalRentProfit + finalTotalRent);
    }

    public void rateItem(Item item, Customer customer) {
        try {
            //We should also make a transaction here to store in the transactionList arrayList above.
            Transaction currentTransaction = new Transaction(customer.getId(), item.daysBetween(), item.getID(), customer, item);

            System.out.print("Do you want to give a rating or write a review? Answer Y for yes or N for no: ");
            String input = UserInputHandler.inputString();

            if (input.equalsIgnoreCase("Y")) {
                System.out.print("Please give any number between 0 and 5: ");
                int userRating = UserInputHandler.inputInt();
                Value value = new Value(userRating, null);
                System.out.print("Do you want to write a review? Answer Y for yes or N for no: ");
                input = UserInputHandler.inputString();
                item.addValue(value);
                currentTransaction.setRatingScore(userRating);
                if (input.equalsIgnoreCase("Y")) {
                    System.out.print("Please write a review: ");
                    String review = UserInputHandler.inputString();
                    value.setReview(review);
                    currentTransaction.setReview(review);
                }
            }
            transactionList.add(currentTransaction);
            StorageController.saveTranscationToFile(currentTransaction);
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());

        }
    }

    /**
     * Showing methods
     */


    public void menuShowTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }

    public void showTransaction() {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    public void showAll() {
        for (Item item : dartProducts) {
            System.out.println(item);
        }
    }

    public void showAllGames() {
        for (Item item : dartProducts) {
            if (item instanceof Game) {
                System.out.println(item);
            }
        }
    }

    public void showAllAlbums() {
        for (Item item : dartProducts) {
            if (item instanceof Song) {
                System.out.println(item);
            }
        }
    }

    public void showAllAvailable() {
        for (Item item : dartProducts) {
            if (item.getRentStatus().equals("available")) {
                System.out.println(item);
            }
        }
    }

    public void showAllAvailableAlbums() {
        for (Item item : dartProducts) {
            if (item instanceof Song && item.getRentStatus().equals("available")) {
                System.out.println(item);
            }
        }
    }

    public void showAllAvailableGames() {
        for (Item item : dartProducts) {
            if (item instanceof Game && item.getRentStatus().equals("available")) {
                System.out.println(item);
            }
        }
    }


    /**
     * Sort related methods
     */


//    public void sortByAverageRating() {
//        for (int i = 0; i < dartProducts.size(); i++) { //firstly we search for i in array
//            for (int j = i + 1; i < dartProducts.size(); i++) { //then we search for j, which stands next to  i and compare them
//                if (dartProducts.get(j).findAverageRating() > dartProducts.get(i).findAverageRating()) {//compare them
//                    Item buffer = dartProducts.get(i); //temporary value which keep the number of index should be replaced
//                    dartProducts.set(i, dartProducts.get(j)); //replace i to j
//                    dartProducts.set(j, buffer);//replace j to i
//                }
//            }
//        }
//        showAll();
//    }
    public void sortByAverageRatingUsingInterfaces() {
        Collections.sort(dartProducts, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.findAverageRating(), o1.findAverageRating());
            }
        });

    }


    public void sortByYearUsingInterfaces() {
        Collections.sort(dartProducts, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.getReleaseYear() - o1.getReleaseYear();
            }
        });
    }


    public void profitableItems() {

        Collections.sort(dartProducts, Item.rentCompare());

        for (int i = 0; i < dartProducts.size(); i++) {
            System.out.println(dartProducts.get(i) + "\nTotal profit: " + dartProducts.get(i).getTotalRentProfit() + "\n");
        }
    }

    public void rentFrequency() {

        Collections.sort(dartProducts, Item.frequencyCompare());

        for (int i = 0; i < dartProducts.size(); i++) {
            if (dartProducts.get(i).getCounter() != 0) {
                System.out.println("Item: " + dartProducts.get(i) + "\nFrequency of rent:  " + dartProducts.get(i).getCounter() + "\n");
            }
        }

    }


    public void myFavoriteCustomer() {

        ArrayList<Customer> activeCustomers = new ArrayList<>();

        for (int i = 0; i < transactionList.size(); i++) {
            Customer activeCustomer = transactionList.get(i).getCustomer();
            activeCustomers.add(activeCustomer);
        }

        Collections.sort(activeCustomers, Customer.activityCompare());

        System.out.println(activeCustomers.get(0) + "\nPaid amount of rent: " + activeCustomers.get(0).getTotalPaidRent());


    }

    /**
     * Search methods
     */

    public Item getItemWithId(String itemId) {
        Item itemFound = null;
        int index = 0;

        while (itemFound == null && index < dartProducts.size()) {
            Item item = dartProducts.get(index);

            if (item.getID().equals(itemId)) {
                itemFound = item;
            } else {
                index++;
            }
        }
        return itemFound;
    }

    public void findGame(String genre) {

        for (Item item : dartProducts) {
            if (item instanceof Game) {

                Game a = (Game) item;
                if (a.getGenre().equals(genre)) {
                    System.out.println(a);
                }
            }
        }
    }

    public void findSong(int year) {
        for (Item item : dartProducts) {
            if (item instanceof Song) {
                Song s = (Song) item;//turn item in song
                if (s.getReleaseYear() == year) {
                    System.out.println(s);
                }
            }
        }
    }

    public Item findItem(String Id) {
        for (int i = 0; i < dartProducts.size(); i++) {
            if (Id.equals(dartProducts.get(i).getID().toString())) {

                return dartProducts.get(i);
            }
        }
        System.out.println("Product with ID " + Id + " not found");
        // TODO: how to make it not crash after this??
        return null;
    }


    // I added these for mockdata purposes, since they don't have any menu's.
    // The prints should be separated from the other "addSong" and "registerAGame",
    // but this works for now.
    public void addGame(Game game) {
        dartProducts.add(game);
    }

    public void addSong(Song song) {
        dartProducts.add(song);
    }



}