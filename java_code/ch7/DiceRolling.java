// exercise 7.17 rolling a dice
import java.security.SecureRandom;

public class DiceRolling {
  
  public static void main(String[] args) {

    SecureRandom randomNumber = new SecureRandom();

    long[] frequency = new long[13];
    
    int dice1;
    int dice2;
    int sum;

    for (long i = 0; i < 36000000; i ++) {
      dice1 = 1 + randomNumber.nextInt(6);
      dice2 = 1 + randomNumber.nextInt(6);

      sum = dice1 + dice2;

      ++frequency[sum];
    }

    System.out.printf("%5s%30s%n", "SUM", "Number of Times Rolled");

    for (int i = 2; i <= 12; i ++) {
      System.out.printf("%5d%20d%n", i, frequency[i]);
    }

  }
}
