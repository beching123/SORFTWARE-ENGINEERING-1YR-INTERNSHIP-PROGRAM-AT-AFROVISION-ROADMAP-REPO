// Exercise 4.37 i. Estimation of exponential value of e.
import java.util.Scanner;

public class EstimationOfExponential {
   
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int number;

    System.out.print("\nEnter a number: ");
    number = input.nextInt();
    int tempNumber = 1;
    int tempNumber2;
    double exponential = 1;

    double fact = 1;
    while (tempNumber <= number){
      tempNumber2 = tempNumber;
      while (tempNumber2 != 0){
        fact *= tempNumber2 --;
     }
     exponential += ((float)1 / fact);
     tempNumber ++;
     fact = 1;
    }
    System.out.printf("\nThe approximated range of e:  %f\n", exponential);
  }
}
