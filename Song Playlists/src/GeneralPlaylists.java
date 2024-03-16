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
    private Node newNode;
    
    //Constructor that takes users likedSongs playlist as parameter
    public GeneralPlaylists(LikedSongPlaylists likedSongs){
        this.likedSongs = likedSongs;
        head = null;
        last = null;
        current = head;
        size = 0;
        newNode = null;
    }
    
    //Search song method with a song parameter for the user
    @Override
    public String searchSong(String song){
        current = head;
        return searchSong(current,song); //calls on a private search method with a current index node provided
    }
    
    //Private search method
    private String searchSong(Node current, String song){
        if(current == null){ //If current is null 
            return "Not found";
        }
        else if(current.getSong().getName().equalsIgnoreCase(song)){//if song matches current
            return "Song " + song + " found";
        }
        else {
            return searchSong(current.getNext(),song); //else recursion
        }
        
    }
    
    //A print method open to user. Calls a private print method with a current parameter
    @Override
    public String printPlaylist(){
        current = head;
        return printPlaylist(current);
    }
    
    //Prints all the songs in the general playlist by using current parameter
    private String printPlaylist(Node current){
        String stringBuild1 = "";
        String stringBuild2 = "";
        if(current == null){
            return "Nothing to print.\n";
        }
        else {
            stringBuild1 = "Song " + current.getSong() + "\n";
            stringBuild2 = printPlaylist(current.getNext());
            return stringBuild1 + stringBuild2;
        }
    }
    
    //Provides size of the general playlist
    @Override
    public int size(){
        return size;
    }
    
    //Tells whether the playlist is empty
    @Override
    public boolean isEmpty(){
        return (size == 0);
    }
    
    //Obtains a song name based on an index value provided by user
    @Override
    public Song get(int index){
        if(isEmpty()){
            return null;
        }
        
        if(index > size || index < 1){
            return null;
        }
        
        current = head;
        for(int i = 1; i < index; i++){
            current = current.getNext();
        }
        
        if(current == null){
            return null;
        }
        
        return current.getSong();
    }
    
    //Removes a song based on index provided by user
    @Override
    public String remove(int index){
        
        if(isEmpty()){
            return "Playlist is empty";
        }
        
        if (index > size){
            return "Index too big";
        } else if((index < 0)){
               return "Index too small";     
        } else if(index == 1 || index == 0){
            if(head.getNext() != null){
                head.getNext().setPrev(null);
            }
            head = head.getNext();
            size--;
            if(head == null){
                last = null;
            }
            return "Removed Song 1";
        } else{
            for(int i=0; i<index; i++){
                current = current.getNext();
            }
            if(current.getPrev() != null){
                current.getPrev().setNext(current.getNext());
            }
            if(current.getNext() != null){
                current.getNext().setPrev(current.getPrev());
            }
            if(current == last){
                last = current.getPrev();
            }
            size--;
            return "Removed Song at " + index;
        }
    
    }
    
    //Adds a song based on index provided by user
    @Override
    public void add(int index){

        newNode();
        
        if (isEmpty()){
            head = newNode;
            last = head;
        } else if(index > size){
            newNode.setPrev(last);
            last.setNext(newNode);
            last = last.getNext();
        } else if((index < size) || (index <= 1)){
            newNode.setNext(head);
            head.setPrev(newNode);
            head = head.getPrev();        
        } else{
            for(int i=0; i<index; i++){
                current = current.getNext();
            }
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }
        size++;
    }
    
    //Adds a song either to the end if list already exists or to the begining if its empty
    @Override
    public void add(){
        
        newNode();
        
        if(isEmpty()){
            head = newNode;
            last = newNode;
            size++;
        } else {
            last.setNext(newNode);
            last.getNext().setPrev(last);
            last = last.getNext();
            size++;
        }
        
    }
    
    //Repeats the playlist
    @Override
    public String repeat(String answer){
        answer = answer.toLowerCase();
        if(isEmpty()){
            return "Playlist is empty";
        } else{
            if(answer.equals("yes")){
                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(head);
                head.setPrev(current);
                printPlaylist();
                return "Looping to Begining";
            }
            return "Repeat cancelled";
        }
    }
    
    //Move song from one position to another based on indexes
    @Override
    public void move(int songIndex, int moveIndex){
        if(songIndex > size || songIndex < 1 || moveIndex > size || moveIndex < 1){
            return;
        }
        
        if(!(isEmpty())){
        
        Node movedNode = new Node();
        movedNode = head;
        
        for(int i=1; i<songIndex; i++){
            movedNode = movedNode.getNext();
        }
//        movedNode.setSong(current.getSong());
//        if(current.getNext() != null){
//            current.getNext().setPrev(current.getPrev());
//        }
//        if(current.getPrev() != null){
//            current.getPrev().setNext(current.getNext());
//        }

        if(movedNode.getPrev() != null){
            movedNode.getPrev().setNext(movedNode.getNext());
        } else {
            head = movedNode.getNext();
        }
        if(movedNode.getNext() != null){
            movedNode.getNext().setPrev(movedNode.getPrev());
        } else {
            last = movedNode.getPrev();
        }
        
        Node insertNode = head;
        
        for(int i=1; i<moveIndex; i++){
            insertNode = insertNode.getNext();
        }
        if(insertNode.getPrev() != null){
            insertNode.getPrev().setNext(movedNode);
        } else {
            head = movedNode;
        }
        movedNode.setPrev(insertNode.getPrev());
        movedNode.setNext(insertNode);
        insertNode.setPrev(movedNode);
        
        }
        
    }
   
    //Private method for generating a new node used for creating new nodes
    private void newNode(){
        newNode = new Node();
        newNode.setSong(likedSongs.peek());
    }

    @Override
    public String toString() {
        return "GeneralPlaylists{" + "likedSongs=" + likedSongs + '}';
    }
    
    
    
}
