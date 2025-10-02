/**
 * Maintains the current status of a virtual UMW tour
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class TourStatus {
    /** The campus in question */
    private Campus campus;

    /** The current location of the visitor */
    private Location currentLocation;

    /**
     * Default constructor with no arguments. Initializes both campus and currentLocation to null.
     */
    public TourStatus() {
        this.campus = null;
        this.currentLocation = null;
    }

    /**
     * Sets the current campus
     *
     * @param campus The campus to set
     */
    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    /**
     * Sets the current location of the visitor
     *
     * @param currentLocation The new location to be set
     */
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Returns the current campus
     *
     * @return The new location to be set
     */
    public Campus getCampus() {
        return this.campus;
    }

    /**
     * Returns the current location of the visitor
     *
     * @return The current location
     */
    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    /**
     * Moves the virtual visitor to a new location through the Location class' leaveLocation method.
     *
     * <p>This fucntion does not handle validation of the direction.
     *
     * @param direction The direction to move a visitor towards.
     */
    public void updateTourLocation(String direction) {
        Location nextLocation = this.currentLocation.leaveLocation(direction);

        this.currentLocation = nextLocation;
    }
}
