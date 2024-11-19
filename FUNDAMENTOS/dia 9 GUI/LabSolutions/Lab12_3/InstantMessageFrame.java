// Lab 12.3  The Instant Message GUI

import java.awt.*;
import javax.swing.*;

public class InstantMessageFrame extends JFrame
{
	private JList<String> friends;
//	private JList friends;
	private JTextField message;
	private JButton send;

	public InstantMessageFrame(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel south = getMessagePanel();
		JScrollPane center = getFriendsPane();



		Container contentPane = this.getContentPane();
		contentPane.add(south, BorderLayout.SOUTH);
		contentPane.add(center, BorderLayout.CENTER);
		
		
	}

	private JPanel getMessagePanel()
	{
		JPanel panel = new JPanel(new BorderLayout());
		message = new JTextField();
		send = new JButton("Send");

		panel.add(message, BorderLayout.CENTER);
		panel.add(send, BorderLayout.EAST);

		return panel;
	}

	private JScrollPane getFriendsPane()
	{
		String [] names = {"Jay", "Marie", "Melissa", "Mark", "Margaret",
		                              "lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"
		                             };
		 friends = new JList<String>(names);
	//	friends = new JList();
	//	friends.setListData(names);
		JScrollPane pane = new JScrollPane(friends);
		
		return pane;
	}

	public static void main(String [] args)
	{
		JFrame f = new InstantMessageFrame("My IM Program");
		f.setSize(220,250);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}