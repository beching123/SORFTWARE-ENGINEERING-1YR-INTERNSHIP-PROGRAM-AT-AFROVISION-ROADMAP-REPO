// exercise 6.23 find the minimum
import java.util.Scanner;

public class FindTheMinimum {
  
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    float n1, n2, n3;

    System.out.print("Enter 3 floating point number separated by space: ");
    n1 = input.nextFloat();
    n2 = input.nextFloat();
    n3 = input.nextFloat();

    System.out.printf("The minimum value is: %f", findMIn(Math.min(n1, n2), n3)); 
  }

  public static float findMIn( float n1, float n2) {

    if (n1 < n2)
      return n1;
    return n2;
    
  } 

}
