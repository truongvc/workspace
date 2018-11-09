package tutorialPkg;
import java.util.Scanner;
public class Store {

    public static void main(String[] args) {
	Scanner wordScan = new Scanner(System.in);
	Scanner numScan = new Scanner(System.in);
	
	double chairCost = 5.99;
	double deskCost = 10.50;
	double sofaCost = 20.99;
	System.out.println("Hello what is your name?" );
	String name = wordScan.nextLine();
	System.out.println("Welcome " + name + " to Truong's Furniture Store!");
	System.out.println("what do you want to buy?");
	System.out.println("1. chair");
	System.out.println("2. desk");
	System.out.println("3. sofa");
	int menuItem = numScan.nextInt();
	System.out.println("how many do you want?");
	int quantity = numScan.nextInt();
	if(menuItem == 1) {
	
	    System.out.println("Your total is: $" + chairCost * quantity);
	} 
	else if(menuItem == 2) {
	    
	    System.out.println("Your total is: $" + deskCost * quantity);
	}
	else if(menuItem == 3) {
	    
	    System.out.println("Your total is: $" + sofaCost * quantity);
	}
	
	else {
	    System.out.println("Sorry we don't have any of those");
	}
	
	System.out.println("thanks for coming in, BYE!");
	
	
	
    }//end main

}//end cost
