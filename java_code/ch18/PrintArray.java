package Chapter_18;

public class PrintArray {
    
    public static void printArray (int array[], int index) {

        if (index < 0) 
            return;

        printArray(array, index - 1);
        System.out.print(array[index] + " ");
    }

    public static int recursiveMinimum(int array[], int currentMin, int index) {
        
        if (index > array.length - 1) {
            return currentMin;
        }

        if (array[index] <= currentMin) {
            currentMin = array[index];
        }

        return recursiveMinimum(array, currentMin, index + 1);

    }

    public static void main(String[] args) {

        int array[] =  {1, 2 , 3, 4 , 5 , 6, 7 , 8 , 9 , 0};
        printArray(array, array.length - 1);System.out.println(); System.out.println();

        System.out.println(recursiveMinimum(array,array[0] , 0));
    }
}
