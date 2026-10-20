package java_code.ch23;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;

import java.security.SecureRandom;

public class Ball {

    // coordinates
    private int x;
    private int y;

    // random generator
    SecureRandom generator = new SecureRandom();

    // color
    Color color;

    // constructor
    public Ball(int x, int y) {

        this.x = (x < 0) ? 0: x;
        this.y = (y < 0) ? 0: y;

      

    }

    // draw method that draws the shape
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g; // using 2d graphics

        // setting the color
        g2d.setPaint(color);

        // drawing
        g2d.fill(new Ellipse2D.Double(x, y, 20, 20));
    }

    // setting x
    public void setX(int x) {

        this.x = x;
    }

    // setting y
    public void setY(int y) {

        this.y = y;
    }


    
}



