// exercise 6.25 prime numbers

public class Primes {
  
  public static boolean isPrime(long number) {

    for (int i = 2; i <= Math.sqrt((double)number); i ++) {
      if ((number % i) == 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

    for (long i = 2; i <= 10000; i ++) {
      if (isPrime(i))
        System.out.printf("%d%s", i, ((i % 20) == 0)? "%n": "\t");
    }
  }
}
