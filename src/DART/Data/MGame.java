package DART.Data;

import java.util.ArrayList;

public class MGame extends RentedObject {

    private String genre;

    public MGame(int ID, String title, double dailyRent, String rentStatus, String genre) {

        super();
        this.genre = genre;
    }

    public MGame() {}

    public String getGenre() { return this.genre; }
    public void setGenre( String genre) { this.genre = genre; }
    public String toString (){
        return super.getID() + " : " + super.getTitle() + " (" + this.genre + "). " + super.getDailyRent() + "$. Status: " + super.getRentStatus()+"\n";
    }
}
