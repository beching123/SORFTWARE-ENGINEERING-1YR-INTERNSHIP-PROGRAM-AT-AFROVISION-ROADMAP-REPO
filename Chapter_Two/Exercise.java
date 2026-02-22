

// Exercises from chapter 2

import java.util.Scanner;

public class Exercise 
{
  public static void main (String[] args)
  {
    int c;
    int thisIsAVariable;
    int q76354;
    int number;
    int value;

    Scanner input = new Scanner(System.in); // creating a new variable of type Scanner which will be used to read input from user
    System.out.print("Enter a value: "); // prompt the user to enter a number integer
    value = input.nextInt(); // Takes or reads input from the user

    System.out.println("This is java program");
    System.out.printf("%s%n%s", "This is java", "program");
     
    if (value != 7)
      System.out.printf("Variable number (%d) is not equal to 7", value);

  }
}
