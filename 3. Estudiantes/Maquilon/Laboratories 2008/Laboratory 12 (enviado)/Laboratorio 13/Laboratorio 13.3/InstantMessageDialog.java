	import javax.swing.event.*;
	
	import java.awt.event.*;
	
	import java.awt.*;
	
	import javax.swing.*;
	

public class InstantMessageDialog extends JDialog
{
	private JButton send, cancel;
	
	private JTextArea message_area;
	
	private String name;
	
	private static final Font system = new Font("Bookman Old Style", Font.BOLD,13);
	

	public InstantMessageDialog(Frame owner, String person)
	{		
		super(owner, "SendMessage Dialog", true);
		
		name = person;

		Container contentPane = this.getContentPane();
		
	
	
		//  Boton send
		
		send = new JButton("Send");
		
		send.setFont(system);
		
		
		//  Boton cancel
		
		cancel = new JButton("Cancel");
		
		cancel.setFont(system);
				
		
		
		//  Message Area & Adding Panels 
		
		message_area = new JTextArea();
		
		message_area.setBorder(BorderFactory.createLineBorder(Color.black));
		
		message_area.setBackground(Color.white);

		JPanel south = new JPanel();
		
		south.add(send);
		
		south.add(cancel);
		
		contentPane.add(south, BorderLayout.SOUTH);
		

		JScrollPane center = new JScrollPane(message_area);
		
		contentPane.add(center, BorderLayout.CENTER);

		JLabel north = new JLabel("Sending message to " + person);
		
		north.setFont(system);
		
		contentPane.add(north, BorderLayout.NORTH);
	
		this.setSize(400,200);
		
		SendMessage listener = new SendMessage(message_area, person, this);
		
		send.addActionListener(listener);
		
		cancel.addActionListener(listener);
		
	}

	public static void main(String [] args)
	{
		InstantMessageDialog imd = new InstantMessageDialog(null, "simon");
		
		imd.setLocationRelativeTo(null);
		
		imd.show();
	}
}