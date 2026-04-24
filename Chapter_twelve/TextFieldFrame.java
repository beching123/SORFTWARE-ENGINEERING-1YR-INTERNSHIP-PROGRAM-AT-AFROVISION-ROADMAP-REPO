package Chapter_twelve;
// Fig. 12.9:  TextFieldFrame.java;
// JTextFields and JPasswordFields.

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame {
  
  private final JTextField textField1; // text field with set size
  private final JTextField textField2; // text filed with text
  private final JTextField textField3; // text field with text and size
  private final JPasswordField passwordField; // password field with text

  // TextFieldFrame constructor adds JTextFields to JFrame
  public TextFieldFrame() {

    super("Testing JTextField and JPassword");
    setLayout(new FlowLayout());

    // constructor text field with 10 columns
    textField1 = new JTextField(10); 
    add(textField1); // add textField1 to JFrame

    // constructor text field with default text
    textField2 = new JTextField("Enter text here");
    add(textField2); // add textField2 to JFrame

    // construct text field with default text and 21 columns
    textField3 = new JTextField("Enter text here");
    textField3.setEditable(false); // disable editing
    add(textField3); // add textField3 to JFrame

    // construct password field with default text
    passwordField = new JPasswordField("Hidden text");
    add(passwordField); // add passwordField to JFrame

    // register event handlers
    TextFieldHandler handler = new TextFieldHandler();
    textField1.addActionListener(handler);
    textField2.addActionListener(handler);
    textField3.addActionListener(handler);
    passwordField.addActionListener(handler);

  }

  // private inner class for event handling
  private class TextFieldHandler implements ActionListener {

    // process test field events
    @Override
    public void actionPerformed(ActionEvent event) {

      String string = "";

      // user pressed Enter in JTextField textField1
      if (event.getSource() == textField1) 
        string = String.format("textField1: %s", event.getActionCommand());

      // user pressed Enter in JTextField textField2
      else if (event.getSource() == textField2) 
        string = String.format("textField2: %s", event.getActionCommand());

      // user pressed Enter on tJFrame textField3
      else if (event.getSource() == textField3) 
        string = String.format("textField3: %s", event.getActionCommand());

      //user pressed Enter in JTextField passwordField
      else if (event.getSource() == passwordField) 
        string = String.format("passwordField: %s", event.getActionCommand());

      // display JTextField counter
      JOptionPane.showMessageDialog(null, string);
    }
  } // end private inner class TextFieldHandler
} // end class TextField 
