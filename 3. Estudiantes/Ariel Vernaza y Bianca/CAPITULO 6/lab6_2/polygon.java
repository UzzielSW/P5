public class Polygon
{
	public int sides;
	public double area;

	public Polygon(int sides)
	{
		this.sides = sides;
		System.out.println("Inside Polygon constructor");
	}

	public int getNumberOfSides()
	{
		return sides;
	}

	public String toString()
	{
		return "Polygon with " + sides + " sides ";
	}	
}