package test;
/**
 * This program determines the fibanocci number for the given n 
 * @author victor.truong
 *
 */
public class hi {//start class


	public static int fib( int n ){ //method declaration to calculate fib num passes in 'n' for the fib number you want
	  if ( n == 1 ) //base case for fib 1
	    return 1;//we know fib 1 is 1
	    
	  else if  ( n == 2 ) //base case for fib 2
	    return 1;//we also know fib 2 is 
	    
	  else // if requested fib num is > 2 recursively call fib(n) method
	    return fib( n-1 ) + fib( n-2 );//the fib numb is the sum of the 2 previous fib numbers
	}//end fib method
	    public static void main(String[] args) {//main method to run program
	    int x = 12;//fib numb we want to find
	    int fibNum;//var to store fib num
	    fibNum = fib(x);//store result of fib(x) into fibNum var
	    System.out.print("The " + x + "th Fibonacci Number is: " + fibNum);//print out fibNum to console
	    
	    }//end main method
	}//end class

