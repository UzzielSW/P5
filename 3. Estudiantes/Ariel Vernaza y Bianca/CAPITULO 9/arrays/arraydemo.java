public class ArrayDemo
{
	public static void main(String [] args)
	{
		int [] sums;
		sums = new int[20];

		sums[0] = 1;
		for(int i = 1; i < 20; i++)
		{
			sums[i] = sums[i-1] + i;
		}

		for(int i = 0; i < sums.length; i++)
		{
			System.out.println("sums[" + i + "] = " + sums[i]);
		}

		System.out.println(sums.toString());

		double [] temps = new double[31];
		temps[0] = 85.0;
		temps[1] = 79.5;
		temps[2] = 76.0;

		Employee [] myCompany;
		myCompany = new Employee[500];
		myCompany[227] = new Employee("George Washington", "Mount Vernon", 1);
		myCompany[227].mailCheck();
		System.out.println("The length of myCompany is " + myCompany.length);

		System.out.println(temps[31]);
	}
}
