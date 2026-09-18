// Exercise 5.11: finding the smallest value in a list of several integers
import java.util.Scanner;

public class FinTheSmallestValue {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int number;
    int userInput, smallest;

    System.out.print("Enter the number of integers which wil be entered: ");
    number = input.nextInt();

    System.out.printf("%nEnter integer %d: ", 1);
    userInput = input.nextInt();
    smallest = userInput;

    for (int i = 1; i < number; i ++) {

      System.out.printf("Enter integer %d: ", i + 1);
      userInput = input.nextInt();

      if (smallest > userInput)
        smallest = userInput;
    }
    System.out.printf("The smallest in the list is %d", smallest);
  }
}
