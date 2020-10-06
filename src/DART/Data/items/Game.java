package DART.Data.items;

import DART.Data.items.parent.grandparent.Item;
import DART.UserInputHandler;

public class Game extends Item {
    private String genre;
    private double dailyRent;
    private String rentStatus = "available";

    public Game(int id, String name) {
        super(name);
        System.out.print("Please enter title of a game: ");
        name = UserInputHandler.inputString();
        System.out.print("Please enter genre of a game: ");
        genre = UserInputHandler.inputString();
        System.out.print("Please enter daily rent of a game: ");
        dailyRent = UserInputHandler.inputDouble();
        System.out.print("Rent status: " + rentStatus);
        System.out.println("\nYou created a new game. Game ID " + id + "!" );
        //this.id=id;
//        this.title=title;
//        this.genre=genre;
//        this.dailyRent=dailyRent;
//        this.rentStatus=rentStatus;

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

    public void makeGameAvailableAgain(){ rentStatus="available";}



    public String toString (){ //
        return getId() + " : " + name + " (" + genre + "). " + dailyRent + "$. Status: " + rentStatus+"\n";
    }
}

