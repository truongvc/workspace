package tutorialPkg;

public class Counting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i <= 10; i+=2 ) {
			System.out.print(i);
		}
		System.out.println();
		for(int i = 10; i >= 0; i-- ) {
			System.out.print(i + ", ");
		}
		
		String name = "george";
		System.out.println(name.indexOf('r'));
		System.out.println(name.substring(2));
		System.out.println(name.substring(2,5));
		for(int i = 0; i < name.length(); i++ ) {
			System.out.print(i);
		}
		for(int i = 0; i < name.length(); i++ ) {
			System.out.println(name.charAt(i));
			if(name.charAt(i) == 'r') {
				break;
			}
		}
		
		
	}

}
