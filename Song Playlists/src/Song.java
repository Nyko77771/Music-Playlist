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
//    private String length;
    private String artist;
    private String album;
    
    public Song(String nameOfSong, String artist, String album){
        name = nameOfSong;
//        this.length = length;
        this.artist = artist;
        this.album = album;     
    }
    
    public Song(String name, String artist){
        this(name, artist, "Unknown");
    }
    
    public Song(String name){
        this(name, "Unknown", "Unknown");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Song{" + "name=" + name + ", artist=" + artist + ", album=" + album + '}';
    }   
    
}
