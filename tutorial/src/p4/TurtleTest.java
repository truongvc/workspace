package p4;

import java.awt.Color;

public class TurtleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Turtle t = new Turtle();
		t.create(500,500);
		t.setColor(Color.black);
		t.fly(t.width/2,t.height/2);
		t.forward(100);
		t.rotate(90);
		t.forward(100);
		t.rotate(90);
		t.forward(100);
		t.rotate(90);
		t.forward(100);
		t.rotate(90);
		t.forward(100);
		
		
		t.render();


	}

}
