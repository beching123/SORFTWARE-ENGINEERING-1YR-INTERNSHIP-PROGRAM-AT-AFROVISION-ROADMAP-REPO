// Fig. 5.6: Interest.java
 // Compound-interest calculations with for.

public class ModifiedCompoundInterest {

   public static void main(String[] args)
   {
      double amount; // amount on deposit at end of each year
      double principal = 1000; // initial amount before interest
      double rate;

      for (int i = 5; i <= 10; i ++){
        rate = (float) i / 100;
        System.out.printf("%n%n%d. Interest for rate: %.2f: %n", i,rate,i);
        // display headers
        System.out.printf("%s %n", "Year", "Amount on deposit");
        // calculate amount on deposit for each of ten years 
        for (int year = 1; year <= 10; ++year)             
        {                                                    
          // calculate new amount for specified year        
          amount = principal * Math.pow(1.0 + rate, year);
                                                      
          // display the year and the amount                
          System.out.printf("%4d%,20.2f%n", year, amount);
        }
     }
   }
}   // end class interest                                    