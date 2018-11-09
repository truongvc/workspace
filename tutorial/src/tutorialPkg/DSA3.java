package tutorialPkg;

import java.util.Scanner;

public class DSA3 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// a
		String[] item = { "apple", "pear", "bannana", "grapes", "pineapple" };
		double[] price = { 2.98, 3.85, 4.77, 1.5, 3.5 };
		int[] qty = new int[item.length];

		// b
		for (int i = 0; i < item.length; i++) {
			System.out.println(i + ". " + item[i] + " " + price[i]);
		}
		System.out.println("enter -1 to stop shopping");
		System.out.println();

		// c
		System.out.print("what do you want to buy? enter a number: ");
		int choice = input.nextInt();
		while (choice != -1) {
			// d
			System.out.print("how many ");
			qty[choice] = input.nextInt();

			// e
			System.out.println(qty[choice] + " " + item[choice] + " comes to " + (qty[choice] * price[choice]));

			//f
			for (int i = 0; i < item.length; i++) {
				System.out.println(i + ". " + item[i] + " " + price[i]);
			}
			System.out.println("enter -1 to stop shopping");
			System.out.println();
			choice = input.nextInt();
		}

	}// end main
}// end class
