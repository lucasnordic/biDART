//package DART.Data;
//
//public class GameLibrary {
//    private Game[] games; //array for games
//    private int nextPosition;
//
//    public GameLibrary() {
//        this.games = new Game[10];
//
//    }
////
////    public void addGame(Game game) {
////        if (nextPosition < this.games.length) {
////            games[nextPosition] = game;
////            nextPosition++;
////        } else {
////            Game[] biggerGame = new Game[games.length + 1];
////            for (int i = 0; i < games.length; i++) {
////                biggerGame[i] = games[i];
////            }
////            this.games = biggerGame;
////            biggerGame[nextPosition] = game;
////            nextPosition++;
////
////        }
////    }
//       for (int i = 0; i < games.length; i++) {//searching for the first empty cell
//            if (games[i] == null) {
//                games[i] = game;//put new game into empty cell
//                System.out.println("Game N " + i + " was added to DART");
//                return;//stop search
//            }
//        }
//        Game[] moreGames = new Game[games.length + 1];
//        System.arraycopy(games, 0, moreGames, 0, games.length);
//        moreGames[games.length] = game;
//        games = moreGames;
//        System.out.println("Game N" + games.length + "was added to DART");
//    }
//
//
//
//    public void removeAGame(int id) {
//        for (int i = 0; i < games.length; i++) {
//            if (games[i] != null && games[i].getId() == id) {
//                games[i] = null;
//                System.out.println("Game is removed!");
//                return;
//            }
//        }
//        System.out.println("Game with id #" + id + " not found");
//    }
//}
//
//
////
////
////package DART.Data;
////
////        import java.io.DataInput;
////        import java.io.IOException;
////        import java.util.ArrayList;
////        import java.util.Scanner;
////
////public class GameLibrary {
////    private Game[] games; //array for games
////    private int nextPosition;
////
////    public GameLibrary(){
////        this.games = new Game[10];
////
////
////    }
////
////    public void addGame(Game game) {
////        if (nextPosition < this.games.length) {
////            games[nextPosition] = game;
////            nextPosition++;
////        } else {
////            Game[] biggerGame = new Game[games.length + 1];
////            for (int i = 0; i < games.length; i++) {
////                biggerGame[i] = games[i];
////            }
////            this.games = biggerGame;
////            biggerGame[nextPosition] = game;
////            nextPosition++;
////
////        }
////    }
////
////    public void removeAGame(int id) {
////        for (int i = 0; i < games.length; i++) {
////            if (games[i] != null && games[i].getId() == id) {
////                games[i] = null;
////                System.out.println("Game is removed!");
////                return;
////            }
////        }
////        System.out.println("Game with id #" + id + " not found");
////    }
////
////
////    //for EPF6
////    //show all available games.
////    //rent an available game given ID.
////    //cover cases where ID does not exist.
////
////    //  public void rentGame(){
////
////    public void rentGame() {
////
////        ArrayList<Game> gameList = new ArrayList<>();// making array list for the games
////
////    }
////
////    Game[] availableGames = new Game[10];
////    private final DataInput InputClass = null;
////
////    {
////
////        for (int i = 0; i < 10; i++) {
////            Scanner input = new Scanner(System.in);
////            System.out.println("Please enter the id of the game");
////
////            int id = input.nextInt();
////            input.nextLine();
////
////            System.out.println("Type the title of the game");
////            String title = input.nextLine();
////
////            System.out.println("Type the genre of the game");
////            String genre = input.nextLine();
////
////            System.out.println("Type the daily rent of the game");
////            double dailyPrice = input.nextDouble();
////
////            Game game = new Game(id, title, genre,dailyPrice); //constructor call
////            availableGames[i] = game;
////            System.out.println("The game has been added");
////        }
////
////        System.out.println("Printing all games: ");
////        for (int i = 0; i < games.length; i++) {
////            System.out.println(games[i]);
////        }
////    }
////
////}