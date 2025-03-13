

/**
 * Title:        Exercise Solutions
 * Description:  Solutions to the exercises for Introduciton to Java Programming with JBuilder 4
 * Copyright:    Copyright (c) 2000
 * Company:      Armstrong Atlantic State University
 * @author Y. Daniel Liang
 * @version 1.0
 */
// Exercise10_18.java: Test multiple listeners
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise10_18 extends JFrame
  implements ActionListener {
  // Create two buttons
  private JButton jbtOk = new JButton("OK");
  private JButton jbtCancel = new JButton("Cancel");

  /**Default constructor*/
  public Exercise10_18() {
    // Set the window title
    setTitle("Exercise10_18");

    // Set FlowLayout manager to arrange the components
    // inside the frame
    getContentPane().setLayout(new FlowLayout());

    // Add buttons to the frame
    getContentPane().add(jbtOk);
    getContentPane().add(jbtCancel);

    // Register the frame as listeners
    jbtOk.addActionListener(this);
    jbtCancel.addActionListener(this);

    // Register a second listener for buttons
    SecondListener secondListener = new SecondListener(this);
    jbtOk.addActionListener(secondListener);
    jbtCancel.addActionListener(secondListener);
  }

  /**Main method*/
  public static void main(String[] args) {
    Exercise10_18 frame = new Exercise10_18();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }

  /**This method will be invoked when a button is clicked*/
  public void actionPerformed(ActionEvent e) {
    System.out.print("First listener: ");
    processButtons(e);
  }

  public void processButtons(ActionEvent e) {
    if (e.getSource() == jbtOk) {
      System.out.println("The OK button is clicked");
    }
    else if (e.getSource() == jbtCancel) {
      System.out.println("The Cancel button is clicked");
    }
  }
}

/**The class for the second listener*/
// This class can be simplified by making SecondListener an inner
// class inside Exercise10_18
class SecondListener implements ActionListener {
  Exercise10_18 frame;

  public SecondListener(Exercise10_18 frame) {
    this.frame = frame;
  }

  /**Handle ActionEvent*/
  public void actionPerformed(ActionEvent e) {
    System.out.print("Second listener: ");
    frame.processButtons(e);
  }
}