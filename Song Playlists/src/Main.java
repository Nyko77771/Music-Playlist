

/**
 *
 * @author nykytamcdonald
 */
public class Main {
    
    public static void main(String[] args) {
        
    LikedSongPlaylists likedPlaylist = new LikedSongPlaylists();
    
    Song song1 = new Song("Don't Worry Be Happy");
    Song song2 = new Song("Imagine");
    Song song3 = new Song("Thriller");
    Song song4 = new Song("Somebody that I used to know");
    
    likedPlaylist.push(song4);
    likedPlaylist.push(song3);
    likedPlaylist.push(song2);
    likedPlaylist.push(song1);

    
    }
    
}
