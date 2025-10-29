/**
 * Represents a command to view or interact with the backpack. This command typically displays the
 * contents of the user's backpack.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class BackpackCommand implements UserInputCommand {

    /** Creates a new backpack command. */
    public BackpackCommand() {}

    /**
     * Carries out the backpack action.
     *
     * @return A message describing the result of opening or viewing the backpack
     */
    @Override
    public String carryOut() {
        TourStatus cur = TourStatus.getInstance();

        return cur.listBackpackItems();
    }
}
