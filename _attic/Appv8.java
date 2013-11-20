package codebreaker;

/*
*CodeBreaker
*v8 Compares and displays where correctly guess and positioned colours are
*
*@author Seosamh O Cinneide
*
**/

import javabook.*;

class Appv8
{
	public static void main(String args[])
	{
		Appv8 thisProgram = new Appv8();
	}

	public Appv8()
	{
		//Declare variables
		String codeToGuess;
		StringBuffer codeRevealed; //this reveals to the user what they have so far
		String userEntry; //this is used because we don't want to always put the user entry into the array
		int life;
		int guesses;
		int sequenceSize;
		Boolean stayOpen;

		codeRevealed = new StringBuffer();
		life = 8;
		guesses = life;
		sequenceSize = 4;
		stayOpen = true;

		//declare array
		String[] codeUserArray; //previous user entered codes
		//create array of size "life"
		codeUserArray = new String[life];

		//declare objects
		MainWindow mWindow;
		InputBox iBox;
		OutputBox oBox;
		ResponseBox rBox;

		CodeGenerator aCodeObject;
		CodeComparison aComparisonObject;

		//create objects
		mWindow = new MainWindow();
		iBox = new InputBox(mWindow);
		oBox = new OutputBox(mWindow);
		rBox = new ResponseBox(mWindow);

		aCodeObject = new CodeGenerator();
		aComparisonObject = new CodeComparison();



		//get input

		//debug code

		//Process


		//Output
		while(stayOpen)
		{
			//get code (using outside class)
			codeToGuess = aCodeObject.getCode();
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
				oBox.println("Enter a " + sequenceSize + " character sequence from the following values");
				oBox.println("ROYGBIV or 0 to exit");

				for (int i = 0; i < guesses; i++)
				{
					int j = 0;
					userEntry = iBox.getString("Enter a 4 character sequence from the following values: ROYGBIV or 0 to exit");
					if (userEntry.contains("0"))
					{
						System.out.println("Thank you for playing!");
						System.exit(0);
					}
					else
					{
						oBox.println("userEntry: " + userEntry);
						codeUserArray[i] = userEntry;
						oBox.println("array at " + i + " " + codeUserArray[i]);
						

						while(j < i) 
						{
							if(codeUserArray[i].equalsIgnoreCase(codeUserArray[j]))
							{
								oBox.println("You already tried that! Enter again.");
								i = i-1;
								break;

							}
							else
							{
								j++;
							}
						}
						if(i==j)
						{
							if(codeUserArray[i].equalsIgnoreCase(codeToGuess))//do the codes match?
							{
								//they do match
								oBox.println("Code: " + codeToGuess + " You win!");
								if((rBox.prompt("Do you want to play again(Y/N)?")==0))
								{
									oBox.clear();
									break;
								}
								else	
							 	{
							 		System.out.println("Thank you for playing!");
							 		stayOpen = false;
							 		System.exit(0);
							 	}
							}
							else
							{
								//the codes don't match
								aComparisonObject.setCorrectString(codeToGuess);
								aComparisonObject.setUserString(codeUserArray[i]);
								codeRevealed = aComparisonObject.CompareStrings();
								oBox.println("Code revealed: " + codeRevealed);

							}
						}

					}
				}
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
