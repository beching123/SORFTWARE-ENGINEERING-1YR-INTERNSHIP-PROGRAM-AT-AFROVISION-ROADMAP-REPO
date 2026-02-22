// Exercise 2.15

import java.util.Scanner;

public class ExerciseFour {
  
  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);

    int numberOne;
    int numberTwo;

    System.out.print("Enter the first number: ");
    
    numberOne = input.nextInt();

    System.out.print("Enter number two: ");

    numberTwo = input.nextInt();

    System.out.printf("The sum of %d  + %d  = %d%n", numberOne, numberTwo, numberOne + numberTwo);

    System.out.printf("The product of %d x %d = %d%n", numberOne, numberTwo, numberOne * numberTwo);

    System.out.printf("The difference between %d - %d = %d%n", numberOne, numberTwo, numberOne - numberTwo);

    System.out.printf(" The qoutient of %d / %d = %d%n", numberOne, numberTwo, numberOne / numberTwo);


    // Exercise 2.16 continue from here

    if (numberOne > numberTwo) 
      System.out.printf(" %d is larger%n", numberOne);
    if (numberTwo > numberOne)
      System.out.printf("%d is larger%n", numberTwo);
    if (numberOne == numberTwo)
      System.out.print("These numbers are equal\n");
    
    // Exercise 2.17 continue from here

    int numberThree;

    System.out.print("Enter the third number: ");
    numberThree = input.nextInt();

    System.out.printf("The sum of %d  + %d + %d = %d%n", numberOne, numberTwo, numberThree, numberOne + numberTwo + numberThree);

    System.out.printf("The average between the three number is %d%n", (numberOne + numberThree + numberTwo) / 3 );

    if (numberOne > numberTwo && numberOne > numberThree)
      System.out.printf("%d is the largest%n", numberOne);
    if (numberTwo > numberOne && numberTwo > numberThree)
      System.out.printf("%d is the largest%n", numberTwo);
    if (numberThree > numberOne && numberThree > numberTwo)
      System.out.printf("%d is the largest%n", numberThree);

    if (numberOne < numberTwo && numberOne  < numberThree)
      System.out.printf("%d is the smallest%n", numberOne);
    if (numberTwo < numberOne && numberTwo < numberThree)
      System.out.printf("%d is the smallest%n", numberTwo);
    if (numberThree < numberOne && numberThree < numberTwo)
      System.out.printf("%d is the smallest%n", numberThree);

    if (numberOne == numberTwo && numberTwo == numberThree)
      System.out.print("these numbers are equal");

  }
}
