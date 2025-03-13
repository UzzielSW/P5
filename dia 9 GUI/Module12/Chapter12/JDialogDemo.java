import java.awt.*;
import javax.swing.*;

public class JDialogDemo extends JDialog
{
	private JButton ok, cancel;

	public JDialogDemo(String title)
	{
		this.setTitle(title);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);

		JLabel message = new JLabel("Continue?");
		message.setBounds(70, 20, 125, 20);

		ok = new JButton("OK");
		ok.setBounds(15,50, 60, 20);
		cancel = new JButton("Cancel");
		cancel.setBounds(90, 50, 80, 20);

		contentPane.add(message);
		contentPane.add(ok);
		contentPane.add(cancel);
	}

	public static void main(String [] args)
	{
		JDialog f = new JDialogDemo("JDialogDemo");
		f.setSize(200,200);
		f.setResizable(false);
		f.setVisible(true);
	}
}