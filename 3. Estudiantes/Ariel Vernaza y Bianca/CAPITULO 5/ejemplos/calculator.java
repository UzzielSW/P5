public class Calculator
{
	public int multiply(int x, int y)
	{
		System.out.println("Multiply int * int");
		return x * y;
	}

	public double multiply(double x, double y)
	{
		System.out.println("Multiply double * double");
		return x * y;
	}

	public double multiply(int x, double y)
	{
		System.out.println("Multiply int * double");
		return x * y;
	}

	public int multiply(int x)
	{
		System.out.println("Multiply int * itself");
		return x * x;
	}

	public int multiply(int x, int y, int z)
	{
		System.out.println("Multiply three ints");
		return x * y * z;
	}
}