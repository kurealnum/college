import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void readInstitutions(
            String filename, ArrayList<Researcher> list, String delimeter) {
        try {
            File inputFile = new File(filename);
            Scanner reader = new Scanner(inputFile);

            while (reader.hasNextLine()) {
                String institution = reader.nextLine();

                String nextLine = reader.nextLine();

                while (!nextLine.equals(delimeter)) {
                    // Find student
                    for (Researcher r : list) {
                        if (r.getName().equals(nextLine)) {
                            r.setInstitution(institution);
                        }
                    }
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ArrayList<Researcher> list = new ArrayList<Researcher>();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the information of two researchers");

        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter a name for a researcher");
            String name = myScanner.nextLine();

            System.out.println("Please enter the years of XP for the researcher");
            int yoe = myScanner.nextInt();

            // consume current line
            myScanner.nextLine();

            System.out.println("Has the researcher done significant work? (true or false)");
            boolean dsw = myScanner.nextBoolean();

            System.out.println("Has the researcher made a breakthrough?");
            boolean mbt = myScanner.nextBoolean();

            Researcher r = new Researcher(name, yoe, dsw, mbt);

            list.add(r);
        }

        myScanner.close();

        for (Researcher person : list) {
            System.out.println(person.getName());
        }

        // or

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}
