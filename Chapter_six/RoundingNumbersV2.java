// Exercise 6.9 rounding Numbers entered by user
import java.util.Scanner;



public class RoundingNumbersV2 {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    double number;
    double newNumber;

    System.out.print("Enter a decimal number: ");
    number = input.nextDouble();

    System.out.printf("Old Number: %f", number);
    System.out.println();
    System.out.printf("\tNumber rounded to nearest Integer: %d%n", roundToInteger(number));
    System.out.printf("\tNumber rounded to the nearest Tenths: %f%n", roundToTenths(number));
    System.out.printf("\tNumber rounded to the nearest Hundredths: %f%n", roundToHundredths(number));
    System.out.printf("\tNumber rounded to the nearest thousandths: %f", roundToThousandths(number));
  }

  public static long roundToInteger(double number) {
    return (long)Math.floor(number + 0.5);
  }

  public static double roundToTenths(double number) {
    return Math.floor( number * 10 + 0.5 ) / 10;
  }

  public static double roundToHundredths(double number) {
    return Math.floor( number * 100 + 0.5 ) / 100;
  }

  public static double roundToThousandths(double number) {
    return Math.floor( number * 1000 + 0.5 ) / 1000;
  }
}

