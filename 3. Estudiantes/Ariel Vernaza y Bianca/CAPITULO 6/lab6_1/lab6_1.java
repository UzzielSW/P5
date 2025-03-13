public class Lab6_1
{
	public static void main(String [] args)
	{
		Polygon p = new Polygon(5);
		System.out.println(p.toString());

		Triangle t = new Triangle(5, 7);
		System.out.println(t.toString());
		System.out.println("Area = " + t.getArea());
	}
}