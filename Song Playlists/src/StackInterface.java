

/**
 *
 * @author nykytamcdonald
 */
public interface StackInterface {
    
    public boolean isEmpty();
    public boolean isFull();
    public void push(Song song);
    public Song pop();
    public int size();
    
}
