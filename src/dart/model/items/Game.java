package dart.model.items;

public class Game extends Item {

    private String genre;

    public Game( String title, double dailyRent, int releaseYear, String genre) {

        super(title,dailyRent,releaseYear);
        this.genre = genre;
    }

    public Game (String[] savedAttributes) {
        super(savedAttributes);
        this.genre = savedAttributes[3];
    }


    public String getGenre() { return this.genre; }
    public void setGenre( String genre) { this.genre = genre; }
    public String toString (){
       // return super.toString()+" (" + genre + ")";
        return super.getID() + " : " + super.getTitle() + " (" + this.genre + "). "+
                "Released in " + super.getReleaseYear() + ". "+
               + super.getDailyRent() + " SEK. Status: " + super.getRentStatus()+ super.toString();
    }
}
