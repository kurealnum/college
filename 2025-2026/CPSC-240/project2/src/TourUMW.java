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
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter a file name to parse");
            String filename = scanner.nextLine();

            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            TourUMW tour = new TourUMW();
            Campus campus = tour.setUpCampus(fileScanner);

            // If something went wrong when parsing the file. `setUpCampus()` does not throw an
            // exception as specified in the UML diagram
            if (campus.getCampusName().equals(null)) {
                return;
            }

            TourStatus tourStatus = new TourStatus();
            tourStatus.setCampus(campus);
            tourStatus.setCurrentLocation(campus.getLocation("Double Drive"));

            String input = tour.getAndSetLocation(tourStatus, scanner);

            while (!input.equals("q")) {
                input = tour.getAndSetLocation(tourStatus, scanner);
            }

            scanner.close();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Gets the inputted direction from the user and, if valid, sets the location.
     *
     * <p>An inputted direction is considered valid if and only if it is possible to travel in that
     * direction and if it is either n, s, w, e, or q.
     *
     * @param tourStatus A TourStatus object to get the current location of the tour
     * @param scanner A scanner used for getting input from the user
     * @return The users input
     */
    private String getAndSetLocation(TourStatus tourStatus, Scanner scanner) {
        Location currentLocation = tourStatus.getCurrentLocation();

        System.out.println("You are currently at " + currentLocation.getName() + ".");
        if (!currentLocation.getHaveVisited()) {
            System.out.println(currentLocation.getDescription());
            currentLocation.setHaveVisited(true);
        }
        System.out.println(currentLocation.describeDoors());
        System.out.println("Choose one of the options above, or enter q to quit");

        String input = scanner.nextLine();

        if (currentLocation.getDirections().indexOf(input) == -1 && !input.equals("q")) {
            System.out.println("That's not a valid command. Please try again.");
        } else {
            tourStatus.updateTourLocation(input);
        }

        return input;
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

        return campus;
    }
}
