package p4;

import java.util.Scanner;

import p3.Monsters;

public class MonsterGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] monster = {"vampire","mummy","frankenstein","zombie", "skeleton", 
				"werewolf", "player"};
		
		System.out.print("what is player name?: ");//prompt
		monster[monster.length - 1] = "player: " + input.nextLine();
		
		//create coins array and fill randomly
		int[] coins = new int[monster.length];
		for(int i = 0; i < monster.length; i++) {
			coins[i] = (int)(Math.random() * 8 + 2);
		}
		
		String[] ability = new String[monster.length];
		ability[0] = "fangs";
		ability[1] = "fear";
		ability[2] = "brute strength";
		ability[3] = "brain eating teeth";
		ability[4] = "spook";
		ability[5] = "claws";
		ability[6] = "ninja skills";
		
		for(int i = 0; i < monster.length; i++) {
			System.out.println(monster[i] + " attacks with " + ability[i]
					+ " has " + coins[i] + " gold coins");
		}
		System.out.println();
		
		//randomly assign hp
		int[] hp = new int[monster.length];
		for(int i = 0; i < monster.length; i++) {
			hp[i] = (int)(Math.random() * 15 + 5);
			System.out.println(monster[i] + " has " + hp[i] + " HP");
		}
		
		System.out.println("The vampire ate a teenager, how many coins did it collect:");
		coins[0] += input.nextInt();
		System.out.println(monster[0] + " has " + coins[0] + " gold coins");
		
		System.out.print("the " + monster[2] + " gets mutated into what? ");
		input.nextLine();//eats up extra return/enter symbol
		monster[2] = input.nextLine();
		
		System.out.println("new monster: " + monster[2]);
		int totalCoins = coins[monster.length - 1];//set total to initial value
		int turns = 0;
		//fight while player hp > 0
		while(hp[monster.length - 1] > 0) {
			int randomMonster = (int)(Math.random() * monster.length);//pick random monster
			if(randomMonster != monster.length - 1) {//check to make sure not fight self
				int hitChance = (int)(Math.random() * 2);
				
				if(hitChance % 2 == 0) {
					System.out.println("you hit with your " + ability[monster.length - 1]
							+ " ability and " + monster[randomMonster] + " drops" 
							+ coins[randomMonster] + " gold Coins");
					totalCoins += coins[randomMonster];
				}
				else if(hitChance % 2 == 1) {
					int randomDmg = (int)(Math.random() * 2 + 1);
					hp[monster.length - 1] -= randomDmg;
					System.out.println(monster[randomMonster] + " hit you for " 
							+ randomDmg + " damage. " + hp[monster.length -1 ] 
							+ "hp remaining");			
				}//end else if
				
				turns++;	
			}//if
			System.out.println();
		}//end while
		System.out.println("you runaway with " + totalCoins + 
				" coins and lasted " + turns + " turns");
	}//end main

}//end class















