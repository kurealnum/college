/**
 * This class represents a researcher object
 *
 * @author Dr. Zeitz
 */
public class Researcher {
    private String name;
    private String institution;
    private int yearsExp;
    private boolean doesSignificantWork;
    private boolean makesBreakThrough;

    /** Default constructor for objects */
    public Researcher() {
        this.doesSignificantWork = false;
        makesBreakThrough = false;
    }

    /** Non-default constructor for objects */
    public Researcher(String n, int y, boolean dsw, boolean mbt) {
        this.name = n;
        this.yearsExp = y;
        this.doesSignificantWork = dsw;
        this.makesBreakThrough = mbt;
    }

    public String getName() {
        return this.name;
    }

    public int getYearsExperience() {
        return this.yearsExp;
    }

    public boolean getDoesSignificantWork() {
        return this.doesSignificantWork;
    }

    public boolean getMakesBreakThrough() {
        return this.makesBreakThrough;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setYearsExperience(int y) {
        this.yearsExp = y;
    }

    public void setDoesSignificantWork(boolean dsw) {
        this.doesSignificantWork = dsw;
    }

    public void setMakesBreakThrough(boolean mbt) {
        this.makesBreakThrough = mbt;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * This method determines whether a researcher is a candidate for the Nobel prize. A researcher
     * has to have done significant work and made a break through to be a candidate.
     *
     * @return whether the researcher is a candidate
     */
    public boolean isACandidate() {
        return getDoesSignificantWork() && getMakesBreakThrough();
    }
}
