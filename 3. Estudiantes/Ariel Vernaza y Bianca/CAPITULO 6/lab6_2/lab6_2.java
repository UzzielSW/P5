public class Lab6_2
{
	public static void main(String [] args)
	{
		RightTriangle r = new RightTriangle(3, 4);
		System.out.println(r.toString());
		System.out.println("Area = " + r.getArea());
		System.out.println("Number of sides = " + r.getNumberOfSides());		
	}
}