// Exercise 22.11 Creating a Color Chooser MyColorChooser.java
package java_code.ch22;

// importing packages that will be used in the jpanel
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java_code.ch12.DrawPanel;

public class MyColorChooser extends JPanel {

    // instance variables
    private JSlider[] slider;
    private JTextField[] textField;
    private JPanel[] panels;
    private JLabel[] labels;
    private Color color;
    DrawPanel drawPanel;

    // constructor
    public MyColorChooser(DrawPanel drawPanel) {
        setLayout(new GridLayout(2, 1, 5, 3));

        // initiaizing all the instance variables
        slider = new JSlider[3];
        textField = new JTextField[3];
        panels = new JPanel[5];
        labels = new JLabel[3];
        color = new Color(120, 120, 0);
        this.drawPanel = drawPanel;

        // setting up the color for our jpanel
        drawPanel.setCurrentColor(color);

        // setting up the sliders.
        setSlider(slider);

        // setting up the ui for panels, with their sliders
        // and labels
        String[] letters = { "R: ", "G: ", "B: " };

        for (int i = 0; i < 3; i++) {

            labels[i] = new JLabel(letters[i]);
            textField[i] = new JTextField(5);
            textField[i].setText("5");
            panels[i] = new JPanel(new FlowLayout());
            panels[i].add(labels[i]);
            panels[i].add(slider[i]);
            panels[i].add(textField[i]);

        }

        // setting up the general panel
        panels[3] = new JPanel(new GridLayout(3, 1));

        // putting together the values changer which comprises of
        // sliders, textArea, and a label

        panels[3].add(panels[0]);
        panels[3].add(panels[1]);
        panels[3].add(panels[2]);

        panels[3].setSize(200, 200);

        panels[4] = new JPanel();
        panels[4].setBackground(new Color(5, 5, 5));
        panels[4].setSize(100, 100);

        // handling all the events for the sliders
        sliderEventHandler(slider, panels[4], textField, drawPanel);

        // handling all the events for the textFields
        textFieldEventHandler(slider, panels[4], textField);

        // setting the ui fo the entire application together
        add(panels[4]);
        add(panels[3]);
    }

    // paintComponent
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // parent method.

    }

    // helper method to setup the sliders
    private void setSlider(JSlider[] slider) {

        for (int i = 0; i < 3; i++) {

            slider[i] = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 5);
            slider[i].setPaintTicks(true);
            slider[i].setMajorTickSpacing(5);
        }
    }

    // helper method to handle the events of the sliders
    public void sliderEventHandler(JSlider[] sliders, JPanel panel, JTextField[] textFields, DrawPanel drawPanel) {

        for (int i = 0; i < sliders.length; i++) {

            sliders[i].addChangeListener(new ChangeListener() {

                // implementing parent method.
                @Override
                public void stateChanged(ChangeEvent e) {

                    // setting up the color
                    Color clr = new Color(sliders[0].getValue(), sliders[1].getValue(), sliders[2].getValue());
                    setColor(clr); // setting up the color instance variable to the current color of the panel,
                                   // reflecting the color //created from the sliders

                    // setting up the color for the panel in which the shapes are drawned on.
                    drawPanel.setCurrentColor(clr);
                    panel.setBackground(clr);

                    // updating the textField to reflect the color fo the sliders each
                    textFields[0].setText(sliders[0].getValue() + "");
                    textFields[1].setText(sliders[1].getValue() + "");
                    textFields[2].setText(sliders[2].getValue() + "");
                }

            });
        }
    }

    // helper method to handle the events for the textFields
    public void textFieldEventHandler(JSlider[] sliders, JPanel panel, JTextField[] textFields) {

        for (int i = 0; i < textFields.length; i++) {

            textFields[0].addActionListener(new ActionListener() {

                // overriding parent method
                @Override
                public void actionPerformed(ActionEvent e) {

                    slider[0].setValue(Integer.parseInt(textFields[0].getText()));
                }
            });

            textFields[1].addActionListener(new ActionListener() {

                // overriding parent method
                @Override
                public void actionPerformed(ActionEvent e) {

                    slider[1].setValue(Integer.parseInt(textFields[1].getText()));
                }
            });

            textFields[0].addActionListener(new ActionListener() {

                // overriding parent method
                @Override
                public void actionPerformed(ActionEvent e) {

                    slider[0].setValue(Integer.parseInt(textFields[0].getText()));
                }
            });
        }
    }

    // set color
    public void setColor(Color color) {

        this.color = color;
    }

    // get color value
    public Color getColor() {

        return color;
    }

} // end class MyColorChooser