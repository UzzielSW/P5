public class Radio
{
	public int volume;
	public double channel;
	public char band;

	public Radio(int v, double c, char b)
	{
		volume = v;
		channel = c;
		band = b;
	}

	public String toString()
	{
		System.out.println("Inside Radio toString");
		String rep = "Radio volume = " + volume + ", channel = " + channel + " and band = " + band;
		return rep;
	}
}