package tutorialPkg; 

public class Cards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] suit = new String[52];
		int[] value = new int[52];
		
		for(int i = 0; i< 52; i++) {
			value[i] = i % 13 + 1;
			if(i /13 % 4 == 0) {
				suit[i] = "Diamonds";
			}
			if(i /13 % 4 == 1) {
				suit[i] = "Clubs";
			}
			if(i /13 % 4 == 2) {
				suit[i] = "Hearts";
			}
			if(i /13 % 4 == 3) {
				suit[i] = "Spades";
			}
		}
		for(int i = 0; i< 52; i++) {
			System.out.println(value[i] + " \t" + suit[i]);
		}

		//shuffle
		for(int i = 0; i < value.length; i++) {
			int index = (int)(Math.random() * value.length);//pick random spot
			
			int tempValue = value[i]; //store current element i into temp var
			String tempSuit = suit[i];
			
			value[i] = value[index]; //swap current element #i with element #index
			suit[i] = suit[index];
			
			value[index] = tempValue;//return temp card to element #index
			suit[index] = tempSuit;
			
		}
		
		System.out.println("SHUFFLED");
		for(int i = 0; i< 52; i++) {
			System.out.println(value[i] + " \t" + suit[i]);
		}
		

	}

}
