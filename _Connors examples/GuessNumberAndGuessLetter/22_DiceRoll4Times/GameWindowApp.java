/*****************************************************************
 *
 *	Date: 14 Oct 2011
 *	@author Conor O Reilly
 *
 *****************************************************************/

import javabook.*;

class GameWindowApp
{
	public static void main(String args[])
	{
			GameWindowApp thisProgram = new GameWindowApp();
	}

	public GameWindowApp()
	{
		//Declare constants
		int aNumber = 0;

		//Declare objects
		MainWindow mWindow;
		InputBox iBox;
		OutputBox oBox;
		Dice diceOne;
		Dice diceTwo;
		Dice diceThree;

		//Create objects
		mWindow = new MainWindow("Dice Game");
		iBox = new InputBox(mWindow);
		oBox = new OutputBox(mWindow);
		diceOne 	= new Dice();
		diceTwo 	= new Dice();
		diceThree 	= new Dice();

		//Use objects
		mWindow.show();
		oBox.show();

		//LOOP
		for (int i = 1; i < 5; i++ )
		{
			//Get Input
			aNumber = iBox.getInteger("Enter 1 to throw the dice, or 0 to exit: ");
			//Process
			diceOne.throwDice();
			diceTwo.throwDice();
			diceThree.throwDice();
			//Output
			oBox.println( "Throw :" + i );
			oBox.println( "You threw : " + diceOne.getFaceValue() + " " + diceTwo.getFaceValue() + " " + diceThree.getFaceValue() );
		}
		System.exit(0);
	}
}
