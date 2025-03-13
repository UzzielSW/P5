import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;

public class PlayListener implements ActionListener
{
	private JTextField textField;
	private PlayClipApplet playClip;

	public PlayListener(JTextField tf, AppletContext context)
	{
		textField = tf;
		playClip = (PlayClipApplet) context.getApplet("playclip");
	}

	public void actionPerformed(ActionEvent e)
	{
		String label = e.getActionCommand();
		if(label.equals("Play"))
		{
			String song = textField.getText();
			try
			{
				URL url = new URL(song);
				
				playClip.setAudioClip(url);
				
				playClip.start();
				
			}  catch(MalformedURLException m)
			
			{
				System.out.println(m.getMessage());
			}
		}
		else if(label.equals("Stop"))
		{
			playClip.stop();
		}
	}
}