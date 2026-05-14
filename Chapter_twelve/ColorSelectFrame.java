// Exercise 12.10
// CalorSelectFrame.java
package Chapter_twelve;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ColorSelectFrame extends JFrame {

  private final JComboBox<String>colorList;
//private final JLabel[] labels;
  private final JCheckBox[] checkBox;
  private final JButton[] buttons;
  private final JPanel panel;
  private final JPanel centerPanel;
  private final JPanel southPanel;

   private static final String[] colorNames = {"RED", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};


  public ColorSelectFrame () {

    super("ColorSelect");
    setLayout(new BorderLayout());

    colorList = new JComboBox<String>(colorNames);
    colorList.setMaximumRowCount(1);
   

   // labels = new JLabel[2];
    //labels[0] = new JLabel("Background");
    //labels[1] = new JLabel("Foreground");

    checkBox = new JCheckBox[2];
    checkBox[0] = new JCheckBox("Background");
    checkBox[1] = new JCheckBox("Foreground");

    buttons = new JButton[2];
    buttons[0] = new JButton("Ok");
    buttons[1] = new JButton("Cancel");

    centerPanel = new JPanel();
    southPanel = new JPanel();

    centerPanel.setLayout(new FlowLayout());
    centerPanel.add(checkBox[0]);
    centerPanel.add(checkBox[1]);

    southPanel.setLayout(new FlowLayout());
    southPanel.add(buttons[0]);
    southPanel.add(buttons[1]);


    panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(colorList, BorderLayout.NORTH);
    panel.add(centerPanel, BorderLayout.CENTER);
    panel.add(southPanel, BorderLayout.SOUTH);
    add(panel);
    
  }

  public static void main(String[] args) {

    ColorSelectFrame frame = new ColorSelectFrame();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(300, 130);
    frame.setVisible(true);
    
  }
  
}
