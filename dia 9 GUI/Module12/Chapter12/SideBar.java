import java.awt.*;

public class SideBar
{
	public static void main(String [] args)
	{
		Frame f = new Frame();
		f.setBounds(100, 100, 300, 400);

		Button ok = new Button("OK");
		ok.setBounds(20, 200, 60, 40);

		f.setLayout(null);
		f.add(ok);

		f.setVisible(true);
	}
}