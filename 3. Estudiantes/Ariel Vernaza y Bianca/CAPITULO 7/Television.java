//package electronics;

/** The Television class is used to represent a standard TV
*	that contains a channel and volume setting. This
*	particular javadoc comment will appear at the beginning
*	of the documentation page.
*
*	@author Rich Raposa
*	@version 1.2
*/

/**
 * @author darkserver
 *
 */
public class Television
{
	/**
	*	The channel field represents the current channel
	*	being watched.
	*/
	public int channel;

	/**
	*	This field is private and by default will not
	*	appear on the documentation page.
	*/
	private int volume;

	/**
	*	Constructs a Television object with a channel of
	*	4 and volume 5.
	*/
	public Television()
	{
		this(4,5);
		System.out.println("Inside Television()");
	}

	/**
	*	Constructs a Television object with a channel c
	*	and volume v.
	*	@param c The initial channel.
	*	@param v The initial volume.
	*/
	public Television(int c, int v)
	{
		System.out.println("Inside Television(int, int)");
		channel = c;
		setVolume(v);
	}

	/**
	*	Accessor method for the volume field.
	*	@return The current volume.
	*/
	public int getVolume()
	{
		return volume;
	}

	/**
	*	Changes the volume as long as the parameter is
	*	a value between 0 and 10.
	*	@param v The new volume of the television. This value
	*	should be between 0 and 10.
	*/
	public void setVolume(int v)
	{
		if(v >= 0 && v <= 10)
		{
			volume = v;
		}
	}
	public static void main(String args[]){
	Television a= new Television();
	int b=a.channel;
	System.out.println(b);
	
	}
}
