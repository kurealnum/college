/**
 * Represents a movement command entered by the user. This command moves the player in a specified
 * direction.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class MovementCommand implements UserInputCommand {

    private String dir;

    /**
     * Creates a new movement command with the given direction.
     *
     * @param dir The direction in which to move (e.g., "north", "south")
     */
    public MovementCommand(String dir) {
        this.dir = dir;
    }

    /**
     * Carries out the movement action.
     *
     * @return A message describing the result of the movement
     */
    @Override
    public String carryOut() {
        TourStatus cur = TourStatus.getInstance();

        cur.updateTourLocation(this.dir);
        Location newLocation = cur.getCurrentLocation();

        return newLocation.describeLocation();
    }
}
