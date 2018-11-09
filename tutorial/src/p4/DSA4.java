package p4;

public class DSA4 {

	public static void main(String[] args) {
	
		String[] names = {"bob","jack","jill","june", "chris", "joe","bill","george",
				"nancy","hayden"};
		
		double[] raisedMoney = {100,343,391,99,842.25,154.50,300.10,50.50,60.90,210.25};
		
		boolean[] returnedForm = {true,false,false,true,true,true,false,false,true,true};
		
		//step 1
		for(int i = 0; i < names.length; i++) {
			System.out.println("Name: " + names[i] + " $" + raisedMoney[i] +
					" form: " + returnedForm[i]);
		}
		//step 2
		double totalAmt = 0; //stores total amount raised
		for(int i = 0; i < raisedMoney.length; i++) {
			totalAmt += raisedMoney[i];//add each index to totalAmt
		}
		double avgRaised = totalAmt / names.length;//calculates avg amount raised
		
		int bigMoneyCount = 0; //tracks how many ppl raised over $200
		
		for(int i = 0; i < raisedMoney.length; i++) { 
			//searching for > 200
			//counting number of ppl over $200
			if(raisedMoney[i] > 200) {
				System.out.println(names[i] + " Raised " + raisedMoney[i]);
				bigMoneyCount++;//add one to bigMoneyCount 
			}
		}
		
		for(int i = 0; i < returnedForm.length; i++) {
			//searching for ppl who have not returned their form
			if(returnedForm[i] == false) {
				System.out.println(names[i] + " has not returned form");
			}
		}
		
		System.out.println("Total amount Raised " + totalAmt);
		System.out.println("avg amount raised " + avgRaised);
		
		double lowestAmt;//declare var for item tracked
		lowestAmt = raisedMoney[0];//assume first index is item searched for
		String person;
		int nameIndex = 0;//tracks index of the person with lowest amt raised
		for(int i = 0; i < raisedMoney.length; i++) {//find lowest amount raised
			if(raisedMoney[i] < lowestAmt){
				lowestAmt = raisedMoney[i];//set new lowest value
				nameIndex = i;
				person = names[i];
			}
		}
		
		System.out.println("lowest amount raised: " + lowestAmt +
				" by " + names[nameIndex]);
		
	}//end main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
