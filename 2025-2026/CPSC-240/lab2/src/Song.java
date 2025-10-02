import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a song in a .txt file, with a delimeter of "*****" between the title and the lyrics.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class Song {
    /** The title of the song */
    private String title;

    /** The lyrics of the song, where each element is a singular line */
    private ArrayList<String> lyrics;

    /**
     * Creates a new song object given a file path to the .txt file containing that song.
     *
     * <p>The file should be structured as such:
     *
     * <p>title
     *
     * <p>*****
     *
     * <p>lyrics (...)
     *
     * @param path The filepath that the song (.txt file) is located at
     * @return The instantiated Song object
     */
    public Song(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            ArrayList<String> lyrics = new ArrayList<String>();

            String title = scanner.nextLine();

            // Delimeter
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String lyric = scanner.nextLine();

                if (lyric.length() == 0) {
                    continue;
                }

                lyrics.add(lyric);
            }

            scanner.close();

            this.title = title;
            this.lyrics = lyrics;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Gets the lyrics of the song
     *
     * @return The lyrics of a given song
     */
    public ArrayList<String> getLyrics() {
        return this.lyrics;
    }

    /**
     * Gets the title of the song
     *
     * @return The title of a given song
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the song
     *
     * @param title The new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the lyrics of the song
     *
     * @param lyrics The lyrics of the song
     */
    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }
}
