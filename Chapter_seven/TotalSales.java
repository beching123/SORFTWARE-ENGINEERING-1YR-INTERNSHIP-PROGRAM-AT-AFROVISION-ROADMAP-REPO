// exercise 7.20 Total Sales
import java.util.Scanner;
import java.security.SecureRandom;

public class TotalSales {
  
  public static final int NUMBER_OF_PRODUCTS = 6;
  public static final int NUMBER_OF_WORKERS = 5;
  public static final int INFO = 2;
  public static final int NUMBER_OF_DAYS = 30;
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    double [][] product_SalesPeople = new double[NUMBER_OF_PRODUCTS][NUMBER_OF_WORKERS];
    double[][] totalNumberOfProductsSold = new double [NUMBER_OF_PRODUCTS][INFO];
    double[][] totalProductPerPerson = new double[NUMBER_OF_WORKERS][INFO];
    double[] slips = new double [INFO];
    double sum;
    int numberOfSlip;
    SecureRandom randomNumber = new SecureRandom();

    for (int days = 1; days <= NUMBER_OF_DAYS; days ++) {

      System.out.printf("Day %d%n%n", days);

      for (int person = 1; person <= 4; person ++) {

        System.out.printf("Person %d", person);
        //System.out.printf("Enter the Number of slips you gave for day %d: ", days);
        //numberOfSlip = input.nextInt();
        numberOfSlip = 1 + randomNumber.nextInt(5);


        System.out.println();

        for (int slip = 1; slip <= numberOfSlip; slip ++) {
          System.out.printf("Slip %d%n", slip);

          //System.out.print("Enter Product Number: ");
          //slips[0] = input.nextDouble();
          slips[0] = 1 + randomNumber.nextInt(5);

          //System.out.print("Enter Total dollar value of that product sold that day: ");
          //slips[1] = input.nextDouble();

          slips[1] = 1 + randomNumber.nextDouble(400);

          product_SalesPeople[(int)slips[0]][person] += slips[1];

        }
        System.out.println();System.out.println();
      }
    }

    for (int i = 1; i < NUMBER_OF_WORKERS; i ++) {
            
      totalProductPerPerson[i][0] = i;

      for (int j = 1; j < NUMBER_OF_PRODUCTS; j ++) {
       
        totalProductPerPerson[i][1]  += product_SalesPeople[j][i];
      }
    }

    for (int i = 1; i < NUMBER_OF_PRODUCTS; i ++) {
            
      totalNumberOfProductsSold[i][0] = i;

      for (int j = 1; j < NUMBER_OF_WORKERS; j ++) {
       
        totalNumberOfProductsSold[i][1]  += product_SalesPeople[i][j];
      }
    }
    
    System.out.print("Product Number\t\tWorker 1\t\tWorker 2\t\tWorker 3\t\tWorker 4\t\t Total Product sold\n");
    for (int i = 1; i < NUMBER_OF_PRODUCTS; i ++){
      System.out.printf("%n%14d\t\t", i);

      for (int j = 1; j < NUMBER_OF_WORKERS; j ++){

        System.out.printf("%,7.3f\t\t", product_SalesPeople[i][j]);
      }
      System.out.printf("%,.3f", totalNumberOfProductsSold[i][1]);
    }
    System.out.println();
    System.out.printf("%n%14s\t\t","Total");
    for (int i = 1; i < NUMBER_OF_WORKERS; i ++) {

      System.out.printf("%,7.3f\t\t", totalProductPerPerson[i][1]);
    }
  }
}