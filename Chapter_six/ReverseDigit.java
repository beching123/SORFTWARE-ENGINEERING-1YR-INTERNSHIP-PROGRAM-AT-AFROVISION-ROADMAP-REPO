// Exercise 6.26; reversing digits
import java.util.Scanner;

public class ReverseDigit {
  
  public static void reverseDigit(String number) {

    for (int i = number.length() - 1; i >= 0; i--) {

      System.out.printf(" %s", number.charAt(i));
    }
  }
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      System.out.print("Enter number: ");
      String number = input.nextLine();

      reverseDigit(number);
    }
  }
