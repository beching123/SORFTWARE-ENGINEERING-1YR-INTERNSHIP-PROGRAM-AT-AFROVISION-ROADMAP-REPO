package Chapter_twelve;
// Fig. 12.2: Addition.java
// Addition program that uses JOptionPane for input and output
import javax.swing.JOptionPane;

public class Addition {
  

  public static void main(String[] args) {

    // obtain user input from jOptionPane input dialogs

    String firstNumber = JOptionPane.showInputDialog("Enter the first integer");

    String secondNumber = JOptionPane.showInputDialog("Enter second integer");

    int number1 = Integer.parseInt(firstNumber);
    int number2 = Integer.parseInt(secondNumber);


    int sum = number1 + number2;

    // display results in a JOptionPane dialog 
    JOptionPane.showMessageDialog(null, "The sum is " + sum, "sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
  }
}
