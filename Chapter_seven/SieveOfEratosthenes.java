// Exercise 7.27 Sieve of Eratosthenes for prime number;

public class SieveOfEratosthenes {
  
  private boolean[] isPrime = new boolean[1000];


  public SieveOfEratosthenes() {

    for (int i = 0; i < 1000; i ++) {

      isPrime[i] = true;
    }
  }

  public boolean isTrue(int index) {

    if (isPrime[index])
      return true;
    else return false;

  }

  public void updateIsPrime(int index) {

    for (int i = index + 1; i < 1000; i ++) {

      if (i % index == 0)

        isPrime[i] = false;
    }
  }

  public void displayPrimes() {

    for (int i = 2, counter = 1; i < 1000; i ++) {

      if (isPrime[i]){
        System.out.printf("%3d", i);
        System.out.printf("%s", (counter % 10 == 0) ? 
        "\n": "  ");
        counter ++;
      }
    }
  }

  public void primes() {

    for (int i = 2; i < 1000; i ++) {

      if (isTrue(i)) {

        updateIsPrime(i);

      }
    }

    displayPrimes();
  }

  public static void main(String[] args) {

    SieveOfEratosthenes primeNumbers = new SieveOfEratosthenes();

    primeNumbers.primes();
  }
}
