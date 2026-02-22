// Exercise 4.35 Side of a triangle
import java.util.Scanner;

public class TriangularEquality {
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


    if (((sideA + sideB) > sideC) && ((sideA + sideC) > sideB) &&((sideC + sideB) > sideA))
      System.out.println("\nCorrect! Sides could form a triangle.");
    else System.out.println("\nWrong! Sides cannot form a triangle.");
  }
}
