/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */
public class GeneralPlaylists extends Playlist implements LinearListInterface {
    
    private Node head;
    private Node last;
    private Node current;
    private int size;
    
    public GeneralPlaylists(){
        head = null;
        last = null;
        current = head;
        size = 0;
    }
    
    public String searchSong(Song song){
        return searchSong(current,song);
    };
    
    private String searchSong(Node current, Song song){
        if(current == null){
            return "Not found";
        }
        else if(current.getSong().equals(song)){
            return "Song " + song + " found";
        }
        else {
            searchSong(current.getNext(), song);
            return "Searching next";
        }
    }
    
    public String printPlaylist(){
        return printPlaylist(current);
    };
    
    private String printPlaylist(Node current){
        if(current == null){
            return "/n";
        }
        else {
            printPlaylist(current.getNext());
            return "Song " + current.getSong() + "/n";
        }
    }
    
    public int size(){
        return size;
    };
    
    public boolean isEmpty(){
        return (size == 0);
    };
    
    public Song get(int index){
    
    };
    
    public void remove(int index){
    
    };
    
    public void add(Song song, int index){
    
    };
    
    public void add(Song song){
    
    };
    
    public void repeat(){
    
    };
    
}
