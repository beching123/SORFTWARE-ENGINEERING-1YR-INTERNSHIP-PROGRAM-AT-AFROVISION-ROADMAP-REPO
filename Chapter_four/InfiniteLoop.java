package Chapter_four;

public class InfiniteLoop {
  public static void main(String[] args) {

    double i = 1;

    while (true) {
      System.out.printf("%n%f", i);
      i *= 2;
    }
  } 
}
