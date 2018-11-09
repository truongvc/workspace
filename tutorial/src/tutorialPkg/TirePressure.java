package tutorialPkg;
import java.util.Scanner;
import java.util.Random;

public class TirePressure {

    public static boolean tirePressureCheck(int r1, int r2, int p) {
	int range1 = r1;//not neccessary
	
	if(p >= r1 && p <= r2) {
	    //System.out.print("Pressure Good");
	    return true;}
	else {
//	    System.out.println("no good");
	    return false;}
    }//end tirePressureCheck
    
    public static void main(String[] args) {
	Random randy = new Random();
	int randNum = randy.nextInt(10) + 30;
	tirePressureCheck(30,35,32);//calling method
	System.out.println("Pressure is good: " + tirePressureCheck(30,35,randNum));
	System.out.println(randNum);
	if(tirePressureCheck(30,35,randNum) == true) {
	    System.out.println("good");
	    System.out.println("HI");
	}//end if(tirepressurecheck)
	
    }//end main

}
