// Calculating the hypotenuse
import java.util.Scanner; 

public class HypotenuseCalculation {
  
  public static double hypotenuse(double side1, double side2) {
    double hypotenuse;

    hypotenuse = Math.sqrt(Math.pow(side2, 2) + Math.pow(side1, 2));

    return hypotenuse;
  }

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    double side1;
    double side2;

    System.out.print("Enter side1: ");
    side1 = input.nextDouble();

    System.out.print("Enter side2: ");
    side2 = input.nextDouble();

    System.out.printf("The hypotenuse for %f and %f is %f", side1, side2, hypotenuse(side1, side2));
    System.out.printf("%nThe hypotenuse using Math.hypo is %f", Math.hypot(side1, side2));

  }
}
