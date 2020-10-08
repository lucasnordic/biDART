package DART.Data;

import DART.UserInputHandler;


public class SongAlbum extends DART.Data.Product {

    private String artist;
    private int year;

    public SongAlbum(String title, double dailyRent, String artist, int year) {
        super(title, dailyRent);
        this.artist = artist;
        this.year = year;

    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return this.getId() + " : " + this.getTitle() + " by " + artist + ". Released in " + year + ". Price: " + getDailyRent() + " SEK. Status: " + getRentStatus();
    }


}
