import java.applet.*;

import java.net.*;

public class PlayClipApplet extends Applet
{
	private AudioClip clip;
	
	private String clipName;

	public void setAudioClip(URL url)
	{
		clip = getAudioClip(url);
		
		clipName = url.getFile();
	}

	public void start()
	{
		if(clip != null)
		{
			getAppletContext().showStatus("Playing " + clipName);
			
			clip.play();
		}
	}

	public void stop()
	{
		if(clip != null)
		{
			clip.stop();
			
			getAppletContext().showStatus("");
		}
	}
}