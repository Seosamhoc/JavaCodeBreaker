
/**********************************************************
* Author: yourname
* Assignment:WE21,codebreaker assignment,Digital Skills Academy
* Student ID: D12127581
* Date : 2013/07/14
* Ref:  checked against moodle week 11 "CodeBreaker July12th 2013" @author Paul Byrne
*       putInSpaces method from moodle week 5 "guess Numbers and Letters code Example" @author Connor O'Reilly
***********************************************************/


/*CODECOMPARISON
*Version 2
*
*/

class CodeComparison
{
	//private variables
	private String userString;
	private String correctString;
	private StringBuffer stringBufferForReturn;
        private StringBuffer stringBufferForHints;
	private int hints;

	//Constructors
	public CodeComparison()
	{
	}// END OF CONSTRUCTOR 	public CodeComparison()

	public StringBuffer CompareStrings()
	{
            this.hints= 0;
            stringBufferForReturn = new StringBuffer();
            stringBufferForHints = new StringBuffer(correctString);

            //Fill "stringBufferForReturn" with underscores before string comparison
            for (int k = 0; k < this.correctString.length(); k=k+1) 
            {
        	stringBufferForReturn.append("_");
			
            } // END for (int k = 0; k < this.stringFromComputer.length(); k=k+1)


            for (int k = 0; k < this.correctString.length(); k=k+1) 
            {
                String userStrAtK; //what the user input into the string at position k
		userStrAtK = new String();
		userStrAtK += userString.charAt(k);
                    if(correctString.contains(userStrAtK)) //checking if any of the user's characters are in the correct code?
                    {
                     //
                      if((userString.charAt(k)) == (correctString.charAt(k))) //are correct characters in the right place?
                     {
                    	stringBufferForReturn.setCharAt(k, userString.charAt(k));
                        stringBufferForHints.setCharAt(k, '.');
                     }
                        else
                      {
                          int correctPosition;
                          correctPosition = (int) correctString.indexOf(userString.charAt(k));
                          if(userString.charAt(correctPosition) == correctString.charAt(correctPosition)) 
                          {
                                                    stringBufferForHints.setCharAt(correctPosition, '.');
                          }
                          else
                          {
                             //first time character entered should add to clues then that correctPosition shouldn't be counted again
                             //If the conditions to get here are met doing nothing here adds a 1 to clue below for each time
                              for(int m=k+1; m < this.correctString.length(); m++)
                              {
                                  if(userString.charAt(k)==userString.charAt(m))
                                  {
                                      if(correctString.charAt(m)== userString.charAt(m))//stops a clue being added for a letter that will be filled in by a latter letter
                                      {stringBufferForHints.setCharAt(m, '.');}
                                      else
                                      {
                                          hints=1;
                                          stringBufferForHints.setCharAt(correctPosition, '.');
                                          //Need to deal with when user enters 3 characters the same in the wrong places
                                      }
                                  }
                                  else{}
                              }
                          }
                      }//END checking place
                    }//END if(correctString.contains(userString.charAt(k))
		else{}//END checking if contained
            }//END for (int k = 0; k < this.correctString.length(); k=k+1) 
            
            String forHints;
            forHints = new String();
            forHints += stringBufferForHints;
            
            for (int k = 0; k < this.stringBufferForHints.length(); k=k+1) 
            {
                String userStrAtK; //we need Strings to use .contains
		userStrAtK = new String();
		userStrAtK += userString.charAt(k);

                
                if(forHints.contains(userStrAtK)) //checking if any of the user's characters are in the correct code?
                {
                    if(stringBufferForHints.charAt(k)=='.')
                    {}
                    else
                    {
                        hints++;
                    }
                }
                else
                {}//END checking if contained
            }//END for (int k = 0; k < this.stringBufferForHints.length(); k=k+1)
            
            
            
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
        	public double getTheClues()
	{
		return(this.hints);
	}

//@author Connor O'Reilly available on Moodle Week 5 guess a planet. Puts spaces between characters so they can be read easier.
	public StringBuffer putInSpaces( String aWord )
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