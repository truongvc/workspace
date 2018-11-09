package tutorialPkg;
import java.util.Scanner;
public class Store2 {
    /*consider what vars to declare - 
     * 
     * 
     */

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	double chairCost = 5;
	double deskCost = 10.50;
	double sofaCost = 20.99;
	double cost=0;
	double tax = 0.05;

	
	System.out.println("Hello what is your name?" );
	String name = scan.nextLine();
	System.out.println("Welcome " + name + " to Truong's Furniture Store!");
	System.out.println("what do you want to buy?");
	System.out.println("0. exit");
	System.out.println("1. chair");
	System.out.println("2. desk");
	System.out.println("3. sofa");
	
	int menuItem = scan.nextInt();
	System.out.println("how many do you want?");
	int quantity = scan.nextInt();
	
	while (menuItem > 0) {
        	
        	if(menuItem == 1) {
        	    cost = cost + chairCost * quantity;
        	} 
        	else if(menuItem == 2) {
        	    cost += deskCost * quantity;
        	}
        	else if(menuItem == 3) {
        	    cost = sofaCost * quantity + cost;
        	}
        	else {
        	    System.out.println("Sorry we don't have any of those");
        	}
        	System.out.println("what else do you want to buy?");
        	System.out.println("0. exit");
        	System.out.println("1. chair");
        	System.out.println("2. desk");
        	System.out.println("3. sofa");
        	menuItem = scan.nextInt();
        	if(menuItem != 0) {
        	System.out.println("how many do you want?");
        	quantity = scan.nextInt();
        	}
        	
	}//end while
	
	System.out.println("Your total is: $" + cost);
	System.out.println("Your tax is: $" + cost*tax);
	System.out.printf("Your total with tax is: $%.2f\n", cost * tax + cost);
	System.out.println("thanks for coming in, BYE!");
	
	
	
    }//end main

}//end cost
