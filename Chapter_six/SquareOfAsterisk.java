// Exercise 6.18
import java .util.Scanner;

public class SquareOfAsterisk {
  
  public static void displayAsterisk(int size, char c) {

    for (int i = 1; i <= size; i ++){
      for (int j = 1; j <= size; j ++){
        System.out.print(c);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int size;
    char c;

    
    System.out.print("Enter your character: ");
    c = input.next().charAt(0);

    System.out.print("Enter size: ");
    size = input.nextInt();


    System.out.println();

    displayAsterisk(size,c);
  }
}
