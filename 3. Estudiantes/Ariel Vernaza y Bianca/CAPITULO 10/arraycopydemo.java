public class ArrayCopyDemo
{
	public static void main(String [] args)
	{
		int [] odds = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		System.out.println("** odds the first time **");
		for(int i = 0; i < odds.length; i++)
		{
			System.out.println("odds[" + i + "] = " + odds[i]);
		}

		System.out.println("** odds the second time **");
		int [] temp = odds;
		odds = new int[20];

		System.arraycopy(temp, 0, odds, 4, temp.length);
		for(int i = 0; i < odds.length; i++)
		{
			System.out.println("odds[" + i + "] = " + odds[i]);
		}
	}
}
