package test;

public class FibRab {
	 public static int rFib( int n )
	  {
		int r;
	    if ( n == 1 ) 
	      r =  1;
	    else if ( n == 2 ) 
	       r = 1;
	    else if (n == 3)
	    	r = 2;
	    else if (n == 4)
	    	r = 3;
	    else if (n == 5)
	    	r = 4;
	    else
	    	r = (rFib(n-1) + fib(n-3));
	    System.out.println("rfib " + n + " is : " + r);
	    return r;
	  }

	 public static int fib( int n )
	  {
		int f;
	    if ( n == 1 ) 
	      f =  1;
	    else if ( n == 2 ) 
	       f = 1;
	    else 
	    	f = (fib(n - 1))  + (fib( n - 2));
	    System.out.println("fib " + n + " is : " + f);
	    return f;
	  }
	    	
	  public static void main ( String[] args){
	    int argument = 8;
	    int result = rFib( argument );
	    System.out.println("fib(" + argument + ") is " + result );
	  }
}
