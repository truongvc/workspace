package p4;
import java.util.Scanner;
public class StoreP4a {

  public static void main(String[] args) {
  	Scanner scanWords = new Scanner(System.in);
  	Scanner scanNums = new Scanner(System.in);
  	double civicCost = 10000.25;
  	double f150Cost = 12500;
  	double f1Cost = 800235.99;
  	int totalQty = 0;
  	int totalCivicQty = 0;
  	int totalF150Qty = 0;
  	int totalF1Qty = 0;
  	final double TAX = 0.05;//gst
  	double cost = 0;//cost of the sale
  	int choice;
  	int qty;
  	System.out.print("What is your name?: ");//prompting user
  	
  	String name = scanWords.nextLine();//input and store name
  	
  	System.out.println("Welcome " + name + " to Brix's not illegal car store");
  	
  	do {
      	System.out.println("\nWhat would you like to buy? " 
      			+ "\n0. exit"	
      			+ "\n1. honda civic" 
      			+ "\n2. ford f150" 
      			+ "\n3. macleran f1"
      			+ "\nenter a number: ");
      	
      	choice = scanNums.nextInt();//declare choice var and store input 
      	
      	if(choice != 0) {
          	System.out.print("How Many would you like to buy? ");
          	
          	qty = scanNums.nextInt();
      	
          	if(choice == 1) {
        	    cost = civicCost * qty + cost;
              totalCivicQty += qty;
              totalCivicQty = totalCivicQty + qty;
            }
            else if(choice == 2) {
              cost += f150Cost * qty;
              totalF150Qty += qty;
            }
            else if(choice == 3) {
              cost += f1Cost * qty;
              totalF1Qty += qty;
            }
            else {
        	    System.out.println("Sorry we don't have those");
          	}
          	totalQty += qty;
      	}  	
  	}while (choice != 0);//end do while 
  	System.out.println("total civics sold: " + totalCivicQty);
  	System.out.println("total F150s sold: " + totalF150Qty);
  	System.out.println("total F1s sold: " + totalF1Qty);
  	System.out.println("total Quantity sold: " + totalQty);
  	System.out.printf("tax is: $%.2f \n", cost * TAX);
  	double totalCost = cost + cost * TAX;
  	System.out.printf("Total with tax is: $%.2f\n", totalCost);
  	System.out.println("thanks for shopping! BYE!");
  }//end main

}
