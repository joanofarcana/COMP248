package program1;

public class Score {
	
	public int Lose(int kenjo)
	{
		//System.out.println("Hrmmm... Score: " + kenjo);
		return -7;
	}
	
	public int Win(int kenjo)
	{
		//System.out.println("Kenjo! Score: " + kenjo);
		return 10;
	}
	
	public int KenjoChima(int kenjo, int chima)
	{
		//System.out.println("Kenjo-Chima!! " + kenjo + " = " + chima + " !");
		return 5;
	}
	
	public void Outcome(int winnings)
	{
		if (winnings > 0)
		{
			System.out.println("The player won $" + winnings + ".");
			System.out.println();
			System.out.println("Congratulations!");
		}
		else
		{
			System.out.println("The player lost $" + -winnings + ".");
			System.out.println();
			System.out.println("Better luck next time!");
		}
	}
	

}
