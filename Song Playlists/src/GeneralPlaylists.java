/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */
public class GeneralPlaylists extends Playlist implements LinearListInterface {
    
    private LikedSongPlaylists likedSongs;
    private Node head;
    private Node last;
    private Node current;
    private int size;
    private final Node newNode;
    
    public GeneralPlaylists(){
        head = null;
        last = null;
        current = head;
        size = 0;
        newNode = null;
    }
    
    @Override
    public String searchSong(Song song){
        current = head;
        return searchSong(current,song);
    }
    
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
    
    @Override
    public String printPlaylist(){
        current = head;
        return printPlaylist(current);
    }
    
    private String printPlaylist(Node current){
        if(current == null){
            return "/n";
        }
        else {
            printPlaylist(current.getNext());
            return "Song " + current.getSong() + "/n";
        }
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public boolean isEmpty(){
        return (size == 0);
    }
    
    @Override
    public Song get(int index){
        
        for(int i=0; i < index; i++){
            if(current.getSong().equals(index)){
                return current.getSong();
            }
        }
        
        return null;
    
    }
    
    @Override
    public String remove(int index){
        
        if (index > size){
            return "Index too big";
        } else if((index < 0)){
               return "Index too small";     
        } else if(index == 1){
            head.getNext().setPrev(null);
            head = head.getNext();
            return "Removed Song 1";
        } else{
            current = head;
            for(int i=0; i<index; i++){
                current = current.getNext();
            }
            
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current = current.getPrev();
            size--;
            return "Removed Song at " + index;
        }
    
    }
    
    @Override
    public void add(int index){

        newNode();
        
        if (index > size){
            newNode.setPrev(last);
            last.setNext(newNode);
            last = last.getNext();
        } else if((index < size) || (index <= 1)){
            newNode.setNext(head);
            head.setPrev(newNode);
            head = head.getPrev();         
        } else{
            current = head;
            for(int i=0; i<index; i++){
                current = current.getNext();
            }
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }
    
    @Override
    public void add(){
        
        newNode();
        
        if(isEmpty()){
            head.setSong(newNode.getSong());
            head.setNext(last);
            size++;
        } else {
            last.setNext(newNode);
            last.getNext().setPrev(last);
            last = last.getNext();
            size++;
        }
        
    }
    
    @Override
    public String repeat(boolean answer){
        
        if(isEmpty()){
            return "Playlist is empty";
        } else{
            if(answer){
                current = head;
                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(head);
                head.setPrev(current);
                return "Looping to Begining";
            }
            return "Repeat cancelled";
        }
    }
    
    @Override
    public void move(int songIndex, int moveIndex){
        if(songIndex > size || songIndex < size || moveIndex > size || moveIndex < size){
            return;
        }
        
        Node movedNode = null;
        current = head;
        
        for(int i=0; i<songIndex; i++){
            current = current.getNext();
        }
        
        movedNode.setSong(current.getSong());
        
        if(current.getNext() != null){
            current.getNext().setPrev(current.getPrev());
        }
        if (current.getPrev() != null){
            current.getPrev().setNext(current.getNext());
        }
        current = head;
        for(int i=0; i<moveIndex; i++){
            current = current.getNext();
        }
        
        movedNode.setPrev(current.getPrev());
        movedNode.setNext(current);
        current.getPrev().setNext(movedNode);
        current.setPrev(movedNode);
        
    }
    
    private void newNode(){
        newNode.setSong(likedSongs.peek());
    }
    
}
