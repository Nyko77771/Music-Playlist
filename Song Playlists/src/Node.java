/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */

//Is used by Double linked List to store songs and to link all the stored songs in memory together
public class Node {
    
    private Song song;//references a stored song
    private Node prev;//references the previos song node
    private Node next;//references the next song node
    
    public Node(Song song, Node next, Node prev){
        this.song = song;
        this.next = next;
        this.prev = prev;
    }
    
    //Made this constructor in order to create empty nodes that can be filled by setters and getters.
    public Node(){
        this(null,null,null);
    }
    
    //Setters and getters for pointers and song
    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Song getSong() {
        return song;
    }

    protected void setSong(Song song) {
        this.song = song;
    }

    protected void setPrev(Node prev) {
        this.prev = prev;
    }

    protected void setNext(Node next) {
        this.next = next;
    }  
    
}
