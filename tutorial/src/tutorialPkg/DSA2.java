package tutorialPkg;

public class DSA2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//a
		String[] names = {"jim", "bob","jill", "joan", "chelsea", "jake"};
		int[] grade = {12,11,10,12,10,11};
		int[] exam1 = {100,23,89,75,43,65};
		int[] exam2 = {34,78,64,74,98,43};
		int[] exam3 = {45,67,87,78,54,23};
		
		//b
		System.out.println(names[0]);
		System.out.println(grade[0]);
		System.out.println(exam1[0]);
		System.out.println(exam2[0]);
		System.out.println(exam3[0]);
		System.out.println();
		
		//c
		System.out.println(names[names.length - 1]);
		System.out.println(grade[names.length - 1]);
		System.out.println(exam1[names.length - 1]);
		System.out.println(exam2[names.length - 1]);
		System.out.println(exam3[names.length - 1]);
		System.out.println();
		
		//d
		for(int i = 0; i < names.length; i++) {
			System.out.println("name: " + names[i]);	
		}
		System.out.println();
		
		//e
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + " " + grade[i] + " " 
					+ exam1[i] + " "+ exam2[i] + " " + exam3[i]);	
		}
		System.out.println();
		
		//f
		for(int i = 0; i < names.length; i++) {
			System.out.println((i+1) + ". " + names[i] + " " + grade[i] + " " 
					+ exam1[i] + " "+ exam2[i] + " " + exam3[i]);	
		}
		System.out.println();
		
		System.out.println("/******************next 20%***********************/");
		for(int i = 0; i < names.length; i++) {
			System.out.println("the avg for " + names[i] + " is " + 
					(exam1[i]+ exam2[i] + exam3[i])/3);	
		}
		System.out.println();
		
		System.out.println("/******************next 20%***********************/");
		for(int i = 0; i < names.length; i++) {
			if(exam3[i] > 79) {
				System.out.println(names[i]);
			}
		}
		System.out.println();
		for(int i = 0; i < names.length; i++) {
			if(exam1[i] < 50) {
				exam1[i] = 40;
			}
		}
		System.out.println();
		for(int i = 0; i < names.length; i++) {
			System.out.println(exam1[i]);
		}
		
		
		}//end main
	}//end class

