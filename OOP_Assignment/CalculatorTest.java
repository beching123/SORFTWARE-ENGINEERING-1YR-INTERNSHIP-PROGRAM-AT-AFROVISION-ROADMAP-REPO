// OOP Assignment, class to test my calculator class
// CalculatorTest.java
import java.util.Scanner;

public class CalculatorTest {

  // main method which called method lunchCalculator which implements our calculator
  public static void main(String[] args) {

    // calling method to run calculator
    lunchCalculator();

  }

  // used to make my code clean as all of the functionalities which were to be done in the 
  // main method were put here
  public static void lunchCalculator () {

        // input object used to collect user input from keyboard
    Scanner input = new Scanner(System.in);
    Calculator myCalculator; // calculator object created from calculator class
    
    System.out.println();
    System.out.println("Simple Calculator\n");

    // prompting the user to enter number one and two
    System.out.print("Enter Number 1: ");
    double numberOne = input.nextDouble();
    System.out.print("Enter Number 2: ");
    double numberTwo = input.nextDouble();

    // initializing myCalculator object with the number entered by the user
    myCalculator = new Calculator(numberOne, numberTwo);

    // calling the menu method to print out the various operation our calculator can perform
    myCalculator.menu();
    
    // collecting user input
    int choice = input.nextInt();

    double result = myCalculator.performOperation(choice);

    System.out.printf("%n%nResult: %,.2f", result );

    boolean keepRunning = true; // used to check if the user wants to continue running the application
    while (keepRunning) { 

      // prompting the user to enter the current choice 
      System.out.print("\n\nEnter 1 to do another Operation or 0 to stop: ");
      int runState = input.nextInt();

      // stop the loop once user enter anything apart from one
      if (runState != 1)
        keepRunning = false;

      // allow user to lunchCalculator multiple times
      lunchCalculator();
    }

    // closing the scanner variable
    input.close();
  }
}
