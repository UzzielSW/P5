public class DoubleArray
{
	public static void main(String [] args)
	{
		System.out.println("Instantiating a double array");
		int [] [] sums = new int[10][12];

		System.out.println("Filling the array with data");
		for(int row = 0; row < 10; row++)
		{
			for(int col = 0; col < 12; col++)
			{
				sums[row][col] = row + col;
			}
		}

		System.out.println("Displaying the array");
		for(int row = 0; row < sums.length; row++)
		{
			for(int col = 0; col < sums[row].length; col++)
			{
				System.out.print(sums[row][col] + "\t");
			}
			System.out.println();
		}

	}
}
