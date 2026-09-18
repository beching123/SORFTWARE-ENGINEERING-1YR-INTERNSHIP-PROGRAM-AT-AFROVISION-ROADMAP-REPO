// Exercise 4.30 palindromes
import java.util.Scanner;

public class Palindromes {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int digit;
    System.out.printf("\nEnter a five digit integer: ");
    digit = input.nextInt();

    int counter;
    int remainder;
    int quotient;
    int flag = 0;

    int tempDigit = digit;

    counter = 0;

    int i = 0;
    while (tempDigit != 0){
      
      tempDigit /= 10;
      remainder = tempDigit % 10;
      counter ++;
    }

    tempDigit = digit;

    if (counter > 5 || counter < 5){
      System.out.println("\nError! Enter a 5 digit number.\n");
      return;
    }
    else {
      remainder = digit % 10;
      quotient = digit / 10000;

      if (remainder == quotient)
        flag = 1;
      else 
        flag = 0;
      
      digit /= 10;
      digit %= 1000;

      remainder = digit % 10;
      quotient = digit / 100;

      if (remainder == quotient && flag == 1){
        flag = 1;
      }
      else 
        flag = 0;
      
    }

    if (flag == 1)
      System.out.printf("%n%d is Palindrome%n%n", tempDigit);
    else 
      System.out.printf("%n%d is  not Palindrome%n%n", tempDigit);
  }
}
