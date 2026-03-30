package Chapter_eight;

public class SavingsAccountTest {
  
  public static void main(String[] args) {

    SavingsAccount saving1 = new SavingsAccount(2000.00);
    SavingsAccount saving2 = new SavingsAccount(3000.00);

    SavingsAccount.modifyInterestRate(0.04);

    for (int i = 1; i <= 12; i ++) {

      saving1.calculateMonthlyInterest();
      saving2.calculateMonthlyInterest();

      System.out.printf("%,.3f\t%,.3f\n", saving1.getSavingsBalance(), saving2.getSavingsBalance());

    }

    System.out.println(); System.out.println();
    saving1 = new SavingsAccount(2000.00);
    saving2 = new SavingsAccount(3000.00);


    SavingsAccount.modifyInterestRate(0.05);

    for (int i = 1; i <= 12; i ++) {

      saving1.calculateMonthlyInterest();
      saving2.calculateMonthlyInterest();

      System.out.printf("%,.3f\t%,.3f\n", saving1.getSavingsBalance(), saving2.getSavingsBalance());

    }

  }
}
