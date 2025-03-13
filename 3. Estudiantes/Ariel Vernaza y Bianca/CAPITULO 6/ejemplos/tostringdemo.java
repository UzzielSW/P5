public class ToStringDemo
{
	public static void main(String [] args)
	{
		Radio radio = new Radio(7, 100.3, 'F');
		System.out.println("toString returns " + radio.toString());

		System.out.println("Just printing the reference: " + radio);
	}
}