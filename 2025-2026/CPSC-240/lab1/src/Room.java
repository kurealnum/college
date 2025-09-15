/**
 * Describes a college classroom.
 *
 * @author Oscar Gaske
 */
public class Room {
    /** The maximum number of people a given classroom can sit */
    private int seatingCap;

    /** The name of the building where the class takes place */
    private String buildingName;

    /** The number of the room */
    private int roomNum;

    /* Default constructor */
    public Room() {
        this.seatingCap = -1;
        this.buildingName = "None";
        this.roomNum = -1;
    }

    /**
     * Non-default constructor
     *
     * @param seatingCap the maximum number of people a given classroom can sit
     * @param buildingName the name of the building where the class takes place
     * @param roomNum the number of the room
     * @throws IllegalArgumentException thrown if newSeatingCap is less than 0
     */
    public Room(int seatingCap, String buildingName, int roomNum) throws IllegalArgumentException {
        if (seatingCap < 0) {
            throw new IllegalArgumentException("Seating cap cannot be less than 0");
        }

        this.seatingCap = seatingCap;
        this.buildingName = buildingName;
        this.roomNum = roomNum;
    }

    /**
     * Returns the current seating cap.
     *
     * @returns seatingCap the maximum number of people a given classroom can sit
     */
    public int getSeatingCap() {
        return this.seatingCap;
    }

    /**
     * Sets the seating cap. Throws an exception if the value to set is less than 0.
     *
     * @param newSeatingCap the new maximum number of people a given classroom can sit
     * @throws IllegalArgumentException thrown if newSeatingCap is less than 0
     */
    public void setSeatingCap(int newSeatingCap) throws IllegalArgumentException {
        if (newSeatingCap < 0) {
            throw new IllegalArgumentException("Seating cap cannot be less than 0");
        }
        this.seatingCap = newSeatingCap;
    }

    /**
     * Returns the current building name.
     *
     * @returns buildingName the current building name
     */
    public String getBuildingName() {
        return this.buildingName;
    }

    /**
     * Sets the building name.
     *
     * @param newBuildingName the new building name
     */
    public void setBuildingName(String newBuildingName) {
        this.buildingName = newBuildingName;
    }

    /**
     * Returns the room number.
     *
     * @return roomNum the current room number
     */
    public int getRoomNum() {
        return this.roomNum;
    }

    /**
     * Sets the room number
     *
     * @param newRoomNum the new room number
     */
    public void setRoomNum(int newRoomNum) {
        this.roomNum = newRoomNum;
    }
}
