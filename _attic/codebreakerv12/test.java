package codebreaker;

/**
 *
 * @author seosamh
 */

import javabook.*;
public class test 
{
    	public static void main(String args[])
	{
		test thisProgram = new test();
	}


        public test()
{
    
    String codeToGuess;
 //this reveals to the user what they have so far
		String userEntry; //this is used because we don't want to always put the user entry into the array
                String rawUserEntry;
		int life;
		int sequenceSize;
		Boolean stayOpen;
                Boolean invalidInput;

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
                
oBox.show();
while(invalidInput=true)
{
int j = 0;
rawUserEntry = iBox.getString("Enter a 4 character sequence from the following values: ROYGBIV or 0 to exit");
userEntry = rawUserEntry.toUpperCase();
if (userEntry.contains("0"))//0 to exit, ROYGBIV, 4(sequenceSize) characters long
{
    System.out.println("Thank you for playing!");
    System.exit(0);
}
else if (userEntry.length()!=sequenceSize)
{
    oBox.println(userEntry + "is invalid input, enter a" +sequenceSize+ "character string using the letters ROYGBIV or 0 to exit");
    oBox.println(userEntry.length() + " SS: " + sequenceSize);
    invalidInput=true;
}
else if((!(userEntry.contains("R")||userEntry.contains("O")||userEntry.contains("Y")||userEntry.contains("G")||userEntry.contains("B")||userEntry.contains("I")||userEntry.contains("V"))))
{
    oBox.println("NO");  
    invalidInput=true;
}
else
{
    oBox.println("yes");
    invalidInput=false;
    break;
}
}

oBox.waitUntilClose();
System.exit(0);
}
}
