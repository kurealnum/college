/**
 * The "top" class in this program
 *
 * @author Oscar Gaske
 */
public class Main {
    /**
     * The main function
     *
     * @param args optional command line arguments
     */
    public static void main(String[] args) {
        Room jamesFarmer140 = new Room();

        jamesFarmer140.setRoomNum(140);
        jamesFarmer140.setBuildingName("James Farmer");
        try {
            jamesFarmer140.setSeatingCap(30);
        } catch (Exception e) {
            System.out.println("Seating cap cannot be negative. Error: " + e);
        }

        try {
            Room univerityCenter200 = new Room(30, "University Center", 200);

            if (univerityCenter200.getRoomNum() != 200) {
                System.out.println("Something went wrong with getRoomNum");
            } else {
                System.out.println("getRoomNum works!");
            }

            if (univerityCenter200.getSeatingCap() != 30) {
                System.out.println("Something went wrong with getRoomNum");
            } else {
                System.out.println("getSeatingCap works!");
            }

            if (!univerityCenter200.getBuildingName().equals("University Center")) {
                System.out.println("Something went wrong with getRoomNum");
            } else {
                System.out.println("getBuildingName works!");
            }
        } catch (Exception e) {
            System.out.println("Seating cap cannot be negative. Error: " + e);
        }
    }
}
