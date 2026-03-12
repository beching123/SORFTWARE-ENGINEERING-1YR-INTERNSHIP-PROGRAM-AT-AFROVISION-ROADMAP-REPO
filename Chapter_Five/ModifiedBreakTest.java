// Fig. 5.26 modification of fig 5.13
// removing the break statement by replacing it with a structured code segment

public class ModifiedBreakTest {
  
  public static  void main(String[] args){

    int count; // control variable also used after loop terminates

    for (count = 1; count <= 10; count ++) {
      if (count == 5)
        count = 12; // terminating loop if count is 5
      else  
        System.out.printf("%d ", count);
    }
    System.out.println();
    System.out.printf("%n Broke out of the loop at count = %d%n", count);
  } // end class modifiedBreakTest
}
