// exercise 7.10 sales commission
import java.util.Scanner;

public class SalesCommissions {
  
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int[] frequency = new int[11]; 
    
   
    double salary = 0.0;
    while (salary  != -1.0) {
       System.out.print("Enter a valid salary or -1 to stop: ");

       salary = input.nextFloat();
       
       if (salary >= 1000)
       ++frequency[10];
      else 
        ++frequency[(int) salary / 100];
    }

    System.out.printf("%s| %s%n%n", "Salary Range" , "Number of Employee");

    for (int i = 2; i <= frequency.length - 1; i ++) {
      if (i == frequency.length - 1)
        System.out.printf("$%,d+...  | %5d%n", 1000, frequency[i]);
      
      else 
        System.out.printf("$%d - $%d | %5d%n", i * 100, i * 100 + 99, frequency[i]);
    } 
  }
}
