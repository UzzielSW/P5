/** The CellPhone class displays the status of a football
* game using abbreviated System.out.println() statements
* as if they were being displayed on a cellphone.
*/
public class CellPhone implements FootballListener
{
	private String home, visitors;
	private int homePoints, visitorPoints;
	private int currentQuarter;

	/** Constructs a new CellPhone object
	* and sets the current quarter to 1.
	*/
	public CellPhone()
	{
		currentQuarter = 1;
	}

	/** Prints out the current score and quarter
	*/
	public void updateScore()
	{
				System.out.println(home + ": " + homePoints);
		System.out.println(visitors + ": " + visitorPoints);
		displayQuarter();	
	}

	/** Displays the current quarter
	*/
	public void displayQuarter()
	{
		if(currentQuarter > 0)
		{
			System.out.println("Game is in quarter " + currentQuarter);
		}
		else
		{
			System.out.println("Final score");
		}
	}

	/** Add the given points to the home team's score
	* @param points The number of points to add to the home score.
	*/
	public void homeTeamScored(int points)
	{
		System.out.println("The home team scored " + points);
		homePoints += points;
		updateScore();
	}

	/** Add the given points to the visiting team's score
	* @param points The number of points to add to the visiting score.
	*/
	public void visitingTeamScored(int points)
	{
		System.out.println("The visiting team scored " + points);
		visitorPoints += points;
		updateScore();
	}

	/** Updates the quarter of the game
	* @param quarter The quarter that just ended.
	*/
	public void endOfQuarter(int quarter)
	{

		if(quarter >= 1 && quarter <= 3)
		{
			currentQuarter++;
		}
		else
		{
			currentQuarter = -1;	//game is over
		}
	}

	/** Sets the home team
	* @param name The name of the home team
	*/
	public void setHomeTeam(String name)
	{
		home = name;
	}

	/** Sets the visiting team
	* @param name The name of the visiting team
	*/
	public void setVisitingTeam(String name)
	{
		visitors = name;
	}
}