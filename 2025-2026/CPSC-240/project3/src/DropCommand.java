/**
 * Represents a drop command entered by the user. This command drops an item from the user's
 * backpack into the current location.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class DropCommand implements UserInputCommand {

    private String itemName;

    /**
     * Creates a new drop command for the given item.
     *
     * @param itemName The name of the item to drop
     */
    public DropCommand(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Carries out the drop action.
     *
     * @return A message describing the result of dropping the item
     */
    @Override
    public String carryOut() {
        TourStatus cur = TourStatus.getInstance();
        Location curLocation = cur.getCurrentLocation();

        Item item = cur.dropItemFromBackpack(this.itemName);
        if (item == null) {
            return "This item does not exist.";
        }
        curLocation.addItem(item);

        return "You dropped the " + itemName + ".";
    }
}
