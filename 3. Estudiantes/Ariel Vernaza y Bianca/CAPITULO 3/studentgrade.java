public class StudentGrade
{
	public static void main(String [] args)
	{
		int score = Integer.parseInt(args[0]);

		char grade;
		if(score >= 90)
		{
			grade = 'A';
			System.out.println("Way to go!");
		}
		else if(score >= 80)
		{
			grade = 'B';
			System.out.println("Good job");
		}
		else if(score >= 70 && score < 80)
		{
			grade = 'C';
		}
		else if(score >= 60)
		{
			grade = 'D';
		}
		else
		{
			grade = 'F';
			System.out.println("Try again");
		}

		System.out.println("Your grade is a " + grade);
	}
}
