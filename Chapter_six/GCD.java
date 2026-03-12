// exercise 6.28 GCD
import java.util.Scanner;

public class GCD {
  
  public static long gcd(long number, long number2) {

    while (number2 != 0 && number != 0) {

      if (number > number2)
        number -= number2;
      else 
        number2 -= number;
    }

    return (number == 0)? number2: number;
  }

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter numbers separated by space: ");

    long number = input.nextLong();
    long number2 = input.nextLong();

    System.out.printf("GCD of %d and %d: %d", number, number2, gcd(number, number2));
  }
}
