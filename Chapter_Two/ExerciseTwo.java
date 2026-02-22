// Exercise 2 from the text book
// This program will be used to calculate the product of three integers entered by the user

import java.util.Scanner;

public class ExerciseTwo {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in); // the variable input will be used to accept keyboard input from the user

    int x; // variable to hold the first number
    int y; // variable to hold the second number
    int z; // variable to hold the third number

    System.out.print("Enter the first integer: "); // prompting the user to enter the first integer

    x = input.nextInt(); // reading or accepting the value entered by the user

    System.out.print("Enter the second integer: "); //prompting the user to enter the second integer

    y = input.nextInt();// reading or accepting the value from the user

    System.out.print("Enter the third integer: "); // prompting the user to enter the third integer
    z = input.nextInt(); // reading the number entered by the user

    int result = x * y * z; // multiplying the three numbers and storing the result in result variable of type int

    System.out.printf("Product is: %d", result);

  }
}
