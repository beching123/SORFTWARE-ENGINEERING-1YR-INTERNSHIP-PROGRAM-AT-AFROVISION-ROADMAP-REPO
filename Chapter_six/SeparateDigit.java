// exercise 6.21 separating digits
import java.util.Scanner;

public class SeparateDigit {

  public static void displayDigit(int digit) {
    int remainder;
    String newDigit = "";
    int counter = 0;

    while (digit != 0) {

      remainder = digit % 10;
      digit /= 10;

      newDigit += remainder;
      counter ++;
    }

    for (int i = counter - 1; i >= 0; i --)
      System.out.printf("%c\t", newDigit.charAt(i));
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter you digit: ");
    int digit = input.nextInt();

    displayDigit(digit);
  }
}
