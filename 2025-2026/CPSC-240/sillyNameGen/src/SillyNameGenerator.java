import java.util.ArrayList;
import java.util.Scanner;

public class SillyNameGenerator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Integer> vowelCounts = new ArrayList<Integer>();

        System.out.println("Do you want to enter a person's information? If no, type 'quit'.");
        String response = myScanner.nextLine();

        while (!response.equalsIgnoreCase("quit")) {
            System.out.println("What is this person's first name?");
            String firstName = myScanner.nextLine();

            System.out.println("What is this person's last name?");
            String lastName = myScanner.nextLine();

            System.out.println("What is this person's favorite color?");
            String favColor = myScanner.nextLine();

            System.out.println("What street does this person live on?");
            String streetName = myScanner.nextLine();

            Person newPerson = new Person(firstName, lastName, favColor, streetName);
            people.add(newPerson);
            vowelCounts.add(newPerson.calculateNumVowels());

            System.out.println(
                    "Do you want to enter another person's information? If no, type 'quit'");
            response = myScanner.nextLine();
        }

        for (Person person : people) {
            System.out.println(person.createSillyName());
        }

        myScanner.close();
    }
}
