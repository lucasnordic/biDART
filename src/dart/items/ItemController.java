package dart.items;

import dart.tools.UserInputHandler;

import java.util.ArrayList;

public class ItemController {

    ArrayList<Item> dartProducts = new ArrayList<>();

    // Must Use UUID for IDs later!!!

    public void addSong() {

        Item song = new Song();

        System.out.println("Please insert the following information:\nSong ID:");
        int ID = UserInputHandler.inputInt();
        song.setID(ID);

        System.out.println("Title: ");
        String title = UserInputHandler.inputString();
        song.setTitle(title);

        System.out.println("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        song.setDailyRent(rent);

        System.out.println("Artist: ");
        String artist = UserInputHandler.inputString();
        ((Song) song).setArtist(artist);

        System.out.println("Release year: ");
        int releaseYear = UserInputHandler.inputInt();
        ((Song) song).setReleaseYear(releaseYear);


        dartProducts.add(song);

        System.out.println(song.toString());

    }

    public void deleteSong() {

        System.out.println("Please enter the ID of the song which you wish to delete:");
        int ID = UserInputHandler.inputInt();

        for (int i = 0; i < dartProducts.size(); i++) {

            Item song = dartProducts.get(i);
            int songID = song.getID();

            if (ID == songID) {

                dartProducts.remove(song);
                System.out.println(dartProducts);
            }
        }
    }

    public void rentSong() {

        System.out.println("Insert the ID of the song you wish to rent:");
        int receivedID = UserInputHandler.inputInt();

        for (int i = 0; i < dartProducts.size(); i++) {

            Item song = dartProducts.get(i);
            int songID = song.getID();

            if (receivedID == songID) {

                Item foundSong = dartProducts.get(i);
                foundSong.rent();

                System.out.println(dartProducts);

            }
        }
    }

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

    public void registerAGame() {

        Item game = new Game();

        System.out.println("Please insert the following information:\nGame ID:");
        int ID = UserInputHandler.inputInt();
        game.setID(ID);

        System.out.println("Title: ");
        String title = UserInputHandler.inputString();
        game.setTitle(title);

        System.out.println("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        game.setDailyRent(rent);

        System.out.println("genre: ");
        String genre = UserInputHandler.inputString();
        ((Game) game).setGenre(genre);

        dartProducts.add(game);

        System.out.println(game.toString());

       /* Game game = new Game(gameLastNumber++);//creating new game, next id +1
        gameLibrary.addGame(game);// method that allow to add games to library
        System.out.println(gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus() + "\n");
        */

    }

    public void menuRemoveAGame() {
        System.out.print("Please enter a number of the game you want to remove: ");
        int id = UserInputHandler.inputInt();
        dartProducts.remove(id);
    }

    public void rentAGame() {

        //gameLibrary.showAvailableGames();
        for (int i = 0; i < dartProducts.size(); i++) {

            Game game = (Game) dartProducts.get(i);
            String gameStatus = game.getRentStatus();
            if (gameStatus.equalsIgnoreCase("available")) {
                System.out.println(game);
            }
        }

        System.out.print("Please enter game ID that you want to rent: ");
        int gameID = UserInputHandler.inputInt();
        for (int i = 0; i < dartProducts.size(); i++) {

            if (dartProducts.get(i).getID() == gameID) {

                if (dartProducts.get(i).getRentStatus().equals("rented")) {
                    System.out.println("Game with ID " + gameID + " is already rented");
                }
                dartProducts.get(i).rent();
                System.out.println("The game has been rented!");
                return;
            }
        }
    }
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

    public void returnItem() {

        System.out.println("Insert the ID of the item you wish to return:");
        int inputID = UserInputHandler.inputInt();

        for (int i = 0; i < dartProducts.size(); i++) {

            Item item = dartProducts.get(i);
            int id = item.getID();

            if (inputID == id) {
                //  item.returnObject();
                System.out.print("Please enter the number of days in which the game was rented: ");
                int days = UserInputHandler.inputInt();
                double dailyRent = item.getDailyRent();
                double totalRent = dailyRent * days;
                System.out.println("The total rent is " + dailyRent + " * " + days + " = " + totalRent);
                item.makeAvailableAgain();
                item.storeDailyRent(totalRent);
                System.out.print("Do you want to give a rating or write a review? Answer Y for yes or N now: ");
                String input = UserInputHandler.inputString();
                if (input.equalsIgnoreCase("Y")) {
                    System.out.print("Please give any number between 0 and 5: ");
                    int userRating = UserInputHandler.inputInt();
                    System.out.print("Please write a review: ");
                    String review = UserInputHandler.inputString();
                    Value value = new Value(userRating, review);
                    item.addValue(value);
                    return;
                }
            }
            System.out.println("This ID not found");
        }
    }


    public void showAllGames() {
        for (Item item : dartProducts) {

            System.out.println(item + ". Average user rating: " + item.findAverageRating() + ". Customer reviews: " + item);

        }
        System.out.print("Press any key to continue: ");
        UserInputHandler.pressAnyKeyCon();


    }

    public double dartDailyRent() {
        double totalRentProfit = 0;
        for (Item item : dartProducts) {
            totalRentProfit = (totalRentProfit + item.getDailyRent());
        }
        return totalRentProfit;//return value

    }

    public void showTotalDailyRent() {
        System.out.println("Total daily rent" +/* itemController.*/dartDailyRent());
    }


//    public void search() {
//        System.out.print("Please enter S for song album search or G for game search: ");
//        String input = UserInputHandler.inputString();
//        if (input == "S") {
//            findSong(int year);
//        }
//        else if(input=="G"){
//            findGame(String genre);
//        }
//        return;
//    }
//
//    public void findGame(String genre) {
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
//
//    }
//
//    public void findSong(int year) {
//        for (Item item : dartProducts) {
//            if (item instanceof Song) {
//                Song s = (Song) item;//turn item in song
//                if (s.getReleaseYear() == s.getReleaseYear()) {
//                    System.out.println(s);
//                }
//            }
//        }
//
//
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

}