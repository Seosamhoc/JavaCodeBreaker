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
	private	boolean tryAgain;
	private	int numberToGuess;
	private	int numberOfLives;
	private	int numbersEnteredArray[];    //to store previous guess numbers entered
	private	int livesLeft;
	private char theLetterIn;

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
        this.tryAgain = false;

        //create objects
        this.theNumberGenerator = new NumberGenerator();
		this.someInput = new Scanner(System.in);

		//playGame
		playBoard();

		//pause before exit
        System.out.println(" \n Press enter to exit the program");
		this.someInput.nextLine();

		//close the program without error
		System.exit(0);
	}

	// METHODS
	//............................................................

	/*================================================
	 * ask if want to play again once played once
	 *
	 *================================================*/
	private void playBoard()
	{
        do
        {		
        	
        	playGame();

			this.tryAgain = false;
			System.out.print("\n Play again (Y/N): ");
			this.theUsersInput = this.someInput.nextLine();

			// we get a String in, we only want the first character
			// a String is like an array, the first position starts at 0
			// theLetterIn is of type char

			this.theLetterIn = this.theUsersInput.charAt(0);

			//now comparing two characters

			if( (this.theLetterIn == 'Y') || ( this.theLetterIn == 'y') )
			{
				this.tryAgain = true;
			}
       	
        }
        while(this.tryAgain);

	}//EOM-playBoard()

	/*================================================
	 * Play the game
	 *
	 *================================================*/
	private void playGame()
	{
        this.guessed = false;
        this.integerEntered = 0;
		this.invalidInput = true;

		int count = 0;

        //get a random number for the user to guess
        this.numberToGuess = this.theNumberGenerator.getNumber();

		//input: game intro
		System.out.println("\n-----------------------------------");
		System.out.println("This is a number guessing game.");
		System.out.println("Guess a number between 1 and 10.");

		//set number of lives
		this.livesLeft = this.numberOfLives;

		//clear out input history array
		for (int i = 0; i < this.numberOfLives; i=i+1)
		{
			this.numbersEnteredArray[i] = 0;
		}	
		
		//loop the number of lives
		for (int i = 0; i < this.numberOfLives; i=i+1)
		{
			
			//input: enter a guess number
	        do
	        {
				System.out.print("\n  Please enter a guess : ");
				this.theUsersInput = this.someInput.nextLine();

				try
				{
					//validate the input, convert from String to int
					this.integerEntered = Integer.parseInt(this.theUsersInput);
					this.invalidInput = false;
				}
				catch (Exception e)
				{
					System.out.println(" You entered " + this.theUsersInput + ", this is not a valid entry, retry. \n");
					this.invalidInput = true;
				}        	
	        }
	        while(this.invalidInput);

	        //processing : compare numbers
	        if( this.numberToGuess == this.integerEntered )
	        {
				this.guessed = true;
				break;
	        }
	        else
	        {
	        	this.livesLeft = this.livesLeft - 1;

	        	//put number entered into history array
	        	this.numbersEnteredArray[count] = this.integerEntered;
	        	count = count + 1;

	        	//show history of numbers entered
	        	System.out.print("\n Entered so far: ");

	        	//use j variable as within a loop that is using i
				for (int j = 0; j < count; j=j+1)
				{
					System.out.print(this.numbersEnteredArray[j] + "  ");
				}

	        	System.out.println("\n\n Try again, guesses left: " + this.livesLeft);
	        	this.guessed = false;
	        }
    	}

    	//check if guessed or not
	    if( this.guessed )
        {
			System.out.println("\n YOU WIN - Good Guess !! the number was : " + this.numberToGuess);
        }
        else
        {
        	System.out.println("\n YOU LOOSE, the number was : " + this.numberToGuess);
        }   	

	}//EOM-play()

}//EOC
