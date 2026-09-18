// Exercise 4.31 printing the decimal equivalence of a binary digit
import java.util.Scanner;

public class PrintingTheDecimalEquivalenceOfBinaryDigit {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int binaryDigit;

    System.out.print("Enter you Binary digit: ");
    binaryDigit = input.nextInt();

    int quotient;
    int remainder;
    int decimalDigit;
    int multiplier;

    multiplier = 1;
    decimalDigit = 0;
    quotient = binaryDigit;

    while (quotient != 0){

      remainder = quotient % 10;
      quotient /= 10;

      decimalDigit += multiplier * remainder;
      multiplier *= 2;
    }
    System.out.printf("Decimal equivalent of %d: %d", binaryDigit, decimalDigit);
  }
}
