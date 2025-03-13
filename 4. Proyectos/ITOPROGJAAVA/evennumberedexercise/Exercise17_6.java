// Exercise17_6.java: Play an audio file selected from a file
// dialog box
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;

public class Exercise17_6 extends JFrame implements ActionListener {
  private AudioClip audioClip;
  private JButton jbtPlay = new JButton("Play");
  private JButton jbtLoop = new JButton("Loop");
  private JButton jbtStop = new JButton("Stop");
  private JButton jbtChooseFile =
    new JButton("Choose an Audio File");
  private JFileChooser jFileChooser = new JFileChooser();
  URL url;

  public Exercise17_6() {
    url = this.getClass().getResource("/anthem/china.mid");
    audioClip = Applet.newAudioClip(url);

    JPanel panel = new JPanel();
    panel.add(jbtPlay);
    panel.add(jbtLoop);
    panel.add(jbtStop);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jbtChooseFile, BorderLayout.NORTH);
    getContentPane().add(panel, BorderLayout.SOUTH);

    jbtPlay.addActionListener(this);
    jbtLoop.addActionListener(this);
    jbtStop.addActionListener(this);
    jbtChooseFile.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if (actionCommand.equals("Play")) {
      audioClip.play();
    }
    else if (actionCommand.equals("Loop")) {
      audioClip.loop();
    }
    else if (actionCommand.equals("Stop")) {
      audioClip.stop();
    }
    else if (e.getSource() == jbtChooseFile) {
      jFileChooser.setCurrentDirectory(new File("."));
      if (jFileChooser.showOpenDialog(this) ==
        JFileChooser.APPROVE_OPTION) {
        url = this.getClass().getResource(
          "anthem/" + jFileChooser.getSelectedFile().getName());

        System.out.println("url " + jFileChooser.getSelectedFile().getName());
        System.out.println("url " + url);
        audioClip = Applet.newAudioClip(url);
      }
    }
  }

  /**Main method*/
  public static void main(String[] args) {
    // Create a frame
    Exercise17_6 frame = new Exercise17_6();
    frame.setTitle("Exercise 17.6");
    frame.pack();
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}