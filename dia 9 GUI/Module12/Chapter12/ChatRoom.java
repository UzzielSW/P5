import java.awt.*;

public class ChatRoom extends Frame
{
	private Button send,quit;
	
	private TextArea tArea;
	
	private TextField tfield;

	public ChatRoom(String title)
	{
		super(title);
		send = new Button("Send");
		quit = new Button("Quick");
		
		tArea = new TextArea();
	    tfield = new TextField(20);
		
		Panel eastPanel = new Panel(new GridLayout(2,1));
		eastPanel.add(send);
		eastPanel.add(quit);
		eastPanel.setBackground(Color.BLUE);
	
		this.add(eastPanel, BorderLayout.EAST);		
		this.add(tfield, BorderLayout.SOUTH);
		this.add(tArea, BorderLayout.CENTER);
	}

	public static void main(String [] args)
	{
		Frame f = new ChatRoom("ChatRoom");
	//	f.pack();
		f.setResizable(false);
    

	f.setSize(600,400);
	f.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	f.setLocation((d.width - f.getSize().width) / 2, (d.height - f.getSize().height)/2);
	
		f.setVisible(true);
	}
}