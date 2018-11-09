package p3;
import java.util.Scanner;

public class StoreP3b {
	//global variables
	static double price = 0; //total price of sale
	static final double TAX = 0.05;
	
	static int totalQty = 0;//accumulator - counter 
	static int charQty =0;
	static int pikaQty = 0;
	static int jigQty = 0;
	
 	public static void menu() {
		Scanner scanWords = new Scanner(System.in); //scanner object to take in words
		Scanner scanNums = new Scanner(System.in); //scanner object to take in nums
		double charizardPrice = 50.0; 
		double pikachuPrice = 6.99;
		double jigglyPuffPrice = 1;
		
		int itemNum;
		System.out.print("what is your name?: "); //prompt user to enter name
		String name = scanWords.nextLine(); //declare name variable and store input
		
		System.out.println("\nWelcome " + name + " to John's Pokemon store");
		//menu items
		do {
			System.out.println("\nWhat would you like to buy?\n"
				+ "0. Exit\n"
				+ "1. charizard\n" 
				+ "2. pikachu\n" 
				+ "3. jiggly puff");
		
			itemNum = scanNums.nextInt();//declare itemNum var and store input
	    	
			if(itemNum != 0) {
	    	System.out.println("How many do you want? ");
			int qty = scanNums.nextInt();	    	
	    	totalQty += qty;
	    	
	    	if(itemNum == 1) {
	    	    price += calcCost(charizardPrice, qty);
	    	    charQty += qty;
	    	}
	    	else if(itemNum == 2) {
	    	    price += calcCost(pikachuPrice, qty);
	    	    pikaQty += qty;
	    	}
	    	else if(itemNum == 3) {
	    	    price += calcCost(jigglyPuffPrice, qty);
	    	    jigQty += qty;
	    	}
	    	else {
	    	    System.out.println("sorry we don't have that");
	    	}
			}//end if(itemNum != 0)
		} while(itemNum != 0);//end of do/while
	    		
		printSummary();
		
	}//end menu
	
	public static double calcCost(double itemPrice, int qty) {
		return itemPrice * qty;
	}//end calcCost
	
	public static double calcTax(double TAX, double price) {
		return TAX * price;
	}//end calcTax
	
	public static void printSummary() {
		System.out.println("Total items sold " + totalQty);
		System.out.println("Total charizards sold " + charQty);
		
		System.out.println("Your total is: " + price);
		
//		System.out.println("Tax is: " + calcTax(TAX,price));
		System.out.printf("Tax is: %.2f \n", calcTax(TAX,price));
		
		double totalPrice = calcTax(TAX,price) + price;
		System.out.printf("Total with tax is: %.2f \n",  totalPrice);
		
		System.out.println("Thanks for shopping, BYE!!");
	}//end printSum
	
	public static void main(String[] args) {
  	menu();
    }//end main
	
	
	
	
	
	
	
    

}
