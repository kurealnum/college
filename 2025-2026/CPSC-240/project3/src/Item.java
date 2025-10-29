/**
 * An item in a users backpack.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class Item {
    /** The name of the given item. */
    private String name;

    /** ??? */
    private String message;

    /** Default constructor, initializes both name and message to null. */
    public Item() {
        this.name = "";
        this.message = "";
    }

    /** Constructor with parameters for all fields. */
    public Item(String name, String message) {
        this.name = name;
        this.message = message;
    }

    /**
     * Gets the name.
     *
     * @return The current name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the message.
     *
     * @return The current message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the name.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the message.
     *
     * @param message The message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
