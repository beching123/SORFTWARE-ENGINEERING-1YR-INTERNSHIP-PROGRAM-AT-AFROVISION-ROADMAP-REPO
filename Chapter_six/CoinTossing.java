// exercise 6.29 Tossing coin randomly
import java.util.Scanner;
import java.security.SecureRandom;

public class CoinTossing {

  private static int face;
  private static int tail;

  public CoinTossing() {

    face = 0;
    tail = 0;
  }
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    SecureRandom randomNumber = new SecureRandom();

    int rand;

    int choice;
    System.out.print("%nEnter 1 to toss coin%nEnter -1 to stop%n5n");
    choice = input.nextInt();

    switch(choice) {
      case 1:
        rand = TossCoin();
        break;
      case -1: 
        System.out.printf("%n The number of time face appeared: %d", face);
        System.out.printf("%nThe number of times tail appeared: %d ", tail);
    }
  }

  public static int TossCoin () {}
}
