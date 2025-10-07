import java.util.ArrayList;

/**
 * Represents a location on a college campus.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class Location {
    /** The name of the location */
    private String name;

    /** The description of the location */
    private String description;

    /** If the user has visited this location, this is true. If the user has not, this is false. */
    private boolean haveVisited;

    /** A list of doors accessible from this location. */
    private ArrayList<Door> doors;

    /**
     * The default constructor. Sets everything to null, except for haveVisited and doors, which
     * this constructor sets to false and an empty ArrayList respectively.
     */
    public Location() {
        this.name = null;
        this.description = null;
        this.haveVisited = false;
        this.doors = new ArrayList<>();
    }

    /**
     * A constructor for Location. Sets doors to an empty ArrayList, and haveVisited to false.
     *
     * @param name The name of the location
     * @param description The description of the location
     */
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.haveVisited = false;
        this.doors = new ArrayList<>();
    }

    /**
     * Gets the name of the location
     *
     * @return The name of the location
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the description of the location
     *
     * @return The description of the location
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns true if the user has visited this location, and false if they haven't.
     *
     * @return If the user has visited this location.
     */
    public boolean getHaveVisited() {
        return this.haveVisited;
    }

    /**
     * Sets the name of the location
     *
     * @param name The new name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description for the location.
     *
     * @param description The new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets if the user has visited this location.
     *
     * @param haveVisited A boolean representing if the user has visited this location.
     */
    public void setHaveVisited(boolean haveVisited) {
        this.haveVisited = haveVisited;
    }

    /**
     * Returns the location that the door in the inputted direction leads to, if that doors exists.
     * If that door does not exist, it returns an initialized Location object with all fields set to
     * null.
     *
     * @param direction The direction to travel
     * @return The location that the user would "travel" to
     */
    public Location leaveLocation(String direction) {
        for (Door door : doors) {
            if (door.getDirection().equals(direction)) {
                return door.getEntering();
            }
        }
        return new Location(null, null);
    }

    /**
     * Gets a list of possible directions to take from a location based off of the doors leading
     * away from that location.
     *
     * @return An ArrayList of the possible directions to take.
     */
    public ArrayList<String> getDirections() {
        ArrayList<String> res = new ArrayList<String>();

        for (Door door : this.doors) {
            res.add(door.getDirection());
        }

        return res;
    }

    /**
     * Describes the current door with every doors .describe() method
     *
     * @return The .describe() method of every door at this location, separated with a newline.
     */
    public String describeDoors() {
        String res = "";

        for (Door door : this.doors) {
            res += door.describe() + "\n";
        }

        return res;
    }

    /**
     * Adds a door to all of the possible doors that lead away from this location.
     *
     * @param door The new door
     */
    public void addDoor(Door door) {
        doors.add(door);
    }
}
