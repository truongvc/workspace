package p4;

public class EmployeesP4 {

	public static void main(String[] args) {
		String[] employeeName = {"john","jill","george","greg","basil"};
		int[] wage = {15,16,22,17,25};
		
		int[] hours = new int[5];
		
		hours[0] = 34;
		hours[1] = 25;
		hours[2] = 45;
		hours[3] = 58;
		hours[4] = 40;
		
		for(int i = 0; i < wage.length; i++) {//print names and wages
			System.out.println("i: " + i + " Name: " + employeeName[i] + " \twage: " 
					+ wage[i]);
		}
		System.out.println();
				
		for(int i = 0; i < wage.length; i++) {//print pay
			System.out.println("Name: " + employeeName[i] + " \tPay: " + 
		  wage[i] * hours[i]);
		}
		
		System.out.println();
		
		for(int i = 0; i < wage.length; i++) {//linear search fire unproductive employees
			if(hours[i] < 40) {
				System.out.println("FIRE: " + employeeName[i]);
				employeeName[i] = "";
				wage[i] = 0;
			}
		}
		
		for(int i = 0; i < wage.length; i++) {//print names and wages
			System.out.println("i: " + i + " Name: " + employeeName[i] + " \twage: " 
					+ wage[i]);
		}
		
	}

}







