public class Triangle extends Polygon
{
	public int base;
	public int height;

	public Triangle(int b, int h)
	{
		super(3);
		base = b;
		height = h;
		System.out.println("Inside Triangle constructor");
	}

	public String toString()
	{
		return "Triangle with base " + base + " and height " + height;
	}

	public double getArea()
	{
		area = 0.5 * base * height;
		return area;
	}
}