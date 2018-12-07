package tutorialPkg;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMutant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mutagen x = new Mutagen();
		Superhero bob = new Superhero("bob", 23);
		x.mutate(bob);
		System.out.println();

		
		ArrayList<Superhero> team = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			team.add(new Superhero());
			System.out.println("Enter a name: ");
			team.get(i).setName(input.nextLine());
			x.mutate(team.get(i));
		}
		
		int count = 0;
		
		for(Superhero s: team) {
			if(s.isMutated) {
				System.out.println(s.toString());
				count++;
			}
			// System.out.println("Total powered heros: " + count);
		}
		
		System.out.println();
		System.out.println("Total powered heros: " + count);
		

	}//end main

}//end class
