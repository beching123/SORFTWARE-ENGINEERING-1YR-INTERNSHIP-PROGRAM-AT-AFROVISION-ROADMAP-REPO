// Exercise 4.32 Checkerboard Pattern of Asterisks

public class Checkered {

  public static void main(String[] args){

    int size = 8;
    int row = 1;

    while (row <= size) {

      int column = 1;
      while (column <= size) {
        if (row % 2 == 1 && column == size)
          System.out.print(" ");
        else if (row % 2 == 0 && column == 1)
          System.out.print("  ");
        else 
          System.out.print("*  ");

        column ++;
      }
      System.out.println();
      row ++;
    }
  }
}