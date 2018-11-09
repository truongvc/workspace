package tutorialPkg;

public class SimpleCeasarCipher2 {

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
			if(s.charAt(i) == ' ' ) {
				encrypted  += ' ';
			}
			else	{
				encrypted += (char)(s.charAt(i) + shiftValue);//add shift to char
//				System.out.println(s.charAt(i) + " is " +  (char)(s.charAt(i) + shiftValue));
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
			}
			else	{
				encrypted += (char)(s.charAt(i) - shiftValue);//add shift to char
//				System.out.println(s.charAt(i) + " is " +  (char)(s.charAt(i) - shiftValue));
			}
		}
		return encrypted;
		
	}
	


}
