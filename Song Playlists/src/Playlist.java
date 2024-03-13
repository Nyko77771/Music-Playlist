
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author nykytamcdonald
 */
public abstract class Playlist {
    
    abstract Song addSong(Object item);
    abstract Song removeSong();
    abstract String searchSong(Object item);
    abstract String printPlaylist();
    abstract int size();
    abstract boolean isEmpty();
    
}
