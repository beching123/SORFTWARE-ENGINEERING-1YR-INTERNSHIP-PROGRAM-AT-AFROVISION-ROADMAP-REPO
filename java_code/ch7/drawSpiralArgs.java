// optional gui 
// drawing rectangle spiral
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;


public class drawSpiralArgs  extends JPanel {
 
    public drawSpiralArgs () {

    setBackground(Color.WHITE); // set the background to white

  }
  
  public void paintComponent(Graphics g) {

    super.paintComponent(g); 

    int x = getWidth() / 2;
    int y = getHeight() / 2;

    int width = 20;
    int height = 20;
    int arcStep = 20;

    for (int i = 0; i < 10; i ++) {

      if (i % 2 == 0){
        g.drawArc(x, y, width, height, 0, 180);

        x -= arcStep;
        width += arcStep;
        height += arcStep;

      } else {
        y -= arcStep;
        g.drawArc(x, y, width, height, 180, 180);

        width += arcStep;
        height += arcStep;
      }
    }
  }
}

