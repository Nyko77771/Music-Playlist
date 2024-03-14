/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */
public class Song {
    
    private String name;
    private String length;
    private String artist;
    private String album;
    
    public Song(String nameOfSong, String length, String artist, String album){
        name = nameOfSong;
        this.length = length;
        this.artist = artist;
        this.album = album;     
    }
    
    public Song(String name, String length, String artist){
        this(name, length, artist, "Unknown");
    }
    
    public Song(String name, String length){
        this(name, length, "Unknown", "Unknown");
    }
    
    public Song(String name){
        this(name, "0:00", "Unknown", "Unknown");
    }

    public String getName() {
        return name;
    }
    
}
