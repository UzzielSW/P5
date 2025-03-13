public class BigScreenTV extends Television
{
	public String aspectRatio;
	public short size;

	public BigScreenTV()
	{
		super();
		aspectRatio = "unknown";
		size = 40;
		System.out.println("Inside BigScreenTV()");
	}
}