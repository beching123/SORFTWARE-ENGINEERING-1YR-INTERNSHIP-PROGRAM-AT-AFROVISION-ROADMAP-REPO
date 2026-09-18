// Exercise: 5.17 Calculating sales
import java.util.Scanner;

public class Sales {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    float totalRetailValue;

    int productNumber;
    int quantitySold;

    totalRetailValue = 0;

    do {

      System.out.print("Enter Product Number: ");
      productNumber = input.nextInt();

      if (productNumber == -1){
        continue;
      }

      System.out.print("Enter Quantity Sold: ");
      quantitySold = input.nextInt();

      switch (productNumber) {

        case 1: 
           totalRetailValue += (quantitySold * 2.98);
           break;
        case 2: 
           totalRetailValue += (quantitySold * 4.50);
           break;
        case 3: 
           totalRetailValue += (quantitySold * 9.98);
           break;
        case 4: 
           totalRetailValue += (quantitySold * 4.49);
           break;   
        case 5: 
           totalRetailValue += (quantitySold * 6.87);
           break;
      }

      System.out.println();
    }
    
    while(productNumber != -1);

    System.out.printf("%nTotal retail value of all products: %,f", totalRetailValue);
  }
  
}
