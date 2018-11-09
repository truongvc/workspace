package tutorialPkg;

import java.util.Scanner;

public class Tut1 {
    
	
    public static void printName() {
	
	for(int i = 0; i < 5; i++) {
	    System.out.print("HI Mr Truong\n");
	}
    }
    
    public static void main(String[] args) {

	int varNum1;
	varNum1 = 10;
	int varNum2 = 25;
	int varNum3;
	varNum3 = varNum1 + varNum2;
	
	System.out.print(varNum3);
	System.out.println(varNum2);
	System.out.println(varNum1);

	printName();
if(varNum3 > 5) {
    System.out.println("greater");
	}
else if(varNum3 > 6)
    System.out.println("bigger than 6");
else
    System.out.println("less");

	String inData;
	Scanner scan = new Scanner( System.in );

	System.out.println("Enter the data:");
	inData = scan.nextLine();

	System.out.println("You entered:" + inData );
	
	int num;
	int square;
	System.out.println("Enter an integer:");
	num = scan.nextInt();
	square = num * num ;  // compute the square 

	System.out.println("The square of " + num + " is " + square);
	
    }//end main
 
}//end class





