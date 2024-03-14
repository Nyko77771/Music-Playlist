/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */
public class Node {
    
    private Song song;
    private Node prev;
    private Node next;
    
    public Node(Song song, Node next, Node prev){
        this.song = song;
        this.next = next;
        this.prev = prev;
    }

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
