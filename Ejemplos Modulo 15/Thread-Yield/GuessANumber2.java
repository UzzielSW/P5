public class GuessANumber2 extends Thread
{
	private int number;

	public GuessANumber2(int number)
	{
		this.number = number;
	}

	public void run()
	{
		int counter = 0;
		int guess = 0;
		do
		{
			Thread.yield();

			guess = (int) (Math.random() * 100 + 1);
			System.out.println(this.getName() + " guesses " + guess);
			counter++;
		}while(guess != number);

		System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.**");
	}
}