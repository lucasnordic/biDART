package dart.items;

public class Game extends Item {

    private String genre;

    public Game( String title, double dailyRent, String genre) {

        super(title,dailyRent);
        this.genre = genre;
    }
    public Game() {}


    public String getGenre() { return this.genre; }
    public void setGenre( String genre) { this.genre = genre; }
    public String toString (){
       // return super.toString()+" (" + genre + ")";
        return super.getID() + " : " + super.getTitle() + " (" + this.genre + "). "
               + super.getDailyRent() + "$. Status: " + super.getRentStatus()+ super.toString();
    }
}
