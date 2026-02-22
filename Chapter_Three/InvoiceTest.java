//Exercise 3.12 testing the invoice application

import java.util.Scanner;


public class InvoiceTest {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);// scanner object to read input from user

    //object created from our invoice class
    Invoice Item1 = new Invoice("123ASE","Car Tires" , -1, 2500);
    Invoice Item2 = new Invoice("123Be", "Fridge part", 10, 2500.0);

    //printing thier info
    System.out.printf("%n 1. %s:%n  - Id: %s%n  - Prize: %.2f%n  - Quantity: %d%n  - Invoice Amount: %f ", Item1.getPartDescription(), Item1.getPartNumber(), Item1.getPrizePerItem(), Item1.getQuantityPurchased(), Item1.getInvoicedAmount());

    System.out.printf("%n 2. %s:%n  - Id: %s%n  - Prize: %.2f%n  - Quantity: %d%n  - Invoice Amount: %f  ", Item2.getPartDescription(), Item2.getPartNumber(), Item2.getPrizePerItem(), Item2.getQuantityPurchased(),Item2.getInvoicedAmount());

    

  }
}
