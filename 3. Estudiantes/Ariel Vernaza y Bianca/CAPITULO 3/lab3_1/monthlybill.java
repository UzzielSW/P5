public class MonthlyBill
{
	public static void main(String [] args)
	{
		int peak = Integer.parseInt(args[0]);
		int offPeak = Integer.parseInt(args[1]);
		
		double total = 29.95;
		if(peak > 400)
		{
			total += 0.40 * (peak - 400);
		}

		if(offPeak > 750)
		{
			total += 0.40 * (offPeak - 750);
		}
		System.out.println("Monthly bill = $" + total);
	}
}
