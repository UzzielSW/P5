public class ShiftDemo
{
	public static void main(String [] args)
	{
		byte b = 11;
		System.out.println(b << 1); //shift to the left
		System.out.println(b >> 1); //signed shift to the right
		System.out.println(b >>> 1); //unsigned shift to the right

		byte c = -10;
		System.out.println(c << 3); //shift to the left three
		System.out.println(c >> 1); //sign shift to the right
		System.out.println(c >>> 1);
	}
}