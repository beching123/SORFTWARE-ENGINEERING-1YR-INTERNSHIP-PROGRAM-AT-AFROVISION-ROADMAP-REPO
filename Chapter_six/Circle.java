// Exercise 6.20 Area of a circle
import java.util.Scanner;


public class Circle {
  
  public static double Area(double radius) {

    return Math.PI * (radius * radius);

  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    double radius;

    System.out.print("Enter radius: ");
    radius = input.nextDouble();

    System.out.printf("The Area of the Circle is: %f", Area(radius));
  }
}
