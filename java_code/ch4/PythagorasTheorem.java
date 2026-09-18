// Exercise 4.36 Side of a triangle
import java.util.Scanner;

public class PythagorasTheorem {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    double sideA;
    double sideB;
    double sideC;

    System.out.print("Enter side a: ");
    sideA = input.nextDouble();
    System.out.print("Enter side b: ");
    sideB = input.nextDouble();
    System.out.print("Enter side c: ");
    sideC = input.nextDouble();


    if ((sideA <= sideB && sideB <= sideC) && ((sideA * sideA) + (sideB * sideB) == (sideC * sideC)))
      System.out.println("\nCorrect! Sides could form a right triangle.");
    else System.out.println("\nWrong! Sides cannot form a right triangle.");
  }
}
