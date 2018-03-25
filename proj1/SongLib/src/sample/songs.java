//Jonathen Sheffer
//Aaron Teitz


package sample;
import java.util.*;
public class songs {

    public String name;
    public String artist;
    public String album;

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setYear(String year) {
        this.year = year;
    }



    public String year;



    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }



    public songs (String name, String artist, String album, String year)
    {
        this.name =name;
        this.artist=artist;
        this.album=album;
        this.year = year;

    }

    @Override
    public String toString()
    {
        return "Song name: " + this.name;
        //return "Song name: " + this.name + "    Arist: " + this.artist + "  Album: " + this.album + "   Year: " + this.year;
    }




}
