// Exercise 7.16 Game of craps modified
import java.security.SecureRandom;

public class GameOfCraps {

  private static final SecureRandom randomNumber = new SecureRandom();
  private enum Status {CONTINUE, WON, LOST};

  //constants that represent common rolls ot the dice
  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3; 
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;
  public static void main(String[] args) {

    long[] frequency = new long[3];

    int myPoint = 0;
    Status gameStatus;

    for (long i = 0; i < 1000000; i ++) {

      int sumOfDice = rollDice();

      switch (sumOfDice) {
        case SEVEN:
        case YO_LEVEN:
          gameStatus = Status.WON;
          break;
        
        case SNAKE_EYES:
        case TREY:
        case BOX_CARS:
          gameStatus = Status.LOST;

        default:
          gameStatus = Status.CONTINUE;
          myPoint = sumOfDice;
          System.out.printf("Point is %d%n", myPoint);
          break;
      }

      while (gameStatus == Status.CONTINUE) {

        sumOfDice = rollDice();

        if (sumOfDice == myPoint)
          gameStatus = Status.WON;
        else 
          if (sumOfDice == SEVEN)
            gameStatus = Status.LOST;
      }

        if (gameStatus == Status.WON){

          ++frequency[1];
          System.out.println("Player Wins");

        }
        else{ 
          ++frequency[2];
          System.out.println("Player loses");
        
        }

      System.out.println();
      System.out.println();
    }

    System.out.printf("Number of games won: %d%nNUmber of game lost: %d", frequency[1], frequency[2]);
  }

  public static int rollDice() {

    int die1 = 1 + randomNumber.nextInt(6);
    int die2 = 1 + randomNumber.nextInt(6);

    int sum = die1 + die2;

    System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

    return sum;  
  }
}
