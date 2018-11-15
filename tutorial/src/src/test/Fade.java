package test;

import java.util.Random;

public class Fade {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	int num = 0;
	Random r = new Random();
	for (int i = 0; i < 8; i++) {
	    int pos = r.nextInt(108)+1;
	    int row = pos % 9;
	    int col = pos % 12;
	    System.out.println("row: " +  row + " col: " + col + " = x: " + (row * 66 + 50) +" y: " + (col * 66 + 50));
	}
    }
}
