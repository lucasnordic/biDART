package dart.items;

import dart.tools.UserInputHandler;
import dart.users.Customer;
import dart.users.Employee;
import dart.users.User;
import dart.users.UserController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;

public class ItemController {


    private ArrayList<Item> dartProducts = new ArrayList<>();
    private ArrayList<String> historyList = new ArrayList<>();


    public ItemController() {
        mockData();
    }


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
        Item song = new Song(title, rent, artist, releaseYear);
        dartProducts.add(song);

        System.out.println(song.toString());

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
        Item game = new Game(title, rent, year, genre);

        dartProducts.add(game);
        System.out.println(game.toString());

       /* Game game = new Game(gameLastNumber++);//creating new game, next id +1
        gameLibrary.addGame(game);// method that allow to add games to library
        System.out.println(gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus() + "\n");
        */

    }


    public void removeAGame() {
        System.out.print("Please enter the ID of the game you want to remove: ");
        String id = UserInputHandler.inputString();
        System.out.print("Game is removed! Press any key to continue...");
        UserInputHandler.pressAnyKeyCon();
        dartProducts.remove(id);
    }


    public void rentProcess(User user) {
        int maxAllowedRent = ((Customer) user).getMaxAllowedRent();
        for (int i = 0; i < maxAllowedRent; i++) {
            rentItem();
            ((Customer) user).addCredit();
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


    public Item findItem(String Id) {
        for (int i = 0; i < dartProducts.size(); i++) {
            if (Id.equals(dartProducts.get(i).getID().toString())) {
                return dartProducts.get(i);
            }
        }
        System.out.println("Product with ID " + Id + " not found");
        return null;
    }


    public void returnProcess(User user) {
        int credit = ((Customer) user).getCredit();

        System.out.print("Insert the ID of the item you wish to return:");
        String inputID = UserInputHandler.inputString();
        Item returnee = findItem(inputID);

        if (credit < 5) {
            double payablePercent = ((Customer) user).payablePercent();
            returnItem(returnee, payablePercent);
            rateItem(returnee);
        } else {
            System.out.println("The total rent is 0. ");
            ((Customer) user).setCredit(credit - 5);
            //returnee.makeAvailableAgain();
            rateItem(returnee);
        }

    }


    public void returnItem(Item item, double payablePercent) {

//        System.out.print("Please enter the number of days in which the game was rented: ");
//        int days = UserInputHandler.inputInt();
        System.out.print("Please enter the date the item was returned (yyyy-mm-dd): ");
        LocalDate dateReturned = LocalDate.parse(UserInputHandler.inputString());
        item.makeAvailableAgain(dateReturned);

        double dailyRent = item.getDailyRent();
        double finalDailyRent = payablePercent * dailyRent;

        double totalRent = dailyRent * item.daysBetween();
        double finalTotalRent = payablePercent * totalRent;

        System.out.println("The total rent is " + finalDailyRent + " * " + item.daysBetween() + " = " + finalTotalRent);
       // item.makeAvailableAgain(dateReturned);
        item.storeDailyRent(finalTotalRent);
    }


    public void rateItem(Item item) {
        System.out.print("Do you want to give a rating or write a review? Answer Y for yes or N for no: ");
        String input = UserInputHandler.inputString();
        if (input.equalsIgnoreCase("Y")) {
            System.out.print("Please give any number between 0 and 5: ");
            int userRating = UserInputHandler.inputInt();
            System.out.print("Please write a review: ");
            String review = UserInputHandler.inputString();
            Value value = new Value(userRating, review);
            item.addValue(value);
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


    public double dartDailyRent() {
        double totalRentProfit = 0;
        for (Item item : dartProducts) {
            totalRentProfit = (totalRentProfit + item.getDailyRent());
        }
        return totalRentProfit;//return value

    }


    public void showTotalDailyRent() {
        System.out.println("Total Daily rent is :  " +/* itemController.*/dartDailyRent());
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