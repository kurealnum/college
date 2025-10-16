import java.util.ArrayList;
import java.util.Scanner;

public class TestAcademicRoom {
    public static void main(String[] args) {
        ArrayList<AcademicRoom> academicRooms = new ArrayList<AcademicRoom>();

        AcademicRoom jf26 = new AcademicRoom(25, "James Farmer", 26, "CPSC", true);
        AcademicRoom c1 = new AcademicRoom(30, "Combs", 1, "LING", true);
        AcademicRoom jf150 = new AcademicRoom(32, "James Farmer", 150, "MATH", false);

        academicRooms.add(jf26);
        academicRooms.add(c1);
        academicRooms.add(jf150);

        Scanner stdinScanner = new Scanner(System.in);

        String input = "";

        while (!input.equals("q")) {
            System.out.println(
                    "Would you like to add a room (a), search for a room (s), or quit (q)?");
            input = stdinScanner.nextLine();

            if (input.equals("q")) {
                break;
            } else if (input.equals("a")) {
                System.out.print("Enter room capacity: ");
                int capacity = stdinScanner.nextInt();
                stdinScanner.nextLine();

                System.out.print("Enter building name: ");
                String buildingName = stdinScanner.nextLine();

                System.out.print("Enter room number: ");
                int roomNum = stdinScanner.nextInt();
                stdinScanner.nextLine();

                System.out.print("Enter department: ");
                String department = stdinScanner.nextLine();

                System.out.print("Does the room have a projector? (true/false): ");
                boolean hasProjector = stdinScanner.nextBoolean();
                stdinScanner.nextLine();

                AcademicRoom newRoom =
                        new AcademicRoom(capacity, buildingName, roomNum, department, hasProjector);

                boolean foundDuplicateRoom = false;

                for (AcademicRoom a : academicRooms) {
                    if (a.getRoomNum() == roomNum) {
                        System.out.println("Found duplicate room -- not adding room.");
                        foundDuplicateRoom = true;
                    }
                }

                if (!foundDuplicateRoom) {
                    System.out.println("Added room");
                    academicRooms.add(newRoom);
                }

            } else if (input.equals("s")) {
                System.out.print("Enter building name: ");
                String buildingName = stdinScanner.nextLine();

                System.out.print("Enter room number (or press Enter to list all rooms): ");
                String roomNumberInput = stdinScanner.nextLine();

                boolean roomNumberProvided = !roomNumberInput.isEmpty();
                int roomNumber = 0;
                if (roomNumberProvided) {
                    try {
                        roomNumber = Integer.parseInt(roomNumberInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid room number. Please enter a number.");
                        return;
                    }
                }

                boolean found = false;

                for (AcademicRoom room : academicRooms) {
                    if (room.getBuildingName().equalsIgnoreCase(buildingName)) {
                        if (!roomNumberProvided || room.getRoomNum() == roomNumber) {
                            found = true;
                            System.out.println("Building: " + room.getBuildingName());
                            System.out.println("Room Number: " + room.getRoomNum());
                            System.out.println("Capacity: " + room.getSeatingCap());
                            System.out.println("Department: " + room.getAcademicDepartment());
                            System.out.println("Has Projector: " + room.doesContainProjector());
                        }
                    }
                }

                if (!found) {
                    System.out.println("No matching rooms found.");
                }
            } else {
                System.out.println("Unrecognized command -- please try again");
            }
        }
    }
}
