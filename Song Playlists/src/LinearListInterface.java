/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */
public interface LinearListInterface {
    
    public Song get(int index);
    public void remove(int index);
    public void add(Song song, int index);
    public void add(Song song);
    public void repeat();
    
}
