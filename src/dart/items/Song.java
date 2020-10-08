package dart.items;

public class Song extends Item {

    //New added attributes:

    private String artist;
    private int releaseYear;

    //Constructor:

    public Song(int ID, String title, double dailyRent, String rentStatus, String artist, int releaseYear) {

        super();
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public Song() {}

    //Getters & setters:

    protected String getArtist() { return this.artist; }
    protected int getReleaseYear() { return this.releaseYear; }

    protected void setArtist(String artist) { this.artist = artist; }
    protected void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    //Methods:

    public String toString() {
        return  super.getID() + ": " + super.getTitle() + " by " + this.artist +
                ". Released in " + this.releaseYear + ". Price: " + super.getDailyRent() +
                " SEK. Status: " + super.getRentStatus() + "\n"; }

}
