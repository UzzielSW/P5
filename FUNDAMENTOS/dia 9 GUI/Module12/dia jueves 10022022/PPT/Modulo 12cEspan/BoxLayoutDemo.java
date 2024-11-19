import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo extends JFrame
{
	public BoxLayoutDemo(String title)
	{
		super(title);
		//create a Box with a vertical axis
		Box box = new Box(BoxLayout.Y_AXIS);

		//add some components to the Box
		box.add(new JButton("OK"));
		box.add(new JCheckBox("Check here"));
		box.add(new JButton("Click here to continue"));
		box.add(new JLabel("Enter your name:"));
		box.add(new JTextField());

		//add the Box to the content pane of this JFrame
		Container contentPane = this.getContentPane();
		contentPane.add(box, BorderLayout.CENTER);
	}

	public static void main(String [] args)
	{
		JFrame f = new BoxLayoutDemo("BoxLayoutDemo");
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}
}