// Fig. 4.23 finding the two largest values in a list of ten integer
import java.util.Scanner;

public class TwoLargestValues { 
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int integerInput;
    int counter;
    int largest;
    int secondLargest;

    counter = 0;
    largest = 0;
    secondLargest = 0;
    integerInput = 0;

    while (counter < 10) {
      System.out.printf("Enter integer %d:  ", counter + 1);
      integerInput = input.nextInt();
      if (largest < integerInput){
        secondLargest = largest;
        largest = integerInput;
      }
      counter ++;
    }

    System.out.printf("The largest Integer in the list is: %d%n", largest);
    System.out.printf("The second largest Integer in the list is: %d", secondLargest);
  }
}