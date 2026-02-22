// Exercise 4.29 Hollow square
import java.util.Scanner;

public class SquareOfAsterisk {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    System.out.print("Enter the size of your square(1 to 20): ");
    int size = input.nextInt();

    if(size < 1 || size > 20){
      System.out.print("Invalid size. Kindly rerun the application and input a valid size");
      return;
    }
    int row = 1;
    while (row <= size){
      
      int column = 1;
      if (row == 1 || row == size){
        while (column <= size){
          System.out.print("* ");
          column ++;
        }
      }

      else {
        while (column <= size){
          if (column == 1 || column == size)
            System.out.print("* ");
          else 
            System.out.print("  ");
          column ++;
        }
      }
      row ++;
      System.out.println();
    }

  }
}