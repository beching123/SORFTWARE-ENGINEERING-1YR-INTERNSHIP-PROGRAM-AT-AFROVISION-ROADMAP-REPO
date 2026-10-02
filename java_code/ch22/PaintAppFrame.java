// JFrame subclass DrawFrame.java tha will
//provide the GUI of our drawPanel
package java_code.ch22;

// importing classes which will be used
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java_code.ch12.DrawPanel;

public class PaintAppFrame extends JFrame {

  // instance variable that comprises of all the component that
  // will be visible in our frame
  private final JButton undoButton;
  private final JButton clearButton;
  private final JButton colors;
  private final JComboBox<String> shapeType;
  private final JCheckBox filledShape;
  private final DrawPanel panel;
  private final JPanel componentPanels;
  private final JLabel label;
  private MyColorChooser clr; // class referencing the color chooser i built
  private JFrame temp; // frame in which the color chooser will be embeded in

  /*
   * private final String[] colorsPalette = {"Black", "Blue", "Cyan", "Dark Gray",
   * "Gray", "Green","Light Gray", "Magenta", "Orange", "Pink", "Red", "White",
   * "Yellow"};
   * 
   * private final Color[] colorsChoice = {Color.BLACK, Color.BLUE, Color.CYAN,
   * Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
   * Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW };
   */

  // list of available shapes
  private final String[] shapeTypes = { "Line", "Rectangle", "Oval" };

  // constructor
  public PaintAppFrame() {
    super("Rexzy's Mini Drawing application ");

    // setting the layout of the application
    setLayout(new BorderLayout());

    // instancing the instance variables
    label = new JLabel("(0 0)");
    panel = new DrawPanel(label);
    clearButton = new JButton("Clear");
    undoButton = new JButton("Undo");
    filledShape = new JCheckBox("Filled");
    colors = new JButton("Colors");
    shapeType = new JComboBox<String>(shapeTypes);
    clr = new MyColorChooser(panel); // reference tothe color chooser i built
    temp = new JFrame("Color Chooser"); // will be used to embed the color chooser

    // component at the top north panel
    componentPanels = new JPanel(new FlowLayout());
    componentPanels.add(undoButton);
    componentPanels.add(clearButton);
    componentPanels.add(colors);
    componentPanels.add(shapeType);
    componentPanels.add(filledShape);

    // putting everything together
    add(componentPanels, BorderLayout.NORTH);
    add(panel, BorderLayout.CENTER);
    add(label, BorderLayout.SOUTH);

    // making the color chooser sup application visible inorder
    // for the user to select and choose their color
    colors.addActionListener(new ActionListener() {

      // method that handles the change by making the application visible or not
      @Override
      public void actionPerformed(ActionEvent e) {

        // setting up the frame that will be visible to the user to choose their color
        temp.add(clr);
        temp.setSize(400, 450);
        temp.setLocation(165, 100);

        // the colors button will be used to both, make the color chooser visible
        // and to make it invisible when clicked , vise versa, and this if handles that
        if (temp.isVisible()) {
          temp.setVisible(false);
        } else {
          temp.setVisible(true);
        }

      }

    });

    // used to remove a shape or undo the recent shape drawned
    undoButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        panel.clearLastShape();
      }
    });

    // clears all the shapes on the panel
    clearButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        panel.clearDrawing();
      }
    });

    // use to get the shape which is currently selected by the user
    shapeType.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        int index = shapeType.getSelectedIndex();
        panel.setShapeType(index);

      }
    });

    // used to determine if the shape will be filled or not with the current color
    filledShape.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        if (filledShape.isSelected())
          panel.setFillShape(true);
        else
          panel.setFillShape(false);

      }
    });
  }
} // end of class PaintAppFrame