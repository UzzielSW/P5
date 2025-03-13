// Exercise10_16.java: Display a pie chart
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise10_16 extends JFrame implements ActionListener {
  RectPanel rectPanel =  new RectPanel();
  OvalsPanel ovalPanel = new OvalsPanel();
  ArcsPanel arcPanel = new ArcsPanel();
  PolygonsPanel polygonPanel = new PolygonsPanel();
  JPanel figurePanel = rectPanel;

  // Selection buttons
  JButton jbtRect = new JButton("Show Rectangle");
  JButton jbtOval = new JButton("Show Oval");
  JButton jbtArc = new JButton("Show Arc");
  JButton jbtPolygon = new JButton("Show Polygon");

  public static void main(String[] args) {
    JFrame frame = new Exercise10_16();
    frame.setSize(300, 300);
    frame.setTitle("Exercise 10.16");
    frame.setVisible(true);
  }

  public Exercise10_16() {
    getContentPane().add(figurePanel, BorderLayout.CENTER);

    JPanel p = new JPanel();
    p.add(jbtRect);
    p.add(jbtOval);
    p.add(jbtArc);
    p.add(jbtPolygon);

    getContentPane().add(p, BorderLayout.SOUTH);

    jbtRect.addActionListener(this);
    jbtOval.addActionListener(this);
    jbtArc.addActionListener(this);
    jbtPolygon.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    getContentPane().remove(figurePanel);

    if (e.getSource() == jbtRect)
      figurePanel = rectPanel;
    else if (e.getSource() == jbtOval)
      figurePanel = ovalPanel;
    else if (e.getSource() == jbtArc)
      figurePanel = arcPanel;
    else if (e.getSource() == jbtPolygon)
      figurePanel = polygonPanel;

    getContentPane().add(figurePanel);
    getContentPane().repaint();
  //  getContentPane().doLayout();
    getContentPane().validate();
  }
}