
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */
public class LikedSongPlaylists extends Playlist implements StackInterface{
    
    private List<Song> likedSongs;
    
    public LikedSongPlaylists(){
        likedSongs = new ArrayList<Song>();
    }
    
    public boolean isEmpty(){
        return likedSongs.isEmpty();
    };
    
    public boolean isFull(){
        return false;    
    };
    
    public void push(Song song){
        addSong(song);
    };
    
    public Song pop(){
        return removeSong();
    };
    
    public int size(){
    
    };
    
    protected Song addSong(Object item){
    };
    
    protected Song removeSong(){
    
    };
    
    public String searchSong(){
    
    };
    
    public String printPlaylist(){
    
    };
    
}
