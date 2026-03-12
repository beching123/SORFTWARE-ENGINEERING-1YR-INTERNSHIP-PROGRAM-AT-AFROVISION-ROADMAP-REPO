// Exercise 6.9 rounding Numbers entered by user
import java.util.Scanner;

public class RoundingNumbers {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    double number;
    double newNumber;

    System.out.print("Enter a decimal number: ");
    number = input.nextDouble();

    newNumber = Math.floor(number + 0.5);
    System.out.printf("Old number: %f%nNew number: %f", number, newNumber);
  }
}
