/*****************************************************************
 *
 *	Date: 01 Oct 2011
 *	@author Conor O Reilly
 *
 *	Version 1 - throw a dice and just allow one guess,
 *
 *****************************************************************/

import java.util.Scanner;

class App
{
	public static void main(String args[])
	{
			App anApp = new App();
	}


	public App()
	{
		//declare variable
		int integerEntered;
		boolean invalidInput;
		int numberToGuess;
		int numberOfLives;
		int numbersEnteredArray[];    //to store previous guess numbers entered

		//declare objects
		Scanner someInput;
		String theUsersInput;
		Dice theDice;

		//initialise variables
		integerEntered = 0;
		invalidInput = true;
		numberOfLives = 3;
        numbersEnteredArray = new int[numberOfLives];   //array = max number of lives

        //create objects
        theDice = new Dice();
		someInput = new Scanner(System.in);

        //get a random number for the user to guess
        theDice.throwDice();
        numberToGuess = theDice.getFaceValue();

		//input: game intro
		System.out.println("This is a number guessing game.");
		System.out.println("Guess a number between 1 and 6.");

		//input: enter a guess number
        do
        {
			System.out.print("Please enter a guess : ");
			theUsersInput = someInput.nextLine();

			try
			{
				//validate the input, convert from String to int
				integerEntered = Integer.parseInt(theUsersInput);
				invalidInput = false;
			}
			catch (Exception e)
			{
				System.out.println(" You entered " + theUsersInput + ", this is not a valid entry, retry. \n");
				invalidInput = true;
			}        	
        }
        while(invalidInput);

        //processing : compare numbers
        if( numberToGuess == integerEntered )
        {
			System.out.println("\n YOU WIN - Good Guess !! the number was : " + numberToGuess);
        }
        else
        {
        	System.out.println("\n YOU LOOSE, the number was : " + numberToGuess);
        }

        //pause before exit
        System.out.println(" \n Press enter to exit the program");
		someInput.nextLine();

		//close the program without error
		System.exit(0);
	}
}
