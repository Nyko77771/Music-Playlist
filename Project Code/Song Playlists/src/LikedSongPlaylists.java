
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

//Stack class uses abstract parent class Playlist and Stack interface
public class LikedSongPlaylists extends Playlist implements StackInterface{
    
    private List<Song> likedSongs;
    LikedSongPlaylists tempList;
    
    public LikedSongPlaylists(){
        likedSongs = new ArrayList<Song>();
        tempList = null;
    }
    
    //Method for checking if the list is empty
    @Override
    public boolean isEmpty(){
        return likedSongs.isEmpty();
    }
    
    //Method for checking if the list is full(always false as cannot get full
    @Override
    public boolean isFull(){
        return false;    
    }
    
    //Method for adding song to top of stack
    @Override
    public void push(Song song){
        likedSongs.add(0, song);
    }
    
    //Method for removing song from the top of stack
    @Override
    public Song pop(){
        if(!isEmpty()){
            return likedSongs.remove(0);
        }      
        return null;
    }
    
    //Method for counting the size of stack based on how many elements it has
    @Override
    public int size(){
        
        int count = 0;
        
        if(!(isEmpty())){
            Iterator i; //using iterator to loop through the stack
            i = likedSongs.iterator();
            while (i.hasNext()){
                i.next();
                count++;
            }
        }
        
        return count;
    }
    
    //Method for searching for a particular song based on provided song name
    //Return the song name or informs user if its not found
    @Override
    public String searchSong(String song){
        String stringBuild = "";
        if(!(isEmpty())){
            Iterator<Song> i;
            i = likedSongs.iterator();
            while(i.hasNext()){
                Song nextSong = i.next();
                if(nextSong.getName().equalsIgnoreCase(song)){
                    stringBuild = "Song "+ song + " found";
                    return stringBuild;
                } else {
                    return "Song not found";
                }
            }
        }
        return "List is empty";
    }
    
    //Method for printing songs in the stack
    @Override
    public String printPlaylist(){
                String stringBuild = ""; //Use a string to store the songs
                if(!(isEmpty())){
                    for(int i = 0; i < likedSongs.size(); i++){
                        stringBuild +="Song " + likedSongs.get(i) + "\n";
                    } return stringBuild;
        }
        return "List is empty"; //return all the songs in playlist or return nothing
    }
    
    //Method to look at the top song in the stack
    @Override
    public Song peek(){
        if(isEmpty()){
            return null;
        }
        return likedSongs.get(0); //returns top song
    }
    
    //Method for removing everything from the list
    @Override
    public void clear(){
        if(isEmpty()){
            System.out.println("Is empty");
        }   else {
            pop();
            clear();
        }
    }
    
    //Method for repeating the playlist
    @Override
    public String repeat(String answer){
        tempList = new LikedSongPlaylists();
        if(isEmpty()){
            return "Playlist is empty";
        } else{
            if(answer.equalsIgnoreCase("yes")){
                  while(!(likedSongs.isEmpty())){
                    tempList.push(pop());
                  }
                  clear();
                  while(!(tempList.isEmpty())){
                      likedSongs.add(tempList.pop());
                  } 
                  tempList.clear();
                  printPlaylist();
                  return "Playlist reversed";
            }
            return "Repeat cancelled";
        }
    }

}
