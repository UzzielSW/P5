public class RandomLoop
{
	public static void main(String [] args)
	{
		int a, b;

		a = (int) (Math.random() * 10 + 1);
		System.out.println("a = " + a);
		do
		{
			b = (int) (Math.random() * 10 + 1);
			System.out.println("Trying b = " + b);
		}while(a == b);

		System.out.println("a = " + a + " and b = " + b);
	}
}