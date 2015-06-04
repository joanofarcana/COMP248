package program1;

import java.util.Random;

public class Die 
{
	int score;
	
	public int roll() 
	{		
		Random dieRoll = new Random();
		score = dieRoll.nextInt(6) + 1;
		return score;
	}
	
	
}
