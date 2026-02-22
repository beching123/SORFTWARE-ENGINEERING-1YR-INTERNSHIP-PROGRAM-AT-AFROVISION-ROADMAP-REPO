// Fig. 3.9: AccountTest.java
// Inputting and outputting floating-point numbers with Account objects.
import java.util.Scanner;

public class AccountTest {

  public static void displayAccount(Account accountToDisplay){
      System.out.printf("%s balance: $%.2f%n", accountToDisplay.getName(), accountToDisplay.getBalance());    
  }

  public static void main(String[] args){
    Account account1 = new Account("jane Green", 50.0);
    Account account2 = new Account("John Blue", -7.53);

    //display initial balance of each object
    System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
    System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

    // create a Scanner to obtain input from the command window
    Scanner input = new Scanner(System.in);

    
    
    
    System.out.printf("Enter deposit amount for account1: ");
    double depositAmount = input.nextDouble(); //obtain user input
    System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
    account1.deposit(depositAmount); // add account1's balance 

    //display balance
    displayAccount(account1);
    displayAccount(account2);

    System.out.print("Enter deposit amount for account2: "); //prompt 
    depositAmount = input.nextDouble(); // obtain user input
    System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
    account2.deposit(depositAmount); // add to account2 balance

    // display balance 
     displayAccount(account1);
     displayAccount(account2);

    //enable the user to withdraw money from their account
    System.out.print("Enter the withdraw amount for account1: ");
    double withdrawAmount = input.nextDouble();
    account1.withdraw(withdrawAmount);

      // display balance 
     displayAccount(account1);
     displayAccount(account2);

    //enable account2 to withdraw
    System.out.print("Enter the withdraw amount for account2: ");
    withdrawAmount = input.nextDouble();
    account2.withdraw(withdrawAmount);

      // display balance 
     displayAccount(account1);
     displayAccount(account2);
    
  } // end main
} // end class AccountTest