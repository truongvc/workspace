package tutorialPkg;
import java.util.Scanner;
import java.util.Random;

public class Tutorial1 {

    /**
     * it calculates circumference given a radius
     * @param radius - a double that represents the radius
     * @return - the circumference of a circle
     */
    public static double circumference(double radius) {//header or signature
	
	double circumference = 2 * Math.PI * radius;    
	
	return circumference; 
    }
    
    public static int areaOfRectangle(int l, int w) {
	return l * w;
    }
    
    public static void printName() {
	for(int i = 0; i < 5; i++) {
	    System.out.print("HI MR Truong\n");
	}//end for
	
	int num = 0;
	while(num < 5) {
	    System.out.println("BYE");
	    num++;
	}//end while
    }//end printName()
    
    public static void main(String[] args) {
//	int varNum1;
//	varNum1 = 34;
//
//	int varNum2 = 22;
//	
//	int varNum3 = varNum1 + varNum2;
//	
//	System.out.print(varNum3);
//	System.out.println(varNum2);
//	System.out.println(varNum1);
//	System.out.print(varNum3);
//	
//	printName();
//
//	String inData;
//	Scanner scan = new Scanner( System.in );
//
//	System.out.println("Enter the data:");
//	inData = scan.nextLine();
//
//	System.out.println("You entered:" + inData );
//	
//	int num, square;      // declare two int variables 
//
//	    System.out.println("Enter an integer:");
//	    num = scan.nextInt();
//	    square = num * num ;  // compute the square 
//
//	    System.out.println("The square of " + num + " is " + square);
//    
//	 
//	    
//	    Random rand = new Random();
//	    
//	    int randomNum = rand.nextInt(11) + 5;
//	    
//	    System.out.println(randomNum);
	    
	double r = 4.6;
	double  c = circumference(r);//r is the argument 
	
	System.out.println("circumference is: " + c);
	
	int l = 4;
	int w = 10;
	
	System.out.println("area is: " + areaOfRectangle(l,w));
	
    }//end main

}










