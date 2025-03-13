
package clases;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ProgressW extends JFrame implements Runnable{

    JProgressBar current;
    JTextArea out;
    JButton find;
    Thread runner;
    int num = 0;

	public void run()
	{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        pane.setBackground(Color.black);
        pane.add(current);
        JLabel message = new JLabel("Updating your Account");
        message.setForeground(Color.gray);          
        pane.add(message,BorderLayout.SOUTH);
        setContentPane(pane);
       	setBounds(340,250,290,85);  	
        setVisible(true);
        iterate();
        setVisible(false);
        JOptionPane.showMessageDialog(null,
    	"Your withdraw was succes",
    	"Inane warning",
    	JOptionPane.WARNING_MESSAGE);
    }
    
       public void iterate() {
        while (num < 2000) {
        	current.setVisible(true);
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 250;
        }
    }
    
 /*   public static void main(String [] args)
    {
    	Progress p = new Progress();
    }*/
}