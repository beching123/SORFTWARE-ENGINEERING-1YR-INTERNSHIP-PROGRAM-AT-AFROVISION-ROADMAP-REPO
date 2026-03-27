// Exercise 7.15 modification of command line values
import java.util.Scanner;

public class InitializeArray {

  public static void main(String[] args) {

    // declare variable array and initialize it with an array object
    int[] array;

    if (args.length != 0)
      array = new int[Integer.parseInt(args[0])];
    else 
      array = new int[10];

    System.out.printf("%s%8s%n", "Index", "Value");

    for (int counter = 0; counter < array.length; counter ++)
      System.out.printf("%5d%8d%n", counter, array[counter]);
  }
}