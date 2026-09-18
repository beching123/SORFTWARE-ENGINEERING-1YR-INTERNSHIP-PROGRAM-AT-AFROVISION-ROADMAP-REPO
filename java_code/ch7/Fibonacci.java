// exercise 7.29 fibonacci
import java.util.Scanner;

public class Fibonacci {
  
  public static int fibonacci(int n) {

    int previous_1 = 0;    
    int previous_2 = 1;

    int fib = 0;

    for (int i = 2; i <= n; i ++) {
       
      fib = previous_1 + previous_2;

      previous_1 = previous_2;
      previous_2 = fib;
    }

    return fib;
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter a Number: ");
    int number = input.nextInt();

    System.out.printf("The fib of %d: %d", number, fibonacci(number));
  }
}
