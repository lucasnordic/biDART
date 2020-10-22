package dart.items;

import dart.tools.InvalidDataInput;
import dart.tools.Transaction;
import dart.tools.UserInputHandler;
import dart.users.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//import org.jetbrains.annotations.NotNull;

public class ItemController {


    private ArrayList<Item> dartProducts = new ArrayList<Item>();
    //    private ArrayList<String> historyList = new ArrayList<>();
    private ArrayList<Transaction> transactionList = new ArrayList<>(); // We add values to this arrayList in rateItem
    double totalRentProfit = 0;
    private final int coolCredit = 5;
    private Item item;
    private Customer customer;


//    public Transaction getCurrentTransaction() {
//        return currentTransaction;
//    }
//
//    public void setCurrentTransaction(Transaction currentTransaction) {
//        this.currentTransaction = currentTransaction;
//    }


    public ItemController() {
        mockData();
    }


    /**
     * Adding and deleting items
     */


    public void addSong() {
//        System.out.println("Please insert the following information:\nSong album ID:");
//        int ID = UserInputHandler.inputInt();
//        song.setID(ID);
        System.out.print("Title: ");
        String title = UserInputHandler.inputString();
        //song.setTitle(title);
        System.out.print("Artist: ");
        String artist = UserInputHandler.inputString();
        //((Song) song).setArtist(artist);
        System.out.print("Release year: ");
        int releaseYear = UserInputHandler.inputInt();
        //((Song) song).setReleaseYear(releaseYear);
        System.out.print("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        //song.setDailyRent(rent);
        try {
            Item song = new Song(title, rent, artist, releaseYear);
            dartProducts.add(song);

            System.out.println(song.toString());
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteSong() {

        System.out.println("Please enter the ID of the song which you wish to delete:");
        String id = UserInputHandler.inputString();

        for (int i = 0; i < dartProducts.size(); i++) {

            Item song = dartProducts.get(i);
            String songID = song.getID().toString();

            if (id.equals(songID)) {

                dartProducts.remove(song);
                System.out.println(dartProducts);
            }
        }
    }


    public void registerAGame() {
        System.out.print("Title: ");
        String title = UserInputHandler.inputString();
        //game.setTitle(title);
        System.out.print("Genre: ");
        String genre = UserInputHandler.inputString();
        //((Game) game).setGenre(genre);
        System.out.print("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        // game.setDailyRent(rent);
        //Item game = new Game(title, rent, genre);
        // game.setDailyRent(rent);
        System.out.print("Release year: ");
        int year = UserInputHandler.inputInt();
        try {
            Item game = new Game(title, rent, year, genre);

            dartProducts.add(game);
            System.out.println(game.toString());
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }

       /* Game game = new Game(gameLastNumber++);//creating new game, next id +1
        gameLibrary.addGame(game);// method that allow to add games to library
        System.out.println(gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus() + "\n");
        */

    }


    public void removeAGame() {
        System.out.print("Please enter the ID of the game you want to remove: ");
        String id = UserInputHandler.inputString();
        System.out.println("Game is removed!");
        UserInputHandler.pressAnyKeyCon();
        dartProducts.remove(id);
    }


    /**
     * Renting and removing items
     */

    //    public void rentProcess(User user) {
//        int maxAllowedRent = ((Customer) user).getMaxAllowedRent();
//        for (int i = 0; i < maxAllowedRent; i++) {
//            rentItem();
//            ((Customer) user).addCredit();
//        }
//    }
    public void rentProcess(Customer customer) {
        int maxAllowedRent = customer.getMaxAllowedRent(); //here we get the maximum number of items each customer is allowed to rent depending on their type of membership.
        for (int i = 0; i < maxAllowedRent; i++) {
            rentItem();
            customer.addCredit();
        }
    }


    public void rentItem() {
        showAllAvailable();
        System.out.print("Please enter ID of the item that you want to rent: ");
        String id = UserInputHandler.inputString();
        Item item = findItem(id);
        if (item.getRentStatus().equalsIgnoreCase("rented")) {
            System.out.println("Product ID" + id + " is already rented");
        } else {
            System.out.print("Please enter the date the item was rented (yyyy-mm-dd): ");
            LocalDate dateRented = LocalDate.parse(UserInputHandler.inputString());
            //dartProducts.get(i).rent(dateRented);//sending date of rent in method rent()
            item.rent(dateRented);
            System.out.println("Yay! Rented!");
        }
//        for (int i = 0; i < dartProducts.size(); i++) {
//            if (dartProducts.get(i).getID().toString().equals(id)) {
//                if (dartProducts.get(i).getRentStatus().equals("rented")) {
//                    System.out.println("Product ID" + id + " is already rented");
//                    //  return;
//                }
//                if (dartProducts.get(i).getRentStatus().equals("available")) {
//                    dartProducts.get(i).rent();
//                    System.out.println("Yay! Rented!");
//                    return;
//                }
//            }
//        }
    }


    public void returnProcess(Customer customer) { //why we here didnt call just a customer
        //  int credit = ((Customer) user).getCredit();
        int credit = customer.getCredit();
        //getCurrentTransaction().setCustomerId(customer.getId());

        System.out.print("Insert the ID of the item you wish to return:");
        String inputID = UserInputHandler.inputString();
        Item returnee = findItem(inputID);

        // We should check if the customers credit is high enough to rent items for free
        if (credit < coolCredit) {
            // double payablePercent = ((Customer) user).payablePercent();
            double payablePercent = customer.payablePercent();  //In this line we use a method from membership classes to reduce the price of each item depending on customer membership discount.
            returnItem(returnee, payablePercent, customer);
            rateItem(returnee, customer);

        } else {
            System.out.print("Please enter the date the item was returned (yyyy-mm-dd): ");
            LocalDate dateReturned = LocalDate.parse(UserInputHandler.inputString());

            returnee.makeAvailableAgain(dateReturned);
//            customer.setCredit(credit - coolCredit);
//            getCurrentTransaction().setItemId(returnee.getID());
//            getCurrentTransaction().setDaysRented(returnee.daysBetween());
            // They shouldn't pay anything so their rent price is zero
            System.out.println("The total rent is 0. ");
            customer.setCredit(credit - coolCredit);
            // ((Customer) user).setCredit(credit - 5);
            //returnee.makeAvailableAgain();

            //         returnee.storeDailyRent(0);

            rateItem(returnee, customer);
        }

    }


    public void returnItem(Item item, double payablePercent, Customer customer) {

//        System.out.print("Please enter the number of days in which the game was rented: ");
//        int days = UserInputHandler.inputInt();
        System.out.print("Please enter the date the item was returned (yyyy-mm-dd): ");
        LocalDate dateReturned = LocalDate.parse(UserInputHandler.inputString());
        item.makeAvailableAgain(dateReturned);

        double dailyRent = item.getDailyRent(); //This is Item's price without discount implementation'
        double finalDailyRent = payablePercent * dailyRent; // price after discount

        double totalRent = dailyRent * item.daysBetween();
        double finalTotalRent = payablePercent * totalRent;
        customer.setTotalPaidRent(finalTotalRent);
        item.setTotalRentProfit(finalTotalRent);
        item.setCounter(1);

//        getCurrentTransaction().setDaysRented(item.daysBetween());
//        getCurrentTransaction().setItemId(item.getID());

        try {
            System.out.println("The total rent is " + finalDailyRent + " * " + item.daysBetween() + " = " + finalTotalRent);
            // item.makeAvailableAgain(dateReturned);
            storeDailyRent(finalTotalRent);
//        item.storeDailyRent(finalTotalRent);
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }
    }


    public void storeDailyRent(double finalTotalRent) {
        totalRentProfit = (totalRentProfit + finalTotalRent);
    }

    public void rateItem(Item item, Customer customer) {
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

                currentTransaction.setReview(review);
            }

        }
        transactionList.add(currentTransaction);
    }


//    public double dartDailyRent() {
//        double totalRentProfit = 0;
//        for (Item item : dartProducts) {
//            totalRentProfit = (totalRentProfit + item.getDailyRent());
//        }
//        return totalRentProfit;//return value
//
//    }
//
//
//    public void showTotalDailyRent() {
//        System.out.println("Total Daily rent is :  " +/* itemController.*/dartDailyRent());
//    }
//
//    public void rateItem(Item item, Customer customer) {
//        //We should also make a transaction here to store in the transactionList arrayList above.
//        Transaction currentTransaction = new Transaction(customer.getId(), item.daysBetween(), item.getID(), customer, item);
//
////    public void transactionSetUp() {
////        transactions.add(currentTransaction);
////        getCurrentTransaction().setReview(null);
////        getCurrentTransaction().setRatingScore(0);
////    }
//
//
////    public void showTransaction() {
////        System.out.println(transactions);
////    }
//
//
//        System.out.print("Do you want to give a rating or write a review? Answer Y for yes or N for no: ");
//        String input = UserInputHandler.inputString();
//
//        if (input.equalsIgnoreCase("Y")) {
//            System.out.print("Please give any number between 0 and 5: ");
//            int userRating = UserInputHandler.inputInt();
//
//            //getCurrentTransaction().setRatingScore(userRating);
//            //System.out.println("Do you want to write a review? Answer Y for yes or N for no: ");
//
//            System.out.print("Please write a review: ");
//            String review = UserInputHandler.inputString();
//
//            //getCurrentTransaction().setReview(review);
//
//            Value value = new Value(userRating, review);
//            item.addValue(value);
//
//            currentTransaction.setRatingScore(userRating);
//            currentTransaction.setReview(review);
//        }
//        transactionList.add(currentTransaction);
//    }

//    public double dartDailyRent() {
//        double totalRentProfit = 0;
//        for (Item item : dartProducts) {
//            totalRentProfit = (totalRentProfit + item.getDailyRent());
//        }
//        return totalRentProfit;//return value
//
//    }
//
//
//    public void showTotalDailyRent() {
//        System.out.println("Total Daily rent is :  " +/* itemController.*/dartDailyRent());
//    }
//

    /**
     * Showing methods
     */


    public void menuShowTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }
//    public void transactionSetUp() {
//        transactions.add(currentTransaction);
////        getCurrentTransaction().setReview(null);
////        getCurrentTransaction().setRatingScore(0);
//    }

    public void showTransaction() {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }
//    public void addTransaction (Item item, Customer customer){
//        Transaction currentTransaction = new Transaction(item.getID(), customer.getId(), item.daysBetween());
////        currentTransaction.setRatingScore(userRating);
////        currentTransaction.setReview(review);
//        transactionList.add(currentTransaction);
//
//    }

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
//        System.out.print("Press any key to continue: ");
//        UserInputHandler.pressAnyKeyCon();

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


    public void sortByAverageRating() {
        for (int i = 0; i < dartProducts.size(); i++) { //firstly we search for i in array
            for (int j = i + 1; i < dartProducts.size(); i++) { //then we search for j, which stands next to  i and compare them
                if (dartProducts.get(j).findAverageRating() > dartProducts.get(i).findAverageRating()) {//compare them
                    Item buffer = dartProducts.get(i); //temporary value which keep the number of index should be replaced
                    dartProducts.set(i, dartProducts.get(j)); //replace i to j
                    dartProducts.set(j, buffer);//replace j to i
                }
            }
        }
        showAll();
    }


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
//        ArrayList <Item> profitableItems = new ArrayList<>(); // We make an arrayList and store the Items that were rented during running Dart.
//        for (int i = 0; i < transactionList.size(); i++) {
//            Item item = transactionList.get(i).getItem();
//            profitableItems.add(item);
//        }

        //Then we sort the arrayList so that the item with the highest profit goes in the first position.
//        for (int i = 0; i < dartProducts.size(); i++) { //firstly we search for i in array
//            for (int j = i + 1; i < dartProducts.size(); i++) { //then we search for j, which stands next to  i and compare them
//                if (dartProducts.get(j).getTotalRentProfit() > dartProducts.get(i).getTotalRentProfit()) {//compare them
//                    Item buffer = dartProducts.get(i); //temporary value which keep the number of index should be replaced
//                    dartProducts.set(i, dartProducts.get(j)); //replace i to j
//                    dartProducts.set(j, buffer);//replace j to i
//                }
//            }
//        }
    }


