// Fig. 19.2: LinearSearchTest.java
// Sequentially searching an array for an item.
package Chapter_19;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveLinearSearch {

    // perform a linear search on the data
    public static int linearSearch(int data[], int searchKey, int startingIndex) {

        // base case but returns the index if found or -1
        if (startingIndex == data.length - 1) {
            if (data[startingIndex] == searchKey)
                return startingIndex;
            else
                return -1;
        }

        if (data[startingIndex] == searchKey)
            return startingIndex;

        if (startingIndex >= data.length)
            return -1;
        else
            return linearSearch(data, searchKey, ++ startingIndex);

    } // end methods linearSearch

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SecureRandom randomNumber = new SecureRandom();

        int[] data = new int[10]; // create array

        for (int i = 0; i < data.length; i++) {
            data[i] = 10 + randomNumber.nextInt(90); // populate array
        }

        System.out.printf("%s%n%n", Arrays.toString(data)); // display array

        // get input from user
        System.out.print("Please enter an integer value (-1 to quit): ");
        int searchInt = input.nextInt();

        // repeatedly input an integer; -1 terminates the program
        while (searchInt != -1) {

            int position = linearSearch(data, searchInt, 0);

            if (position == -1) // not found
                System.out.printf("%d was not found%n", searchInt);
            else // found
                System.out.printf("%d was found in position %d%n%n", searchInt, position);

            // get input from user
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }
    } // end main
} // end class LinearSearchTest
