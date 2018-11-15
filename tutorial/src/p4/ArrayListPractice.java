package p4;

import java.util.ArrayList;

public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] marks = new int[10];
		//create new ArrayList object
		ArrayList<Integer> grades = new ArrayList<>();
		int num;
		
		//useful methods for ArrayList
		grades.add(76); //adds to ArrayList
		grades.add(88);
		grades.add(1, 90); //insert 90 at index 1
		grades.remove(0); //remove first item (index 0) in ArrayList
		grades.get(0); //return index 0
		num = grades.get(1); //assign value of index 1 to num
		grades.size();//return length of ArrayList
		
		grades.add(35);
		grades.add(75);
		//print ArrayList
		for(int i = 0; i < grades.size(); i++) {
			System.out.println(grades.get(i));
		}
		
		grades.remove(1);
		
		for(int grade: grades) {//enhanced for loop to print ArrayList
			System.out.println(grade);
		}
		
		System.out.println(grades.indexOf(35));//finds index of 35
		
		
		
		
		
		
		
	}

}
