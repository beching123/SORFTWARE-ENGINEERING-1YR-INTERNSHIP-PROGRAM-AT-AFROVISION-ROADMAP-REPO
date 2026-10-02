package java_code.ch23;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ball3DDemo extends JPanel {

    // Ball attributes
    private final int x;
    private final int y;
    private final int diameter = 100;
    private final int radius = diameter / 2;
    private final Color baseColor = new Color(220, 00, 250); // Crimson red

    public Ball3DDemo(int x, int y) {

        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(400, 350));
        setBackground(new Color(240, 240, 240));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 1. Enable Anti-Aliasing for smooth 3D curves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // --- DRAW THE FLOOR SHADOW ---
        int shadowY = 250; // Floor line position
        int shadowWidth = 110;
        int shadowHeight = 25;
        int shadowX = x + radius - (shadowWidth / 2);

        // Soft, semi-transparent gradient for the shadow
        Point2D shadowCenter = new Point2D.Float(shadowX + shadowWidth / 2f, shadowY + shadowHeight / 2f);
        float[] shadowDist = { 0.0f, 1.0f };
        Color[] shadowColors = { new Color(0, 0, 0, 120), new Color(0, 0, 0, 0) }; // Dark center to transparent edge

        RadialGradientPaint shadowPaint = new RadialGradientPaint(shadowCenter, shadowWidth / 2f, shadowDist,
                shadowColors);

        g2d.setPaint(shadowPaint);
        g2d.fillOval(shadowX, shadowY, shadowWidth, shadowHeight);

        // --- DRAW THE 3D BALL ---
        // Light source comes from top-left offset (0.65 * radius)
        Point2D highlightCenter = new Point2D.Float(x + (radius * 0.65f), y + (radius * 0.65f));

        float[] ballDist = { 0.0f, 0.75f, 1.0f };
        Color[] ballColors = { Color.WHITE, // Specular highlight (top-left)
                baseColor, // Core ball color
                baseColor.darker().darker() // Deep shadow (bottom-right edge)
        };

        RadialGradientPaint ballPaint = new RadialGradientPaint(highlightCenter, radius * 1.1f, ballDist, ballColors);

        g2d.setPaint(ballPaint);
        g2d.fillOval(x, y, diameter, diameter);

        // --- OPTIONAL: GLOSSY SHINE SPOT ---
        // Draws a small soft white highlight curve near the top-left edge
        g2d.setColor(new Color(255, 255, 255, 90)); // Semi-transparent white
        g2d.fillOval(x + (int) (radius * 0.4), y + (int) (radius * 0.3), (int) (radius * 0.5), (int) (radius * 0.3));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("3D Sphere Renderer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.addMouseListener(new MouseAdapter() {

                // implementing the parent mouseClicked method
                @Override
                public void mouseClicked(MouseEvent e) {

                    frame.add(new Ball3DDemo(e.getX(), e.getY()));
                    frame.pack();
                }
            });

        });
    }
}