/*****************************************************************
 *	Template
 *
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
		int aNumber = 1;		// set to 1 as otherwise loop will not start
		int throwSum = 0;

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
		while (throwSum <= 12 && aNumber > 0)
		{
			//Get Input
			aNumber = iBox.getInteger("Enter 1 to throw the dice, or 0 to exit: ");

			//Process
			diceOne.throwDice();
			diceTwo.throwDice();
			diceThree.throwDice();
			//Output
			oBox.println( "You threw : " + diceOne.getFaceValue() + " " + diceTwo.getFaceValue() + " " + diceThree.getFaceValue() );
			throwSum = diceOne.getFaceValue() + diceTwo.getFaceValue() + diceThree.getFaceValue();
			oBox.println( "Total Score : " + throwSum );
		}
	}
}
