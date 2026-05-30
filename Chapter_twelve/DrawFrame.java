// JFrame subclass DrawFrame.java tha will
//provide the GUI of our drawPanel
package Chapter_twelve;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class DrawFrame extends JFrame {

  private final JButton undoButton;
  private final JButton clearButton;
  private final JComboBox<String> colors;
  private final JComboBox<String> shapeType;
  private final JCheckBox filledShape;
  private final DrawPanel panel;
  private final JPanel componentPanels;
  private final JLabel label;

  private final String[] colorsPalette = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green","Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};

  private final Color[] colorsChoice = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW }; 

  private final String[] shapeTypes = {"Line", "Rectangle", "Oval"};

  public DrawFrame () {
    super("Rexzy's Mini Drawing application ");

    setLayout(new BorderLayout());

    label = new JLabel("(0 0)");
    panel = new DrawPanel(label);
    clearButton = new JButton("Clear");
    undoButton = new JButton("Undo");
    filledShape = new JCheckBox("Filled");
    colors = new JComboBox<String>(colorsPalette);
    shapeType = new JComboBox<String>(shapeTypes);

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



    colors.addActionListener(
      new ActionListener () {

        @Override 
        public void actionPerformed(ActionEvent e) {

          int index = colors.getSelectedIndex();
          panel.setCurrentColor(colorsChoice[index]);

        }
    });

    undoButton.addActionListener(
      new ActionListener () {

        @Override
        public void actionPerformed (ActionEvent e) {
        
          panel.clearLastShape();
      }
    });

    clearButton.addActionListener(
      new ActionListener () {

        @Override 
        public void actionPerformed(ActionEvent e) {

          panel.clearDrawing();
        }
    });

    shapeType.addActionListener(
      new ActionListener() {

        @Override 
        public void actionPerformed(ActionEvent e) {

          int index = shapeType.getSelectedIndex();
          panel.setShapeType(index);
          
    
        }
      });

    filledShape.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          if (filledShape.isSelected())
            panel.setFillShape(true);
          else 
            panel.setFillShape(false);

        }
    });
  }
}


