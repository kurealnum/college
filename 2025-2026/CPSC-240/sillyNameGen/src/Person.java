public class Person {
    private String origFirstName;
    private String origLastName;
    private String color;
    private String street;

    // Both of these variables are updated when Person is initialized
    private static int minVowels = Integer.MAX_VALUE;
    // The current person with the least number of vowels in their name
    private static Person legendaryPerson;

    public Person(String firstName, String lastName, String favColor, String streetName) {
        this.origFirstName = firstName;
        this.origLastName = lastName;
        this.color = favColor;
        this.street = streetName;

        int numVowels = this.calculateNumVowels();

        if (numVowels < Person.minVowels) {
            Person.minVowels = numVowels;
            Person.legendaryPerson = this;
        }
    }

    public String createSillyName() {
        int firstNameIndex = this.origFirstName.length() - 3;

        String newFirstName =
                this.origFirstName.substring(firstNameIndex, firstNameIndex + 1).toUpperCase()
                        + this.origFirstName.substring(firstNameIndex + 1).toLowerCase();
        String newLastName = this.origLastName.substring(0, 3).toLowerCase();
        String sillyFirstName = newFirstName + newLastName;

        String newColor =
                this.color.substring(0, 1).toUpperCase() + this.color.substring(1, 2).toLowerCase();
        String newStreet = this.street.substring(0, 3).toLowerCase();
        String sillyLastName = newColor + newStreet;

        String sillyName = sillyFirstName + " " + sillyLastName;

        // If this person has the least number of vowels in their name...
        if (this == Person.legendaryPerson) {
            return createTheLegendaryName(sillyName);
        }

        return sillyName;
    }

    public String createTheLegendaryName(String sillyName) {
        return sillyName + " the Legendary";
    }

    public int calculateNumVowels() {
        String name = this.origFirstName + this.origLastName;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int numVowels = 0;

        for (char c : name.toCharArray()) {
            for (char v : vowels) {
                if (c == v) {
                    numVowels++;
                }
            }
        }

        return numVowels;
    }
}
