public class OaklandAtDenver
{
	public static void main(String [] args)
	{
		System.out.println("Instantiating a new FootballGame");
		FootballGame game = new FootballGame("Broncos", "Raiders");

		System.out.println("Instantiating a listener");
		CellPhone cellPhone = new CellPhone();

		game.addFootballListener(cellPhone);

		System.out.println("Simulating a game...");
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.homeTeamScored(7);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.quarterEnded(1);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.visitingTeamScored(3);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.visitingTeamScored(7);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.quarterEnded(2);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.quarterEnded(3);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		game.homeTeamScored(3);

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}		game.homeTeamScored(7);
		game.quarterEnded(4);
	}
}