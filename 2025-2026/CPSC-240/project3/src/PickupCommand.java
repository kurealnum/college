/**
 * Represents a pickup command entered by the user. This command attempts to pick up an item from
 * the current location.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class PickupCommand implements UserInputCommand {

    private String itemName;

    /**
     * Creates a new pickup command for the given item.
     *
     * @param itemName The name of the item to pick up
     */
    public PickupCommand(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Carries out the pickup action.
     *
     * @return A message describing the result of the pickup
     */
    @Override
    public String carryOut() {
        TourStatus cur = TourStatus.getInstance();
        Location curLocation = cur.getCurrentLocation();

        Item item = curLocation.getItemNamed(this.itemName);
        if (item == null) {
            return "This item does not exist.";
        }
        cur.addToBackpack(item);
        curLocation.removeItem(item);

        return "You picked up the " + itemName + ".";
    }
}
