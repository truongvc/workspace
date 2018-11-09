package tutorialPkg;
import java.util.Scanner; //Import of scanner

import java.util.Random;

public class Tests {
	public static String ConvertToInt(String code, int ShiftValue) {

	//Makes a new method called ConvertToInt this is what converts the message, it asks for the message and the shift value

	String ConvertedCode = "";

	//Makes a new String called ConvertedCode for later use

	for (int i = 0; i<code.length(); i++) {

	//Makes a new local int called i and it is the length of chars in the variable code

	ConvertedCode = ConvertedCode + " " + ((int)code.charAt(i) - ShiftValue);

	//This is where the ConvertedCode gets used and the chars are converted to ints

	}

	return ConvertedCode.substring(1);

	//Returns ConvertedCode with a substring of 1 because of a space showing up at the start of the code without substring

	}

	public static String ConvertFromInt(String code, int ShiftValue) {

	//Makes a new method called ConvertFromInt this converts the message from ints, it takes the message and shift value

	String ConvertedCode = "";

	//Makes a new String called ConvertedCode for later use

	String[] CodeArray = code.split(" ");

	//This String Array is used to split the message by spaces and is much easier to handle

	for (int i = 0; i<CodeArray.length; i++) {

	//Makes a new for loop with a length of the amount of strings in the CodeArray

	ConvertedCode = ConvertedCode+((char)(Integer.parseInt(CodeArray[i]) + ShiftValue));

	//Uses the ConvertedCode and converts the numbers in the CodeArray to change them back to a char using the Integer parseInt to convert the string to an int and add a Shift Value

	}

	return ConvertedCode;

	//Returns the converted Code

	}


	public static void main(String args[]) {
		
	System.out.println(ConvertToInt("Spaces Don't Effect This :O", 5));

	System.out.println(ConvertFromInt("78 107 92 94 96 110 27 63 106 105 34 111 27 64 97 97 96 94 111 27 79 99 100 110 27 53 74", 5));
	}


}
