import java.awt.*;

import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame {
	private Button north, south, east, west, center;

	public BorderLayoutDemo(String title) {
		super(title);

		north = new Button(" North ");
		south = new Button(" South ");
		east = new Button(" East ");
		west = new Button(" West ");
		center = new Button(" Center ");

		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame f = new BorderLayoutDemo("BorderLayoutDemo");
		f.setVisible(true);
	}
}
