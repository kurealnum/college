import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a text-based tour at UMW.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class TourUMW {
    /**
     * The main method
     *
     * @param args Arguments for the main program
     */
    public static void main(String[] args) {
        try {
            TourStatus tourStatus = TourStatus.getInstance();
            Scanner scanner = tourStatus.getInputScanner();
            System.out.println("Please enter a file name to parse");
            String filename = scanner.nextLine();

            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            TourUMW tour = new TourUMW();
            Campus campus = tour.setUpCampus(fileScanner);

            // If something went wrong when parsing the file. `setUpCampus()` does not throw an
            // exception as specified in the UML diagram
            if (campus.getCampusName().equals(null)) {
                scanner.close();
                return;
            }

            tourStatus.setCampus(campus);
            tourStatus.setCurrentLocation(campus.getLocation("Double Drive"));

            // Ask initial question to user
            Location currentLocation = tourStatus.getCurrentLocation();
            System.out.println(currentLocation.describeLocation());
            UserInputCommand input;

            while (true) {
                System.out.println(
                        "Press p to pick up an item if there is an item(s).\n"
                                + "Press b to view your backpack.\n"
                                + "Press d to drop an item at a location.");
                System.out.println("Choose one of the options above, or enter q to quit");
                String strInput = scanner.nextLine();
                if (strInput.equals("q")) {
                    break;
                }

                input = tour.parseInput(strInput);
                System.out.println(input.carryOut());
            }

            scanner.close();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * A function for parsing a users input.
     *
     * @param input The raw input from the user as a string
     * @return The resulting command after parsing
     */
    public UserInputCommand parseInput(String input) {
        TourStatus cur = TourStatus.getInstance();
        Location curLocation = cur.getCurrentLocation();

        if (input.equals("p")) {
            Scanner tmpScanner = cur.getInputScanner();
            System.out.println("What item would you like to pick up?");
            String itemName = tmpScanner.nextLine();
            return new PickupCommand(itemName);
        } else if (input.equals("b")) {
            return new BackpackCommand();
        } else if (input.equals("d")) {
            Scanner tmpScanner = cur.getInputScanner();
            System.out.println("What item would you like to drop from your backpack?");
            String itemName = tmpScanner.nextLine();
            return new DropCommand(itemName);
        } else if (curLocation.getDirections().indexOf(input) != -1) {
            return new MovementCommand(input);
        } else {
            return new InvalidCommand(input);
        }
    }

    /**
     * Reads a .txt file containing the information about a given campus.
     *
     * @param scanner A scanner used to read the campus file
     * @return The newly created Campus object
     */
    public Campus setUpCampus(Scanner scanner) {
        final String primaryDelimeter = "*****";
        final String separator = "+++";

        String campusName = scanner.nextLine();
        Campus campus = new Campus(campusName);
        TourStatus tourStatus = TourStatus.getInstance();

        // Delimeters
        scanner.nextLine(); // *****
        scanner.nextLine(); // Locations:

        // Locations
        String parsed = "";

        // This is probably not the best way to do this, but it's the most optimal ATM
        while (true) {
            String name = scanner.nextLine();

            // if name == *****
            if (name.equals(primaryDelimeter)) {
                break;
            }

            String description = scanner.nextLine();
            String tmp = description;

            // Get the rest of the description
            while (true) {
                String tmpDescription = scanner.nextLine();

                if (tmpDescription.equals(separator)) {
                    break;
                }

                description += " " + tmpDescription;
                tmp = tmpDescription;
            }

            Location newLocation = new Location(name, description);
            campus.addLocation(newLocation);
        }

        // Delimeter
        scanner.nextLine(); // *****

        // Doors
        parsed = "";

        while (!parsed.equals(primaryDelimeter)) {
            String leavingLocationString = scanner.nextLine();

            // if leavingLocationString == *****
            if (leavingLocationString.equals(primaryDelimeter)) {
                break;
            }

            String direction = scanner.nextLine();
            String enteringLocationString = scanner.nextLine();

            Location leavingLocation = campus.getLocation(leavingLocationString);
            Location enteringLocation = campus.getLocation(enteringLocationString);

            Door door = new Door(direction, leavingLocation, enteringLocation);

            // Assign doors to each location
            leavingLocation.addDoor(door);

            // Separator
            scanner.nextLine(); // +++
        }

        Location doubleDrive = campus.getLocation("Double Drive");
        campus.setStartingLocation(doubleDrive);

        // Delimeters
        scanner.nextLine(); // Items:

        while (true) {
            String itemName = scanner.nextLine();

            if (itemName.equals("*****")) {
                break;
            }

            String locationName = scanner.nextLine();
            String itemMessage = scanner.nextLine();

            Item item = new Item(itemName, itemMessage);
            Location itemLocation = campus.getLocation(locationName);

            itemLocation.addItem(item);

            // Delimeter
            scanner.nextLine(); // +++
        }

        return campus;
    }
}
