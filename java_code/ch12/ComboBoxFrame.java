package Chapter_twelve;

// Fig 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame {

  private final JComboBox<String> imagesJComboBox; // hols icon names
  private final JLabel label; // display selected icon

  private final String[] names = { "images.png", "images2.png", "images3.png", "images4.png"};

  private final Icon[] icons = {
    new ImageIcon(getClass().getResource(names[0])),
    new ImageIcon(getClass().getResource(names[1])),
    new ImageIcon(getClass().getResource(names[2])),
    new ImageIcon(getClass().getResource(names[3]))

  };

  // ComboBoxFrame constructor adds JComboBox to JFrame
  public ComboBoxFrame() {

    super("Testing JComboBox");
    setLayout(new FlowLayout()); // set frame layout

    imagesJComboBox = new JComboBox<String>(names); // set up JComboBox a JComboBox
    imagesJComboBox.setMaximumRowCount(10); // display three rows

    imagesJComboBox.addItemListener(
      new ItemListener() // anonymous inner class 
      {

        // handle JComboBox event
        @Override 
        public void itemStateChanged(ItemEvent event) {

          // determine wether item selected
          if (event.getStateChange() == ItemEvent.SELECTED) 
            label.setIcon(icons[
              imagesJComboBox.getSelectedIndex()]);
        }
      } // end anonymous inner class
    );  // end call to addItemListener

    add(imagesJComboBox); // add combo box to JFrame
    label = new JLabel(icons[0]); // display first icon
    add(label); // add label to JFrame
  }
} // end class ComboBoxFrame