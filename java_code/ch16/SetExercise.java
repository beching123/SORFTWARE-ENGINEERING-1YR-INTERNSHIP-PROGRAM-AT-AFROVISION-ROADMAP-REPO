package Chapter_sixteen;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class SetExercise {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Set<String> names = new HashSet<>();

        System.out.printf("Enter your first name or (quit to continue): %n");

        while (true) {

            String name = input.next();
            if (name.equalsIgnoreCase("quit"))
                break;
            names.add(name);
        }

        System.out.printf("Names %s: ", names);

        System.out.println("Enter a name to search for (type 'quit' to quit");

        while (true) {
            String searchName = input.next();
            if (searchName.equalsIgnoreCase("quit"))
                break;
            System.out.println(names.contains(searchName) ? "Found!": "Not found. ");

        }

        input.close();
    }
}
