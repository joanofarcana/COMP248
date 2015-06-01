// -----------------------------------------------------
// COMP 248 - Assignment #2, question 2
// Written by: Nina Prentiss, 26270611		May 31, 2015
// General Description: Calculates the frequency of a
// 	note, given its letter and octave. Assumes a char
//	and int given for the note and octave, 
//	respectively. Program repeats when prompted.
// ----------------------------------------------------- 

package question2;

import java.util.Scanner;

public class PianoKeys 
{
	public static void main(String[] args)
	{
		// Declarations
		char note;									// user given note
		boolean noteCheck;							// is note valid?
		int octave;									// user given octave
		boolean octaveCheck;						// is octave valid?
		double constant;							// exponent of the twelfth root of 2, determined by given note
		double frequency;							// calculated frequency
		String frequencyFormat;						// frequency formatted to 2 decimal places;
		String repeat;								// check if user wishes to repeat program
		boolean repeatCheck;						// is repeat valid?
		
		final int minNote = 97;						// lowest valid note
		final int maxNote = 103;					// highest valid note
		final int minOctave = -4;					// lowest valid octave
		final int maxOctave = 5;					// highest valid octave
		final double r = Math.pow(2.0, (1.0/12.0));	// constant used in calculations
		
		Scanner userInput = new Scanner(System.in);
		
		// Greeting
		System.out.println("Welcome to the Piano Keys program!");
		
		// User Input and Calculation
		do 
		{
			// User Input
			// UI: note
			do
			{
				noteCheck = false;
				System.out.println("Enter a note: ");
				note = userInput.next().charAt(0);			// assumes user will give one character response	
				note = Character.toLowerCase(note);
				if (note < minNote || note > maxNote)
					System.out.println(note + " is not a valid note (it must be c, d, e, f, g, a or b).");
				else
					noteCheck = true;
			} while (!noteCheck);
			
			// UI: octave
			do
			{
				octaveCheck = false;
				System.out.println("Enter an octave: ");
				octave = userInput.nextInt();				// assumes user will give an integer
				if (octave < minOctave || octave > maxOctave)
				{
					System.out.println(octave + " is not a valid octave (it must be between -4 and 5 inclusively).");
				}
				else
					octaveCheck = true;
			} while (!octaveCheck);
			
			// Calculation
			switch (note)
			{
				case 'c': constant = 0;
					break;
				case 'd': constant = 2;
					break;
				case 'e': constant = 4;
					break;
				case 'f': constant = 5;
					break;
				case 'g': constant = 7;
					break;
				case 'a': constant = 9;
					break;
				case 'b': constant = 11;
					break;
				default: constant = 100;					// impossible case
					break;
			}
			if (constant < 100)
			{
				frequency = 440.00 * Math.pow(r, (constant - 9.00)) * Math.pow(2.0, (double)octave);
				frequencyFormat = String.format("%.2f", frequency);
			}
			else 											// impossible case
			{
				frequency = 0;
				frequencyFormat = "POOP";
				System.out.println("You should not be here.");
			}
			
			// Report
			System.out.println("The frequency of " + note + " is " + frequencyFormat + " Hertz.");
			System.out.println();

			// Repeat?
			do
			{
				repeatCheck = false;
				System.out.println("Would you like to try another note (Y/N) ?");
				repeat = userInput.next();
				if (repeat.length() == 1 && (repeat.toUpperCase().charAt(0) == 'Y' || repeat.toUpperCase().charAt(0) == 'N'))
					repeatCheck = true;
			} while (!repeatCheck);
			
		} while (repeat.toUpperCase().charAt(0) == 'Y');
		
		// Goodbye
		System.out.println("Thank you for using the program.");
		System.out.println("Goodbye!");
	}
}
