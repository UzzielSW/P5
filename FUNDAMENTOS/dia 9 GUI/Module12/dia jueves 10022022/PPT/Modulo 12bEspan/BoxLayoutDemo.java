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
		JFrame jf = new BoxLayoutDemo("BoxLayoutDemo");
			 jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	  jf.setLocation((d.width - jf.getSize().width) / 2, (d.height - jf.getSize().height)/2);
	   jf.setSize(400,200);
		//jf.pack();
		jf.setVisible(true);
	}
}