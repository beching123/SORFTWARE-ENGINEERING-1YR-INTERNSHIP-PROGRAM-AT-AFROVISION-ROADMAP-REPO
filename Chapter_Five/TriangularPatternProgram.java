// Exercise: 5.15 printing various triangular pattern

public class TriangularPatternProgram {

  public static void main(String[] args) {
  
    for (int i = 1; i <= 10; i ++){

      for (int j = 1; j <= i; j++){
        System.out.print('*');
      }

      System.out.println();
    }

    System.out.println();

    for (int i = 10; i >= 1; i --){

      for (int j = 1; j <= i; j ++){
        System.out.print('*');
      }
      
      System.out.println();
    }

    System.out.println();

    for (int i = 10; i >= 1; i --){

      for (int k = i; k < 10; k ++){
        System.out.print(' ');
      }

      for (int j = 1; j <= i; j ++){
        System.out.print('*');
      }
      
      System.out.println();
    }

    System.out.println();

    for (int i = 1; i <= 10; i ++){

      for (int k = i; k < 10; k ++){
        System.out.print(' ');
      }

      for (int j = 1; j <= i; j ++){
        System.out.print('*');
      }
      
      System.out.println();
    }
  }
}
