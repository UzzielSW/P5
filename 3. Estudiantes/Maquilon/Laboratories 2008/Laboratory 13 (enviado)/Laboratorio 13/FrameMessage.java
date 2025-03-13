import java.awt.*;
import javax.swing.*;

import javax.swing.event.*;
import java.awt.event.*;

public class FrameMessage extends JFrame implements ActionListener
{
	private JList friends;
	private JTextField message;
	private JButton send;
	
	private JList list;

	public FrameMessage(String title)
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
		
		message.addActionListener(this);
		
		message.setBorder(BorderFactory.createLineBorder(Color.black));
		
		send = new JButton("Send");
		
		send.addActionListener(this);
		
		send.setBackground(new Color(0,0,128));
		
		send.setForeground(Color.WHITE);

		panel.add(message, BorderLayout.CENTER);
		
		panel.add(send, BorderLayout.EAST);

		return panel;
	}

	private JScrollPane getFriendsPane()
	{
		friends = new JList();
		
		friends.addMouseListener(new Dialog());

		String [] names = {"Jay", "Marie", "Melissa", "Mark", "Margaret"};
		
		friends.setListData(names);
		
		list = friends;
		
		JScrollPane pane = new JScrollPane(friends);
		
		pane.setBackground(new Color(202,225,255));
		
		return pane;
	}
	
	
		// Metodo del ActionListener
	
	
	public void actionPerformed(ActionEvent a)
	{
		String mensaje = message.getText();
		if(mensaje != "")
		{
			ListModel model = list.getModel();
			int size = model.getSize();
			for(int i = 0; i < size; i++)
			{
				System.out.println(mensaje + " " + model.getElementAt(i));
			}
		}
	}


	public static void main(String [] args)
	{
		JFrame f = new FrameMessage("My IM Program");
		
		f.setSize(220,450);
		
		f.setLocationRelativeTo(null);
		
		f.setVisible(true);
	}
}







	//   Clase que presenta a WindowDialog

	class Dialog extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(e.getClickCount() == 2)
			{
				JList list = (JList) e.getSource();
				
				String name = (String) list.getSelectedValue();
				
				System.out.println("Clicked on " + name);
				
				JDialog nuevo = new WindowDialog(null, name);
				
				nuevo.show();
			}
		}
	}