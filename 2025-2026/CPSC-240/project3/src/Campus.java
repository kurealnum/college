import java.util.Hashtable;

/**
 * Represents a college campus.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class Campus {
    /** The name of the campus */
    private String campusName;

    /**
     * A hashmap with each key referring to the name of the location, and each value being a
     * Location object
     */
    private Hashtable<String, Location> locations;

    /** The location that the visitor starts at */
    private Location startingLocation;

    /** The file to read the campus information from */
    private String filename;

    /**
     * The default constructor. Sets everything to null, except for locations which this constructor
     * sets to an empty Hashtable
     */
    public Campus() {
        this.campusName = null;
        this.locations = new Hashtable<>();
    }

    /**
     * A constructor for a basic campus.
     *
     * @param campusName The name of the campus
     */
    public Campus(String campusName) {
        this.campusName = campusName;
        this.locations = new Hashtable<>();
    }

    /**
     * Adds a location to the locations hashmap.
     *
     * @param location A fully initialized location object
     */
    public void addLocation(Location location) {
        this.locations.put(location.getName(), location);
    }

    /**
     * Gets a location based off of the name of the location. Case sensitive.
     *
     * @param name The location name
     * @return The location requested
     */
    public Location getLocation(String name) {
        return locations.get(name);
    }

    /**
     * Sets the campus name
     *
     * @param campusName The new campus name
     */
    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    /**
     * Gets the campus name
     *
     * @return The current name of the campus
     */
    public String getCampusName() {
        return campusName;
    }

    /**
     * Sets the starting location for the campus
     *
     * @param startingLocation The new starting location
     */
    public void setStartingLocation(Location startingLocation) {
        this.startingLocation = startingLocation;
    }

    /**
     * Gets the current starting location
     *
     * @return The current starting location
     */
    public Location getStartingLocation() {
        return startingLocation;
    }

    /**
     * Sets the filename
     *
     * @param filename The new filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets the current filename
     *
     * @return The current filename
     */
    public String getFilename() {
        return this.filename;
    }
}
