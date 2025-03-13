public class Television
{
	public int channel;
	public int volume;

	public Television()
	{
		this(4, 10);
		System.out.println("Inside no-arg constructor");
	}

	public Television(int c)
	{
		this(c, 10);
		System.out.println("Inside one-arg constructor");
	}

	public Television(int c, int v)
	{
		System.out.println("Inside two-arg constructor");
		channel = c;
		volume = v;
	}
}