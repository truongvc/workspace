package test;

import java.util.Scanner;

public class tt2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello welcome to the most awesome calculator ever!\n");
		System.out.println("What would you like to do?\n");
		System.out.println("1. ADD");
		System.out.println("2. SUBTRACT");
		System.out.println("3. MULTIPLY");
		System.out.println("4. DIVIDE");
		System.out.print("\nEnter the number of your choice: ");
		int choice = input.nextInt();
		System.out.print("\nEnter the first number: ");
		double num1 = input.nextDouble();
		System.out.print("Enter the second number: ");
		double num2 = input.nextDouble();
		System.out.println();
		double result = 0;
		
		switch(choice){
		case 1:
			System.out.println("I will Add " + num1 + " to " + num2); 
			result = num1 + num2;
			break;
		case 2:
			System.out.println("I will Subtract " + num1 + " to " + num2); 
			result = num1 - num2;
			break;
		case 3:
			System.out.println("I will Multiply " + num1 + " to " + num2); 
			result = num1 * num2;
			break;
		case 4:
			System.out.println("I will Divide " + num1 + " to " + num2); 
			result = num1 / num2;
			break;
		default:
		System.out.println("choice doesn't exist");
		}
		String x;
		if(result > 0){
			 x = " positive ";
		}
		else if(result < 0){
			 x = " negative ";
		}
		else{
			x = " zero ";
		}
		
		if(Math.abs(result) > 0 && Math.abs(result) <= 10){
			System.out.println("The answer is " + result + " and it is a small" + x + "number");
		}
		else if(Math.abs(result) > 10 && Math.abs(result) < 100){
			System.out.println("The answer is " + result + " and it is a medium" + x + "number");
		}
		else if(Math.abs(result) > 100 && Math.abs(result) <= 1000){
			System.out.println("The answer is " + result + " and it is a large" + x + "number");
		}
		else{
			System.out.println("The answer is " + result + " and it is a huge" + x + "number");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/**	
		if(result < 0){
			if(Math.abs(result) > 0 && Math.abs(result) <= 10){
				System.out.println("The answer is " + result + " and it is a small negative number");
			}
			else if(Math.abs(result) > 10 && Math.abs(result) < 100){
				System.out.println("The answer is " + result + " and it is a medium negative number");
			}
			else if(Math.abs(result) > 100 && Math.abs(result) <= 1000){
				System.out.println("The answer is " + result + " and it is a large negative number");
			}
			else{
				System.out.println("The answer is " + result + " and it is a huge negative number");
			}
		}//end if negative
		else if(result > 0){
			if(Math.abs(result) > 0 && Math.abs(result) <= 10){
				System.out.println("The answer is " + result + " and it is a small positive number");
			}
			else if(Math.abs(result) > 10 && Math.abs(result) < 100){
				System.out.println("The answer is " + result + " and it is a medium positive number");
			}
			else if(Math.abs(result) > 100 && Math.abs(result) <= 1000){
				System.out.println("The answer is " + result + " and it is a large positive number");
			}
			else{
				System.out.println("The answer is " + result + " and it is a huge positive number");
			}
		}//end if positive
		else{
			System.out.println("The answer is 0");
		}//end else
		**/		
	}

}
