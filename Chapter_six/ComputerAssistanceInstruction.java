// Exercise 6.35 Computer Assistance Instruction 
import java.util.Scanner;
import java.security.SecureRandom;


public class ComputerAssistanceInstruction {
  
  private int numberOne;
  private int numberTwo;
  private static final SecureRandom randomNumber = new SecureRandom();
  private int randomIndex = 0;


  public void setQuestions (int bound) {

    numberOne = randomNumber.nextInt(bound);
    numberTwo = randomNumber.nextInt(bound);
    
  } 

  public String getQuestion (int choice) {

     switch (choice) {
      case 1: 
        return String.format( "How much is %d plus %d?", numberOne, numberTwo);
      case 2:
        return String.format( "How much is %d minus %d?", numberOne, numberTwo);
      case 3: 
        return String.format( "How much is %d times %d?", numberOne, numberTwo);
      case 4:
        if (numberTwo == 0)
          return null;
        else
          return String.format( "How much is %d divided %d?", numberOne, numberTwo);
    }

    return null;
  }

  public  double getAnswer(int choice) {
    
    switch (choice) {
      case 1: 
        return ( numberOne + numberTwo );
      case 2:
        return (numberOne - numberTwo);
      case 3: 
        return (numberOne * numberTwo);
      case 4:
        if (numberTwo == 0)
          return -1;
        else 
          return numberOne / numberTwo;
    }

    return 0;
  }

  public String possibleCorrectAnswerResponses () {

    String[] response = {"Very good!", "Excellent work!", "Nice work!", "Keep up the good work!"};

    return response[randomNumber.nextInt(4)];

  }

  public String possibleWrongAnswerResponses () {

    String[] response = {"No. please try again,", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."};

    return response[randomNumber.nextInt(4)];

  }

  public static void main(String[] args) {

    double answer;
    ComputerAssistanceInstruction CAI = new ComputerAssistanceInstruction();
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to elementary multiplication\n");

    int counter = 1;

    int bound; 

    System.out.println("\nLevel 1: single digit (0 - 9)");
    System.out.println("Level 2. larger number of digit (0 - 1000....)");

    System.out.print("Enter level: ");
    int level = input.nextInt();

    if (level == 1)
      bound = 10;
    else bound = 1000;

    System.out.println("Operations\n 1. Addition\n 2. subtraction\n 3. multiplication\n 4. division\n 5. RandomMixture\n");
    System.out.print("Enter choice: ");

    int firstChoice = input.nextInt();
    int choice;
    
      
    
    while (true) {
      CAI.setQuestions(bound);

      if (firstChoice == 5)
        choice = randomNumber.nextInt(4) + 1;
      else 
        choice = firstChoice;


      System.out.printf("%d. %s",counter ++, CAI.getQuestion(choice));
      System.out.print("\nEnter answer: ");
      answer = input.nextDouble();

      if (CAI.getAnswer(choice) == -1) {
        System.out.print("Division by 0 is math error!");
        continue;
      }

      if (answer == CAI.getAnswer(choice))
        System.out.printf("\n%s\n\n", CAI.possibleCorrectAnswerResponses());

      while (answer != CAI.getAnswer(choice)) {

        System.out.printf("\n%s\n", CAI.possibleWrongAnswerResponses());

        System.out.print("Enter Answer: ");
        answer = input.nextDouble();

        if (answer == CAI.getAnswer(choice))
         System.out.printf("\n%s\n\n", CAI.possibleCorrectAnswerResponses());
      }
    }
  }
}
