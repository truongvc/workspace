package tutorialPkg;

public class Mutagen {

	private String[] powers = {"Strength","claws","speed","flying","energy shot"};
	//make mutagen constructor to take in name and power(s) it gives
	//make mutate methods for given mutagen
	
	public void mutate(Superhero s) {
		
		if((Math.random() * 10) < 7) {
			s.setMutated(true);
			s.setPower(powers[(int)(Math.random()*powers.length)]);
			s.setPowerLevel((int) (Math.random() * 1000) + 100 );			
			s.setAge((int)(Math.random() * 10 + 1));
			System.out.println("Mutated");
			System.out.println(s.toString());
		}
		else
			System.out.println("Nothing happened " + s.toString());
	}
	
}//end class
