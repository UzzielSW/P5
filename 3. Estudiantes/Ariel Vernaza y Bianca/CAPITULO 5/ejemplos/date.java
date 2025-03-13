public class Date
{
	public int day, month, year;

	public int getDay()
	{
		System.out.println("Inside getDay method");
		return day;
	}

	public void printDate()
	{
		System.out.println("Inside printDate method");
		System.out.println(month + "/" + day + "/" + year);
	}
}
