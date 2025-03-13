public class Multiply
{
	public static void main(String [] args)
	{
		int x = 0, y = 0;
		try
		{
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		}catch(NumberFormatException n)
		{
			System.out.println("The two command line arguments must be of type int");
			n.printStackTrace();
			return;
		}catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Please enter two command line arguments");
			a.printStackTrace();
			return;
		}

		System.out.println(x + " x " + y + " = " + (x * y));
	}
}