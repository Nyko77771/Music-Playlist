
import java.util.ArrayList;
import java.util.Iterator;
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
    }
    
    public boolean isFull(){
        return false;    
    }
    
    public void push(Song song){
        likedSongs.add(0, song);
    }
    
    public Song pop(){
        if(!isEmpty()){
            return likedSongs.remove(0);
        }      
        return null;
    }
    
    public int size(){
        
        int count = 0;
        
        if(!isEmpty()){
            Iterator i;
            i = likedSongs.iterator();
            while (i.hasNext()){
                count++;
            }
        }
        
        return count;
    }
    
    public String searchSong(Song song){
        if(!isEmpty()){
            Iterator i;
            i = likedSongs.iterator();
            while(i.hasNext()){
                if(i.next().equals(song)){
                    return "Song "+ song + "found";
                }
            }
        }
        return "Song " + song + "not Found";
    }
    
    public String printPlaylist(){
                if(!isEmpty()){
                    for(int i = 0; i > likedSongs.size(); i++){
                        return "Song " + likedSongs.get(i) + "/n";
                    }
        }
        return null;
    }
    
    public Song peek(){
        if(isEmpty()){
            return null;
        }
        return likedSongs.get(0);
    }
    
    public String clear(){
        if(isEmpty()){
            return "Is empty";
        }   else {
            pop();
            clear();
        }
        return "Playlist cleared";
    }
    
    public String repeat(boolean answer){
        if(isEmpty()){
            return "Playlist is empty";
        } else{
            if(answer){
                
            }
        }
    }
    
    public void move(int songIndex, int moveIndex){
        
    }
    
}
