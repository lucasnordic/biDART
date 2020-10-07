package dart.data;

import dart.data.items.Game;
import dart.UserInputOutput;

import java.util.ArrayList;

public class GameController {
    private ArrayList<Game> games= new ArrayList<>();
    private double totalRentProfit = 0;

    public void showAvailableGames(){
        for(int i =0 ; i<games.size(); i++){
            if (games.get(i).getRentStatus().equals("available")) {
                System.out.println(games.get(i));
            }
        }
    }

    public void addGame (Game game){
        games.add(game);
        System.out.println("The game has been added!");
    }

//    public void removeGame (int id){
//        for(int i =0 ; i<games.size(); i++){
//            if (games.get(i).getId()==id) {
//                games.remove(i);
//                System.out.println("The game has been removed!");
//                return;
//            }
//        }
//        System.out.println("Game ID " + id + " is not found");
//    }

    public void showAllGames(){
        for(int i =0 ; i<games.size(); i++){
                System.out.println(games.get(i));
        }
        System.out.print("Press any key to continue: ");
        UserInputOutput.pressAnyKeyCon();
    }

//    public Game find (int gameId) {
//        for (int i = 0; i < games.size(); i++) {
//            if (games.get(i).getId() == gameId) {
//                return games.get(i); //this method receive from GameLibrary game searching its ID
//            }
//        }
//        return null;
//    }

//    public void rentAGame(int gameID) {
//        for(int i =0 ; i<games.size(); i++){
//            if (games.get(i).getId()==gameID) {
//                if (games.get(i).getRentStatus().equals("rented")){
//                    System.out.println("Game with ID "+gameID+" is already rented");
//                    return;
//                }
//                games.get(i).rent();
//                System.out.println("The game has been rented!");
//                return;
//            }
//
//        }
//        System.out.println("Game with ID "+gameID+" is not found");
//    }

    public void storeDailyRent(double totalRent){
        totalRentProfit =totalRentProfit + totalRent;
    }

    public void menuShowTotalRentProfit() {
        System.out.println("Total rent profit is " + totalRentProfit);
    }

}


