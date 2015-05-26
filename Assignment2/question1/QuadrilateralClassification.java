// -----------------------------------------------------
// COMP 248 - Assignment #2, question 1
// Written by: Nina Prentiss, 26270611		May 20, 2015
// General Description: 
// ----------------------------------------------------- 

package question1;

import java.util.Scanner;

public class QuadrilateralClassification 
{
	public static void main(String[] args)
	{
		// Declarations
		boolean rightAngle, oppositeSides, adjacentSides, allSides;			// store side equality and if there's a right angle
		double length12, length23, length34, length41;						// the calcuated sides of the quadrilateral
		double angle214;													// the calculated angle at point 1;
		int x1, x2, x3, x4;													// user-inputted x-coords
		int y1, y2, y3, y4;													// user-inputted y-coords
		Scanner userInput = new Scanner(System.in);							// gather user input
		rightAngle = oppositeSides = adjacentSides = allSides = false;		// all booleans default to false
		
		// Greeting
		System.out.println("Welcome to the Quadrilateral Classification program!");
		System.out.println();
		
		// User Input
		System.out.println("Please enter the coordinates of the 4 points (clockwise)");
		System.out.println("x1 y1 : ");
		x1 = userInput.nextInt();
		y1 = userInput.nextInt();
		System.out.println("x2 y2 : ");
		x2 = userInput.nextInt();
		y2 = userInput.nextInt();
		System.out.println("x3 y3 : ");
		x3 = userInput.nextInt();
		y3 = userInput.nextInt();
		System.out.println("x4 y4 : ");
		x4 = userInput.nextInt();
		y4 = userInput.nextInt();
		System.out.println("Thank you. Now calculating...");
		System.out.println();
		
		// Calculations
		// sides
		length12 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		length23 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
		length34 = Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
		length41 = Math.sqrt(Math.pow((x1 - x4), 2) + Math.pow((y1 - y4), 2));
		
		// angle
		angle214 = Math.toDegrees(Math.acos(((x2 - x1) * (x4 - x1) + (y2 - y1) * (y4 - y1)) / (length12 * length41)));
		
		// determine boolean values
		if (length12 == length34)
			oppositeSides = true;
		if (length12 == length23)
			adjacentSides = true;
		if (oppositeSides && adjacentSides)
			allSides = true;
		if (angle214 == 90)
			rightAngle = true;
		
		// Report
		// sides
		System.out.println("length 1-2 = " + length12);
		System.out.println("length 2-3 = " + length23);
		System.out.println("length 3-4 = " + length34);
		System.out.println("length 4-1 = " + length41);
		
		// angle
		System.out.println("angle 2-1-4 = " + angle214);
		System.out.println();
		
		// classification
		if (!oppositeSides) 
			System.out.println("This is an irregular quadrilateral.");
		else {
			if (allSides)
				if (rightAngle)
					System.out.println("This is a SQUARE.");
				else
					System.out.println("This is a RHOMBUS.");
			else
				if (rightAngle)
					System.out.println("This is a RECTANGLE.");
				else
					System.out.println("This is a PARALLELOGRAM.");
		}
		
		// Good-bye
		System.out.println();
		System.out.println("Thank you. Goodbye.");
	}
}
