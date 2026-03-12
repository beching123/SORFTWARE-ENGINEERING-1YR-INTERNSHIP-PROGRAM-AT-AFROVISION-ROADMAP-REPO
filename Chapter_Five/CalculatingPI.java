// Exercise 5.20 calculating the value of pi

public class CalculatingPI {
  
  public static void main(String[] args){


    double PI;
    double decimalPart;
    long denominator;
    int flag;

    denominator = 3;
    decimalPart = 0.0;
    PI = 4;
    flag = 0;

    for (long i = 1; i <= 200000; i ++) {
      
      decimalPart = ((double) 4 / denominator);

      if (flag == 0){
        PI -= decimalPart;
        flag = 1;
      }

      else {
        PI += decimalPart;
        flag = 0;
      }
      
      System.out.printf("%10d\tPI:%20f", i, PI);
      System.out.println();
      denominator += 2; 

    }
  }
}
