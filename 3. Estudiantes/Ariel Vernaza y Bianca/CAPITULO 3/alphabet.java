public class Alphabet
{
	public static void main(String [] args)
	{
		char current = 'a';

		for(int row = 1; row <= 3; row++)
		{
			for(int column = 1; column <= 10; column++)
			{
				System.out.print(current + " ");
				current++;
			}
			System.out.println();
		}
	}
}
