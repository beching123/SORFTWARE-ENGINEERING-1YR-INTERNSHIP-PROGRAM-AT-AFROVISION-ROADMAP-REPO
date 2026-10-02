package java_code.ch23;
// exercise 23.10 BouncingBallPanel.java

// creating a bouncing ball simulation 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class BouncingBallPanel extends JPanel {

    // instance variables for our ball class
    private ArrayList<Ball> balls = new ArrayList<>();

    // index to keep track of the number of balls
    int index = 0;

    // constructor that gets the mouseEvent
    public BouncingBallPanel() {

        addMouseListener(new MouseAdapter() {

            // handle mouse click event to draw the ball
            @Override
            public void mouseClicked(MouseEvent e) {

                // getting points drawing our ball
                if (index < 10) {
                    balls.add(new Ball(e.getX() - 10, e.getY() - 10));
                    repaint();
                }
            }
        });
    }

    // paintComponent methods to draw the ball
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // calling parent class
        for (Ball ball : balls)
            ball.draw(g);
    }

    // drawing our ball

    // update the location of the balls
    public void updateLocation() {
    }
}
