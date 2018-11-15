package test;
import java.util.Scanner;

public class TestInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create scanner object
		Scanner input = new Scanner(System.in);//this allows keyboard input from user
		
		//prompt the user for input
		System.out.print("Enter your Age: ");
		
		int age = input.nextInt();//store the input into the age variable
		
		if(age >= 18){//do something with inputed data
			System.out.println(" You are able to vote!");
		}
		else{
			System.out.println("\n You are NOT able to vote!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
