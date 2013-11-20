package codebreaker;
/**********************************************************
* Author: yourname
* Assignment:WE21,codebreaker assignment,Digital Skills Academy
* Student ID: D12127581
* Date : 2013/07/14
* Ref:  checked against moodle week 11 "CodeBreaker July12th 2013" @author Paul Byrne
***********************************************************/

/*CODEGENERATOR
*Generates the delete code
*
*
*/

class CodeGenerator 
{
	private char [] colours = {'R','O','Y','G','B','I','V'};

public CodeGenerator()
	{
		
	} // End of CodeGenerator() CONSTRUCTOR

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
}//END OF CODEGENERATOR