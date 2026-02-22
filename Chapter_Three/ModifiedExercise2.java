// Modified addition Program in Fig. 2.7 to use dialog based input and output

import javax.swing.JOptionPane; // importing necessary object to use graphic user interface
import java.lang.Integer; // will be used to convert from string to integer

public class ModifiedExercise2 {
  
  public static void main(String[] args){

    String number = JOptionPane.showInputDialog("Enter first integer");
    
    int number1 = Integer.parseInt(number);

    number = JOptionPane.showInputDialog("Enter second integer");

    int number2 = Integer.parseInt(number);

    int sum = number1 + number2;

    String message = String.format("Sum: %d", sum);

    JOptionPane.showMessageDialog(null,message);

  }
}
