package DART.Data;

import DART.UserInputHandler;

import java.util.ArrayList;

public class RentProcess {

    ArrayList <RentedObject> dartProducts = new ArrayList<>();

    // Must Use UUID for IDs later!!!

    public void addSong() {

        RentedObject song = new Song();

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

        System.out.println(dartProducts);

    }

    public void deleteSong() {

        System.out.println("Please enter the ID of the song which you wish to delete:");
        int ID = UserInputHandler.inputInt();

        for (int i = 0; i < dartProducts.size(); i++){

            RentedObject song = dartProducts.get(i);
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

        for(int i = 0; i < dartProducts.size(); i++) {

            RentedObject song = dartProducts.get(i);
            int songID = song.getID();

            if( receivedID == songID ) {

                RentedObject foundSong = dartProducts.get(i);
                foundSong.rent();

                System.out.println(dartProducts);

            }
        }
    }

    public void returnSong() {

        System.out.println("Insert the ID of the song you wish to return:");
        int inputID = UserInputHandler.inputInt();

        for(int i = 0; i < dartProducts.size(); i++) {

            RentedObject song = dartProducts.get(i);
            int songID = song.getID();

            if( inputID == songID ) {
                song.returnObject();
            }
        }

        System.out.println(dartProducts);
    }




    public void menuRegisterAGame() {

        RentedObject game = new MGame();

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
        ((MGame) game).setGenre(genre);

        dartProducts.add(game);

        System.out.println(dartProducts);

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
        for(int i = 0; i < dartProducts.size(); i++) {

            MGame game = (MGame) dartProducts.get(i);
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

    public void returnAGame() {

        System.out.println("Insert the ID of the game you wish to return:");
        int inputID = UserInputHandler.inputInt();

        for(int i = 0; i < dartProducts.size(); i++) {

            RentedObject game = dartProducts.get(i);
            int songID = game.getID();

            if( inputID == songID ) {
                game.returnObject();
            }
        }

        System.out.println(dartProducts);
    }

    public void menuShowTotalRentProfit() {
        // didnt get this part from previous code!!
    }     //HHHHHEEEEYY FIX THIS pls!!!

    public void showAllGames(){
        for(int i =0 ; i<dartProducts.size(); i++) {

            if (dartProducts.get(i) instanceof MGame) {
                System.out.println(dartProducts.get(i));
            }
        }
        System.out.print("Press any key to continue: ");
        UserInputHandler.pressAnyKeyCon();
    }

}
