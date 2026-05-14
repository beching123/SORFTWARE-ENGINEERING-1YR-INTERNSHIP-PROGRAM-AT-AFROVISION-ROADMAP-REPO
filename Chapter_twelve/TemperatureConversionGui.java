// Temperature Conversion GUI program
package Chapter_twelve;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;



public class TemperatureConversionGui extends JFrame {


  private final JLabel[] display;
  private final JTextField textField;
  private final JTextField textField2;
  private final JPanel panel;
  private final JButton submit;
  private String temp;
  private double convertedTemp;


  public TemperatureConversionGui() {

    super("Fahrenheit to Celsius");
    setLayout(new FlowLayout());

    display = new JLabel[3];
    textField = new JTextField();
    panel = new JPanel(new GridLayout(6, 1, 10, 10));
    submit = new JButton("Submit");
    textField2 = new JTextField();

    display[0] = new JLabel("Enter Your temperature: ");
    display[1] = new JLabel("Result: 0.0c");
    display[2] = new JLabel("Enter 1 to convert\n celsius and 2 for kelvin");

    panel.add(display[0]);
    panel.add(textField);
    panel.add(display[2]);
    panel.add(textField2);
    panel.add(submit);
    panel.add(display[1]);

    submit.addActionListener(
      new ActionListener() // anonymous inner class
      {

        // handle button event
        @Override 
        public void actionPerformed(ActionEvent event) {

          // collect the temperature from the textfield
          temp = textField.getText();
          String choice = textField2.getText();

          if (Integer.parseInt(choice) == 1) {

            convertedTemp =  FahrenheitToCelsius(temp);

            display[1].setText(String.format("Result in celsius: %,.2fc", convertedTemp));

          }
          
          else {

            convertedTemp =  CelsiusToKelvin(temp);

            display[1].setText(String.format("Result in kelvin: %,.2fc", convertedTemp));
            
          }
        }
      }
    );

   

    add(panel);

  }

  public double FahrenheitToCelsius(String temp) {
    
    return ( (5-0 / 9.0) * ( Double.parseDouble(temp)- 32));

  }

  public double CelsiusToKelvin(String temp) {
    
    return FahrenheitToCelsius(temp)  + 275.15;

  }
  
  public static void main(String[] args) {

  

    TemperatureConversionGui temp0 = new TemperatureConversionGui();
    temp0.setDefaultCloseOperation(EXIT_ON_CLOSE);
    temp0.setSize(200, 200);
    temp0.setVisible(true);

  }
}
