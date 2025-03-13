package guiprogramming;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class JSliderDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    JPanel topPanel = new JPanel(new BorderLayout());
    final JTextField textField = new JTextField();
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 4);
    slider.setMinorTickSpacing(1);
    slider.setMajorTickSpacing(5);
    slider.setPaintLabels(true);
    slider.setPaintTicks(true);
    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        int value =  ((JSlider) e.getSource()).getValue();
        textField.setText("Your rating is " + value);
      }
    });
    topPanel.add(slider, BorderLayout.CENTER);
    topPanel.add(new JLabel("Rate the ice cream on a scale of 0-10"), BorderLayout.NORTH);
    topPanel.add(textField, BorderLayout.SOUTH);
    window.setContentPane(topPanel);
    window.pack();
    window.setTitle("JSlider Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

