import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModalDemo extends Frame implements ActionListener
{
	private static  final long serialVersionUID = 1L;
	private Dialog modal;
	private JButton go, ok;

	public ModalDemo(String title)
	{
		super(title);

		//prepare the buttons
		go = new JButton("Go");
		go.addActionListener(this);

		ok = new JButton("OK");
		ok.addActionListener(this);

		//prepare the Dialog window
		modal = new Dialog(this, "A modal dialog", true);
		modal.setLayout(new FlowLayout());
		modal.add(ok);
		modal.setBounds(60,100,180,60);

		//add the "Go" button to the Frame
		JPanel center = new JPanel();
		center.add(go);
		this.add(center, BorderLayout.CENTER);
	}

	//Clicking either button causes this method to be invoked
	public void actionPerformed(ActionEvent e)
	{
		String label = e.getActionCommand();
		if(label.equals("Go"))
		{
			//modal.show();
			   modal.setVisible(true);
		}
		else if(label.equals("OK"))
		{
		//	modal.hide();
		     modal.dispose();
		}
	}

	public static void main(String [] args)
	{
		Frame f = new ModalDemo("Modal Demo");
		f.setSize(300, 300);
		
		f.setVisible(true);
	}
}