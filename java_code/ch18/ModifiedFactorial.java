// Fig. 18.3: ModifiedFactorial.java
// Recursive factorial method.
package Chapter_18;

public class ModifiedFactorial {
    
    // recursive method factorial (assumes its parameter is >= 0)
    public static int ITERATOR;
    public static double factorial(long number) {

        System.out.printf("local variable: %d\t|", number);

        if (number <= 1) { //  test for base case 
            System.out.printf("No recursive call%n");
            return 1; // base case: 0! = 1 and 1! = 1
        }
        else {// recursion step
            System.out.printf("recursive level %d call parameter: %d%n%n",++ModifiedFactorial.ITERATOR , number - 1);
            return number * factorial(number - 1);
        }
    }

    // output factorials for values 0-21
    public static void main(String[] args) {

        // calculae the factorial of 0 through 21
        for (int counter = 0; counter <= 21; counter ++) {
            ModifiedFactorial.ITERATOR = 0;

            System.out.printf("%n%n--> Output: %3d! = %.0f%n", counter, factorial(counter));
            System.out.printf("------------------------------------------------%n");
        }
    } 
}  //end class ModifiedFactorial