    public void rentFrequency() {


        Collections.sort(dartProducts, Item.frequencyCompare());

        for (int i = 0; i < dartProducts.size(); i++) {
            if (dartProducts.get(i).getCounter() != 0) {
                System.out.println("Item: " + dartProducts.get(i) + "\nFrequency of rent:  " + dartProducts.get(i).getCounter() + "\n");
            }
        }


       /* ArrayList<Integer> itemFrequency = new ArrayList<>();

        for (int i = 0; i < rentFrequency.size(); i++) {
            int counter = 1;
            for (int j = i + 1; i < rentFrequency.size(); i++) {
                if (rentFrequency.get(j).getID().equals(rentFrequency.get(i).getID())) {
                    rentFrequency.remove(j);
                    counter++ ;
                }
                itemFrequency.add(counter);
            }
        }
        int maxValue = Collections.max(itemFrequency);
        int maxIndex = itemFrequency.indexOf(maxValue);*/

    }


    public void myFavoriteCustomer() {

        ArrayList<Customer> activeCustomers = new ArrayList<>();

        for (int i = 0; i < transactionList.size(); i++) {
            Customer activeCustomer = transactionList.get(i).getCustomer();
            activeCustomers.add(activeCustomer);
        }

        for (int i = 0; i < activeCustomers.size(); i++) {

            for (int j = i + 1; i < activeCustomers.size(); i++) {
                if (activeCustomers.get(j).getId().equals(activeCustomers.get(i).getId())) {
                    activeCustomers.remove(activeCustomers.get(j));
                }
            }
        }

        Collections.sort(activeCustomers, Customer.activityCompare());

        for (int i = 0; i < activeCustomers.size(); i++) {
            System.out.println(activeCustomers.get(i) + "\nPaid amount of rent: " + activeCustomers.get(i).getTotalPaidRent() + "\n");
        }

    }


