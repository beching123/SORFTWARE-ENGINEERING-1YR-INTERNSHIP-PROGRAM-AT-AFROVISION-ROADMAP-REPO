// Exercise 6.30 Guess the Number game.
import java.util.Scanner;
import java.security.SecureRandom;


public class GuessTheNumber {
  
  // declaring instance variable
  private int guess; 
  private SecureRandom randomNumber;

  public GuessTheNumber () {

    guess = 0;
    randomNumber = new SecureRandom ();

  }

  public void setGuess() {
    guess = randomNumber.nextInt(1000) + 1;

  }

  public int getGuess () {

    return guess;

  }


  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int number;
    GuessTheNumber guess = new GuessTheNumber();
    guess.setGuess();
    int counter; 

    number = 0;
    counter = 0;

    while (number != guess.getGuess()) {
      System.out.print("Guess a number between 1 to 1000: ");
      number = input.nextInt();
      counter ++;

      if (number< guess.getGuess()){
        System.out.println("\nToo low. Try again");
      }
      else if (number > guess.getGuess()) {
        System.out.println("\nToo High. Try again");
      }

      else {
        System.out.println("\n Congratulations.");
        System.out.printf("\n%s%n", (counter <= 10) ? ((counter == 10)? "Aha! You know the secret!" : " Either you know the secret or you got lucky!") : "You should be able to do better!");
        
        System.out.print("Enter 1 to stop or 2 to continue: ");
        int choice = input.nextInt();
        counter = 0;
        
        if (choice == 1)
          break;
        
        guess.setGuess();

      }

    }

  }
}
