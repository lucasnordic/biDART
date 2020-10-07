package dart.data.items;

import dart.data.items.parent.Item;

public class SongAlbum extends Item {

    private String artist;
    private int releaseYear;
    private double dailyRent;
    private boolean rentStatus;

    // controller:
    public SongAlbum(String name, String artist, int releaseYear, double dailyRent) {
        super(name);
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.dailyRent = dailyRent;
        rentStatus = true;
    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(double dailyRent) {
        this.dailyRent = dailyRent;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }
}
