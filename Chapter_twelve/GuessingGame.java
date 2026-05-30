// Exercise 12.14 Guessing game
package Chapter_twelve;

import java.security.SecureRandom;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GuessingGame extends JFrame implements ActionListener{
  
  private SecureRandom randomNumber;
  private int randNumber;
  private int lastDistance;
  //private final JPanel panel;
  private final JTextField textField;
  private final JLabel promptLabel;
  private final JLabel feedbackLabel;
  private final JButton retryButton;

  public GuessingGame () {

    super("Guessing Game");
    
    setLayout(new FlowLayout());

    randomNumber = new SecureRandom();
    randNumber = randomNumber.nextInt(1000) + 1;
    lastDistance = -1;

    promptLabel = new JLabel("I have a number between 1 to 1000. Can you guess my number? Please enter your first guess.");
    feedbackLabel = new JLabel("Enter a number to start playing!");
    textField = new JTextField(10);
    retryButton = new JButton("Play Again");


    textField.addActionListener(this);
    retryButton.addActionListener(this);
  

    add(promptLabel);
    add(textField);
    add(feedbackLabel);
    add(retryButton);

  }

  @Override 
  public void actionPerformed(ActionEvent e) {

    // check if the user clicked the "play again button"
    if (e.getSource() == retryButton) {

      SecureRandom random = new SecureRandom();
      randNumber = randomNumber.nextInt(1000) + 1;
      lastDistance = -1;

      feedbackLabel.setText("Enter a number to start Playing!");
      textField.setText("");
      textField.setEditable(true);
      getContentPane().setBackground(null);
    }

    else if (e.getSource() == textField) {

      try {
        int currentGuess = Integer.parseInt(textField.getText());
        int currentDistance = Math.abs(currentGuess - randNumber);

        if (currentGuess == randNumber) {

          feedbackLabel.setText("Correct!");

          textField.setEditable(false);
          getContentPane().setBackground(Color.GREEN);

        } else {

          if (currentGuess > randNumber) {
            feedbackLabel.setText("Too High!");
          }

          else {
            feedbackLabel.setText("Too Low!");
          }

          if (lastDistance != -1) {
            
            if (currentDistance < lastDistance) {

              getContentPane().setBackground(Color.RED);
            }

            else if (currentDistance > lastDistance) {
              getContentPane().setBackground(Color.BLUE);
            }
          }

          lastDistance = currentDistance;
        }
      }

      catch(NumberFormatException ex) {
        feedbackLabel.setText("Please Enter a valid integer!");
      }
    }  
  }

  public static void main(String[] args) {

    GuessingGame guessingGame = new GuessingGame();
    guessingGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    guessingGame.setSize(700, 150);
    guessingGame.setVisible(true);
  }
}
