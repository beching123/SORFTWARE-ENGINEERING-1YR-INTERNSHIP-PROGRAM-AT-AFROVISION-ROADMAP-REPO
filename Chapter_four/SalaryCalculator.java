// Chapter 4 exercise 4.19
import java.util.Scanner;

public class SalaryCalculator {
  
  public static void main(String[] args){
    
    Scanner input = new Scanner(System.in);

    String nameOfSalesPerson;
    int itemNumber = 0;
    int totalItemSold = 0;
    double amountOfTotalItemsSold = 0;
    double salary;

    System.out.print("Enter name of sales person: ");
    nameOfSalesPerson = input.nextLine();

    System.out.printf(" Enter the item number of item %d or (-1 to stop): ", ++ itemNumber );
    itemNumber = input.nextInt();

    while (itemNumber != -1){

      if (itemNumber == 1) {
        amountOfTotalItemsSold += 239.99;
        totalItemSold ++;
      }
      else if (itemNumber == 2){
        amountOfTotalItemsSold += 129.75;
        totalItemSold ++;
      }
      else if (itemNumber == 3) {
        amountOfTotalItemsSold += 99.95;
        totalItemSold ++;
      }
      else if (itemNumber == 4){
        amountOfTotalItemsSold += 350.89;
        totalItemSold ++;
      }
      else {
        System.out.printf(" %d is an invalid item number!!!%n", itemNumber);
      }
      
      System.out.printf(" Enter the item number of item %d or (-1 to stop): ",++ itemNumber);
      itemNumber = input.nextInt();
    }

    salary = 200.00 + (((float) 9 / 100) * amountOfTotalItemsSold);
    System.out.printf("%nSalary for %s this week is %,15.3f",nameOfSalesPerson, salary);
    System.out.printf("%nNumber of Items sold: %d%n", totalItemSold);
    System.out.printf("%nTotal sales revenue: %,15.3f", amountOfTotalItemsSold);
  }
}
