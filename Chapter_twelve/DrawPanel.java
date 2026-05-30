package Chapter_twelve;
// Exercise 12.17 Interactive Drawing Application

import OPTIONAL_GUI.MyLine;
import OPTIONAL_GUI.MyOvals;
import OPTIONAL_GUI.MyRectangle;
import OPTIONAL_GUI.MyShape;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class DrawPanel  extends JPanel {
 
  // instance variables that holds various information about the shape
  private final MyShape[] shapes;
  private int shapeCount;
  private int shapeType; 
  private MyShape currentShape;
  private Color currentColor;
  private boolean filledShape;
  private final JLabel statusLabel;
  
  
  public DrawPanel () {

    shapes = new MyShape[100];
    statusLabel = new JLabel();

  }

  public DrawPanel(JLabel label) {

    shapes = new MyShape[100];
    statusLabel = label;
    shapeCount = 0;
    shapeType = 0;
    currentShape = null;
    currentColor = Color.BLACK;

    setBackground(Color.WHITE);
    MouseEventsForPanel handler = new MouseEventsForPanel();
    addMouseListener(handler);
    addMouseMotionListener(handler);

  }

  @Override 
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

  
    for (int i = 0; i < shapeCount; i ++) {

      if (shapes[i] != null)
        shapes[i].draw(g);
      
    }

    // draw current Shape
    if (currentShape != null) 
      currentShape.draw(g);
  }
  
  // set method for our shape type
  public void setShapeType (int shapeType)  {

    this.shapeType = shapeType;
    
  }

  // set method for our current Color
  public void setCurrentColor(Color currentColor) {

    this.currentColor = currentColor;
  }

  // set method for our fill shape
  public void setFillShape(boolean filledShape) {

    this.filledShape = filledShape;
  }

  // get method for label
  public String getLabel() {

    return statusLabel.getText();
  }

  // method used to clear the last shape drawn
  public void clearLastShape () {

    if (shapeCount > 0) {

      shapeCount --;
      repaint();

    }

    
  }

  // method used to remove all the shapes in the current drawing
  public void clearDrawing() {

    shapeCount = 0;
    repaint();

  }

  // private inner class to help handler mouse event
  private  class MouseEventsForPanel extends MouseAdapter   implements MouseMotionListener {

    @Override 
    public void mousePressed(MouseEvent e) {

      // create a shape based on the user input
      switch(shapeType) {

        case 0: // assume 0 = line
          currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
          break;
        
        case 1: // assume that 1 = rect

          if (filledShape == true) 
            currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, true);

          else 
            currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, false);

          break;

        case 2: // assume that 1 = Oval

          if (filledShape == true) 
            currentShape = new MyOvals(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, true);

          else 
              currentShape = new MyOvals(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, false);
          break;
      
      }
    }

    @Override 
    public void mouseReleased(MouseEvent e) {

      if (currentShape == null) return;

      Point p = e.getPoint();
      currentShape.setX2(p.x);
      currentShape.setY2(p.y);


      if (shapeCount < shapes.length) {
        shapes[shapeCount] = currentShape;
        shapeCount ++;
      }

      currentShape = null;

      repaint();
    }

    @Override 
    public void mouseMoved(MouseEvent e) {

      Point p = e.getPoint();
      statusLabel.setText(String.format("(%d %d)", p.x, p.y));

    }

    @Override 
    public void mouseDragged(MouseEvent e) {

      Point p = e.getPoint();
      currentShape.setX2(p.x);
      currentShape.setY2(p.y);

      //update status label with coordinates
      statusLabel.setText(String.format("(%d %d)", p.x, p.y));

      repaint();
    }
  }
}
