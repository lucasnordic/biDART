package DART.Data;

import DART.UserInputHandler;

public class Game extends Product {

    private String genre;

    public Game(String title, double dailyRent, String genre) {
        super(title, dailyRent);
        this.genre = genre;

    }

    public Game() {

    }

    public String toString() {
        return this.getId() + " : " + getTitle() + " (" + genre + "). " + getDailyRent() + "$. Status: " + getRentStatus() + "\n";
    }
}

