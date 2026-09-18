package Chapter_19;

// Fig. 19.6: MergeSortTest.java
// Sorting an array with merge sort.
import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSortTest {

    // calls recursive split method to begin merge sorting
    public static void mergeSort(int[] data) {
        sortArray(data, 0, data.length - 1); // sort enire array
    } // end method sort

    // splits array, sorts subarrays and merge subarrays into sorted array
    private static void sortArray(int[] data, int low, int high) {

        // test base case; size of array equals 1
        if ((high - low) >= 1) // if not base case
        {
            int middle1 = (low + high) / 2; // calculate middle of array
            int middle2 = middle1 + 1; // calculate next element over

            // output split step
            System.out.printf("split:   %s%n%n", subarrayString(data, low, high));
            System.out.printf("\t->%s%n", subarrayString(data, low, middle1));
            System.out.printf("\t->%s%n%n", subarrayString(data, middle2, high));

            // split array in half; sort each half (recursive calls)
            sortArray(data, low, middle1); // first half of array
            sortArray(data, middle2, high); // second half of array

            // merge two sorted arrays afrt split calls return
            merge(data, low, middle1, middle2, high);
        } // end if
    } // end method sortArray

    // merge two sorted subarray into one sorted subarray
    private static void merge(int[] data, int left, int middle1, int middle2, int right) {

        int leftIndex = left; // index into left subarray
        int rightIndex = middle2; // index into right subarray
        int combinedIndex = left;
        int[] combined = new int[data.length]; // working array

        // output two subarrays before mergin
        // System.out.print("\n[-------------------------------this is
        // it-------------------------------------\n");
        System.out.printf("merge:  %s%n", subarrayString(data, left, middle1));
        System.out.printf("         %s%n", subarrayString(data, middle2, right));
        // System.out.print("\n-------------------------------this is
        // it-------------------------------------]\n");

        // merge arrays until reaching end of either
        System.out.printf("%n=====->leftIndex: %d, middle1: %d, rightIndex: %d,right:%d, answer: %s%n", leftIndex,
                middle1, rightIndex, right, (leftIndex <= middle1 && rightIndex < right));
        while (leftIndex <= middle1 && rightIndex <= right) {
            // place smaller of two current elements into result
            // and move to next space in arrays
            if (data[leftIndex] <= data[rightIndex])
                combined[combinedIndex++] = data[leftIndex++];
            else
                combined[combinedIndex++] = data[rightIndex++];
        }

        // if left array is empty
        // System.out.print(
        // "\n=========================================== leftIndex: " + leftIndex + "
        // middle2: " + middle2 + " answer: " + (leftIndex == middle2));

        if (leftIndex == middle2) {
            // copy in rest of right array

            while (rightIndex <= right) {
                combined[combinedIndex++] = data[rightIndex++];

            }

        }

        else { // right array is empty

            // copy in rest of left array
            while (leftIndex <= middle1) {
                // System.out.printf("%n=================who brings the zero combined: %d OR
                // data: %d%n", combined[combinedIndex], data[leftIndex ] );
                combined[combinedIndex++] = data[leftIndex++];

            }

        }

        // copy values bck into original array
        for (int i = left; i <= right; i++) {

            data[i] = combined[i];

        }
        System.out.println(Arrays.toString(combined));

        // output merged array
        // System.out.print("\n=============================================");
        System.out.printf("        %s%n%n", subarrayString(data, left, right));
    } // end method merge

    // method to output certain values in array
    private static String subarrayString(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();

        // output spaces for alignment
        // for (int i = 0; i < low; i++) {
        // temporary.append(" ");
        // }
        // output elements left in array
        for (int i = low; i <= high; i++) {
            temporary.append(" " + data[i]);
        }
        return temporary.toString();
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        int[] data = { 10, 4, 5, 3, 7, 2, 8, 1, 9, 6 }; // create array

        // for (int i = 0; i < data.length; i++) // populate array
        // data[i] = 10 + generator.nextInt(90);

        System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data)); // display array
        mergeSort(data);

        System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data)); // display array
    }
} // end class MergeSortTest
