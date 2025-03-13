public class BaseballGame
{
	public Team home, visitor;
	public int homeScore, visitorScore;

	public void homeTeamScored(int numberOfRuns)
	{
		homeScore += numberOfRuns;
	}

	public void visitorTeamScored(int numberOfRuns)
	{
		visitorScore += numberOfRuns;
	}

	public void gameOver()
	{
		if(homeScore > visitorScore)
		{
			home.numberOfWins++;
			visitor.numberOfLosses++;
		}
		else
		{
			visitor.numberOfWins++;
			home.numberOfLosses++;
		}
	}

	public void setHomeTeam(Team t)
	{
		home = t;
	}

	public void setVisitingTeam(Team visitor)
	{
		visitor = visitor;
	}
}