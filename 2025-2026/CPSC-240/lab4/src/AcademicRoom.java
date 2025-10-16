/**
 * Describes a room containing an academic event
 *
 * @author Oscar Gaske
 */
public class AcademicRoom extends Room {
    /** The academic department that this room is managed by */
    private String academicDepartment;

    /** Does this room contain a projector? */
    private Boolean containsProjector;

    public AcademicRoom(
            int seatingCap,
            String buildingName,
            int roomNum,
            String academicDepartment,
            Boolean containsProjector) {
        super(seatingCap, buildingName, roomNum);
        this.academicDepartment = academicDepartment;
        this.containsProjector = containsProjector;
    }

    /**
     * Returns the academic department that this room is managed by
     *
     * @return the current academic department
     */
    public String getAcademicDepartment() {
        return this.academicDepartment;
    }

    /**
     * Sets the current academic department
     *
     * @param newAcademicDepartment the new academic department
     */
    public void setAcademicDepartment(String newAcademicDepartment) {
        this.academicDepartment = newAcademicDepartment;
    }

    /**
     * Returns true if this room contains a projector and false if it doesn't.
     *
     * @return if this room has a projector
     */
    public Boolean doesContainProjector() {
        return this.containsProjector;
    }

    /**
     * Sets if this room contains a projector
     *
     * @param containsProjector the new value for containsProjector -- a boolean
     */
    public void setContainsProjector(Boolean containsProjector) {
        this.containsProjector = containsProjector;
    }
}
