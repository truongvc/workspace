package tutorialPkg;

public class Test {

    public static double volume(double vol) {
	return vol*vol*vol;
    }//end volume
    
    public static void main(String[] args) {
	volume(23.3);//calling the function
	System.out.println(volume(23.4) + 20000);

    }//end main
    



}
