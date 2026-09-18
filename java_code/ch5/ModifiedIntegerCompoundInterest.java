// Modifying compound interest program so i use only integers

public class ModifiedIntegerCompoundInterest {
   public static void main(String[] args)
   {
      long amount; // amount on deposit at end of each year
      long principal = 1000; // initial amount before interest
      long interest;

      principal *= 100;
      amount = principal;

      for (int i = 5; i <= 10; i ++){
        interest = (amount * i) / 100;

        System.out.printf("%n%n%d. %n", i);

        // display headers
        System.out.printf("%4s%20s%n", "Year", "Amount on deposit");
        // calculate amount on deposit for each of ten years 
        for (int year = 1; year <= 10; ++year)             
        {                                                    
          // calculate new amount for specified year        
          amount += interest;
                                                      
          // display the year and the amount
          long dollar = amount / 100;
          long cent = amount % 100;

          System.out.printf("%4d%17d.%02d%n", year, dollar, cent);
        }
     }
   }
}   // end class interest                                    