/*
*CodeBreaker
*v3 
*
*@author Seosamh O Cinneide
*
**/

import javabook.*;

class App
{
	public static void main(String args[])
	{
		App thisProgram = new App();
	}

	public App()
	{
		//Declare variables
		String codeToGuess;
		String codeRevealed; //this reveals to the user what they have so far
		int life;
		int sequenceSize;
		Boolean stayOpen;

		codeRevealed = "_ _ _ _";
		life = 8;
		sequenceSize = 4;
		stayOpen = true;

		//declare array
		String[] codeUserArray; //user 
		//create array of size "life"
		codeUserArray = new String[life];

		//declare objects
		MainWindow mWindow;
		InputBox iBox;
		OutputBox oBox;
		ResponseBox rBox;

		CodeGenerator codeObject;

		//create objects
		mWindow = new MainWindow();
		iBox = new InputBox(mWindow);
		oBox = new OutputBox(mWindow);
		rBox = new ResponseBox(mWindow);

		codeObject = new CodeGenerator();

		//get code (using outside class)
		codeToGuess = codeObject.getCode();

		//get input

		//debug code

		//Process


		//Output
		while(stayOpen)
		{
			//intro
			oBox.show();
			oBox.println(codeUserArray.length);
			oBox.println("The fate of the world rests on");
			oBox.println("your shoulders. A lethal virus");
			oBox.println("is about to be on leashed on");
			oBox.println("the web. You can stop the");
			oBox.println("virus' release if you can");
			oBox.println("guess the sequence of " + sequenceSize);
			oBox.println("colors that delete the virus.");
			oBox.println("");
			oBox.println("The possible colours are");
			oBox.println("R - Red");
			oBox.println("O - Orange");
			oBox.println("Y - Yellow");
			oBox.println("G - Green");
			oBox.println("B - Blue");
			oBox.println("I - Indigo");
			oBox.println("V - Violet");
			oBox.println("You have only " + life + " chances to");
			oBox.println("guess the code. Are you ready");
			oBox.println("to save the world (Y/N)?");
			oBox.println("The code is " +codeToGuess);

			//begin game?
			if((rBox.prompt("Are you ready to save the world?")==0))
 			{
 				//show starting position
				stayOpen = true;
				oBox.clear();
				oBox.println("Lives: " + life);
				oBox.print("Code: " + codeRevealed);
				oBox.print(" Guessed: " + "_ _ _ _");
				oBox.println(" Clues: ");
				oBox.println("Enter a 4 character sequence from the following values");
				oBox.println("ROYGBIV or 0 to exit");


				oBox.waitUntilClose();
				System.exit(0);
		 	}
		 	else	
		 	{
		 		System.out.println("Thank you for playing!");
		 		stayOpen = false;
		 	}
	 	}
		System.exit(0);
	}
}
