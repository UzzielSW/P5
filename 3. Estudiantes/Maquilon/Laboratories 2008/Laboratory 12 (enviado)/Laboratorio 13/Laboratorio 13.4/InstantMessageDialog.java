
	import java.awt.*;

	import javax.swing.*;
	

public class InstantMessageDialog extends JDialog
{
	private JButton send, cancel;
	
	private JTextArea message_area;
	

	public InstantMessageDialog(Frame window, String person)
	{		
		super(window, "SendMessage Dialog", true);

		Container contentPane = this.getContentPane();
		
	
	
		//  Boton send
		
		send = new JButton("Send");
		
		
		
		//  Boton cancel
		
		cancel = new JButton("Cancel");
		
		
		
		message_area = new JTextArea();

		JPanel south = new JPanel();
		
		south.add(send);
		
		south.add(cancel);
		
		contentPane.add(south, BorderLayout.SOUTH);
		

		JScrollPane center = new JScrollPane(message_area);
		
		contentPane.add(center, BorderLayout.CENTER);

		JLabel north = new JLabel("Sending message to " + person);
		
		contentPane.add(north, BorderLayout.NORTH);
	
		this.setSize(400,200);
		
		SendMessage sm = new SendMessage(message_area, person, this);
		
		send.addActionListener(sm);
		
		cancel.addActionListener(sm);
	}


	public static void main(String [] args)
	{
		InstantMessageDialog d = new InstantMessageDialog(null, "simon");
		
		
		// .Show() es un método deprecated del API, es por ello que la compilación manda un WARNING !
		
		d.show();
	}
}