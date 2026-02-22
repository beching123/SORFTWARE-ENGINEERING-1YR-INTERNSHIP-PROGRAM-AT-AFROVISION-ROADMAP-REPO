// Exercise 4.36 Factorial of a number n; integer to be precise.
import java.util.Scanner;

public class Factorial {
   
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int number;

    System.out.print("\nEnter a number: ");
    number = input.nextInt();
    int tempNumber = number;

    double fact = 1;
    while (tempNumber != 0){
      fact *= tempNumber --;
    }
    System.out.printf("%nThe factorial of %d is : %.2f%n%n", number, fact);
    
  }
}
