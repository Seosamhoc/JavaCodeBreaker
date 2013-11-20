/*
*Version 2
*
*/

class CodeComparison
{
	//private variables
	private String userString;
	private String correctString;
	private StringBuffer stringBufferForReturn;
	private int hints;

	//Constructors
	public CodeComparison()
	{
	}// END OF CONSTRUCTOR 	public CodeComparison()

		public StringBuffer compareStrings()
		{
		this.hints= 0;
		stringBufferForReturn = new StringBuffer();
		userString = new String();
		correctString = new String();


		//Fill "stringBufferForReturn" with underscores before string comparison
		for (int k = 0; k < this.correctString.length(); k=k+1) 
		{
        	stringBufferForReturn.append("_");
			
    	} // END for (int k = 0; k < this.stringFromComputer.length(); k=k+1)


		for (int k = 0; k < this.correctString.length(); k=k+1) 
		{
			String userStrAtK;
			userStrAtK = new String();
			userStrAtK += userString.charAt(k);
			if(correctString.contains(userStrAtK)) //checking if any of the user's characters are in the correct code?
			{
				//
				if((userString.charAt(k)) == (correctString.charAt(k))) //are correct characters in the right place?
				{
					stringBufferForReturn.setCharAt(k, userString.charAt(k));
				}
				else
				{
					hints++;
				}//END checking place
			}//END if(correctString.contains(userString.charAt(k))
			else{}//END checking if contained
		}//END for (int k = 0; k < this.correctString.length(); k=k+1) 

		stringBufferForReturn = putInSpaces(stringBufferForReturn.toString());
		return (stringBufferForReturn);

		}//END OF METHOD public void CodeComparison()

	//gets and sets
	public void setUserString(String theUserString)
	{
		userString = theUserString;
	} //END OF METHOD public void setUserString (String theUserString)

	public void setCorrectString (String theComputerString)
	{
		correctString = theComputerString;
	}

//@author Connor O'Reilly available on Moodle Week 5 guess a planet. Puts spaces between characters so they can be read easier.
	private StringBuffer putInSpaces( String aWord )
	{

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < aWord.length() ; i=i+1)
		{
	
			sb.append( aWord.charAt(i) + " ");
		
		}

		return sb;
	}
//End @author Connor O'Reilly

}//END OF CLASS class CodeComparison