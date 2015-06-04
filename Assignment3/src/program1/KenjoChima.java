package program1;

import java.util.Arrays;

public class KenjoChima 
{
	public static void main(String[] args)
	{
		// Declarations
		int kenjo;
		int chima;
		int winnings = 0;
		int frownTally = 0;
		final int numOfGames = 1000;
		final int numOfReports = 25;
		
		String stringKenjo = new String();
			stringKenjo = "Kenjo";
		String stringChima = new String();
			stringChima = "Chima";
		
		Die die1 = new Die();
		Die die2 = new Die();
		
		Score score = new Score();
		Report report = new Report();
		
		Integer[] loseScore = {2, 3, 12};
		Integer[] winScore = {7, 11};
		final int winChima = 7;
		
		Integer[] listKenjo = new Integer[numOfGames];
		Integer[] listChima = new Integer[numOfGames];
		
		// Roll the Dice
		for (int rollCount = 0; rollCount < numOfGames; rollCount++)
		{
			kenjo = die1.roll() + die2.roll();
			
			if (Arrays.asList(loseScore).contains(kenjo))
			{
				winnings += score.Lose(kenjo);
				chima = 0;
				frownTally++;
			}
			else if (Arrays.asList(winScore).contains(kenjo))
			{
				winnings += score.Win(kenjo);
				chima = 0;
			}
			else
			{
				do
				{
					chima = die1.roll() + die2.roll();
					if (chima == kenjo)
					{
						winnings += score.KenjoChima(kenjo, chima);
					}
					if (chima == winChima)
					{
						winnings += score.Lose(chima);
					}
				} while (chima != kenjo && chima != 7);
			}
			
			listKenjo[rollCount] = kenjo;
			listChima[rollCount] = chima;
		}
		
// Score Report
	// Greeting
		System.out.println("Welcome to the Kenjo-Chima simulation!");
		System.out.println("Let's run a simulation of " + numOfGames + " games.");
		System.out.println();
		
	//Report first Kenjo values
		for (int i = 0; i < numOfReports; i++)
		{
			report.FirstScores(stringKenjo, i, listKenjo[i], numOfReports);
		}
	// Report first Chima values
		for (int i = 0; i < numOfReports; i++)
		{
			report.FirstScores(stringChima, i, listChima[i], numOfReports);
		}
	// Report last Kenjo values	
		for (int i = (numOfGames - numOfReports - 1); i < numOfGames; i++)
		{
			report.LastScores(stringKenjo, i, listKenjo[i], numOfReports, numOfGames);
		}
	// Report last Chima values	
		for (int i = (numOfGames - numOfReports - 1); i < numOfGames; i++)
		{
			report.LastScores(stringChima, i, listChima[i], numOfReports, numOfGames);
		}
		System.out.println();
	// Frown tally
		System.out.println("The player frowned " + frownTally + " times.");
		System.out.println();
	//Report Percentages
		report.Distribution(listKenjo, stringKenjo, numOfGames);
		report.Distribution(listChima, stringChima, numOfGames);
		
	// Winnings/Losings
		score.Outcome(winnings);
	}
}
