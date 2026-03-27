// exercise 7.13 Variable length Argument List
import java.util.Scanner;

public class VariableLength {

  public static void main(String[] args) {

    long products = product(1,3,4,5,6,7,7,8,9,0,1,2,3,4,4,4,4,4,5,5,6,6,7,7,8);

    System.out.printf("%d", products);
    
  }

  public static long product(int... numbers) {
    long prod;
    prod = 1;

    for (int number: numbers)
      prod *= number;

    return prod;
  }

}