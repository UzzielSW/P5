import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConstructorRaceCondition extends JFrame {
    Object waitObject = new Object();
    public ConstructorRaceCondition() {
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        JButton jb = new JButton("Press to Finish Constructor");
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                synchronized(waitObject) {
                    waitObject.notify();
                }
            }
        });

        container.add(jb);
        setSize(300,300);
        show();

        synchronized(waitObject) {
            try {
                waitObject.wait();
            } catch(InterruptedException ie) {
            }
        }

        container.add(new JLabel("Ok, I am done"));
        validate();
    }

    public static void main(String args[]) {
        ConstructorRaceCondition crc = new ConstructorRaceCondition();
    }
}
