import java.awt.*;

public class CheckBoxDemo extends Frame
{
	private Checkbox red, yellow, blue;

	public CheckBoxDemo(String title)
	{
		super(title);

		red = new Checkbox("Red");
		blue = new Checkbox("Blue");
		yellow = new Checkbox("Yellow");

		//add the checkboxes to the frame
		Panel north = new Panel();
		north.add(red);
		north.add(blue);
		north.add(yellow);

		this.add(north, BorderLayout.NORTH);

		//register the event listener
		MIxColors listener = new MIxColors(this);
		red.addItemListener(listener);
		blue.addItemListener(listener);
		yellow.addItemListener(listener);
	}

	public static void main(String [] args)
	{
		Frame f = new CheckBoxDemo("CheckboxDemo");
		f.setSize(300,300);
		f.setVisible(true);
	}
}