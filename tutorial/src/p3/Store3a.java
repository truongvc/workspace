package p3;
import java.util.Scanner;
public class Store3a {
    /*consider what functions to make
     * 
     */

	static double cost = 0;
	static double tax = 0.05;
	static int totalQty = 0;
	static int totalChairQty = 0;
	static int totalDeskQty = 0;
	static int totalSofaQty = 0;
	
    public static void menu() {
	Scanner scan = new Scanner(System.in);
	double chairCost = 5;
	double deskCost = 10.50;
	double sofaCost = 20.99;
	int menuItem;
	int quantity;
	
	
	System.out.println("Hello what is your name?" );
	String name = scan.next();
	System.out.println("Welcome " + name + " to Truong's Furniture Store!");
	System.out.println("what do you want to buy?");
	System.out.println("0. Nothing, exit");
	System.out.println("1. chair");
	System.out.println("2. desk");
	System.out.println("3. sofa");
	
	menuItem = scan.nextInt();
	
	while (menuItem > 0) {
        	
        	if(menuItem == 1) {
        	    System.out.print("how many CHAIRS do you want? ");
        	    quantity = scan.nextInt();   
        	    totalQty += quantity;
        	    totalChairQty += quantity;
        	    cost += calculateCost(chairCost, quantity);
        	} 
        	else if(menuItem == 2) {
        	    System.out.print("how many DESKS do you want? ");
        	    quantity = scan.nextInt();
        	    totalQty += quantity;
        	    totalDeskQty += quantity;
        	    cost += calculateCost(deskCost, quantity);
        	}
        	else if(menuItem == 3) {
        	    System.out.print("how many SOFAS do you want? ");
        	    quantity = scan.nextInt();
        	    totalQty += quantity;
        	    totalSofaQty += quantity;
        	    cost += calculateCost(sofaCost, quantity);
        	}
        	else {
        	    System.out.println("Sorry we don't have any of those");
        	}
        	System.out.println("what else do you want to buy?");
        	System.out.println("0. Nothing, exit");
        	System.out.println("1. chair");
        	System.out.println("2. desk");
        	System.out.println("3. sofa");
        	menuItem = scan.nextInt();
        	
	}//end while
	billOut();
    }//end menu
    
    public static double calculateCost(double cost, int qty) {
	return cost * qty;
    }

    public static double calculateTax(double cost, double tax) {
	return cost * tax;
    }
    
    public static void billOut() {
	System.out.printf("Your total is: $%.2f\n", cost);
	System.out.printf("Your tax is: $%.2f\n", calculateTax(cost, tax));
	System.out.printf("Your total with tax is: $%.2f\n", cost + calculateTax(cost, tax));
	System.out.println("Thanks for coming in, BYE!");
    }
    
    public static void main(String[] args) {
    	menu();
    }//end main

}//end cost
