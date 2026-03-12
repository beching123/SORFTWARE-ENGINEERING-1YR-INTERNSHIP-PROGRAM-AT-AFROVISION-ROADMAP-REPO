// Exercise 5.23 Modifying 

public class ModifiedTriangle {
  public static void main(String[] args) {
  
    for (int i = 1, n = 10; i <= 10; i ++, n --){

      // i
      System.out.print("\t");
      for (int j = 1; j <= i; j++){
        System.out.print('*');
      }
      for (int k = 10 - i; k >= 1; k --){
        System.out.print(' ');
      }
      System.out.print("\t");
      

    // n
      for (int j = 1; j <= n; j ++){
        System.out.print('*');
      }
      for (int k = 1; k < i; k ++){
        System.out.print(' ');
      }
      System.out.print("\t");
      

    //n
      for (int k = n; k < 10; k ++){
        System.out.print(' ');
      }
      for (int j = 1; j <= n; j ++){
        System.out.print('*');
      }
      System.out.print("\t");
      

    // i
      for (int k = i; k < 10; k ++){
        System.out.print(' ');
      }
      for (int j = 1; j <= i; j ++){
        System.out.print('*');
      }
      System.out.print("\t");
      
      System.out.println();
    }
  }
}
