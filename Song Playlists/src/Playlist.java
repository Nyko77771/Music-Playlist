
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author nykytamcdonald
 */
public abstract class Playlist {
    
    private List<Song> playlist;
    
    public Playlist(){
        playlist = new ArrayList<Song>();
    }
    
    abstract Song addSong();
    abstract String removeSong();
    abstract String searchSong();
    abstract String printPlaylist();
    abstract int size();
    abstract boolean isEmpty();
    
}
