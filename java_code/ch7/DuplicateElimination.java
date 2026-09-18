// exercise 7.12
import java.util.Scanner;

public class DuplicateElimination {
  
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int[] array = new int[5];

    for (int i = 0; i < array.length; i ++) {
      array[i] = input.nextInt();

      for (int j = 0; j <= i; j ++) {
        
        if (array[i] == array[j]){
          break;
        }
        System.out.printf(" %d", array[i]);
      }
    }
  }
}
