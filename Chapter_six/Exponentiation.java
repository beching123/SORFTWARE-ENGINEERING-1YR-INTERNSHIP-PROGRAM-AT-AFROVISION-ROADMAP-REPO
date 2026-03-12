// exercise 6.14 exponentiation
import java.util.Scanner;

public class Exponentiation {
  public static void main(String[] args)  {

    Scanner input = new Scanner(System.in);
    float number;
    int exponent;

    System.out.print("Enter a base: ");
    number = input.nextFloat();
    System.out.print("Enter an exponent: ");
    exponent = input.nextInt();

    System.out.printf("%n The result: %f", integerPower(number, exponent));

  }

  public static double integerPower(float number, int exponent){

    double result = 1.0;

    for (int i = 1; i <= exponent; i ++)
      result *= number;

    return result;
  }
}
