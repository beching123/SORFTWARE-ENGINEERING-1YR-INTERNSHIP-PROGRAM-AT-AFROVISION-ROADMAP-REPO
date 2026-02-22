// Fig. 4.21 largest integer in the list of integer inputted by the user
import java.util.Scanner;

public class LargestInteger {

  public  static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int integerInput;
    int counter;
    int largest;

    counter = 0;
    largest = 0;
    integerInput = 0;

    while (counter < 10) {
      System.out.printf("Enter integer %d:  ", counter + 1);
      integerInput = input.nextInt();
      if (largest < integerInput)
        largest = integerInput;
      counter ++;
    }

    System.out.printf("The largest Integer in the list is: %d", largest);
  }
}