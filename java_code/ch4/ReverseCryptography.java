// Exercise 4.38 Cryptography of messages
import java.util.Scanner;
  
public class ReverseCryptography {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int number = 0;
    int tempNumber = 0;
    int remainder = 0;
    int counter = 1;
    int newDigit = 0;

    System.out.print("\nEnter a 4 digit integer: ");
    number = input.nextInt();

    tempNumber = number;

    while (counter <= 4){

      remainder = tempNumber % 10;
      tempNumber /= 10;

      remainder -= 7;
      if (remainder < 0) remainder += 10;

      if (counter == 1){
        newDigit += (power(10,2) * remainder);
        
      }
      else if (counter == 2){
        newDigit += (power(10, 3) * remainder);
      }
      else if (counter == 3){
        newDigit += (power(10, 0) * remainder);
      }
      else if (counter == 4){
        newDigit += (power(10, 1) * remainder);
      }
      if ( counter == 4 && tempNumber != 0) {
        System.out.print("\nInvalid number! length of digit must be 4\n\n");
        return;
      }
      counter ++;
    }
    
    System.out.printf("Encrypted data transmitted:   %04d%n%n", newDigit);
  }

  public static int power(int base, int power){
    int square = 1;

    while (power != 0){
      square *= base;
      power --;
    }
    return square;
  }
}
