/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;

/**
 *
 * @author seosamh
 */
public class test {
    	public static void main(String args[])
	{
		test thisProgram = new test();
	}


        public test()
{
    StringBuffer codeRevealed;
    codeRevealed = new StringBuffer();
    String codeToGuess;
    String[] codeUserArray; //previous user entered codes
    //create array of size "life"
    codeUserArray = new String[8];
    
    CodeGenerator aCodeObject;
    CodeComparison aComparisonObject;
    
    aCodeObject = new CodeGenerator();
    aComparisonObject = new CodeComparison();
    codeToGuess = aCodeObject.getCode();
    System.out.println(codeToGuess);
    
    
    codeUserArray[0]="ROYG";
    aComparisonObject.setCorrectString(codeToGuess);
    aComparisonObject.setUserString(codeUserArray[0]);
    codeRevealed = aComparisonObject.CompareStrings();
    System.out.println("Code revealed: " + codeRevealed);
}
}