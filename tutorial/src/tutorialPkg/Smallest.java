package tutorialPkg;

public class Smallest {

	public static int smallest(int x, int y, int z) {
		int min = x;
		
		if(y < z  && y < x) {
			min = y;
		}
		else if(z < x && z < y) {
			min = z;
		}
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(smallest(4,5,7));
		System.out.println(smallest(5,2,6));
		System.out.println(smallest(23,54,7));
		System.out.println(smallest(4,7,5));
		System.out.println(smallest(6,2,5));
		System.out.println(smallest(54,23,7));
	}
}
