/*****************************************************************
 *
 *	Dice
 *
 *	Date: 14 Oct 2011
 *	@author Conor O Reilly
 *
 *	Maths.Random() retunrns a positive number between 0 and 1
 *  to get a number in a range that you want e.g. 1 to 6 for a dice
 *  you multiply the value produced by the random method by your upper bound e.g. 6
 *  and add on the value of your lower bound e.g. 1 inthis case
 *
 *****************************************************************/

class Dice
{
	// DATA
	//............................................................
	//Private Constants
	final int NUMBER_OF_SIDES = 6;

	//Private Variables
	private int faceValue;


	// CONSTRUCTORS
	//............................................................
	public Dice()
	{
		this.faceValue = 0;		//zero if not thrown
	}

	// METHODS - behaviours
	//............................................................
	public void throwDice()
	{
        this.faceValue = 1 + (int) (Math.random() * NUMBER_OF_SIDES);
	}


	// METHODS - gets (accessors)  and sets (mutators)
	//............................................................
	public int getFaceValue()
	{
           return(this.faceValue);
	}

}
