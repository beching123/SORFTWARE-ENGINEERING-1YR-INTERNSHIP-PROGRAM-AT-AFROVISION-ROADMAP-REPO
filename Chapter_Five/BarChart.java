// Exercise: 5.16
import java.util.Scanner;

public class BarChart {
  
  public static void main(String[] args){
    
    Scanner input = new Scanner(System.in);
    int i = 1;

    int number1;

    System.out.printf("Enter number %d: ", i ++);
    number1 = input.nextInt();

    int number2;

    System.out.printf("Enter number %d: ", i ++);
    number2 = input.nextInt();

    int number3;

    System.out.printf("Enter number %d: ", i ++);
    number3 = input.nextInt();

    int number4;

    System.out.printf("Enter number %d: ", i ++);
    number4 = input.nextInt();

    int number5;

    System.out.printf("Enter number %d: ", i ++);
    number5 = input.nextInt();

    for (int j = 0; j < number1; j ++){
      System.out.print('*');
    }
    System.out.println();

    for (int j = 0; j < number2; j ++){
      System.out.print('*');
    }
    System.out.println();

    for (int j = 0; j < number3; j ++){
      System.out.print('*');
    }
    System.out.println();

    for (int j = 0; j < number4; j ++){
      System.out.print('*');
    }


    for (int j = 0; j < number5; j ++){
      System.out.print('*');
    }
    System.out.println();

  }
}

