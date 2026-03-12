// exercise 6.24 perfect Number
import java.util.Scanner;

public class PerfectNumber {

  public static boolean isFactor(long number, long factor) {

    if ((number % factor) == 0)
      return true;
    return false;
  }

  public static void isPerfect(long number) {

    String Factors = "";
    int sum = 0;

    for (long i = 1; i <= (number / 2) + 1; i ++) {
      
      if (isFactor(number, i)){
        sum += i;
        Factors += " + " + i;

      }
    }
    displayMessage(number, Factors, (sum == number) ? "is perfect": "is not perfect");
         
  }

  public static void displayMessage(long number, String Factors, String Message) {

    System.out.printf("%n%d %s.%n\t Factors: ", number,Message);

    for (int i = 3; i < Factors.length(); i ++) {
      System.out.printf("%s", Factors.charAt(i));  
    }

    if (Message == "is perfect")
      System.out.printf(" = %d", number);
    else 
      System.out.printf(" != %d", number);
    
    System.out.println();
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int number; 
    
    for (long i = 1; i <= 20000; i ++)
      isPerfect(i);
    
  }
}