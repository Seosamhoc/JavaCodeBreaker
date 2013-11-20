/*****************************************************************
 *
 *	Date: 01 Oct 2011
 *	@author Conor O Reilly
 *
 *	Version 1 - get a number between 1 - 10 and just allow one guess,
 *
 *****************************************************************/

import java.util.Scanner;

class App
{
	public static void main(String args[])
	{
			App anApp = new App();
	}


	// DATA
	//............................................................
	private	int integerEntered;
	private	boolean invalidInput;
	private	boolean guessed;
	private	int numberToGuess;
	private	int numberOfLives;
	private	int numbersEnteredArray[];    //to store previous guess numbers entered
	private	int livesLeft;

		//declare objects
	private	Scanner someInput;
	private	String theUsersInput;
	private	NumberGenerator theNumberGenerator;


	// CONSTRUCTORS
	//............................................................
	public App()
	{
		//initialise variables
		this.numberOfLives = 3;
        this.numbersEnteredArray = new int[this.numberOfLives];   //array = max number of lives
        this.livesLeft = 0;

        //create objects
        this.theNumberGenerator = new NumberGenerator();
		this.someInput = new Scanner(System.in);

		//playGame
		playGame();

		//pause before exit
        System.out.println(" \n Press enter to exit the program");
		someInput.nextLine();

		//close the program without error
		System.exit(0);
	}

	// METHODS
	//............................................................
	private void playGame()
	{
        this.guessed = false;
        this.integerEntered = 0;
		this.invalidInput = true;

        //get a random number for the user to guess
        numberToGuess = theNumberGenerator.getNumber();

		//input: game intro
		System.out.println("This is a number guessing game.");
		System.out.println("Guess a number between 1 and 10.");

		//loop the number of lives
		livesLeft = numberOfLives;
		
		for (int i = 0; i < numberOfLives; i=i+1)
		{
			
			//input: enter a guess number
	        do
	        {
				System.out.print("\n  Please enter a guess : ");
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
				guessed = true;
				break;
	        }
	        else
	        {
	        	livesLeft = livesLeft - 1;
	        	System.out.println("\n Try again, guesses left: " + livesLeft);
	        	guessed = false;
	        }
    	}

    	//check if guessed or not
	    if( guessed )
        {
			System.out.println("\n YOU WIN - Good Guess !! the number was : " + numberToGuess);
        }
        else
        {
        	System.out.println("\n YOU LOOSE, the number was : " + numberToGuess);
        }   	

	}//EOM-play()

}//EOC
