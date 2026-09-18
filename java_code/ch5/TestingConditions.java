// Exercise 5.23 testing conditions

public class TestingConditions {

  public static void main(String[] args) {

    int x = 1; 
    int y = 4;

    System.out.print(!(x < 5) && !(y >= 7));
    System.out.print(!((x < 5) || (y >= 7)));

    System.out.print(!(x == y) || !(y != 5));
    System.out.print(!((x == y) && (y != 5)));

    System.out.print(!((x <= 8) && (y > 4)));
    System.out.print(!(x <= 8) || !(y > 4));

    System.out.print(!((x > 4) || (y <= 6)));
    System.out.print(!(x > 4) && !(y <= 6));
  }
}
