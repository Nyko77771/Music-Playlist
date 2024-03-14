
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
    LikedSongPlaylists tempList;
    
    public LikedSongPlaylists(){
        likedSongs = new ArrayList<Song>();
        tempList = null;
    }
    
    @Override
    public boolean isEmpty(){
        return likedSongs.isEmpty();
    }
    
    @Override
    public boolean isFull(){
        return false;    
    }
    
    @Override
    public void push(Song song){
        likedSongs.add(0, song);
    }
    
    @Override
    public Song pop(){
        if(!isEmpty()){
            return likedSongs.remove(0);
        }      
        return null;
    }
    
    @Override
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
    
    @Override
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
    
    @Override
    public String printPlaylist(){
                if(!isEmpty()){
                    for(int i = 0; i > likedSongs.size(); i++){
                        return "Song " + likedSongs.get(i) + "/n";
                    }
        }
        return null;
    }
    
    @Override
    public Song peek(){
        if(isEmpty()){
            return null;
        }
        return likedSongs.get(0);
    }
    
    @Override
    public void clear(){
        if(isEmpty()){
            System.out.println("Is empty");
        }   else {
            pop();
            clear();
        }
    }
    
    @Override
    public String repeat(boolean answer){
        if(isEmpty()){
            return "Playlist is empty";
        } else{
            if(answer){
                  while(!(likedSongs.isEmpty())){
                    tempList.push(pop());
                  }
                  clear();
                  while(!(tempList.isEmpty())){
                      likedSongs.add(tempList.pop());
                  } 
                  tempList.clear();
                  return "Playlist reversed";
            }
            return "Repeat cancelled";
        }
    }
    
    @Override
    public void move(int songIndex, int moveIndex){
        if(isEmpty()){
            System.out.println("Playlist is empty");
        }
        
        if((songIndex > size()) || (songIndex < size()) || (moveIndex > size()) || (moveIndex < size())){
            System.out.println("Index given too small or large");
            return;
        }
        
        Song movedSong = null;
        int i = 0;
        while(!(i<songIndex-1)){
            tempList.push(pop());
            i++;
        }
        movedSong = pop();
        while(!(i == 0)){
            push(tempList.pop());
            i--;
        }
        while(!(i<moveIndex+1)){
            tempList.push(pop());
        }
            push(movedSong);
            push(tempList.pop());
    }

}
