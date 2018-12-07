package tutorialPkg;

public class Metorite {
	
	private String[] powers = {"extreme smacking","explosion","doing taxes","baking"};
	
	public Metorite() {}
	
	public void mutate(Hero h) {
		int r = (int)(Math.random() * powers.length);
		String newPower = powers[r];
		h.setPower(newPower);
		System.out.println(h.toString());
	}

}
