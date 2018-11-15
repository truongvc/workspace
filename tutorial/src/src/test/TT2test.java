package test;
import java.util.Scanner;
public class TT2test {
	public static void main(String[] args) {//start main


		System.out.println("Hello welcome to the most awesome calculator ever!"); //printing


		Scanner input = new Scanner(System.in);//this allow keyboard input from the user


		System.out.print("What would you like to do? \n1.ADD\n2.SUBTRACT\n3.MULTIPLY\n4.DIVIDE\n"); //let the user choose

		System.out.print("Enter the number of your choice: ");//prompt

		int choice = input.nextInt();//storing the value

		System.out.print("Enter the first number: ");//asking for the first value

		long firstNumber = input.nextInt(); //storing the value

		System.out.print("Enter the second number: "); //asking for the second value

		long secondNumber = input.nextInt();//storing the value


		switch(choice){ //determining the value

		case 1: // if 1

		System.out.println("I will Add " + firstNumber + " to " + secondNumber); //printing

		break;//stop and move the next prompt

		case 2: // if 2

		System.out.println("I will Subtract " + firstNumber + " to " + secondNumber);//printing

		break;//stop and move the next prompt

		case 3://if 3

		System.out.println("I will Multiply " + firstNumber + " to " + secondNumber);//printing

		break;//stop and move the next prompt

		case 4:// if 4

		System.out.println("I will Divide " + firstNumber + " to " + secondNumber);//printing

		break;//stop and move the next prompt

		default:// if none of the choice

		System.out.println("Option cannot be found");//printing

		break;//stop and move the next prompt

		}




		double result;//the result



		//Add

		if(choice == 1){//determining if 1

		result = firstNumber + secondNumber; //adding

		if(result > 0){ // if greater than 0

		if(result <= 10 ){// if lesser than 10

		System.out.println("The answer is " + result + " and it is a small positive number");//printing

		}else if(result <= 99){// if lesser than 99

		System.out.println("The answer is " + result + " and it is a medium positive number");//printing

		}else if(result <= 1000){// if lesser than 1000

		System.out.println("The answer is " + result + " and it is a large positive number");//printing

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge positive number");//printing

		}

		}else if(result == 0){

		System.out.println("The answer is " + result);//printing

		}else{//if none of the choice

		if(result >= -10 ){// if greater than -10

		System.out.println("The answer is " + result + " and it is a small negative number");//printing

		}else if(result >= -99){// if greater than -99

		System.out.println("The answer is " + result + " and it is a medium negative number");//printing

		}else if(result >= -1000){// if greater than -1000

		System.out.println("The answer is " + result + " and it is a large negative number");//printing

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge negative number");//printing

		}

		}

		}


		//Subtract

		if(choice == 2){//determining if 2

		result = firstNumber - secondNumber;

		if(result > 0){ // if greater than 0

		if(result <= 10 ){// if lesser than 10

		System.out.println("The answer is " + result + " and it is a small positive number");//printing

		}else if(result <= 99){// if lesser than 99

		System.out.println("The answer is " + result + " and it is a medium positive number");//printing

		}else if(result <= 1000){//if lesser than 1000

		System.out.println("The answer is " + result + " and it is a large positive number");//printing

		}else{// if none of the choice

		System.out.println("The answer is " + result + " and it is a huge positive number");//printing

		}

		}else if(result == 0){//if equal to zero

		System.out.println("The answer is " + result);//printing

		}else{//if none of the choice

		if(result >= -10 ){//if greater than -10

		System.out.println("The answer is " + result + " and it is a small negative number");

		}else if(result >= -99){//if greater than -99

		System.out.println("The answer is " + result + " and it is a medium negative number");

		}else if(result >= -1000){//if greater than -1000

		System.out.println("The answer is " + result + " and it is a large negative number");

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge negative number");

		}

		}

		}


		//MULTIPLY

		if(choice == 3){//determining if 3

		result = firstNumber * secondNumber;

		if(result > 0){ // if greater than 0

		if(result <= 10 ){// if lesser than 10

		System.out.println("The answer is " + result + " and it is a small positive number");//printing

		}else if(result <= 99){// if lesser than 99

		System.out.println("The answer is " + result + " and it is a medium positive number");//printing

		}else if(result <= 1000){// if lesser than 1000

		System.out.println("The answer is " + result + " and it is a large positive number");//printing

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge positive number");//printing

		}

		}else if(result == 0){//if none of the choice

		System.out.println("The answer is " + result);//printing

		}else{

		if(result >= -10 ){//if greater than -10

		System.out.println("The answer is " + result + " and it is a small negative number");//printing

		}else if(result >= -99){//if greater than -99

		System.out.println("The answer is " + result + " and it is a medium negative number");//printing

		}else if(result >= -1000){//if greater than -1000

		System.out.println("The answer is " + result + " and it is a large negative number");//printing

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge negative number");//printing

		}

		}

		}


		//Divide

		if(choice == 4){//determining if 4

		result = firstNumber / secondNumber;

		if(result > 0){ // if greater than 0

		if(result <= 10 ){// if lesser than 10

		System.out.println("The answer is " + result + " and it is a small positive number");//printing

		}else if(result <= 99){// if lesser than 99

		System.out.println("The answer is " + result + " and it is a medium positive number");//printing

		}else if(result <= 1000){// if lesser than 1000

		System.out.println("The answer is " + result + " and it is a large positive number");//printing

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge positive number");//printing

		}

		}else if(result == 0){//if none of the choice

		System.out.println("The answer is " + result);//printing

		}else{

		if(result >= -10 ){//if greater than -10

		System.out.println("The answer is " + result + " and it is a small negative number");//printing

		}else if(result >= -99){//if greater than -99

		System.out.println("The answer is " + result + " and it is a medium negative number");//printing

		}else if(result >= -1000){//if greater than -1000

		System.out.println("The answer is " + result + " and it is a large negative number");//printing

		}else{//if none of the choice

		System.out.println("The answer is " + result + " and it is a huge negative number");//printing

		}

		}

		}



		}//end main
}
