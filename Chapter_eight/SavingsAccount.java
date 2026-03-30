package Chapter_eight;

public class SavingsAccount {
  
  private static double annualInterestRate; // static variable to store the annual interest rate for all account holders.
  private double savingsBalance; // instance variable to indicate the current amount the user has on deposit.


  // constructor to set savingsBalance
  public SavingsAccount (double savingsBalance) {

    this.savingsBalance = savingsBalance;

  }

  // method used to calculate monthly interest
  public double calculateMonthlyInterest() {

    double interest = savingsBalance * annualInterestRate / 12; 
    savingsBalance += interest;
    return interest;

  }

  // static method to modify saving balance
  public static void modifyInterestRate (double interestRate) {

    annualInterestRate = interestRate;

  }

  // get savings method
  public double getSavingsBalance () {

    return savingsBalance;
  }
}
