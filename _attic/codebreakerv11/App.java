package codebreaker;

/*
*CodeBreaker
*v11
*
*@author Seosamh O Cinneide
*
**/

import javabook.*;

class App
{
	public static void main(String args[])
	{
            App thisProgram;
            thisProgram = new App();
	}

	public App()
	{
		//Declare variables
		String codeToGuess;
 //this reveals to the user what they have so far
		String userEntry; //this is used because we don't want to always put the user entry into the array
                String unvalidatedEntry;
		int life;
		int sequenceSize;
		Boolean stayOpen;
                Boolean invalidInput;

                unvalidatedEntry="____";
                userEntry="____";
		life = 8;
		sequenceSize = 4;
		stayOpen = true;
                invalidInput = true;

		//declare array
		String[] codeUserArray; //previous user entered codes
                StringBuffer[] codeRevealed;
                int[] clues;
		//create array of size "life"
		codeUserArray = new String[life];
		codeRevealed = new StringBuffer[life];
                clues = new int[life];

                
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

			//begin game?
			if((rBox.prompt("Are you ready to save the world?")==0))
 			{
 				//show starting position
				stayOpen = true;
				oBox.clear();
				oBox.println("Lives: " + life);
				oBox.print("Code: " + "_ _ _ _");
				oBox.print(" Guessed: " + "_ _ _ _");
				oBox.println(" Clues: ");
				oBox.println("Enter a " + sequenceSize + " character sequence from the following values");
				oBox.println("ROYGBIV or 0 to exit");

				for (int i = 0; i < life; i++)//keep going until out of lives (or user quits)
				{
					int j = 0;
                                        do
                                        {
                                        userEntry = iBox.getString("Enter a 4 character sequence from the following values: ROYGBIV or 0 to exit");
                                        
					if (userEntry.contains("0"))//0 to exit
					{
						System.out.println("Thank you for playing!");
						System.exit(0);
					}
					else
					{
                                            codeUserArray[i] = userEntry;

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
                                                            	oBox.println("Code: " + codeUserArray[i] + " Guessed: " + codeUserArray[i] + " Clues: " + clues[i]);
								oBox.println("YOU WIN!!");
                                                                oBox.println("Play again Y/N:");
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
                                                                oBox.clear();
                                                                oBox.println("Lives: " + (life-1-i));
                                                            	oBox.println("Code: " + "_ _ _ _ " + " Guessed: " + "_ _ _ _ " + " Clues: ");
								aComparisonObject.setCorrectString(codeToGuess);
								aComparisonObject.setUserString(codeUserArray[i]);
								codeRevealed[i] = aComparisonObject.CompareStrings();
                                                                clues[i] = (int) aComparisonObject.getTheClues();
                                                                String[] codeUserDisplay;
                                                                codeUserDisplay = new String[life];
                                                                for(int k=0; k<=i; k++)
                                                                {
								oBox.println("Code: " + codeRevealed[k] + " Guessed: " + codeUserArray[k] + " Clues: " + clues[k]);
                                                                }
                                                                

							}
						}

					}
                                        }
                                        while(invalidInput);
				}//END for (int i = 0; i < life; i++)
                                //out of lives
                                oBox.println("Code: " + codeRevealed[life-1] + " Guessed: " + codeUserArray[life-1] + " Clues: " + clues[life-1]);
                                oBox.println("YOU LOSE, the code was: " + codeToGuess);
                                oBox.println("Play again Y/N:");
                                if((rBox.prompt("Do you want to play again(Y/N)?")==0))
				{
                                    oBox.clear();
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
		 		System.out.println("Thank you for playing!");
		 		stayOpen = false;
		 	}
	 	}
		System.exit(0);
	}

}
