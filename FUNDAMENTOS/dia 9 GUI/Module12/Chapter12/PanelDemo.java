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
		northPanel.add(new Label("Make a selection"));
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
		f.setSize(300,200);
		f.setVisible(true);
	}
}