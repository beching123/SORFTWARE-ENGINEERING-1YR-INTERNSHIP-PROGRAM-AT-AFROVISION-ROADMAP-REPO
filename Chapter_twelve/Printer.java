// exercise 12.10 Printer.java
package Chapter_twelve;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class Printer extends JFrame {
  
  private final JPanel[] panels;
  private final JRadioButton[] radioButtons;
  private final JButton[] buttons;
  private final JCheckBox[] checkBoxes;
  private final JComboBox <String>comboBox;
  private final JTextField[] textFields;
  private final JTextArea[] labels;
  private final String[] quality = {"High","Medium", "Low"};
  

  public Printer() {

    super("Printer");
    setLayout(new FlowLayout());


    // initializing properties
    panels = new JPanel[8];
    radioButtons = new JRadioButton[3];
    checkBoxes = new JCheckBox[4];
    buttons = new JButton[4];
    comboBox = new JComboBox<String>(quality);
    textFields = new JTextField[3];
    labels = new JTextArea[2];

    // text 
    labels[0] = new JTextArea();
    labels[1] = new JTextArea();
    labels[0].setText("Printer: My Printer");
    labels[1].setText("Print Quality");
    labels[0].setEnabled(false);
    labels[1].setEnabled(false);
    labels[0].setDisabledTextColor(Color.BLACK);
    labels[1].setDisabledTextColor(Color.BLACK);

    // firstInnermost panel
    panels[0] = new JPanel(new GridLayout(1, 5));
    textFields[0] = new JTextField(4);
    
    checkBoxes[0] = new JCheckBox("Image");
    checkBoxes[1] = new JCheckBox("Text");
    checkBoxes[2] = new JCheckBox("Code");

    // sub innermost panel 1
    panels[1] = new JPanel(new GridLayout(3, 1));
    panels[1].add(checkBoxes[0]);
    panels[1].add(checkBoxes[1]);
    panels[1].add(checkBoxes[2]);

    // textfield 2
    textFields[1] = new JTextField(2);

    // sub inner most panel 2
    panels[2] = new JPanel(new GridLayout(3, 1));
    radioButtons[0] = new JRadioButton("Selection");
    radioButtons[1] = new JRadioButton("All");
    radioButtons[2] = new JRadioButton("Applet");

    panels[2].add(radioButtons[0]);
    panels[2].add(radioButtons[1]);
    panels[2].add(radioButtons[2]);

    // textField 3
    textFields[2] = new JTextField(4);

    panels[0].add(textFields[0]);
    panels[0].add(panels[1]);
    panels[0].add(textFields[1]);
    panels[0].add(panels[2]);
    panels[0].add(textFields[2]);

    // inner most panels 2
    panels[3] = new JPanel(new FlowLayout());
    checkBoxes[3] = new JCheckBox("Print to File");

    panels[3].add(labels[1]);
    panels[3].add(comboBox);
    panels[3].add(checkBoxes[3]);

    // panel 4 for buttons
    panels[4] = new JPanel(new GridLayout(4, 1, 3, 5));
    buttons[0] = new JButton("Ok");
    buttons[1] = new JButton("Cancel");
    buttons[2] = new JButton("Setup...");
    buttons[3] = new JButton("Help");

    panels[4].add(buttons[0]);
    panels[4].add(buttons[1]);
    panels[4].add(buttons[2]);
    panels[4].add(buttons[3]);


    // sub main panel 1
    panels[5] = new JPanel(new GridLayout(3, 1));
    panels[7] = new JPanel(new FlowLayout());
    panels[7].add(labels[0]);

    panels[5].add(panels[7]);
    panels[5].add(panels[0]);
    panels[5].add(panels[3]);

    // main panel for all our panels
    panels[6] = new JPanel(new FlowLayout());

    // final coupling
    panels[6].add(panels[5]);
    panels[6].add(panels[4]);

    add(panels[6]);

  }

  public static void main(String[] args) {

    Printer printer = new Printer();
    printer.setDefaultCloseOperation(EXIT_ON_CLOSE);
    printer.setSize(400, 200);
    printer.setVisible(true);

  }

}
