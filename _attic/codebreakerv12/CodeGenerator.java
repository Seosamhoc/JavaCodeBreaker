package codebreaker;

/*
*Generates the delete code
*
*
*/

class CodeGenerator 
{
	private char [] colours = {'R','O','Y','G','B','I','V'};

public CodeGenerator()
	{
		//no init to do in this constructor
	} // End of CodePatchGenerator() CONSTRUCTOR

public String getCode()
{
	String deleteCode = new String();

	//the delete code is a String of 4 letters randomly chosen from ROYGBIV
	for (int i = 0; i < 4; i++)
	{
		deleteCode += (this.colours[(int) (Math.random() * 7)]);
	}
	return deleteCode;
}
}