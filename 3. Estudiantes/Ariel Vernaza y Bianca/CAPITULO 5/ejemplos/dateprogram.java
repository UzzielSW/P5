public class DateProgram
{
	public static void main(String [] args)
	{
		System.out.println("Within main...");
		Date today = new Date();
		today.day = 25;
		today.month = 12;
		today.year = 2003;

		System.out.println("The day is " + today.getDay());

		System.out.println("Printing the date...");
		today.printDate();

		System.out.println("What is displayed next?");
		today.getDay();
	}
}
