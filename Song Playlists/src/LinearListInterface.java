/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nykytamcdonald
 */

//Interfce for Double Link List
public interface LinearListInterface {
    
    public Song get(int index);
    public String remove(int index);
    public void add(int index);
    public void add();
    public void move(int songIndex, int moveIndex);
    
}
