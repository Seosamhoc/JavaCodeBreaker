/*
*CodeBreaker
*v1 instantiates app, shows intro
*
*@author Seosamh O Cinneide
*
**/

import javabook.*;

class Appv1
{
	public static void main(String args[])
	{
		Appv1 thisProgram = new Appv1();
	}
	public Appv1()
	{
		//Declare variables



		//declare objects
		MainWindow mWindow;
		InputBox iBox;
		OutputBox oBox;


		//create objects
		mWindow = new MainWindow();
		iBox = new InputBox(mWindow);
		oBox = new OutputBox(mWindow);

		//get input

		//debug code

		//Process


		//Output
		oBox.show();
		oBox.println("The fate of the world rests on");
		oBox.println("your shoulders. A lethal virus");
		oBox.println("is about to be on leashed on");
		oBox.println("the web. You can stop the");
		oBox.println("virus' release if you can");
		oBox.println("guess the sequence of 4");
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
		oBox.println("You have only 8 chances to");
		oBox.println("guess the code. Are you ready");
		oBox.println("to save the world (Y/N)?");
		oBox.waitUntilClose();
		System.exit(0);
	}
}
