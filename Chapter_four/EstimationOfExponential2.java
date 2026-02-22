// Exercise 4.37 ii. Estimation of exponential value of e with x.
import java.util.Scanner;

public class EstimationOfExponential2 {
   
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    int number;
    int x;

    System.out.print("\nEnter a number: ");
    number = input.nextInt();
    System.out.print("Enter x: ");
    x = input.nextInt();


    int tempNumber = 1;
    int tempNumber2;
    double exponential = 1;
    int tempX = 1;
    double square = 1;
  

    double fact = 1;
    while (tempNumber <= number){

      tempNumber2 = tempNumber;
      tempX = tempNumber;

      while (tempNumber2 != 0){
        fact *= tempNumber2 --;
     }

     while (tempX != 0){
        square *= x;
        tempX --;
     }

     exponential += (square / fact);
     tempNumber ++;
     fact = 1;
     square = 1;
    }
    System.out.printf("\nThe approximated range of e^x:  %f\n", exponential);
  }
}
