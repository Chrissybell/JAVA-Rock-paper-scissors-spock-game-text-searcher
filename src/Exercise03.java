import java.io.File;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Exercise03 {
    public static void main(String[] args) throws FileNotFoundException {
        search_name();
    }

    // searches for name based on user input
    public static void search_name() throws FileNotFoundException {
        String name;
        String gender;
        int count = 0;
        int population;
        double percentage_of_population;

        Scanner enter_name = new Scanner(System.in);
        System.out.print("Choose a name to search for: ");
        name = enter_name.nextLine();
        Scanner enter_gender = new Scanner(System.in);
        System.out.print("Choose a gender to search for: ");
        gender = enter_gender.nextLine();

        double sum = 0.0;
        // loops through based on years. It should move on to the txt file with the associated year.
        for (int year = 1880; year <= 1880; year++) {
            String file_name = "yob" + year + ".txt";
            Scanner sc = new Scanner(new FileReader(file_name));

            // loops based on if there is a line that it can read
            while (sc.hasNextLine())  {
                Scanner line_scanner = new Scanner(sc.nextLine());
                line_scanner.useDelimiter(",");
                String temp_name = line_scanner.next();
                String temp_gender = line_scanner.next();
                population = line_scanner.nextInt();
                sum = sum + population;

                // now this should evaluate whether the name inputted is in the line. I use Alice and F for my tests
                if (sc.hasNextLine() && sc.hasNextLine()) {
                    if (sc.nextLine().contains(name) && sc.nextLine().contains(gender)) {
                        //System.out.println(temp_name + " " + temp_gender + " " + population);
                        count = count + 1;
                        System.out.println("I found " + name);
                    }
                }
                //if not then it should just print that the name wasn't found
                else {
                    System.out.println(name + ":" + "Name not found");
                }
            }
            percentage_of_population = (count / sum) * 100;
            System.out.println("Total population count for " + year + " is " + sum);
            System.out.println("I found " + name + " " + count + " Times");
            System.out.printf("Percentage of people with the name %s in year %s is %f%n", name, year, percentage_of_population);
        }
    }
}
