// Exercise 6.16 Multiple
import java.util.Scanner;

public class Multiple {
  
  public static boolean isMultiple(int a, int b) {
    
    if (b % a == 0)
      return true;

    return false;

  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    
    int a, b;

    while (true) {
      System.out.print("Enter a: ");
      a = input.nextInt();

      System.out.print("Enter b: ");
      b = input.nextInt();

      System.out.printf("%d is %s of %d%n", b, (isMultiple(a, b)) ? "a multiple": "not a multiple", a);
    }
  }
}
