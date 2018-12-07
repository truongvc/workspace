package tutorialPkg;

public class DayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day today = new Day(1964,11,28);
	
		System.out.println(today.toString());
		System.out.println(today.getMonth());
		today.addDays(228);
		System.out.println(today.toString());
	}

}
