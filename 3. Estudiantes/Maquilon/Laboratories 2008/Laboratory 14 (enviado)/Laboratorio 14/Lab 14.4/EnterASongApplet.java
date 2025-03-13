import java.applet.*;
import javax.swing.*;
import java.net.*;
import java.awt.*;

public class EnterASongApplet extends JApplet
{
	private JButton play, stop;
	private JTextField musica;
	private AppletContext context;

	public void init()
	{
		play = new JButton("Play");
		
		stop = new JButton("Stop");
		
		musica = new JTextField(25);
		
		JPanel center = new JPanel();
		
		center.setLayout(null);
	
		musica.setBounds(40,30,320,20);
		
		center.add(musica);
		
		play.setBounds(83,70,100,20);
		
		center.add(play);
		
		stop.setBounds(210,70,100,20);
		
		center.add(stop);
		
		center.setBackground(Color.white);
		
		this.getContentPane().add(center);

		PlayListener listener = new PlayListener(musica, getAppletContext());
		
		play.addActionListener(listener);
		
		stop.addActionListener(listener);
	}
}