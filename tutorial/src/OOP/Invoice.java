package OOP;

import java.util.ArrayList;

import tutorialPkg.Customer;

public class Invoice {
	Customer theCustomer;
	ArrayList<LineItem> items = new ArrayList<>();
	/**
	 * @param theCustomer
	 * @param items
	 */
	public Invoice(Customer theCustomer) {
		super();
		this.theCustomer = theCustomer;
//		this.items = items;
	}
	
	public void addToOrder(Product p, int q) {
		LineItem l = new LineItem (q, p);
		items.add(new LineItem (q, p));
	}
	
	public void printInvoice() {
		System.out.println("\nCurrent Order:");
		for(int i = 0; i < items.size(); i++) {
			System.out.println((i+1) + " " + items.get(i).toString());
		}
		
		System.out.println("\nTotal DUE: " + amountDue());
		if(canAfford(theCustomer)) {
			System.out.println("******Purchase APPROVED!!!!!!!");
		}
		else {
			System.out.println("Purchase Denied");
			System.out.println(theCustomer.getName() + " is short " + (amountDue()-theCustomer.getEvilFunds()));
		}
	}
	
	public boolean canAfford(Customer c) {
		if (c.getEvilFunds() - amountDue() >=0) {
			return true;
		}
		else
			return false;
	}
	
	public double amountDue() {
		double total = 0;
		for(LineItem i : items) {
			total += (i.getQty() * i.getaProduct().getPrice());
		}
		return total;
	}
	
}//end class
