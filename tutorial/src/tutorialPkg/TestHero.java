package tutorialPkg;

public class TestHero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero h1 = new Hero();
		Hero h2 = new Hero("bill","strong",19,200,20);
		
		System.out.println(h1.toString());
		System.out.println(h2.toString());
		
		Metorite m = new Metorite();
		
		m.mutate(h1);
		m.mutate(h2);
		
		System.out.println(h1.toString());
		System.out.println(h2.toString());
		System.out.println();
		
		while(h1.getHealth() >= 0) {
			h2.fight(h1);
			System.out.println("h1 health: " + h1.getHealth());
		}
		
		
		
		
		
		
		
		
	}

}
