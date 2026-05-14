package Chapter_twelve;
// exercise 12.8 providing the GUI for alignment
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AlignFrame extends JFrame {
  
 
  private final JPanel leftPanel; // for left panel
  private final JPanel centerPanel; // for the center panel
  private final JPanel rightPanel; // for the right panel
  private final JCheckBox snapToGrid; // for the first check box
  private final JCheckBox showGrid; // for the next checkbox
  private final JTextField[] textField;
  private final JPanel[] subCenterPanel;
  private final JButton[] buttons;
  private final String[]   names = {"Ok", "Cancel", "Help"};
  private final JLabel[] jLabel;
  private final JPanel masterPanel;



  public AlignFrame () {

    super("Align");

    masterPanel = new JPanel();
    textField = new JTextField[2];
    subCenterPanel = new JPanel[2];
    jLabel = new JLabel[2];
    buttons = new JButton[3];
    leftPanel = new JPanel();
    centerPanel = new JPanel();
    rightPanel = new JPanel();
    jLabel[0] = new JLabel("X: ");
    jLabel[1] = new JLabel("Y: "); 
    snapToGrid = new JCheckBox("Snap to Grid");
    showGrid = new JCheckBox("Show Grid");
    textField[0] = new JTextField(5);
    textField[1] = new JTextField(5);
  
    

    // add the checkbox to the left panel
    leftPanel.add(snapToGrid);
    leftPanel.add(showGrid);
    leftPanel.setLayout(new GridLayout(2, 1));
    

    // add the components to the center panel
    subCenterPanel[0] = new JPanel();
    subCenterPanel[1] = new JPanel();
    subCenterPanel[0].add(jLabel[0]);
    subCenterPanel[1].add(jLabel[1]);
    subCenterPanel[0].add(textField[0]);
    subCenterPanel[1].add(textField[1]);
    centerPanel.add(subCenterPanel[0]);
    centerPanel.add(subCenterPanel[1]);
    centerPanel.setLayout(new GridLayout(2,1));
  

    // adding to the right
    for (int count = 0; count < buttons.length; count ++) {
      
      buttons[count] = new JButton(names[count]);
      rightPanel.add(buttons[count]);

    }

    rightPanel.setLayout(new GridLayout(3, 1, 10, 10));


    // adding all the components to the general panel
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    masterPanel.setLayout(new GridBagLayout());
    masterPanel.add(leftPanel, gbc);
    masterPanel.add(centerPanel,gbc);
    masterPanel.add(rightPanel,gbc);

    add(masterPanel);
    

  }

  public static void main(String[] args) {

    AlignFrame alignFrame = new AlignFrame();
    alignFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    alignFrame.setSize(400, 200);
    alignFrame.setVisible(true);

  }
}
