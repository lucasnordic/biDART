package dart.items;

import dart.UserInputHandler;

import java.util.ArrayList;

public class ItemController {
    private double totalRentProfit = 0;
    private ArrayList <Item> dartProducts = new ArrayList<>();

    /**
     * Song Item:
     */

    public void addSong() {

        Item song = new SongAlbum();

        System.out.println("Please insert the following information:\nSong Title: ");
        String title = UserInputHandler.inputString();
        song.setTitle(title);

        System.out.println("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        song.setDailyRent(rent);

        System.out.println("Artist: ");
        String artist = UserInputHandler.inputString();
        ((SongAlbum) song).setArtist(artist);

        System.out.println("Release year: ");
        int releaseYear = UserInputHandler.inputInt();
        ((SongAlbum) song).setReleaseYear(releaseYear);

        dartProducts.add(song);

        System.out.println(dartProducts);

    }

    public void deleteSong() {

        System.out.println("Please enter the ID of the song which you wish to delete:");
        String ID = UserInputHandler.inputString();

        for (int i = 0; i < dartProducts.size(); i++){

            Item song = dartProducts.get(i);
            String songID = song.getID();

            if (ID.equals(songID)) {

                dartProducts.remove(song);
                System.out.println(dartProducts);
            }
        }
    }

    public void rentSong() {

        System.out.println("Insert the ID of the song you wish to rent:");
        String receivedID = UserInputHandler.inputString();

        for(int i = 0; i < dartProducts.size(); i++) {

            Item song = dartProducts.get(i);
            String songID = song.getID();

            if( receivedID.equals(songID)) {

                Item foundSong = dartProducts.get(i);
                foundSong.rent();

                System.out.println(dartProducts);

            }
        }
    }

    public void returnSong() {

        System.out.println("Insert the ID of the song you wish to return:");
        String inputID = UserInputHandler.inputString();

        for (Item song : dartProducts) {

            String songID = song.getID();

            if (inputID.equals(songID)) {
                song.returnObject();
            }
        }

        System.out.println(dartProducts);
    }

    /**
     *  Game Item:
     */

    public void registerAGame() {

        Item game = new Game();

        System.out.println("Please insert the following information:\nTitle: ");
        String title = UserInputHandler.inputString();
        game.setTitle(title);

        System.out.println("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        game.setDailyRent(rent);

        System.out.println("genre: ");
        String genre = UserInputHandler.inputString();
        ((Game) game).setGenre(genre);

        dartProducts.add(game);
        System.out.println("The game has been added!");

        System.out.println(dartProducts);

    }

    public void RemoveAGame() {
        System.out.print("Please enter a number of the game you want to remove: ");
        int id = UserInputHandler.inputInt();
        dartProducts.remove(id);
    }

    public void rentAGame() {

        //gameLibrary.showAvailableGames();
        for (Item dartProduct : dartProducts) {

            Game game = (Game) dartProduct;
            String gameStatus = game.getRentStatus();
            if (gameStatus.equals("available")) {
                System.out.println(game);
            }
        }

        System.out.print("Please enter game ID that you want to rent: ");
        String gameID = UserInputHandler.inputString();
        for (Item dartProduct : dartProducts) {

            if (dartProduct.getID().equalsIgnoreCase(gameID)) {

                if (dartProduct.getRentStatus().equals("rented")) {
                    System.out.println("Game with ID " + gameID + " is already rented");
                }
                dartProduct.rent();
                System.out.println("The game has been rented!");
                return;
            }
        }
    }

    public void returnAGame() {

        System.out.println("Insert the ID of the game you wish to return:");
        String inputID = UserInputHandler.inputString();

        for (Item game : dartProducts) {

            String songID = game.getID();

            if (inputID.equals(songID)) {
                game.returnObject();
            }
        }

        System.out.println(dartProducts);
    }

    public void showTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }

    public void showAllGames(){
        for (Item dartProduct : dartProducts) {

            if (dartProduct instanceof Game) {
                System.out.println(dartProduct);
            }
        }
        System.out.print("Press any key to continue: ");
        UserInputHandler.pressAnyKeyCon();
    }

    // TODO: NOT WORKING:
    /*
    public void showAvailableGames(){
        for(int i =0 ; i<dartProducts.size(); i++){
            if (dartProducts.get(i).getRentStatus().equals("available")) {
                System.out.println(games.get(i));
            }
        }
    }

    public Game find (int gameId) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId() == gameId) {
                return games.get(i); //this method receive from GameLibrary game searching its ID
            }
        }
        return null;
    }

    public void storeDailyRent(double totalRent){
        totalRentProfit =totalRentProfit + totalRent;
    }

    public void menuShowTotalRentProfit() {

     */

}
