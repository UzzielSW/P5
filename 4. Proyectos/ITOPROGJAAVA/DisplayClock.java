// DisplayClock.java: Display a clock in a panel
import java.awt.*;
import javax.swing.*;

public class DisplayClock extends JFrame {
  /** Main method to display hour, minute and hour
     @param args[0] hour
     @param args[1] minute
     @param args[2] second
    */
  public static void main(String[] args) {
    // Declare hour, minute, and second values
    int hour = 0;
    int minute = 0;
    int second = 0;

    // Check usage and get hour, minute, second
    if (args.length > 3) {
      System.out.println(
        "Usage: java DisplayClock hour minute second");
      System.exit(0);
    }
    else if (args.length == 3) {
      hour = new Integer(args[0]).intValue();
      minute = new Integer(args[1]).intValue();
      second = new Integer(args[2]).intValue();
    }
    else if (args.length == 2) {
      hour = new Integer(args[0]).intValue();
      minute = new Integer(args[1]).intValue();
    }
    else if (args.length == 1) {
      hour = new Integer(args[0]).intValue();
    }

    // Create a frame to hold the clock
    DisplayClock frame = new DisplayClock();
    frame.setTitle("Display Clock");
    frame.getContentPane().add(new DrawClock(hour, minute, second));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 350);
    frame.setVisible(true);
  }
}