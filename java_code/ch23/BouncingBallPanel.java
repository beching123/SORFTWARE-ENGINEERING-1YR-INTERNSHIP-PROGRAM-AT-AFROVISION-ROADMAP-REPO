package java_code.ch23;
// exercise 23.10 BouncingBallPanel.java

// creating a bouncing ball simulation 
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class BouncingBallPanel extends JPanel {

    // instance variables for our ball class
    private ArrayList<Ball3DDemo> balls = new ArrayList<>();

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
                    int x = e.getX();
                    int y = e.getY();

                    int xPosition = x - 20;
                    int yPostion = y - 20;
                    balls.add(new Ball3DDemo(xPosition, yPostion));
                    repaint();
                }
            }
        });
    }

    // paintComponent methods to draw the ball
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // calling parent class
        for (Ball3DDemo ball : balls)
            ball.draw(g);
    }

    // drawing our ball

    // update the location of the balls
    public void updateLocation() {
    }
}
