
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BorderFactory;
import JButton;
import JFrame;
import JLabel;
import JPanel;
import JProgressBar;
import Timer;

public class SwingProgressBar {

    final static int interval = 100;
    int i;
    JLabel label;
    JProgressBar pb;
    Timer timer;
    JButton button;

    public SwingProgressBar() {
        JFrame frame = new JFrame("Swing Progress Bar");
        button = new JButton("Start");
        button.addActionListener(new ButtonListener());

        pb = new JProgressBar(0, 100);
        pb.setValue(0);
        pb.setStringPainted(true);

        label = new JLabel("");

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(pb);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(panel, BorderLayout.NORTH);
        panel1.add(label, BorderLayout.CENTER);
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a timer.
        timer = new Timer(interval, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (i == 100) {
                    timer.stop();
                    button.setEnabled(true);
                    pb.setValue(0);
                    String str = "<html>" + "<font color=\"#FF0000\">" + "<b>" + "Downloading completed." + "</b>" + "</font>"
                            + "</html>";
                    label.setText(str);
                }
                i = i + 1;
                pb.setValue(i);
            }
        });
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            button.setEnabled(false);
            i = 0;
            String str = "<html>" + "<font color=\"#008000\">" + "<b>" + "Downloading is in process......." + "</b>"
                    + "</font>" + "</html>";
            label.setText(str);
            timer.start();
        }
    }

    public static void main(String[] args) {
        SwingProgressBar spb = new SwingProgressBar();
    }
}
