package Chapter_18;
import java.math.BigInteger;
// Fig. 18.3: FactorialCalculator.java
// Recursive factorial method.

public class FactorialCalculation {
    // recursive method factorial (assumes its parameter is >= 0)
    public static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) // test for base case
            return BigInteger.ONE; // base cases: 0! = 1 and 1! = 1
        else // recursion step
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    // output factorials for value 0-21
    public static void main(String[] args) {

        // calculate the factorials of 0 through 21
        for (int counter = 0; counter <= 21; counter ++) 
            System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
    }
} // enc class FactorialCalculator
