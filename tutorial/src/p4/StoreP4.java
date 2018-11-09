package p4;
import java.util.Scanner;
public class StoreP4 {
	static final double TAX = 0.05;//gst
	static double cost = 0;//cost of the sale
	static int totalQty = 0;
	
  public static void main(String[] args) {
  	menu();
    }//end main

  public static void menu() {
  	Scanner scanWords = new Scanner(System.in);
  	Scanner scanNums = new Scanner(System.in);
  	double civicCost = 10000.25;
  	double f150Cost = 12500;
  	double f1Cost = 800235.99;
  	int choice; //menu choice
  	System.out.print("What is your name?: ");//prompting user
  	String name = scanWords.nextLine();//input and store name
  	
  	System.out.println("Welcome " + name + " to Brix's not illegal car store");
  	do {
  	System.out.println("\nWhat would you like to buy? enter a number:" 
  			+ "\n 0. exit"	
  			+ "\n1. honda civic" 
  			+ "\n2. ford f150" 
  			+ "\n3. macleran f1");
  	
     choice = scanNums.nextInt();// store input into choice variable 
  	
  	if(choice != 0) {
  		System.out.print("How Many would you like to buy? ");
  	  int qty = scanNums.nextInt();
  	  totalQty += qty;
          	if(choice == 1) {
          	   cost += calcCost(civicCost, qty);
          	}
          	else if(choice == 2) {
          	    cost += calcCost(f150Cost, qty);
          	}
          	else if(choice == 3) {
          	    cost += calcCost(f1Cost, qty);
          	}
          	else {
          	    System.out.println("Sorry we don't have those");
          	}
  		}//end if choice != 0	
  	}while (choice != 0); //end do-while 
  	printSummary();
  }//end menu
  
  public static double calcCost(double price, int qty) {
  	return price * qty;
  }//end calcCost
  
  public static double calcTax(double TAX, double cost) {
  	return TAX * cost;
  }//end calcTax
  
  public static void printSummary() {
  	System.out.println("Total number of items sold: " + totalQty);
  	System.out.printf("tax is: $%.2f\n", calcTax(TAX, cost));
  	double totalCost = cost + calcTax(TAX, cost);
  	System.out.printf("Total with tax is: $%.2f\n", totalCost);
  	System.out.println("thanks for shopping! BYE!");
  }//end printSum
  
  
  
  
  
  
  
}
