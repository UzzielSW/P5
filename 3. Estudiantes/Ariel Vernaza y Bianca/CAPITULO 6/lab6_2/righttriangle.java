public class RightTriangle extends Triangle
{
	public double hypotenuse;

	public RightTriangle(int base, int height)
	{
		super(base, height);
		hypotenuse = Math.sqrt((base * base) + (height * height));
		System.out.println("Inside RightTriangle constructor");
	}

	public String toString()
	{
		return super.toString() + " and hypotenuse " + hypotenuse;
	}
}