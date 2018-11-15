package test;

public class R1 {

    public static  int doStuff(int i) {
	if(i == 1)
	    return 1;
	return i + doStuff(i-1);
	
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	System.out.println(doStuff(4));
    }

}
