package Chapter_twelve;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

// Import all required event listeners and events explicitly
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class EventDisplayTracker extends JFrame implements ActionListener, ItemListener, ListSelectionListener, KeyListener, MouseListener, MouseMotionListener {
  
  // Gui component.
  private final JTextField textField;
  private final JCheckBox checkBox;
  private final JList<String> sampleList;

  public EventDisplayTracker () {

    super("GUI EVent Display Tracker");
    setLayout(new FlowLayout());

    // set up components
    add(new JLabel("Type/Press Enter: "));

    // set up components for ActionListener and KeyListener
    textField = new JTextField(10);
    add(textField);

    // set up component for ItemListener
    checkBox = new JCheckBox("Check Me");
    add(checkBox);

    // setup component for ListSelectionListener
    String[] items = {"Option A", "Option B", "Option C"};
    sampleList = new JList<>(items);
    add(new JScrollPane(sampleList));

    // register all listeners to this windows/components
    textField.addActionListener(this);
    textField.addKeyListener(this);
    checkBox.addItemListener(this);

    sampleList.addListSelectionListener(this);

    // register mouse listener on the JFrame window itself
    addMouseListener(this);
    addMouseMotionListener(this);

  }

  // action listener method
  @Override 
  public void actionPerformed(ActionEvent e) {

    System.out.println("--- ActionEvent Triggered ---");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void itemStateChanged(ItemEvent e) {

    System.out.println("--- ItemEvent Triggered ---");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {

    // getValueIsAdjusting ensures we only print once per selection click

    if (!e.getValueIsAdjusting()) {

      System.out.println("--- ListSelectionEVent Triggered ---");
      System.out.println(e.toString() + "\n");
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {

    System.out.println("--- KeyEVent (Pressed) Triggered ---");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void keyReleased(KeyEvent e) {

    System.out.println("--- KeyEvent (Released) Triggered ---");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void keyTyped(KeyEvent e) {

    System.out.println("--- KeyEvent (Typed) Triggered ---");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void mousePressed(MouseEvent e) {

    System.out.println("--- MouseEvent (Pressed) Triggered");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void mouseReleased(MouseEvent e) {

    System.out.println("--- MouseEvent (Released) Triggered ---");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void mouseEntered(MouseEvent e) {

   System.out.println("--- MouseEvent (Entered Window) Triggered ---");
   System.out.println(e.toString() + "\n");
  }

  @Override
  public void mouseExited(MouseEvent e) {

    System.out.println("--- MouseEvent (Exited Window) Triggered");
    System.out.println(e.toString() + "\n");
    System.out.println(e.toString() + "\n");
  }

  @Override
  public void mouseMoved(MouseEvent e) {

    System.out.println("--- MouseEvent (Mouse Moved) Triggered");
    System.out.println(e.toString() + "\n");

  }

  @Override 
  public void mouseClicked(MouseEvent e) {

    System.out.println("--- mouseEvent (Mouse Clicked ) Triggered");
    System.out.println(e.toString() + "\n");
  }

  @Override 
  public void mouseDragged(MouseEvent e) {

    System.out.println("--- mouseEvent (Mouse Dragged) Triggered");
  }


  public void main(String[] args) {

    EventDisplayTracker app = new EventDisplayTracker();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setSize(400, 300);
    app.setVisible(true);

  }
}
