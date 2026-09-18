package java_code.ch20;

// Fig. 20.3: GenericMethodTest.java
// Printing array elements using generic method printArray.

public class ModifiedGenericMethodTest {

    public static void main(String[] args) {

        // create arrays of Integer, Double and Character
        Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] cahracterArray = { 'H', 'E', 'L', 'L', 'O' };
        String[] stringArray = { "one", "two", "three", "four", "five", "six", "seven", "eight" };

        System.out.printf("Array integerArray contains: %n");
        printArray(integerArray); // pass an Integer array
        System.out.printf("%nArray doubleArray contains:%n");
        printArray(doubleArray); // pass a Double array
        System.out.printf("%nArray characterArray contains:%n");
        printArray(cahracterArray); // pass a Character array
        System.out.printf("%nArray stringArray contains:%n");
        printArray(stringArray); // using the string array

        // using the overloaded version of the printArray

        try {
            // pass an Integer array
            System.out.printf("%n%nArray integerArray contains: %n%s%n", printArray(integerArray, 0, 3));

            // pass a Double array
            System.out.printf("%nArray doubleArray contains:%n%s%n", printArray(doubleArray, 2, 4));

            // pass a Character array
            System.out.printf("%nArray characterArray contains:%n%s%n", printArray(cahracterArray, 1, 10));

        } catch (InvalidSubscriptException e) {

            e.printStackTrace();
        }
    }

    // generic method printArray
    public static <T> void printArray(T[] inputArray) {

        // display array element
        for (T element : inputArray)
            System.out.printf("%s ", element);
    }

    // overloaded generic method2
    public static <T> String printArray(T[] inputArray, int lowerSubscript, int higherSubscript) {

        if (lowerSubscript < 0 || higherSubscript > inputArray.length)
            throw new InvalidSubscriptException("Out of bound!");

        String value = "[";
        for (int i = lowerSubscript; i < higherSubscript; i++)
            value += inputArray[i] + ", ";

        value += inputArray[higherSubscript] + "]";

        return value;
    }

    // nongeneric method that overloads the generic method printArray
    public static void printArray(String[] data) {

        for (int i = 0; i < data.length; i++) {

            if (i % 4 == 0)
                System.out.println();
            System.out.printf("%-10s", data[i]);
        }

    }
} // end class GenericMethodTest
