// Exercise 7.16 using enhanced for statement 
import java.util.Scanner;

public class ParseDouble {

  public static void main(String[] args) {

    double sum = 0;
    
    for (int number = 0; number < args.length; number ++) {
      sum += Double.parseDouble(args[number]);
    }

    System.out.printf("%f", sum);
  }
}