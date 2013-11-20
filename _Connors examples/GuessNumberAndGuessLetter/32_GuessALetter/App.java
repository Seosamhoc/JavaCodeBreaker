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
	private	char guessLetter;
	private char letterToGuess;
	private	boolean invalidInput;
	private	boolean guessed;
	private	boolean tryAgain;
	private	int numberToGuess;
	private	int numberOfLives;
	private	char lettersEnteredArray[];    //to store previous guess numbers entered
	private	int livesLeft;
	private char theLetterIn;

	//declare objects
	private	Scanner someInput;
	private	String theUsersInput;
	private	LetterGenerator theLetterGenerator;


	// CONSTRUCTORS
	//............................................................
	public App()
	{
		//initialise variables
		this.numberOfLives = 5;
        this.lettersEnteredArray = new char[this.numberOfLives];   //array = max number of lives
        this.livesLeft = 0;
        this.tryAgain = false;

        //create objects
        this.theLetterGenerator = new LetterGenerator();
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
        char initialLetterIn;
        this.guessed = false;
		this.invalidInput = true;

		int count = 0;

        //get a random number for the user to guess
        this.letterToGuess = this.theLetterGenerator.getLetter();

		//input: game intro
		System.out.println("\n-----------------------------------");
		System.out.println("This is a vowel guessing game.");
		System.out.println("Guess the vowel is it A,E,I,O or U.");

		//set number of lives
		this.livesLeft = this.numberOfLives;

		//clear out input history array
		for (int i = 0; i < this.numberOfLives; i=i+1)
		{
			// note use of single quotes not double quotes around characters
			// double quotes mean a String so "_" is a single letter String object
			// whilst '_' is a primitive character variable
			this.lettersEnteredArray[i] = '_';
		}	
		
		//loop the number of lives
		for (int i = 0; i < this.numberOfLives; i=i+1)
		{
			
			//input: enter a guess letter
	        do
	        {
				System.out.print("\n  Please enter a guess : ");
				this.theUsersInput = this.someInput.nextLine();

				//take the first character out of any string entered
				initialLetterIn = this.theUsersInput.charAt(0);

				//convert character to uppercase before start compars
				this.guessLetter = Character.toUpperCase(initialLetterIn);

				//check if the input was an allowed letter
				if( this.theLetterGenerator.checkLetter(this.guessLetter) )
				{
					this.invalidInput = false;
				}
				else
				{
					System.out.println(" You entered : " + this.theUsersInput.charAt(0) + " this is not a valid entry, try again. \n");
					this.invalidInput = true;						

				}	

				//TODO

				//check if entered that letter before
				for (int k = 0; k < this.numberOfLives; k=k+1)
				{
					if ( this.lettersEnteredArray[k] == this.guessLetter )
					{
						System.out.println(" You entered the letter : " + this.theUsersInput.charAt(0) + " before, please pick a different letter. \n");
						this.invalidInput = true;						
					}
				}				

	        }
	        while(this.invalidInput);

	        //processing : compare numbers
	        if( this.letterToGuess == this.guessLetter )
	        {
				this.guessed = true;
				break;
	        }
	        else
	        {
	        	this.livesLeft = this.livesLeft - 1;

	        	//put letter entered into history array
	        	this.lettersEnteredArray[count] = this.guessLetter;
	        	count = count + 1;

	        	//show history of letters entered
	        	System.out.print("\n Entered so far: ");

	        	//use j variable as within a loop that is using i
				for (int j = 0; j < count; j=j+1)
				{
					System.out.print(this.lettersEnteredArray[j] + "  ");
				}

	        	System.out.println("\n\n Try again, guesses left: " + this.livesLeft);
	        	this.guessed = false;
	        }
    	}

    	//check if guessed or not
	    if( this.guessed )
        {
			System.out.println("\n YOU WIN - Good Guess !! the letter was : " + this.letterToGuess);
        }
        else
        {
        	System.out.println("\n YOU LOOSE, the letter was : " + this.letterToGuess);
        }   	

	}//EOM-play()

}//EOC
