public class Main {
    public static void main(String[] args) {
        Room jamesFarmer140 = new Room();

        jamesFarmer140.setRoomNum(140);
        jamesFarmer140.setBuildingName("James Farmer");
        jamesFarmer140.setSeatingCap(30);

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
    }
}
