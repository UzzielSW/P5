// Exercise12_16.java: Display a pie chart
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise12_16 extends JApplet implements ActionListener {
  RectPanel rectPanel =  new RectPanel();
  OvalsPanel ovalPanel = new OvalsPanel();
  ArcsPanel arcPanel = new ArcsPanel();
  PolygonsPanel polygonPanel = new PolygonsPanel();

  // Selection buttons
  JButton jbtRect = new JButton("Show Rectangle");
  JButton jbtOval = new JButton("Show Oval");
  JButton jbtArc = new JButton("Show Arc");
  JButton jbtPolygon = new JButton("Show Polygon");

  // Create a CardLayout manager
  CardLayout cardLayout = new CardLayout();
  private JPanel cardPanel = new JPanel();

  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise 12.16");

    // Create an instance of the applet
    Exercise12_16 applet = new Exercise12_16();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void init() {
    JPanel p = new JPanel();
    p.add(jbtRect);
    p.add(jbtOval);
    p.add(jbtArc);
    p.add(jbtPolygon);

    cardPanel.setLayout(cardLayout);
    cardPanel.add(rectPanel, "rect");
    cardPanel.add(ovalPanel, "oval");
    cardPanel.add(arcPanel, "arc");
    cardPanel.add(polygonPanel, "polygon");

    getContentPane().add(cardPanel, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    jbtRect.addActionListener(this);
    jbtOval.addActionListener(this);
    jbtArc.addActionListener(this);
    jbtPolygon.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtRect)
      cardLayout.show(cardPanel, "rect");
    else if (e.getSource() == jbtOval)
      cardLayout.show(cardPanel, "oval");
    else if (e.getSource() == jbtArc)
      cardLayout.show(cardPanel, "arc");
    else if (e.getSource() == jbtPolygon)
      cardLayout.show(cardPanel, "polygon");
  }
}