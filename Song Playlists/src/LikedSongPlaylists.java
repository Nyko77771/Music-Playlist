
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
        
        int count = 0;
        
        if(!isEmpty()){
            Iterator i;
            i = likedSongs.iterator();
            while (i.hasNext()){
                count++;
            }
        }
        
        return count;
    };
    
    protected Song addSong(Object item){
        likedSongs.add(0,(Song) item);
        return likedSongs.get(0);
    };
    
    protected Song removeSong(){
        if(!isEmpty()){
            return likedSongs.remove(0);
        }      
        return null;
    };
    
    public String searchSong(String name){
        if(!isEmpty()){
            Iterator i;
            i = likedSongs.iterator();
            while(i.hasNext()){
                if(i.next().equals(name)){
                    return "Song "+ name + "found";
                }
            }
        }
        return "Song " + name + "not Found";
    };
    
    public String printPlaylist(){
                if(!isEmpty()){
                    for(int i = 0; i > likedSongs.size(); i++){
                        return "Song " + likedSongs.get(i) + "/n";
                    }
        }
        return "Playlist is empty";
    };
    
    public Song peek(){
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
    
}
