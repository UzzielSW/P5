/*
 * Stopwatch.java
 */
package stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame
{

  // declare controls used

  JButton startButton = new JButton();
  JButton stopButton = new JButton();
  JButton exitButton = new JButton();
  JLabel startLabel = new JLabel();
  JLabel stopLabel = new JLabel();
  JLabel elapsedLabel = new JLabel();
  ;
  JTextField startTextField = new JTextField();
  JTextField stopTextField = new JTextField();
  JTextField elapsedTextField = new JTextField();

  public static void main(String args[])
  {
    // Construct frame
    new Stopwatch().setVisible(true);
  }

  public Stopwatch()
  {
    // Frame constructor
    setTitle("Stopwatch Application");
    getContentPane().setLayout(new GridBagLayout());
    // add controls
    GridBagConstraints gridConstraints = new GridBagConstraints();

    startButton.setText("Start Timing");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 0;
    getContentPane().add(startButton, gridConstraints);

    stopButton.setText("Stop Timing");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 1;
    getContentPane().add(stopButton, gridConstraints);

    exitButton.setText("Exit");
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 2;
    getContentPane().add(exitButton, gridConstraints);

    startLabel.setText("Start Time");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 0;
    getContentPane().add(startLabel, new GridBagConstraints());

    stopLabel.setText("Stop Time");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 1;
    getContentPane().add(stopLabel, gridConstraints);

    elapsedLabel.setText("Elapsed Time (sec)");
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 2;
    getContentPane().add(elapsedLabel, gridConstraints);

    startTextField.setText("");
    startTextField.setColumns(15);
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 0;
    getContentPane().add(startTextField, gridConstraints);

    stopTextField.setText("");
    stopTextField.setColumns(15);
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 1;
    getContentPane().add(stopTextField, gridConstraints);

    elapsedTextField.setText("");
    elapsedTextField.setColumns(15);
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 2;
    getContentPane().add(elapsedTextField, gridConstraints);

    pack();
  }
}
