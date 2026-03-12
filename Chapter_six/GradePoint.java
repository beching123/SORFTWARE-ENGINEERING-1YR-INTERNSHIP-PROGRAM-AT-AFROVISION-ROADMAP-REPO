// exercise 6.28
import java.util.Scanner;

public class GradePoint {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Enter Grade: ");
    float grade = input.nextFloat();

    qualityPoints(grade);
  }

  public static void qualityPoints(float grade) {

    if (grade <= 100 && grade >= 90)
      System.out.print("Equality Grade: 4");
    else if (grade <= 89 && grade > 80)
      System.out.print("Equality Grade: 3");
    else if (grade <= 79 && grade > 79)
      System.out.print("Equality Grade: 2");
    else if (grade <= 69 && grade >= 60)
      System.out.print("Equality Grade: 1");
    else 
      System.out.print("Equality Grade: 0");
  }
}