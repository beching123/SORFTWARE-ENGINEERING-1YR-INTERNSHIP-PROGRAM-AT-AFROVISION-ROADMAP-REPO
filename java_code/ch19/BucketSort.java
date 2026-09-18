package Chapter_19;

import java.util.Arrays;
import java.security.SecureRandom;

public class BucketSort {

    // sorting the array
    public static void sort(int[] data) {

        // int our bucket array and our index
        int[][] bucket = new int[10][data.length];
        int index; // will be used for putting element to their corresponding bucket

        // beginning of distribution pass
        for (int i = 0; i < 3; i++) {
            System.out.println();

            for (int j = 0; j < data.length; j++) {

                index = repeatedDivision(data, j, i);
                placeValue(bucket, data, index, j); // distrobution pass

            }
            System.out.print("Pass: ");
            for (int k = 0; k < 10; k++)
                System.out.printf("%s", Arrays.toString(bucket[k]));
            System.out.println();
            copyToData(data, bucket); // gathering pass
            // System.out.print(Arrays.toString(data));
            System.out.print("New Data: " + Arrays.toString(data));
            System.out.println();
            System.out.println();

        } // end of distribution pass
    }

    // to help ease the divide and conquer stage
    public static int repeatedDivision(int[] data, int j, int repeat) {

        int k = 0;
        int number = data[j];
        int remainder = 0;
        while (k <= repeat) {

            remainder = number % 10;
            number /= 10;

            k++;
        }

        return remainder;
    }

    // helper function to place the number in the bucket
    public static void placeValue(int[][] bucket, int[] data, int row, int dataIndex) {

        for (int i = 0; i < data.length; i++) {

            if (bucket[row][i] == 0) {

                bucket[row][i] = data[dataIndex];
                break;
            } else
                continue;
        }

    }

    // gathering pass
    public static void copyToData(int[] data, int[][] bucket) {

        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < data.length; j++) {

                if ((counter < data.length) && bucket[i][j] != 0) {
                    data[counter++] = bucket[i][j];
                    bucket[i][j] = 0; // to delete the old element there
                }

            }
        }
    }

    // main method which create and populates
    // our array and passes it to be sorted
    public static void main(String[] args) {

        // random variable which will be used to randomly populate our array
        SecureRandom randomNumber = new SecureRandom();
        int[] data = new int[10];

        // filling our array with random values
        // one dimensional array of positive integer
        for (int i = 0; i < data.length; i++)
            data[i] = randomNumber.nextInt(100); // filling our array }

        // printing out the original array
        System.out.print("\nOriginal Array: ");
        System.out.println(Arrays.toString(data));
        System.out.println();

        // sorting array
        System.out.print("Sorting The Array and showing the result of each iteration...");
        sort(data); // calling bubble sort to help sort the array
        System.out.print("\n\nSorted Array: " + Arrays.toString(data));
        System.out.println();
    }
}
