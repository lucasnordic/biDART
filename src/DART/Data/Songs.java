/*package DART.Data;

import DART.Dart;
import DART.UserInputHandler;

public class Songs {

    SongLibrary songList = new SongLibrary();
    SongLibrary rentedSongs = new SongLibrary();

    //All the methods that happen to songs are defined here:

    public void addSongs() {

        Song song = new Song();

        System.out.println("Please insert the following information:\nSong ID:");
        int ID = UserInputHandler.inputInt();
        song.setID(ID);
        
        System.out.println("Title: ");
        String title = UserInputHandler.inputString();
        song.setTitle(title);

        System.out.println("Artist: ");
        String artist = UserInputHandler.inputString();
        song.setArtist(artist);

        System.out.println("Release year: ");
        int releaseYear = UserInputHandler.inputInt();
        song.setReleaseYear(releaseYear);

        System.out.println("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        song.setDailyRent(rent);

        songList.addSong(song);

        System.out.println(songList);

    }

    public void deleteSong() {

        System.out.println("Please enter the ID of the song which you wish to delete:");
        int ID = UserInputHandler.inputInt();

        for (int i = 0; i < songList.getSize(); i++){

            Song song = songList.get(i);
            int songID = song.getID();

            if (ID == songID) {

                songList.removeSong(song);
                System.out.println(songList);
            }
        }
    }

    public void rentSong() {

        System.out.println("Insert the ID of the song you wish to rent:");
        int receivedID = UserInputHandler.inputInt();

        for(int i = 0; i < songList.getSize(); i++) {

            Song song = songList.get(i);
            int songID = song.getID();

            if( receivedID == songID ) {

                Song foundSong = songList.get(i);
                foundSong.rent();
                rentedSongs.addSong(foundSong);

                System.out.println(songList);
                System.out.println(rentedSongs);
            }
        }
    }

    public void returnSong() {

        System.out.println("Insert the ID of the song you wish to return:");
        int inputID = UserInputHandler.inputInt();

        for(int i = 0; i < rentedSongs.getSize(); i++) {

            Song song = rentedSongs.get(i);
            int songID = song.getID();

            if( inputID == songID ) {

                Song foundSong = rentedSongs.get(i);
                foundSong.returnObject();
                rentedSongs.removeSong(foundSong);
            }
        }
        System.out.println(rentedSongs);
        System.out.println(songList);
    }
}


 */