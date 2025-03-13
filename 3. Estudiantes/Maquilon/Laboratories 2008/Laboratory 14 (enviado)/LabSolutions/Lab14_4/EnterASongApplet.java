import java.applet.*;
import javax.swing.*;
import java.net.*;
import java.awt.*;

public class EnterASongApplet extends JApplet
{
	private JButton play, stop;
	private JTextField songName;
	private AppletContext context;

	public void init()
	{
		play = new JButton("Play");
		stop = new JButton("Stop");
		songName = new JTextField(25);

		JPanel center = new JPanel();
		center.add(songName);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(center, BorderLayout.CENTER);

		JPanel south = new JPanel();
		south.add(play);
		south.add(stop);
		this.getContentPane().add(south, BorderLayout.SOUTH);

		PlayListener listener = new PlayListener(songName, getAppletContext());
		play.addActionListener(listener);
		stop.addActionListener(listener);
	}
}