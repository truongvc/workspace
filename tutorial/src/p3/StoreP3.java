package p3;
import java.util.Scanner;

public class StoreP3 {

  public static void main(String[] args) {
	Scanner scanWords = new Scanner(System.in); //scanner object to take in words
	Scanner scanNums = new Scanner(System.in); //scanner object to take in nums
	double charizardPrice = 50.0; 
	double pikachuPrice = 6.99;
	double jigglyPuffPrice = 1;
	double price = 0; //total price of sale
	final double TAX = 0.05;
	double totalCost;
	
	System.out.print("what is your name?: "); //prompt user to enter name
	String name = scanWords.nextLine(); //declare name variable and store input
	
	System.out.println("\nWelcome " + name + " to John's Pokemon store");
	//menu items
	
	System.out.println("\nWhat would you like to buy?\n"
			+ "0. Exit\n"
			+ "1. charizard\n" 
			+ "2. pikachu\n" 
			+ "3. jiggly puff");
	
	int itemNum = scanNums.nextInt();//declare itemNum var and store input
	
	while(itemNum != 0) {
    	
    	System.out.println("How many do you want? ");
    	
    	int qty = scanNums.nextInt();
    	
    	if(itemNum == 1) {
    	    price = charizardPrice * qty + price;
    	}
    	else if(itemNum == 2) {
    	    price += pikachuPrice * qty;
    	}
    	else if(itemNum == 3) {
    	    price += jigglyPuffPrice * qty;
    	}
    	else {
    	    System.out.println("sorry we don't have that");
    	}
    	
    	System.out.println("\nWhat would you like to buy?\n"
    			+ "0. Exit\n"
    			+ "1. charizard\n" 
    			+ "2. pikachu\n" 
    			+ "3. jiggly puff");
    	
    	itemNum = scanNums.nextInt();//declare itemNum var and store input
    	
	}//end while
	
	System.out.println("Your total is: " + price);
	System.out.println("Tax is: " + price * TAX);
	double totalPrice = price * TAX + price;
	System.out.println("Total with tax is: " + totalPrice);
	System.out.println("Thanks for shopping, BYE!!");
    }
    

}
