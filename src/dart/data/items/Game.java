package dart.data.items;

import dart.data.items.parent.Item;
import dart.UserInputHandler;

public class Game extends Item {
    private String genre;
    private double dailyRent;
    private String rentStatus = "available";

    public Game(String name, String genre, double dailyRent) {
        super(name);
        this.genre = genre;
        this.dailyRent = dailyRent;
        this.rentStatus = rentStatus;

    }

    public String getTitle() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void rent (){
        rentStatus="rented";
    }

    public void makeGameAvailableAgain(){
        rentStatus="available";
    }

    public String toString (){ //
        return getId() + " : " + name + " (" + genre + "). " + dailyRent + "$. Status: " + rentStatus+"\n";
    }
}

