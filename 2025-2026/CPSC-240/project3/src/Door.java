/**
 * Represents a virtual "path" between two locations in a virtual UMW tutor.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class Door {
    /** The direction that this door takes you */
    private String direction;

    /** The location from which the user is leaving */
    private Location leavingLocation;

    /** The location to where the user is going */
    private Location enteringLocation;

    /** The default constructor. Initializes everything to null. */
    public Door() {
        this.direction = null;
        this.leavingLocation = null;
        this.enteringLocation = null;
    }

    /**
     * A basic constructor that initializes all fields of a Door object
     *
     * @param direction The direction that this door takes you
     * @param leavingLocation The location from which the user is leaving
     * @param enteringLocation The location to where the user is going
     */
    public Door(String direction, Location leavingLocation, Location enteringLocation) {
        this.direction = direction;
        this.leavingLocation = leavingLocation;
        this.enteringLocation = enteringLocation;
    }

    /**
     * Describes the door
     *
     * @return The description of the door.
     */
    public String describe() {
        return "You can go " + this.direction + " to get to " + this.enteringLocation.getName();
    }

    /**
     * Gets the current leaving location
     *
     * @return The current leaving location
     */
    public Location getLeaving() {
        return this.leavingLocation;
    }

    /**
     * Gets the current entering location
     *
     * @return The current entering location
     */
    public Location getEntering() {
        return this.enteringLocation;
    }

    /**
     * Gets the current direction of the door
     *
     * @return The current direction of the door
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * Sets the leaving location of the door.
     *
     * @param leavingLocation The new leaving location
     */
    public void setLeaving(Location leavingLocation) {
        this.leavingLocation = leavingLocation;
    }

    /**
     * Sets the entering location of the door.
     *
     * @param enteringLocation The new entering location
     */
    public void setEntering(Location enteringLocation) {
        this.enteringLocation = enteringLocation;
    }

    /**
     * Sets the direction of the door
     *
     * @param direction The the new direction of the door
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
