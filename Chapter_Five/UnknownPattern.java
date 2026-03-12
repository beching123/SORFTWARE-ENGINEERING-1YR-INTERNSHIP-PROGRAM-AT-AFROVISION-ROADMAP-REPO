// Exercise 5.27 Unknown pattern

public class UnknownPattern {
  
  public static void main(String[] args) {
    int i , j , k;
    
    for (i = 1; i <= 5; i++) {

      for (j = 1; j <= 3; j++) {

        for (k = 1; k <= 4; k++)
          System.out.print('*');

        System.out.println();

        } // end inner for

      System.out.println();

    } // end outer for
  }
}
