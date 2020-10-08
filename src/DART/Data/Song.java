package DART.Data;

import DART.UserInputHandler;

/**
 * 7.1 add song album
 * employee/ to add song albums to DART
 * <ID> : <Title> - by <artist>. Released in <release year>. Price:  <daily rent> SEK. Status: <rent status>
 */


public class Song {
    private int songID ;
    private String songTitle;
    private String songArtist;
    private int releaseYear;
    private double price;
    private double dailyRent;
    private String rentStatus = "available";




    public Song(int songID, String songTitle, String songArtist, int releaseYear, double price, double dailyRent, String rentStatus) {
        System.out.println("Please enter ID of the song: ");
        songID = UserInputHandler.inputInt();
        System.out.println("Please enter title of the song: ");
        songTitle = UserInputHandler.inputString();
        System.out.println("please enter artist of the song: ");
        songArtist = UserInputHandler.inputString();
        System.out.println("Please enter release year of the song:");
        releaseYear = UserInputHandler.inputInt();
        System.out.println("Please enter price of the song:");
        price = UserInputHandler.inputDouble();
        System.out.println("Please enter daily rent of the song:");
        dailyRent = UserInputHandler.inputDouble();
        System.out.println("Rent status: " +rentStatus );
        System.out.println("you created a new game with ID" +songID+ "song title"+songTitle
        +"song artist"+songArtist+"release year"+releaseYear+"price"+price+
                "daily rent"+dailyRent);

        //this.songID = songID;
        //this.songTitle = songTitle;
        //this.songArtist = songArtist;
        //this.releaseYear = releaseYear;
        //this.price = price;
        //this.dailyRent = dailyRent;
        //this.rentStatus = rentStatus;



        public int getSongID() {
            return songID;
        }

        public void setSongID(int songID) {
            this.songID = songID;
        }

        public String getSongTitle() {
            return songTitle;
        }

        public void setSongTitle(String songTitle) {
            this.songTitle = songTitle;
        }

        public String getSongArtist() {
            return songArtist;
        }

        public void setSongArtist(String songArtist) {
            this.songArtist = songArtist;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDailyRent() {
            return dailyRent;
        }

        public void setDailyRent(double dailyRent) {
            this.dailyRent = dailyRent;
        }

        public String getRentStatus() {
            return rentStatus;
        }

        public void setRentStatus(String rentStatus) {
            this.rentStatus = rentStatus;
        }





    }
}
