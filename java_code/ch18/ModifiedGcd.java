// ModifiedGcd.java exercise 18.11
package Chapter_18;
//Modifying exercise 6.28 GCD
import java.util.Scanner;

public class ModifiedGcd {

    public static long gcd(long x, long y) {

        if (y == 0) // base case
            return x;
        // recursive step
        return gcd(y, x % y);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter numbers separated by space: ");

        long number = input.nextLong();
        long number2 = input.nextLong();

        System.out.printf("GCD of %d and %d: %d", number, number2, gcd(number, number2));
    }
}
