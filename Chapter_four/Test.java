/*  // Exercise 4.6: Calculate.java
 // Calculate the sum of the integers from 1 to 10 
 public class Test 
 {
   public static void main(String[] args)
   {
      int sum = 0;
      int x = 1;

      while (x <= 10) // while x is less than or equal to 
      {
         sum += x ++; // add x to sum
      } 

      System.out.printf("The sum is: %d%n", sum);
   } 
} // end class Calculate
*/

 // Exercise 4.16: Mystery.java
public class Test 
 {
   public static void main(String[] args)
   {
      int x = 1;
      int total = 0;

      while (x <= 10) 
      {
         int y = x * x;
         System.out.println(y);
         total += y;
         ++x;
      } 

      System.out.printf("Total is %d%n", total);
   } 
 } // end class Mystery