public class Room {
    private int seatingCap;
    private String buildingName;
    private int roomNum;

    public Room() {
        this.seatingCap = -1;
        this.buildingName = "None";
        this.roomNum = -1;
    }

    public Room(int seatingCap, String buildingName, int roomNum) {
        this.seatingCap = seatingCap;
        this.buildingName = buildingName;
        this.roomNum = roomNum;
    }

    public int getSeatingCap() {
        return this.seatingCap;
    }

    public void setSeatingCap(int newSeatingCap) {
        this.seatingCap = newSeatingCap;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public void setBuildingName(String newBuildingName) {
        this.buildingName = newBuildingName;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public void setRoomNum(int newRoomNum) {
        this.roomNum = newRoomNum;
    }
}
