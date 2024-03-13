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
    private int length;
    private String artist;
    private String album;
    
    public Song(String name, int length, String artist, String album){
        this.name = name;
        this.length = length;
        this.artist = artist;
        this.album = album;     
    }
    
    public Song(String name, int length){
        this(name, length, "Unknown", "Unknown");
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
    
}
