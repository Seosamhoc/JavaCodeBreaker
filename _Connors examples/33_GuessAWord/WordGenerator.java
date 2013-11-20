/*****************************************************************
 *
 *	Letter Generator
 *
 *	Date: 14 Oct 2011
 *	@author Conor O Reilly
 *
 *	Maths.Random() retunrns a positive number between 0 and 1
 *  to get a number in a range that you want e.g. 1 to 6 for a dice
 *  you multiply the value produced by the random method by your upper bound e.g. 6
 *  and add on the value of your lower bound e.g. 1 inthis case
 *  BUT as we have an array that starts at 0 we don't add 1
 *
 *****************************************************************/

class WordGenerator
{
	// DATA
	//............................................................

	private String [] wordList = { "mercuary","venus","earth","mars","jupiter","saturn","uranus","neptune","pluto"};


	// CONSTRUCTORS
	//............................................................
	public WordGenerator()
	{
		//no init to do in this constructor
	}

	// METHODS
	//............................................................
	public String getWord()
	{
        return( this.wordList[ (int) (Math.random() * 9) ] );
	}


}

