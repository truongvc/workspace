package tutorialPkg;

public class FundRaiser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] name = {"chris","fred","ken","vic","blake"};
		int[] amount = {120,49,300,230,98};
		boolean[] hasForm = {true,true,false,true,false};
		
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i] +  " " + amount[i] + " " + hasForm[i]);
		}
		
		int total = 0;
		for(int i = 0; i < name.length; i++) {
			total += amount[i];
		}
		
		double avg = 0;
		for(int i = 0; i < name.length; i++) {
			avg = total/name.length;
		}
		
		int over200 = 0;
		for(int i = 0; i < name.length; i++) {
			if(amount[i] >200)
				over200++;
		}
		
		int noForm = 0;
		for(int i = 0; i < name.length; i++) {
			if(hasForm[i] == false)
				noForm++	;
		}
		
	}

}
