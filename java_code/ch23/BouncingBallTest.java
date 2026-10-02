package java_code.ch23;

import javax.swing.JFrame;

public class BouncingBallTest {

    public static void main(String[] args) {

        JFrame app = new JFrame("Ball test");
        BouncingBallPanel panel = new BouncingBallPanel();
        app.add(panel);
        app.setVisible(true);
        app.setSize(500, 500);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
