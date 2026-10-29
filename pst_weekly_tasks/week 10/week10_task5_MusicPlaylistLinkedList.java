import java.util.*;

public class week10_task5_MusicPlaylistLinkedList {
    private LinkedList<String> playlist = new LinkedList<>();

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added: " + song);
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed: " + song);
        } else {
            System.out.println("Song not found: " + song);
        }
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + playlist);
    }

    public static void main(String[] args) {
        week10_task5_MusicPlaylistLinkedList player = new week10_task5_MusicPlaylistLinkedList();
        player.addSong("Shape of You");
        player.addSong("Blinding Lights");
        player.addSong("Believer");

        player.displayPlaylist();

        player.removeSong("Blinding Lights");
        player.displayPlaylist();
    }
}
