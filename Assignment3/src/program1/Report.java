package program1;

public class Report {
	
	public void FirstScores(String kenjoOrChima, int index, Integer value, int numOfReports)
	{
		if (index == 0)
			System.out.print("The first " + numOfReports + " values of " + kenjoOrChima + " are:");

		System.out.print(" " + value);

		if (index == numOfReports - 1)
			System.out.println();
	}
	
	public void LastScores(String kenjoOrChima, int index, Integer value, int numOfReports, int numOfGames)
	{
		if (index == (numOfGames - numOfReports - 1))
			System.out.print("The last " + numOfReports + " values of " + kenjoOrChima + " are:");

		System.out.print(" " + value);

		if (index == numOfGames - 1)
			System.out.println();
	}

	public void Distribution(Integer[] scores, String kenjoOrChima, int numOfGames)
	{
		int percentage;
		for (int i = 2; i <= 12; i++)
		{
			int tally = 0;
			for (int element : scores)
			{
				if (element == i)
				{
					tally++;
				}
			}
				percentage = (tally * 100) / numOfGames;
				System.out.println("The " + kenjoOrChima + " was equal to " + i + " " + percentage + "% of the time.");
			
		}
		System.out.println();
	}
}
