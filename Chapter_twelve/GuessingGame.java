// Exercise 12.14 Guessing game
package Chapter_twelve;
import java.security.SecureRandom;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GuessingGame extends JFrame {
  
  public final JPanel panel;
  public final JTextField textField;
  public final JLabel[] displays;

  public GuessingGame () {

    super("Guessing Game");
    setLayout(new FlowLayout());

    panel = new JPanel(new GridLayout());
  }
}
