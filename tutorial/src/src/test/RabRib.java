package test;

public class RabRib {
	
	
	  public static int fib( int n )
	  {
		int f;
	    if ( n == 1 ) 
	      f =  1;
	    else if ( n == 2 ) 
	       f = 1;
	    else if (n ==3)
	    	f = 2;
	    else if (n == 4)
	    	f = 3;
	    else if (n == 5)
	    	f = 4;
	    else
	    	f = (fib( n-1 ) + fib( n-2 ));
	    return f;
	  }

	  public static void main ( String[] args)
	  {
	    int argument = 13;
	    int result = fib( argument );
	    System.out.println("fib(" + argument + ") is " + result );
	  }
	
}
