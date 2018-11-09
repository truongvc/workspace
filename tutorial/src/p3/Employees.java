package p3;

public class Employees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] employeeName = {"greg","george","jill","john","basil"};
		int[] wage = {15,16,21,15,22};
		int[] hoursWorked = new int[5];
		
		hoursWorked[0] = 20;
		hoursWorked[1] = 30;
		hoursWorked[2] = 15;
		hoursWorked[3] = 60;
		hoursWorked[4] = 38;
		
		for(int i = 0; i < wage.length; i++) {//printing name and wage
			System.out.println("i: " + i + " Name: " + employeeName[i] + " \twage: " + wage[i]);
		}
		System.out.println();
		
		for(int i = 0; i < wage.length; i++) {//print this week's pay
			System.out.println("Name: " + employeeName[i] + " \tpay: " + wage[i] * hoursWorked[i]);
		}
	
		for(int i = 0; i < wage.length; i++) {//linear search for wage over 20
			if(wage[i] > 20) {
				System.out.println("FIRE name: " +  employeeName[i]);
				employeeName[i] = "";
				wage[i] = 0;
			}//end if
		}//end for
		
		for(int i = 0; i < wage.length; i++) {//print new name and wage
			System.out.println("i: " + i + " Name: " + employeeName[i] + " \twage: " + wage[i]);
		}
		
	}

}