    /**
     * Search methods
     */


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


    public void mockData() {
        addGame(new Game("The Legend of Zelda: Link's Awakening", 5, 1998, "rpg"));
        addGame(new Game("Skyrim", 5, 2011, "rpg"));
        addGame(new Game("Fallout: New Vegas", 5, 2009, "rpg"));
        addGame(new Game("Super Smash Bro's", 5, 1998, "fighting"));
        addGame(new Game("Mario Kart", 5, 1998, "racing"));

        addSong(new Song("Evening Machines", 8, "Gregory Alan Isakov", 1984));
        addSong(new Song("The Lion's Roar", 10, "First Aid Kit", 1974));
        addSong(new Song("Soy Pablo", 9, "Boy Pablo", 1982));
        addSong(new Song("The Maze To Nowhere", 14, "Lorn", 2016));
        addSong(new Song("Wandering", 3, "Yosi Horikawa", 1984));
    }

//    public void rentAGame() {
//
//        //gameLibrary.showAvailableGames();
//        for (int i = 0; i < dartProducts.size(); i++) {
//
//            Game game = (Game) dartProducts.get(i);
//            String gameStatus = game.getRentStatus();
//            if (gameStatus.equalsIgnoreCase("available")) {
//                System.out.println(game);
//            }
//        }

