// Exercise 22.7 CircleAndAttributes.java
// Program displays a circle and its attributes.
package java_code.ch22;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import  java.awt.BorderLayout;

import javax.swing.JFrame;

//import java.awt.Dimension;

public class CircleAndAttributes extends JFrame {

    // instance variables.
    private DrawCircle circle;
    private JTextArea textArea;
    private JSlider slider;
    private JPanel container;

    // constructor
    public CircleAndAttributes() {

        // calling the parent constructor

        super("Circle and it's Attribute");
        setLayout(new BorderLayout());

        // initializing our variables
        circle = new DrawCircle();
        circle.setBackground(Color.YELLOW);

        // text area to display the variables involved in a circle
        textArea = new JTextArea();
        calculateValues(5);

        // slider to show and take in new values for different circle sizes
        slider = new JSlider(SwingConstants.VERTICAL, 10, 300, 30);

        // container to combine the circle panel and the slider
        container = new JPanel();
        container.setLayout(new GridLayout());
        container.add(circle);
        container.add(slider);


        // handling events for slider
        slider.addChangeListener(
            new ChangeListener() {
                
                // method that handles the event
                @Override  
                public  void  stateChanged(ChangeEvent e) {

                    int radius = slider.getValue();
                    circle.setdiameter(2 * radius); // setting our new diameter

                    calculateValues(radius); // to calculate our values 
                }
            }
        );

        add(container, BorderLayout.CENTER);
        add(textArea, BorderLayout.NORTH);

    }

    // calculating new values for our variables
    public  void calculateValues(int radius) {

        int diameter = 2 * radius;
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        textArea.setText(String.format("Diameter: %d%nArea: %.2f%nCircumference: %.2f", diameter, area, circumference));
    }


    public static void main(String[] args) {
        
        CircleAndAttributes test = new CircleAndAttributes();
        test.setSize(500, 500);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }
}

// helper class that helps in the drawing of the circle.
class DrawCircle extends JPanel {

    // diameter of our circle
    private int diameter;

    // overloaded constructor 1, default constructor for default value
    public DrawCircle() {

        this(10);
    }

    // overloaded constructor 2, that set the value of the diameter
    public DrawCircle(int diameter) {

        this.diameter = diameter;
    }

    // set method that sets the diameter
    public void setdiameter(int diameter) {

        this.diameter = diameter;
        repaint();
    }

    // method that does the actual drawing
    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        super.paintComponent(g); // calls the parent method
        g.fillOval(10, 10, diameter, diameter);
    }
}
