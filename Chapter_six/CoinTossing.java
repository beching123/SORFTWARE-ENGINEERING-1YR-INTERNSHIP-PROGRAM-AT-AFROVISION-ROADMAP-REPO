// exercise 6.29 Tossing coin randomly
import java.util.Scanner;
import java.security.SecureRandom;

public class CoinTossing {

  private static int face;
  private static int tail;
  private static SecureRandom randomNumber = new SecureRandom();

  private static enum COIN {
    HEAD,
    TALE
  }

  public CoinTossing() {

    face = 0;
    tail = 0;
  }
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);


    int rand;

    int choice = 0;

    while (choice != -1) {
      System.out.printf("%nEnter 1 to toss coin%nEnter -1 to stop%nEnter: ");
      choice = input.nextInt();

      switch(choice) {
        case 1:
          COIN coin = flip();
          System.out.printf("\n You tossed a %s", coin.toString());
          break;
      }
    }

    System.out.println("\n ============================================");
    System.out.printf("Head: %d times%nTail: %d times", face, tail);
        System.out.println("\n ============================================");
  }

  public static COIN flip () {

    int coinType = randomNumber.nextInt(2);
    
    if (coinType == 0)
      face ++;
    else 
      tail ++;

    return COIN.values()[coinType];
  }
}
