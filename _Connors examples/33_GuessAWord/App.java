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
	private String wordToGuess;
	private StringBuffer guessedSoFar;
	private	boolean invalidInput;
	private	boolean guessed;
	private int guessCount;
	private int guessCountTotal;
	private	boolean tryAgain;
	private	int numberToGuess;
	private	int numberOfLives;
	private	char lettersEnteredArray[];    //to store previous guess numbers entered
	private	int livesLeft;
	private char theLetterIn;

	//declare objects
	private	Scanner someInput;
	private	String theUsersInput;
	private	WordGenerator theWordGenerator;


	// CONSTRUCTORS
	//............................................................
	public App()
	{
		//initialise variables
		this.numberOfLives = 5;
        this.lettersEnteredArray = new char[26];   //array = max number of letters in alphabeth
        this.livesLeft = 0;
        this.tryAgain = false;
        this.guessCount = 0;

        //create objects
        this.theWordGenerator = new WordGenerator();
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
		this.guessCountTotal = 0;

		int count = 0;

        //get a random number for the user to guess
        this.wordToGuess = this.theWordGenerator.getWord();

        //init guessed so far with blank characters
        this.guessedSoFar = new StringBuffer();
        for (int i = 0; i < this.wordToGuess.length(); i=i+1)
		{
        	guessedSoFar.append("_");
    	}

		//input: game intro
		System.out.println("\n-----------------------------------");
		System.out.println("This is a planet guessing game.");
		System.out.println("But you must guess the planet a letter at a time");
		System.out.println("Hint: " + putInSpaces(this.guessedSoFar.toString()));

		//set number of lives
		this.livesLeft = this.numberOfLives;

		//clear out input history array
		for (int i = 0; i < 26; i=i+1)
		{
			// note use of single quotes not double quotes around characters
			// double quotes mean a String so "_" is a single letter String object
			// whilst '_' is a primitive character variable
			this.lettersEnteredArray[i] = '_';
		}	
		
		//loop the number of lives
		while( this.livesLeft > 0 )
		{
			
			//input: enter a guess letter
	        do
	        {
	        	this.invalidInput = false;
				System.out.print("\n  Please enter a guess : ");
				this.theUsersInput = this.someInput.nextLine();

				//take the first character out of any string entered
				initialLetterIn = this.theUsersInput.charAt(0);

				//convert character to lowercase before start compars
				this.guessLetter = Character.toLowerCase(initialLetterIn);

				//check if entered that letter before
				for (int k = 0; k < 26; k=k+1)
				{
					if ( this.lettersEnteredArray[k] == this.guessLetter )
					{
						System.out.println(" You entered the letter : " + this.theUsersInput.charAt(0) + " before, please pick a different letter. \n");
						this.invalidInput = true;						
					}
				}				

	        }
	        while(this.invalidInput);

	        //loop through each character of the word see if we have one or more matches
	        this.guessCount = 0;
	        for (int w = 0; w < this.wordToGuess.length(); w=w+1)
			{
	        	if( this.wordToGuess.charAt(w) == this.guessLetter)
	        	{
	        		this.guessCount = this.guessCount + 1;
	        		this.guessedSoFar.setCharAt(w, this.guessLetter);
	        	}

	    	}

	        //if get any letters correct, tell or loose a life
	        if( this.guessCount > 0)
	        {
				System.out.println("\n Hint: " + putInSpaces(this.guessedSoFar.toString()));
				System.out.println("\n\n good guess, guesses left: " + this.livesLeft);
				this.guessCountTotal = this.guessCountTotal + this.guessCount;
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

	        	System.out.println("\n Hint: " + putInSpaces(this.guessedSoFar.toString()));
	        	System.out.println("\n\n Try again, guesses left: " + this.livesLeft);
	        }

	        //whole word guessed?
	        //number of characters guseesd = length of word
	        if( this.guessCountTotal == this.wordToGuess.length())
	        { 
	        	this.guessed = true;
	        	//jump out of lives loop as all letters guessed
	        	break; 
	        }

    	} //for lives loop

    	//check if guessed or not after run out of lives
	    if( this.guessed )
        {
			System.out.println("Your Guess: " + putInSpaces(this.guessedSoFar.toString()));
			System.out.println("\n YOU WIN - Good Guess !! the word was : " + this.wordToGuess);
        }
        else
        {
        	System.out.println("Your Guess: " + putInSpaces(this.guessedSoFar.toString()));
        	System.out.println("\n YOU LOOSE, the word was : " + this.wordToGuess);
        }  	

	}//EOM-play()


	/*================================================
	 * space out the hint words
	 *
	 *================================================*/
	private String putInSpaces( String aWord )
	{
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < aWord.length() ; i=i+1)
		{
			sb.append( aWord.charAt(i) + " ");
		}

		return sb.toString();	
		//return aWord;
	}

}//EOC
