package tutorialPkg;

public class quiz1 {

    public static boolean isSingleDigit(int number) {
	if(number >= -9 && number <= 9) {
	    return true;
	}
	else {
	    return false;
	}
    }//end isSingleDigit
    
    public static int smallest(int x, int y , int z) {
	int smallest = x;
	if(x < y) {
	    if(y< z) {
		smallest = x;
	    }
	    else
		smallest = y;
	}
	
	
	return smallest;
	
    }
    
    public static void main(String[] args) {
	
	System.out.println(isSingleDigit(4));
	System.out.println(isSingleDigit(45));
	System.out.println(isSingleDigit(-3));
	
	System.out.println(smallest(-3,4,5));
	System.out.println(smallest(-13,34,35));
	System.out.println(smallest(-31,4,54));
	
    }

}
