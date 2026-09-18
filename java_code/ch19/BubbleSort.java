// Chapter 19 exercise 19.5 BubbleSort.java
// a simple implementation of the bubble sort
package ch19;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSort {

    // main method which create and populates
    // our array and passes it to be sorted
    public static void main(String[] args) {

        // random variable which will be used to randomly populate our array
        // SecureRandom randomNumber = new SecureRandom();
        int[] data = { 1, 0, 3, 4, 5, 6, 7, 8, 9, 10 };

        // filling our array with random values
        /*
         * for (int i = 0; i < data.length; i++) {
         * 
         * data[i] = randomNumber.nextInt(100); // filling our array }
         */

        // printing out the original array
        System.out.print("\nOriginal Array: ");
        System.out.println(Arrays.toString(data));
        System.out.println();

        // sorting array
        System.out.print("Sorting The Array and showing the result of each iteration...");
        bubbleSort(data); // calling bubble sort to help sort the array
        System.out.print("\n\nSorted Array: " + Arrays.toString(data));
        System.out.println();
    }

    // our sorting method
    public static void bubbleSort(int[] data) {

        // value will hold current number in each sub loop
        int value;
        boolean wasSwapped = false;

        // next for loop used to sort the array
        for (int i = 0; i < data.length; i++) {

            value = 0; // always take the first element

            // inner loop that does the checking and the sorting
            for (int j = 1; j < data.length - i; j++) {

                if (data[value] > data[j]) {

                    swap(data, value, j);
                    wasSwapped = true;

                }

                value = j; // assigning value to the next index

            }

            // checking if no swap were made
            if (wasSwapped)
                wasSwapped = false;
            else
                break;

            // printing the current state
            printState(data, (data.length - 1) - i);

        }
    }

    // helper method to swap values in two elements
    private static void swap(int[] data, int value, int index) {
        int temporary = data[value]; // store first in temporary
        data[value] = data[index];// replace first with second
        data[index] = temporary; // put temporary in second
    }

    // Used to print out the current state of each array after each call
    public static void printState(int[] data, int index) {

        // printing a simple message
        System.out.print("\nCurrent state:  ");

        // printing the array
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%2d  ", data[i]);
        }
        System.out.print("\n\t      ");

        for (int i = 0; i < data.length; i++) {
            if (i >= index) {
                System.out.printf("  %-2s", "--");
            } else {
                System.out.printf("%-2s  ", "  ");
            }
        }

    }

}
