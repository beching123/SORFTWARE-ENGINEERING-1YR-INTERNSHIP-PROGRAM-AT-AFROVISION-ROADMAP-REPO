// Exercise 2.24

import java.util.Scanner; // importing the Scanner class to make use of its objects to read values from the user

public class ChapterTwoExerciseFour { // main class
  public static void main (String[] args) { // main method that start the execution of our program

    Scanner input = new Scanner(System.in);

    int number1, number2, number3, number4, number5; // integers variable to hold the users values which will be inputed

    System.out.print("Enter first number: "); // prompting user for input
    number1 = input.nextInt(); // accepting and storing the input

    System.out.print("Enter second number: "); // prompting user for input
    number2 = input.nextInt(); // accepting and storing the input

    System.out.print("Enter third number: "); // promptssing user for input
    number3 = input.nextInt(); // accepting and storing the input
    
    System.out.print("Enter fourth number: "); // prompting user for input
    number4 = input.nextInt(); // accepting and storing the input
    
    System.out.print("Enter fifth number: "); // prompting user for input
    number5 = input.nextInt(); // accepting and storing the input
    
    if ( number1 >= number2 && number1 > number3 && number1 > number4 && number1 > number5)
      System.out.printf("%d is the largest number int the list\n", number1);

    if (number1 <= number2 && number1 < number3 && number1 < number4 && number1 < number5)
      System.out.printf("%d is the smallest number int the list\n", number1);

    if (number2 < number1 && number2 >= number3 && number2 >= number4 && number2 >= number5)
      System.out.printf("%d is the largest int the list\n", number2);

    if (number2 < number1 && number2 <= number3 && number2 <= number4 && number2 <= number5)
      System.out.printf("%d is the smallest number in the list\n", number2);

    if (number3 >= number5 && number3 >= number4 && number3 > number2 && number3 > number1)
      System.out.printf("%d is the lagest in the list\n", number3);
    
    if (number3 <= number5 && number3 <= number4 && number3 < number2 && number3 < number1 )
      System.out.printf("%d is the smallest in the list\n", number3);

    if (number4 >= number5 && number4 > number3 && number4 > number2 && number4 > number1)
      System.out.printf("%d is the largest number in the list\n", number4);

    if (number4 <= number5 && number4 < number3 && number4 < number2 && number4 < number1)
      System.out.printf("%d is the smallest in the list\n", number4);

    if (number5 > number4 && number5 > number3 && number5 > number2 && number5 > number1)
      System.out.printf("%d is the largest number in the list\n", number5);

    if (number5 < number4 && number5 < number3 && number5 < number2 && number5 < number1)
      System.out.printf("%d is the largest in the list\n", number5);

    if (number1 == number2 && number2 == number3 && number3 == number4 && number4 == number5)
      System.out.print("The five numbers are equal\n");

  }
}
