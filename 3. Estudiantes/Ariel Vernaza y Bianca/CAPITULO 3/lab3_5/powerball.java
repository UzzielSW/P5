public class Powerball
{
	public static void main(String [] args)
	{
		int white1, white2, white3, white4, white5, red;

		red = (int) (Math.random() * 42 + 1);

		white1 = (int) (Math.random() * 49 + 1);
		do
		{
			white2 = (int) (Math.random() * 49 + 1);
		}while(white1 == white2);

		do
		{
			white3 = (int) (Math.random() * 49 + 1);
		}while(white1 == white3 || white2 == white3);

		do
		{
			white4 = (int) (Math.random() * 49 + 1);
		}while(white1 == white4 || white2 == white4 || white3 == white4);


		do
		{
			white5 = (int) (Math.random() * 49 + 1);
		}while(white1 == white5 || white2 == white5 || white3 == white5 || white4 == white5);

		System.out.println("White balls: " + white1 + " " + white2 + " " + white3 + " " + white4 + " " + white5);
		System.out.println("Red ball: " + red);
	}
}
