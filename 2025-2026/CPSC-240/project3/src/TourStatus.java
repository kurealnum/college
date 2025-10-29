import java.util.ArrayList;
import java.util.Scanner;

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

    /** Field for Singleton pattern */
    private static TourStatus tourInstance;

    /** A user's backpack full of Item(s) */
    private ArrayList<Item> backpack;

    private Scanner inputScanner;

    /**
     * Default constructor with no arguments. Initializes both campus and currentLocation to null.
     */
    private TourStatus() {
        this.campus = null;
        this.currentLocation = null;
        this.backpack = new ArrayList<>();
        this.inputScanner = new Scanner(System.in);
    }

    /**
     * Function for Singleton pattern
     *
     * @return the current tour status, if it exists.
     */
    public static synchronized TourStatus getInstance() {
        if (TourStatus.tourInstance == null) {
            TourStatus.tourInstance = new TourStatus();
            return TourStatus.tourInstance;
        }
        return TourStatus.tourInstance;
    }

    /**
     * Gets the current input scanner to use
     *
     * @return The input scanner currently in use
     */
    public Scanner getInputScanner() {
        return this.inputScanner;
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

    /**
     * Adds an item to a user's backpack.
     *
     * @param item The item to add to the user's backpack
     */
    public void addToBackpack(Item item) {
        this.backpack.add(item);
    }

    /**
     * Removes an item, by name, from the user's backpack.
     *
     * @param name The name of the item to remove.
     * @return The removed item
     */
    public Item dropItemFromBackpack(String name) {
        for (Item item : this.backpack) {
            if (item.getName().equals(name)) {
                this.backpack.remove(item);
                return item;
            }
        }
        return null;
    }

    /** */
    // public Item pickupItemFromLocation(String name) {
    //
    // }

    /**
     * Lists all of the items in a backpack.
     *
     * @return A string of all of the items in a backpack
     */
    public String listBackpackItems() {
        String res = "";
        for (Item item : this.backpack) {
            res = res + item.getName() + ", ";
        }
        return res;
    }
}
