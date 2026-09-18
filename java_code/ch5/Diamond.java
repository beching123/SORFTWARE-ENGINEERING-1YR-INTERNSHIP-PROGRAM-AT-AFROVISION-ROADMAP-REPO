// Exercise 5.24 Program to print a diamond

public class Diamond {

  public static void main(String[] args) {
    int j;
    int i;
    int k;
    int l;

    for ( i =1; i <= 5; i++)
    {

        for (l =i; l <= 7-1; l++)
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
        for ( i = 4; i >= 1; i--)
    {

        for (l = i; l <= 7-1; l++)
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
