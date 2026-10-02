// Exercise 22.10 JSliderAndJTextField.java
// Synchronizing a JSlider and a JTextField. 
package java_code.ch22;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Panel extends JPanel {

    // instance variable that will be drawned to the screen
    private String text;

    // constructor
    public Panel(String text) {

        this.text = text; // initialize text
    }

    // paintComponent method that does the drawing
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // calling the parent class

        g.setColor(Color.GREEN);
        g.setFont(new Font("Serif", Font.BOLD, 100));
        g.drawString(text, 30, 100);

    }

    // set text to new one
    public void setText(String text) {

        this.text = text;
        repaint();
    }
}

public class JSliderAndJTextField extends JFrame {

    // instance variable
    private Panel panel;
    private JSlider slider;
    private JTextField textField;
    private JLabel label;
    private JPanel subPanel;

    // constructor that does the working
    public JSliderAndJTextField() {

        super("JSlider and JTextField"); // parent constructor
        setLayout(new GridLayout(3, 1));

        // initialize variables
        panel = new Panel("0");
        panel.setBackground(Color.BLACK);

        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 2000, 100);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);

        textField = new JTextField("0", 10);
        textField.setFont(new Font("Serif", Font.BOLD, 30));

        label = new JLabel("Enter value: ");
        label.setFont(new Font("Serif", Font.BOLD, 30));

        subPanel = new JPanel(new BorderLayout());
        subPanel.add(label, BorderLayout.NORTH);
        subPanel.add(textField, BorderLayout.CENTER);

        slider.addChangeListener(new ChangeListener() {

            // handling a change of state of slider
            @Override
            public void stateChanged(ChangeEvent e) {

                int value = slider.getValue();
                panel.setText(value + "");
                textField.setText(value + "");
            }
        });

        // handling events for the textField
        textField.addActionListener(new ActionListener() {

            // implementing inherrited method
            @Override
            public void actionPerformed(ActionEvent e) {

                String value = textField.getText();
                slider.setValue(Integer.parseInt(value));
                panel.setText(value);
            }
        });

        add(panel);
        add(slider);
        add(subPanel);

    }

    public static void main(String[] args) {

        JSliderAndJTextField test = new JSliderAndJTextField();
        test.setSize(300, 400);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}