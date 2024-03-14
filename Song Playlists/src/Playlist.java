
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author nykytamcdonald
 */
public abstract class Playlist {
    
    abstract String searchSong(Song song);
    abstract String printPlaylist();
    abstract int size();
    abstract boolean isEmpty();
    abstract String repeat(boolean answer);
    abstract void move(int songIndex, int moveIndex);
}
