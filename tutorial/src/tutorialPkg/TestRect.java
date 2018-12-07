package tutorialPkg;

public class TestRect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rect r1 = new Rect();
		Rect r2 = new Rect(5,20,200,5);
		
		r2.translate(25, -25);
		System.out.println(r1.toString());
		System.out.println(r2.toString());

		
	}

}
