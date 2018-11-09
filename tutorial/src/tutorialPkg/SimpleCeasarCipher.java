package tutorialPkg;

public class SimpleCeasarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the lazy fox jumped over the river congrats you decrypted the message";
		String x = "hellozyxt";
		String a = "abcdefghijklmnopqrstuvwxyz";
    String en = encrypt(s,5);
		System.out.println(en);
		System.out.println(decrypt(en,5));
	}
	
	public static String encrypt(String s, int shiftValue) {
		String encrypted = "";
		s = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ' )
				encrypted  += ' ';
			else if((char)(s.charAt(i) + shiftValue) > 122) {//char + shift is too big - need to loop back to ascii 'a'
//				encrypted  += (char) (((s.charAt(i) + shiftValue)% 122) + 96); //value of char + shift Value mod by 122 and add 96 to get to front of alphabet
				encrypted  += (char) (s.charAt(i) + shiftValue); 
				System.out.println(s.charAt(i) + " is " + 
				(char) (((s.charAt(i) + shiftValue)% 122) + 96) );
			}
			else	{
				encrypted += (char)(s.charAt(i) + shiftValue);//add shift to char
				System.out.println(s.charAt(i) + " is " +  (char)(s.charAt(i) + shiftValue));
			}
		}
		return encrypted;
	}//end encrypt
	
	public static String decrypt(String s, int shiftValue) {
		String encrypted = "";
		s = s.toLowerCase();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ' ) {
				encrypted  += ' ';
				System.out.println();
			}
			else if((char)(s.charAt(i) - shiftValue) < 97) {//char + shift is too big - need to loop back to ascii 'a'
				System.out.println(s.charAt(i) + " is " + 
				(char) (122-(96 % (s.charAt(i) - shiftValue))));
//				encrypted += (char)(s.charAt(i) - shiftValue);//add shift to char
				encrypted += (char)(122-(96 % (s.charAt(i) - shiftValue)));
			}
			else	{
				encrypted += (char)(s.charAt(i) - shiftValue);//add shift to char
				System.out.println(s.charAt(i) + " is " +  (char)(s.charAt(i) - shiftValue));
			}
		}
		return encrypted;
		
	}
	


}
