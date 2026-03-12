
// Exercise 5.25 modification of exercise 5.24
import java.util.Scanner;

public class ModifiedDiamond {
  
  public static void main(String[] args) {
    int j;
    int i;
    int k;
    int l;

    Scanner input = new Scanner(System.in);
    int size = input.nextInt();

    for ( i =1; i <= size; i++)
    {

        for (l =i; l <= size + 2 - 1; l++)
        {
            System.out.print(" ");
        }

        for (j=1; j < i; j++)
        {
            System.out.print("*");
        }
        for (k = j; k > 0; k-- )
        {
            System.out.print("*");
        }
        System.out.println();
    }
        for ( i =  size - 1; i >= 1; i--)
    {

        for (l = i; l <= size + 2 - 1; l++)
        {
            System.out.print(" ");
        }

        for (j= 1; j < i; j++)
        {
            System.out.print("*");
        }
        for (k = j; k > 0; k-- )
        {
            System.out.print("*");
        }
        System.out.println();
    }
  }
}