    //        System.out.print("Please enter game ID that you want to rent: ");
//        int gameID = UserInputHandler.inputInt();
//        for (int i = 0; i < dartProducts.size(); i++) {
//
//            if (dartProducts.get(i).getID() == gameID) {
//
//                if (dartProducts.get(i).getRentStatus().equals("rented")) {
//                    System.out.println("Game with ID " + gameID + " is already rented");
//                }
//                dartProducts.get(i).rent();
//                System.out.println("The game has been rented!");
//                return;
//            }
//        }
//    }
//    public void rentProduct(String id) {
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId().toString().equals(id)) {
//                if (products.get(i).getRentStatus().equals("rented")) {
//                    System.out.println("Product ID" + id + " is already rented");
//                    return;
//                }
//                if (products.get(i).getRentStatus().equals("available")) {
//                    products.get(i).rent();
//                    System.out.println("Yay! Rented!");
//                    return;
//                }
//                System.out.println("Product with ID " + id + " not found");
//            }
//        }
//    }


    //    public void rentSong() {
//
//        System.out.println("Insert the ID of the song you wish to rent:");
//        int receivedID = UserInputHandler.inputInt();
//
//        for (int i = 0; i < dartProducts.size(); i++) {
//
//            Item song = dartProducts.get(i);
//            int songID = song.getID();
//
//            if (receivedID == songID) {
//
//                Item foundSong = dartProducts.get(i);
//                foundSong.rent();
//
//                System.out.println(dartProducts);
//
//            }
//        }
//    }
    //    public void returnSong() {
//
//        System.out.println("Insert the ID of the song you wish to return:");
//        int inputID = UserInputHandler.inputInt();
//
//        for(int i = 0; i < dartProducts.size(); i++) {
//
//            Item song = dartProducts.get(i);
//            int songID = song.getID();
//
//            if( inputID == songID ) {
//                song.returnObject();
//            }
//        }
//
//        System.out.println(dartProducts);
//    }

    //
//    public void returnAGame() {
//
//        System.out.println("Insert the ID of the game you wish to return:");
//        int inputID = UserInputHandler.inputInt();
//
//        for(int i = 0; i < dartProducts.size(); i++) {
//
//            Item game = dartProducts.get(i);
//            int songID = game.getID();
//
//            if( inputID == songID ) {
//                game.returnObject();
//            }
//
//        }
//
//        System.out.println(dartProducts);
//    }

//    public void findGame() {
//        for (Item item : dartProducts) {
//            if (item instanceof Game) {
//
//                Game a = (Game) item;
//                if (a.getGenre() == a.getGenre()) {
//                    System.out.println(a);
//                }
//            }
//        }
//
//    }


//    public void menuShowTotalRentProfit() {
//        System.out.println("Total rent profit is " + dartDailyRent());
//    }

//    public void showAllGames() {
//        for (Item item : dartProducts) {
//            if (item instanceof Game) {
//                System.out.println(item);
//            }
//        }
//    }
//
//    public void showAllAlbums() {
//        for (Item item : products) {
//            if (product instanceof Song) {
//                System.out.println(product);
//            }
//        }
//    }

//    public void showAvailableAlbums() {
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getRentStatus().equals("available")) {
//                System.out.println(products.get(i));
//            }
//        }
//    }
//
//    public void showAvailableAll() {
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getRentStatus().equals("available")) {
//                System.out.println(products.get(i));
//            }
//        }
//    }
//
//    public void showAvailable() {
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getRentStatus().equals("available")) {
//                System.out.println(products.get(i));
//            }
//        }
//    }

//    public void mockData() {
//        Song song1 = new Song("Title", 60, "Leelo", 1993);
//        Song song2 = new Song("Title", 60, "Leelo", 1993);
//        Song song3 = new Song("Title", 60, "Leelo", 1993);
//
//        addSong(song1);
//        addSong(song2);
//        addSong(song3);
//    }
}