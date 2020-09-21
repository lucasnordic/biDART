package DART.Data;

public class GameLibrary {
    private Game[] games; //array for games
    private int nextPosition;

    public GameLibrary() {
        this.games = new Game[10];

    }

    public void addGame(Game game) {
        if (nextPosition < this.games.length) {
            games[nextPosition] = game;
            nextPosition++;
        } else {
            Game[] biggerGame = new Game[games.length + 1];
            for (int i = 0; i < games.length; i++) {
                biggerGame[i] = games[i];
            }
            this.games = biggerGame;
            biggerGame[nextPosition] = game;
            nextPosition++;

        }
    }

    public void removeAGame(int id) {
        for (int i = 0; i < games.length; i++) {
            if (games[i] != null && games[i].getId() == id) {
                games[i] = null;
                System.out.println("Game is removed!");
                return;
            }
        }
        System.out.println("Game with id #" + id + " not found");
    }
}
