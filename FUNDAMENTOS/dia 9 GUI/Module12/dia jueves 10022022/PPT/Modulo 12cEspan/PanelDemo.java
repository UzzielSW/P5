import java.awt.*;

public class PanelDemo extends Frame
{
	private Button next, prev, first;
	private List list;

	public PanelDemo(String title)
	{
		super(title);
		next = new Button("Next >>");
		prev = new Button("<< Previous");
		first = new Button("First");

		Panel southPanel = new Panel();
		southPanel.add(prev);
		southPanel.add(first);
		southPanel.add(next);

		this.add(southPanel, BorderLayout.SOUTH);

		Panel northPanel = new Panel();
		Label labN = new Label("Make a selection");
		northPanel.add(labN);
		this.add(northPanel, BorderLayout.NORTH);

		list = new List();
		for(int i = 1; i <= 10; i++)
		{
			list.add("Selection " + i);
		}
		this.add(list, BorderLayout.CENTER);
	}

	public static void main(String [] args)
	{
		Container f = new PanelDemo("PanelDemo");
		f.setBounds(200,200,300,200);
		
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	  f.setLocation((d.width - f.getSize().width) / 2, (d.height - f.getSize().height)/2);
		f.setVisible(true);
	}
}