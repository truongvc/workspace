package tutorialPkg;

public class TirePressure1 {

    public static boolean pressureCheck(int r1, int r2, int p) {
	if(p >= r1 && p <= r2) {
//	    System.out.println("presssure is good");
	    return true;
	}//if(p >= r1 && p <= r2) 
	else {
	    return false;
	}
    }//end pressurecheck
    
    public static void main(String[] args) {
	
	System.out.println(pressureCheck(30,40,35));
	
	if(pressureCheck(30,40,35) == true) {
	    System.out.println("pressure good");
	}

    }

}
