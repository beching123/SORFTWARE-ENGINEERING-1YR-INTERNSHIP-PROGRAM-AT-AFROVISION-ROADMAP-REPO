// Calculating the factorial of a range of numbers

public class Factorial {
  
  public static void main(String[] args){

    long fact = 1;
    System.out.printf("%15s|%30s","Number", "Factorial of Number\n");

    for (int i = 1; i <= 100; i ++){
      for (int j = i; j >= 1; fact *= j, j --);
      System.out.printf("%15d|%30d%n", i, fact);
      fact = 1;
    }
  }
}
