package tutorialPkg;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "victor";
		String reverse ="";
		for(int i = name.length() - 1; i >=0; i--) {
			reverse += name.charAt(i);
		}
		
		System.out.println(reverse);
		System.out.println("OR");
		String name2 = "truong";
		reverse = "";
		for(int j = name2.length() - 1; j >= 0; j--)
		{
		String letter = name2.substring(j, j + 1); //picks up just one letter at a time
		reverse = reverse + letter;
		}
		System.out.println(reverse);
		

	}

}
