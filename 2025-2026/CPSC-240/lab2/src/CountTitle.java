import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class that helps count the # of occurences of the title in a songs lyrics.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class CountTitle {
    /**
     * The main method of CountTitle
     *
     * @param args optional arguments (unused in this method)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();

        Song song1 = new Song(file1);
        Song song2 = new Song(file2);

        File outputFile = new File("songOutput.txt");
        try {
            PrintWriter output = new PrintWriter(outputFile);

            output.write(song1.getTitle() + ": " + countTitle(song1));
            output.write("\n");
            output.write(song2.getTitle() + ": " + countTitle(song2));

            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Counts the number of occurences of a title in a given songs lyrics, not considering case. The
     * "number of occurences" does NOT include the title itself.
     *
     * @param song A song object that has both a title and lyrics
     * @return The number of occurences of a title in the inputted songs lyrics
     */
    public static int countTitle(Song song) {
        int occurences = 0;
        for (String lyric : song.getLyrics()) {
            if (lyric.toLowerCase().contains(song.getTitle().toLowerCase())) {
                occurences++;
            }
        }

        return occurences;
    }
}
