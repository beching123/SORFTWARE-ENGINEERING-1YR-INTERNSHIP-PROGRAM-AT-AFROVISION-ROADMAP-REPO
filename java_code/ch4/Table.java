// Fig. 4.22 Formatted table of 10s

public class Table {
  
  public static void main(String[] args){

    int counter = 1;
    System.out.printf("  %n  %s%8s%8s%8s%n%n", "N", "10*N", "100*N", "1000*N");
    while (counter <= 5){
      System.out.printf("  %d%8d%8d%8d%n", counter, 10 * counter, 100 * counter, 1000 * counter);
      counter ++;
    }
  }
}
