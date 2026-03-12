// Exercise 5.28 modification of fig 5.14
// removing the continue statement and replacing it with a structured block of code

public class ModifiedContinueTest {
  
  public static void main(String[] args){

    for (int count = 1; count <= 10; count ++) {
      if (count == 5); // skip the remaining code when counter is 5
      else 
        System.out.printf("%d ", count);
    }

    System.out.printf("%nUsed structured programming to skip printing of 5%n");
  }
} // end class ModifiedContinueTest
