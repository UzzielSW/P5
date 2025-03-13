// Exercise16_2.java: Repaint part of the viewing area
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Exercise16_2 extends JApplet {
  public void init() {
    getContentPane().add(new TemperatureHistogram(),
      BorderLayout.CENTER);
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Exercise 16.2: Temperature Histogram");

    // Create an instance of the applet
    Exercise16_2 applet = new Exercise16_2();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(500, 200);
    frame.setVisible(true);
  }
}

class TemperatureHistogram extends JPanel implements Runnable {
  double temperature[] = new double[24];
  boolean firstTime = true;
  double newTemp;
  int current = 23;
  Thread thread = null;
  int interval, width, individualWidth, height;

  public TemperatureHistogram() {
    for (int i=0; i<temperature.length; i++)
      temperature[i] = 0; //Math.random()*40 + 50;

    thread = new Thread(this);
    thread.start();
  }

  public void paintComponent(Graphics g) {
    //super.paintComponent(g);

    width = getSize().width;
    height = getSize().height;

    interval = (width-40)/24;
    individualWidth = (int)(((width-40)/24)*0.60);

    if (firstTime) {
      firstTime = false;

      int x = 30;

      for (int i=0; i<24; i++) {
        // g.drawRect(x, height-45-(int)temperature[i], individualWidth, (int)temperature[i]);
        g.drawString(i+"", x, height-35 );
        x += interval;
      }

      FontMetrics fm = g.getFontMetrics();
      String title = "Current Time: "+new Date();
      g.drawLine(10, height-45, width-10, height-45);
      g.drawString(title, (width-fm.stringWidth(title))/2, height-20);
    }
    else {
      int previous = (current-1+24)%24;
      g.setColor(getBackground()); //Color.white);
      g.fillRect(interval*previous+30, height-45-(int)temperature[previous],
        individualWidth, (int)temperature[previous]);

      g.setColor(Color.black);
      g.drawRect(interval*previous+30, height-45-(int)temperature[previous],
        individualWidth, (int)temperature[previous]);

      g.setColor(getBackground());
      g.drawRect(interval*current+30, height-45-(int)temperature[current],
        individualWidth, (int)temperature[current]);

      g.setColor(Color.red);
      temperature[current] = newTemp;
      g.fillRect(interval*current+30, height-45-(int)temperature[current],
        individualWidth, (int)temperature[current]);
    }
  }

  public void run() {
    //simulating temperatures of 24 hours;
    while (true) {
      try {
        thread.sleep(1000);
        // It should be 1000*60*60, but for testing 1000 is used here
      }
      catch (InterruptedException e) {}

      current = (current+1)%24;
      newTemp = (int)(Math.random()*40 + 50);
      repaint();
    }
  }

  public Dimension getPreferredSize() {
    return new Dimension(300, 100);
  }
}