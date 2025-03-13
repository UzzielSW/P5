
	import java.awt.*;

	import javax.swing.*;
	
	import javax.swing.event.*;
	
	import java.awt.event.*;
	

public class WindowDialog extends JDialog implements ActionListener
{
	private JButton send, cancel;
	
	private JTextArea message_area;
	
	private String name;
	
	private static final Font system = new Font("Bookman Old Style", Font.BOLD,13);
	

	public WindowDialog(Frame window, String person)
	{		
		super(window, "SendMessage Dialog", true);
		
		name = person;

		Container contentPane = this.getContentPane();
		
	
	
		//  Boton send
		
		send = new JButton("Send");
		
		send.setFont(system);
		
		send.addActionListener(this);
		
		
		//  Boton cancel
		
		cancel = new JButton("Cancel");
		
		cancel.setFont(system);
		
		cancel.addActionListener(this);
		
		
		
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
	}



	public void actionPerformed(ActionEvent a)
	{
		String label = a.getActionCommand();
		if(label.equals("Send"))
		{
			String message = message_area.getText();
			System.out.println(name + ": " + message);
			this.hide();
		}
		else if(label.equals("Cancel"))
		{
			this.hide();
		}
	}




	public static void main(String [] args)
	{
		WindowDialog d = new WindowDialog(null, "simon");
		
		d.setLocationRelativeTo(null);
		
		d.show();
	}
}