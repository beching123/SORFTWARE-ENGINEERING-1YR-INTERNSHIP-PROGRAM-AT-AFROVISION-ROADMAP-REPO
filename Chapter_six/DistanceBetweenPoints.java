// Exercise 6.33 Distance between points
import java.util.Scanner;

public class DistanceBetweenPoints {

  private double x1;
  private double y1;
  private double x2;
  private double y2;
  private double distance;


  public void setPoints (double x1, double y1, double x2, double y2) {

    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;

  } 

  public double getDistance () {

    distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

    return distance;

  }

  public static void main(String[] args) {

    double[] points = new double[4];
    Scanner input = new Scanner(System.in);
    DistanceBetweenPoints distance = new DistanceBetweenPoints();

    for (int i = 1, counter = 0; i <= 2; i ++) {

      System.out.printf("Enter x%d and y%d (separated by space): ", i, i);

      points[counter ++] = input.nextDouble();
      points[counter ++] = input.nextDouble();

    }

    int index = 0;
    distance.setPoints(points[index ++], points[index ++], points[index ++], points[index]);

    System.out.printf("\n The distance: %.2f", distance.getDistance());

  }
}