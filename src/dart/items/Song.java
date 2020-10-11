package dart.items;

public class Song extends Item {

    //New added attributes:

    private String artist;
    private int releaseYear;

    //Constructor:

    public Song( String title, double dailyRent, String artist, int releaseYear) {

        super(title,dailyRent);
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    //Getters & setters:

    protected String getArtist() { return this.artist; }
    protected int getReleaseYear() { return this.releaseYear; }

    protected void setArtist(String artist) { this.artist = artist; }
    protected void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    //Methods:

    public String toString() {
     //   return super.toString()+ " by " + this.artist + ". Released in " + this.releaseYear + ".";
        return  super.getID() + ": " + super.getTitle() + " by " + this.artist +
                ". Released in " + this.releaseYear + ". Price: " + super.getDailyRent() +
                " SEK. Status: " + super.getRentStatus() + super.toString();
               }

}
