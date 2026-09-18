// calculator layout Exercise 12.9 without any functionality
package Chapter_twelve;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


public class CalculatorFrame extends JFrame {

  private final JTextField display; // for the calculator screen
  private final JButton[] buttons;
  private final JPanel mainPanel;
  private final JPanel keys;
  private final String[] names = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
  
  public CalculatorFrame() {

    super("Calculator");
    setLayout(new BorderLayout(0,10));

    

//    GridBagConstraints gbc = new GridBagConstraints();
  //  gbc.insets = new Insets(4, 4, 4, 4);

    display = new JTextField(20);
    keys = new JPanel();
    buttons = new JButton[16];
    mainPanel = new JPanel(new BorderLayout(8,8));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    keys.setLayout(new GridLayout(4, 4,10,10));
    
    for (int i = 0; i < names.length; i ++) {

      buttons[i] = new JButton(names[i]);
      keys.add(buttons[i]);

    }


    mainPanel.add(display, BorderLayout.NORTH);
    mainPanel.add(keys, BorderLayout.CENTER);

  

    add(mainPanel);

  }

  public static void main(String[] args) {

    CalculatorFrame calculator = new CalculatorFrame();
    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculator.setSize(200, 300);
    calculator.setVisible(true);
    
  }
  
}
