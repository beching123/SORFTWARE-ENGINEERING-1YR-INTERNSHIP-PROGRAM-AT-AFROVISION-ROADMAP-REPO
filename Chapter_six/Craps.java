// Fig. 6.7: Craps.java
// Craps class simulates the dice game craps
import java.security.SecureRandom;
import java.util.Scanner;

public class Craps {

  // create secure random number generator for use in method rollDice
  private static final SecureRandom randomNumber = new SecureRandom (); 

  // enum type with constants that represent the game status
  private enum Status {CONTINUE, WON, LOST};
  
  //constant that represent common rolls of the dice
  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3;
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;
  private static int bankBalance = 1000;
  
  // plays one game of craps
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in); // takes user inputs
    Craps game = new Craps(); // instance object that makes use of this class methods and instance variables

    int bankBalance; // holds user current balanced while playing

    int myPoints = 0; // point if no wins or loss on first roll
    Status gameStatus; // can contain CONTINUE, WIN or LOST

    // prompting the user to enter a wager
    System.out.print("Enter a wager: ");
    bankBalance = input.nextInt();


    // validating users input.
    while (bankBalance < 0 || bankBalance > game.getBankBalance()) {

      System.out.printf("Invalid wager.\nYour balance %d.\n\nEnter a valid wager: ", game.getBankBalance());
      bankBalance = input.nextInt();

    }
    System.out.println(); System.out.println();

    int sumOfDice = rollDice(); // first roll of the dice

    // determine game status and point based on first roll
    switch (sumOfDice) {

      case  SEVEN: // win with 7 on first roll
      case  YO_LEVEN: // win with 11 on first roll
        gameStatus = Status.WON;
        game.chatter();
        break;
      case SNAKE_EYES: // loss with 2 on first roll
      case TREY: // lose with 3 on first roll
      case BOX_CARS: // lose with 12 on first roll
        gameStatus = Status.LOST;
        game.chatter();
        break;
      default: // did not win or lose, so remember point
        gameStatus = Status.CONTINUE; // game is not over
        myPoints = sumOfDice; // remember the point
        System.out.printf("Point is %d%n", myPoints);
        game.chatter();
        break;
    }

    // while game is not complete
    while (gameStatus == Status.CONTINUE) { // not WON or LOSt
      
      sumOfDice = rollDice(); // roll dice again
      game.chatter();
      // determine game status
      if (sumOfDice == myPoints) // win by making point
        gameStatus = Status.WON;
      else 
        if (sumOfDice == SEVEN) // loss by rolling 7 before point
      gameStatus = Status.LOST;
    }

    // display won or lost message
    if (gameStatus == Status.WON) {
      System.out.println("Player Wins");
      System.out.printf("Your new Balance: %d\n", game.getBankBalance() + bankBalance);
    }

    else {
      System.out.println("Player loses");
      System.out.printf("Your new Balance: %d\n%s", game.getBankBalance() - bankBalance, ((game.getBankBalance() - bankBalance) == 0) ? "Sorry. you busted!": "");
    }
  }

  // roll dice, calculate sum and display results
  public static int rollDice () {

    // pick random die value
    int die1 = 1 + randomNumber.nextInt(6); // first die roll
    int die2 = 1 + randomNumber.nextInt(6); // second die roll

    int sum = die1 + die2; // sum of die values

    // display results of this roll
    System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
    
    return sum;

  }

  public int getBankBalance() {

    return bankBalance;
  }

  public void chatter () {

    SecureRandom  randomNumber = new SecureRandom();

    switch (randomNumber.nextInt(3)) {
      case 0:
        System.out.println("\nOh, you're going for broke, huh?");
        break;
      case 1: 
        System.out.println("\nAw c'mon, take a chance!");
        break;
      case 2: 
        System.out.println("\nYou're up big. Now's the time to cash in your chips!");
        break;
      default:
        break;
    }
  }
} // end class Craps