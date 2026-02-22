// Optional GUI for chapter 3.

//Using JOptionPane to display multiple lines in a dialog box

import javax.swing.JOptionPane;

public class ChapterThreeGUI {
  
  public static void main(String[] args){

    //prompt the user to enter name
    String name = JOptionPane.showInputDialog("What is your name?");

    //create the message
    String message = String.format("Welcome, %s, to Java Programming!", name);

    //display a message to welcome the user by name
    JOptionPane.showMessageDialog(null, message);
  }
}
