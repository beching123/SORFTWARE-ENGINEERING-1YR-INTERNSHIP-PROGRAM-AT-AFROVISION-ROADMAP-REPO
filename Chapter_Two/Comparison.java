package Chapter_Two;

// Fig. 2.15 Comparison.java
 // Compare integers using if statements, relational operators and equality operators

import java.util.Scanner; //program uses class Scanner

public class Comparison
{
  //main method begins execution of java application
  public static void main (String[] args)
  {
    //create a Scannner to obtain input from command line
    Scanner input =  new Scanner (System.in);

    int number1; // first number
    int number2; // second number

    System.out.print("Enter first integer: "); // prompt
    number1 = input.nextInt(); //read the first number from the user
    
    System.out.print("Enter second integer: "); //prompt
    number2 = input.nextInt(); //  read the second number from the user

    if (number1 == number2)
      System.out.printf("%d == %d%n", number1, number2);

    if (number1 != number2)
      System.out.printf("%d != %d%n", number1,number2);

    if (number1 < number2)
      System.out.printf("%d < %d%n", number1, number2);

    if (number1 > number2)
      System.out.printf("%d > %d%n", number1, number2);

    if (number1 <= number2)
      System.out.printf("%d <= %d%n", number1, number2);

    if (number1 >= number2)
      System.out.printf("%d >= %d%n", number1, number2);
  }//end method main
}//end class Comparison