import java.awt.*;
import javax.swing.*;

public class UsedCarFrame extends JFrame
{
	private JButton prev, next;
	private JList makes;
	private JRadioButton [] years;
	private JComboBox style;
	private JTextField mileage;

	public UsedCarFrame(String title)
	{
		super(title);

		addSouth();
		addNorth();
		addCenter();
	}

	private void addSouth()
	{
		JPanel south = new JPanel();
		prev = new JButton("<< Prev");
		next = new JButton("Next >>");

		south.add(prev);
		south.add(next);
		this.getContentPane().add(south, BorderLayout.SOUTH);
	}

	private void addNorth()
	{
		JPanel north = new JPanel(new GridLayout(1,3));
		north.add(new JLabel("Year"));
		north.add(new JLabel("Make"));
		north.add(new JLabel("Additional info"));

		this.getContentPane().add(north, BorderLayout.NORTH);
	}

	private void addCenter()
	{
		JPanel center = new JPanel(new GridLayout(1,3));

		JPanel left = new JPanel(new GridLayout(7,2));
		years = new JRadioButton[14];
		ButtonGroup group = new ButtonGroup();

		for(int i = 0; i < years.length; i++)
		{
			years[i] = new JRadioButton(2003 - i + "");
			group.add(years[i]);
			left.add(years[i]);
		}

		center.add(left);

		String [] names = new String[10];
		names[0] = "Acura";
		names[1] = "Audi";
		names[2] = "Buick";
		names[3] = "Chevrolet";
		names[4] = "Ford";
		names[5] = "Honda";
		names[6] = "Toyota";
		names[7] = "Volkswagen";
		names[8] = "Porsche";
		names[9] = "BMW";
		makes = new JList(names);
		JScrollPane scrollPane = new JScrollPane(makes);

		center.add(scrollPane);

		Box right = new Box(BoxLayout.Y_AXIS);
		right.add(new JLabel("Enter mileage"));

		mileage = new JTextField(7);
		JPanel temp1 = new JPanel();
		temp1.add(mileage);
		right.add(temp1);

		right.add(new JLabel("Select style"));

		style = new JComboBox();
		style.addItem("EX");
		style.addItem("LX");
		style.addItem("LS");
		JPanel temp2 = new JPanel();
		temp2.add(style);
		right.add(temp2);

		center.add(right);

		this.getContentPane().add(center, BorderLayout.CENTER);
	}

	public static void main(String [] args)
	{
		JFrame f = new UsedCarFrame("Used Car Program");
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}