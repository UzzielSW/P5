public class CongratulateStudent
{
	public static void main(String [] args)
	{
		char grade = args[0].charAt(0);

		if(grade == 'A')
		{
			System.out.println("Excellent!");
		}
		else if(grade == 'B' || grade == 'C')
		{
			System.out.println("Well done");
		}
		else if(grade == 'D')
		{
			System.out.println("You passed");
			System.out.println("Better try again");
		}
		else if(grade == 'F')
		{
			System.out.println("Better try again");
		}
		else
		{
			System.out.println("Invalid grade");
		}		

		System.out.println("Your grade is a " + grade);
	}
}
