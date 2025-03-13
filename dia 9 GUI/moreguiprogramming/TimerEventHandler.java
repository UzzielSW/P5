package moreguiprogramming;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerEventHandler implements ActionListener {
  JTextArea textArea;
	
  TimerEventHandler(JTextArea t) {
    textArea = t;
  }

  public void actionPerformed(ActionEvent e) {
    textArea.append("Current time is " +System.currentTimeMillis() +"\n");
  }
	
  public static void main(String[] args) {
    JFrame f = new JFrame();
    JPanel topPanel = new JPanel();
    final JTextArea textArea = new JTextArea();
    topPanel.add(textArea);
			
     // listener for the timer
     TimerEventHandler eventHandler = new TimerEventHandler(textArea);

    // create a timer that fires an action event every 1 second
    Timer timer = new Timer(1000, eventHandler);
    timer.start();
	
    // create the scroll pane and add topPanel to it
    JScrollPane scrollPane = new JScrollPane(topPanel);
		
    // add the scroll pane to the content pane 
    f.getContentPane().add(scrollPane, BorderLayout.CENTER);	
    f.setSize(500, 500);
    f.setTitle("Swing Timer Demo");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}

