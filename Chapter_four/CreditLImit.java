// Fig. 4.18 determine if various customers have gone over their credit limit for the month.
import java.util.Scanner;

public class CreditLImit {
  
  public static void main (String[] args){
    // input object to collect user input.
    Scanner input = new Scanner(System.in);

    // The five facts for each user
    int accountNumber;
    int startingBalance;
    int Charges;
    int Credits;
    int limits;

    // Used to whole their current dept
    int newBalance;

    //signal which allows the uer to notify the program if there are any Customer left
    int signal = 0;

    // Note to the user on how to notify te program when there aren't any customer left
    System.out.println("Note: when ever you see \"Signal\" input -1 if NO customer, otherwise any number of you choice\n");
    System.out.printf("Signal: ");
    signal = input.nextInt();
    if (signal == -1) return;

    // Collecting info for customer 1
    System.out.println("\nCustomer 1: ");
    System.out.print(" Enter AccountId: ");
    accountNumber = input.nextInt();
    System.out.print(" Enter Balance at the beginning of the Month: ");
    startingBalance = input.nextInt();
    System.out.print(" Enter the Total stuff bought this Month: ");
    Charges = input.nextInt();
    System.out.print(" Enter Amount Payed this Month: ");
    Credits = input.nextInt();
    System.out.print(" Enter Credit Limit: ");
    limits = input.nextInt();

    //calculating what they owe
    newBalance = startingBalance + Charges - Credits;
    if (newBalance >=  limits) System.out.println("\nNotice!!! Credit limit exceeded\n");

    System.out.printf("Signal: ");
    signal = input.nextInt();
    if (signal == -1) return;

    int tracker = 1; // used to keep track of the number of customers

    while (signal != -1){

    // Collecting info for customer 1
    System.out.printf("\nCustomer %d:%n ", ++tracker);
    System.out.print(" Enter AccountId: ");
    accountNumber = input.nextInt();
    System.out.print(" Enter Balance at the beginning of the Month: ");
    startingBalance = input.nextInt();
    System.out.print(" Enter the Total stuff bought this Month: ");
    Charges = input.nextInt();
    System.out.print(" Enter Amount Payed this Month: ");
    Credits = input.nextInt();
    System.out.print(" Enter Credit Limit: ");
    limits = input.nextInt();

    //calculating what they owe
    newBalance = startingBalance + Charges - Credits;
    if (newBalance >=  limits) System.out.println("\nNotice!!! Credit limit exceeded\n");

    System.out.printf("Signal: ");
    signal = input.nextInt();

    }

  }
}

