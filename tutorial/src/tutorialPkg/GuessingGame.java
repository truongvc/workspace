package tutorialPkg;

import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
    	
        Scanner numScan = new Scanner(System.in);
        Scanner wordScan = new Scanner(System.in);
        String name;
        String playAgain;
        int guess = 0;

        System.out.print("Welcome to the game.  What is your name? ");
        name = wordScan.nextLine();
        
        System.out.print("Do you want to play a game? Enter 'yes' or 'no' ");
        playAgain = wordScan.nextLine();
        
        while(playAgain.equalsIgnoreCase("yes")) {
//        while(true) {
        	System.out.println("Hello " + name + " Guess a number between zero and 99.");
        
          int computerNum = (int) (Math.random() * 100);
          System.out.println("Debug - the answer is: " + computerNum);
          
          while(guess != computerNum){
              
              if(guess > computerNum){
                  System.out.println("Incorrect.  Guess lower");          
              } else if (guess < computerNum){
                  System.out.println("Incorrect.  Guess higher");
              }
              guess = numScan.nextInt();
          }//end while loop
          
          System.out.println("You win!");
          System.out.print("Do you want to play again? Enter 'yes' or 'no' ");
          playAgain = wordScan.nextLine();
          if(playAgain.equals("no"))
          	break;
        }//outer while
        System.out.println("Bye!! Thanks for playing!!");
    }//end main
}//end class