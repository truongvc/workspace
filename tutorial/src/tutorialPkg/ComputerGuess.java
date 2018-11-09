package tutorialPkg;

import java.util.Scanner;

public class ComputerGuess {

	 public static void main(String[] args) {
   	
     Scanner numScan = new Scanner(System.in);
     Scanner wordScan = new Scanner(System.in);
     String name;
     String playAgain;
     int guess = 50;
     String hint="n";
     int high = 100;
     int low = 0;

     System.out.print("Welcome to the game.  What is your name? ");
     name = wordScan.nextLine();
     
     System.out.print("Do you want to play a game? Enter 'yes' or 'no' ");
     playAgain = wordScan.nextLine();
     
//     while(playAgain.equalsIgnoreCase("yes")) {
     while(true) {
     	System.out.println("Hello " + name + " pick a number between zero and 99.");
     
      // int computerNum = numScan.nextInt();
//       System.out.println("Debug - the answer is: " + computerNum);
       
      
       System.out.println("is the number " + guess);
       System.out.print("yes or no? ");
    	 hint = wordScan.nextLine();
       while(!hint.equals("y")){
      	 
      	  System.out.println("is it higher or lower?");      
      	  hint = wordScan.nextLine();
           if(hint.equalsIgnoreCase("h")){
          	   low = guess;
               guess = guess + (high - guess)/2 ;
              
           } else if (hint.equalsIgnoreCase("l")){
              high = guess;
              guess = low + (guess - low) /2;
              
           }
           System.out.println("is the number " + guess);
           System.out.print("yes or no? ");
        	 hint = wordScan.nextLine();
       }//end while loop
       
       System.out.println("I win!");
       System.out.print("Do you want to play again? Enter 'yes' or 'no' ");
       playAgain = wordScan.nextLine();
       high = 100;
       low = 0;
       guess = 50;
       if(playAgain.equals("no"))
       	break;
     }//
     System.out.println("Bye!! Thanks for playing!!");
 }//end main

}
