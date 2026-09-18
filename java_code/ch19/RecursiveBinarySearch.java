package Chapter_19;

// Fig. 19.3: BinarySearchTest.java
// Use binary search to locate an item in an array
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearch {

    // perform a binary search on the data
    public static int binarySearch(int[] data, int key, int startingIndex, int endingIndex) {

        // base case
        if (startingIndex == endingIndex) {
            if (data[startingIndex] == key)
                return startingIndex;
            else
                return -1;
        }

        int middle = (startingIndex + endingIndex + 1) / 2; // middle element
        
        // recursive steps below
        // first case
        if (data[middle] == key)
            return middle;
        
        //second step
        if (data[middle] < key)
            return binarySearch(data, key, middle + 1, endingIndex);
        else return binarySearch(data, key, startingIndex, middle - 1);

    } // end method binarySearch

    // method to output certain values in array
    private static String remainingElement(int[] data, int low, int high) {

        StringBuilder temporary = new StringBuilder();

        // append spaces for alignment
        for (int i = 0; i < low; i++) {
            temporary.append("   ");
        }

        // append elements left in array
        for (int i = low; i <= high; i++)
            temporary.append(data[i] + " ");

        return String.format("%s%n", temporary);
    } // end method remainingElements

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        int[] data = new int[15]; // create array

        for (int i = 0; i < data.length; i++) // populate array
            data[i] = 10 + generator.nextInt(90);

        Arrays.sort(data); // binarySearch requires sorted array
        System.out.printf("%s%n%n", Arrays.toString(data)); // display array

        // get input from user
        System.out.print("Please enter an integer value (-1 to quite): ");
        int searchInt = input.nextInt();

        // repeately input integer; -1 terminates the program
        while (searchInt != -1) {

            // perform search
            int location = binarySearch(data, searchInt, 0, data.length - 1);

            if (location == -1) // not found
                System.out.printf("%d was not found%n%n", searchInt);

            else // found
                System.out.printf("%d was found in position %d%n%n", searchInt, location);

            // get input from user
            System.out.printf("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }

        input.close();
    } // end main
} // end class BinarySearch
