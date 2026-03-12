// Exercise 6.17 Even Odd
import java.util.Scanner;

public class EvenOdd {
  
  public static boolean isEven(int a) {
    
    if (a % 2 == 0)
      return true;

    return false;

  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    
    int a;

    while (true) {
      System.out.print("Enter a: ");
      a = input.nextInt();

      System.out.printf("%d is %s%n", a, (isEven(a)) ? "even": "not even");
    }
  }
}
