// Exercise 5.23

public class PythagorasTriplet {

  public static void main(String[] args) {

    int side1, side2, hypotenuse;

    System.out.printf("%15s%15s%15s", "SIDE1", "SIDE2", "HYPOTENUSE");
    System.out.println();

    for (hypotenuse = 1; hypotenuse < 500; hypotenuse ++) {
      
      for (side1 = 1; side1 <= hypotenuse; side1 ++) {
        
        for (side2 = 1; side2 <= side1; side2 ++) {

          if (((side1 * side1) + (side2 * side2)) == (hypotenuse * hypotenuse)){
            System.out.println();
            System.out.printf("%15d%15d%15d", side1, side2, hypotenuse);
            
          }
        }
        
      }
    }
  }
  
}
