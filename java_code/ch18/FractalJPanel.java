// Fig. 18.19: FractalJPanel.java
// Drawing the "Lo feather fractal" using recursion
package Chapter_18;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class FractalJPanel extends JPanel {

    private Color color; // stores color used to draw fractal
    private int level; // stores current level of fractals

    private static final int WIDTH = 600; // defines width of JPanel
    private static final int HEIGHT = 600; // defines height of JPanel

    // secure random to generate random numbers
    private static final SecureRandom random = new SecureRandom();

    // set the initial fractal level to the value specified
    // and set up JPanel specifications
    public FractalJPanel(int currentLevel) {

        color = Color.BLUE; // initialize drawing color to blue
        level = currentLevel; // set initial fractal level
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    // draw fractal recursively
    public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g) {

        // base case: draw a line connecting two given points
        if (level == 0)
            g.drawLine(xA, yA, xB, yB);
        else // recursion step: dtermine new points, draw next level
        {
            // calculate the midpoint between (xA, yA) and (xB, YB)
            int xC = (xA + xB) / 2;
            int yC = (yA + yB) / 2;

            // calculate the fourth point (xD, yD) whihc forms an
            // isosceles right triangle between (xA, yA) and (xC, yC)
            // where the right angle is at (xD, yD)
            int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
            int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

            // recursively draw the Fractal
            drawFractal(level - 1, xD, yD, xA, yA, g);
            drawFractal(level - 1, xD, yD, xC, yC, g);
            drawFractal(level - 1, xD, yD, xB, yB, g);

        }
    }

    // start drawing the fractal
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw fractal pattern 1
        for (int i = 0; i <= 600; i += 60) {

            g.setColor(getColor());
            g.drawLine(i, 0, i, 600);
            g.drawLine(0, i, 600, i);

        }

        // first line
        g.setColor(getColor());
        drawFractal(level, 300, 300, 120, 430, g);

        // second line
        g.setColor(getColor());
        drawFractal(level, 300, 300, 120, 250, g);

        // third line
        g.setColor(getColor());
        drawFractal(level, 300, 300, 490, 430, g);

        // fourth line
        g.setColor(getColor());
        drawFractal(level, 300, 300, 470, 190, g);

        // five line
        g.setColor(getColor());
        drawFractal(level, 300, 300, 300, 160, g);
    }

    // set the drawing color to c
    public void setColor() {

        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    }

    // getting color
    public Color getColor() {

        setColor();
        return color;
    }

    // set the new level to recursion
    public void setLevel(int currentLevel) {
        level = currentLevel;
    }

    // returns level of recursion
    public int getLevel() {
        return level;
    }
} // end class FractalJPanel
