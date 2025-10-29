/**
 * Represents an invalid command entered by the user. This class is used when a command cannot be
 * recognized or executed.
 *
 * @author Oscar Gaske
 * @version 1.0.0
 */
public class InvalidCommand implements UserInputCommand {

    private String invalidCommand;

    /**
     * Creates a new invalid command with the provided input string.
     *
     * @param invalidCommand The invalid command string entered by the user
     */
    public InvalidCommand(String invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    /**
     * Carries out the invalid command response.
     *
     * @return A message informing the user that the command was not recognized
     */
    @Override
    public String carryOut() {
        return "Invalid command: \"" + invalidCommand + "\". Please try again.";
    }
}
