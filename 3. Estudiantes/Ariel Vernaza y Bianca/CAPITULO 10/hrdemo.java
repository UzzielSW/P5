public class HRDemo
{
	public static void main(String [] args)
	{
		Employee e = new Employee("George Washington", "Mt. Vernon");

		HumanResources hr = new HumanResources();
		System.out.println(hr.getInfo(e) + "\n");
		hr.changeName(e, "Bill Gates");
		hr.updateAddress(e, "Redmond, WA");
		System.out.println("\n" + hr.getInfo(e));
	}
}
