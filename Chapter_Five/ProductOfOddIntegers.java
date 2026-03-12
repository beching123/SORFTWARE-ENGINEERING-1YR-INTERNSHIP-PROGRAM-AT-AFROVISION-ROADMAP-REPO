// Exercises 5.12: Calculating the product of odd integers
import java.util.Scanner;

public class ProductOfOddIntegers {
  
  public static void main(String[] args){

    double product = 1;
    for (int i = 1; i <= 15; product *= i, i += 2);

    System.out.printf("Product of odd integers form 1 to 15: %f", product);
  }
}
