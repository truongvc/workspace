package tutorialPkg;

import java.util.Scanner;

public class HalloweenMonsters {
	static Scanner numscan = new Scanner(System.in);
	static Scanner wordscan = new Scanner(System.in);

	public static void main(String[] args) {
		String[] monsters = { "vampire", "mummy", "frankenstein", "zombie", "skeleton", "werewolf", "player" };

		System.out.println("what is player's name: ");
		monsters[monsters.length - 1] = "player: " + wordscan.nextLine();

		int[] coins = new int[monsters.length];

		for (int i = 0; i < monsters.length; i++) {
			coins[i] = (int)(Math.random() * 8)+2;
			System.out.println("The " + monsters[i] + " has " + coins[i] + " gold coins!");
		}

		String[] abilities = new String[7];

		abilities[0] = "fangs";
		abilities[1] = "fear";
		abilities[2] = "sheer brute strength";
		abilities[3] = "brain eating teeth";
		abilities[4] = "spook";
		abilities[5] = "claws";
		abilities[6] = "ninja";

		System.out.println();

		for (int i = 0; i < monsters.length; i++) {
			System.out.println("The " + monsters[i] + " has " + coins[i] + " gold coins!");
			System.out.println("It will terrify you with its " + abilities[i] + ". Muaaahaaahaaah!");
		}

		int[] HP = new int[monsters.length];

		for (int i = 0; i < monsters.length; i++) {
			HP[i] = (int) (Math.random() * 15 + 2);
			System.out.println("The " + monsters[i] + " has " + HP[i] + " HP!");
		}

		System.out.println("The zombie ate a teenager.  How many gold coins did it collect?");

		int foundCoins = numscan.nextInt();
		coins[3] += foundCoins;

		int totalCoins = coins[monsters.length-1];

		System.out.println("\nThe total coins are: " + totalCoins);
		while (HP[6] > 0) {
			int randomMonster = (int) (Math.random() * monsters.length);
			if (randomMonster != 6) {
				System.out.println("You turned the corner and there stood a " + monsters[randomMonster]);
				int hitChance = (int) (Math.random() * 2);

				if (hitChance > 0) {
					System.out.println("you hit it with your ninja skills");
					HP[randomMonster] = 0;
					System.out.println("It ran away and left you " + coins[randomMonster] + " gold coins");
					totalCoins += coins[randomMonster];
				} else {
					int randomDmg = (int) (Math.random() * 2 + 1);
					HP[6] -= randomDmg;
					System.out.println(
							"it hit you with " + abilities[randomMonster] + " for " + randomDmg + "HP, you have " + HP[6] + "HP");
				}
				System.out.println();
			}

		} // end while
		System.out.println("you run away with " + totalCoins + " coins");
	}// end main
}
