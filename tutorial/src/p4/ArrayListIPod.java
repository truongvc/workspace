package p4;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListIPod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1
		ArrayList<String> allSongs = new ArrayList<String>();
		ArrayList<String> artists = new ArrayList<>();
		ArrayList<String> partyPlaylist = new ArrayList<>();
		
		//2
		allSongs.add("thank u, next");
		artists.add("Ariana Grande");
		allSongs.add("Happier");
		artists.add("Marshmallow");
		allSongs.add("shallow");
		artists.add("lady gaga");
		allSongs.add("without me");
		artists.add("halsey");
		allSongs.add("into you");
		artists.add("Ariana Grande");
		//3
		ArrayList<String> partyPlayList = new ArrayList<>();
		//part 2
		Scanner input = new Scanner(System.in);
		int choice;
		boolean flag = true;
		
		do {
		for(int i = 0; i < allSongs.size(); i++) {
			System.out.println(i + " " +allSongs.get(i) + " "
					+ artists.get(i));
		}//end for
		
		System.out.println("Select menu option: \n" +
		"1. add song to library \n" + 
		"2. delete song from library \n" +
		"3. add song to party play list \n" +
		"4. exit");
		
	
		choice = input.nextInt();
		switch(choice) {
			case 1:
				input.nextLine();//clear extra enter character
				System.out.print("enter title");
				allSongs.add(input.nextLine());//store title name
				System.out.print("enter artist name");
				artists.add(input.nextLine());//store title name
				break;
				
			case 2:
			//todo - check for valid number
				System.out.println("enter song number to delete");
				int delete = input.nextInt();
				allSongs.remove(delete);
				artists.remove(delete);
				break;
				
			case 3:
				//add to party playlist and print songs and artists of 
				//party playlist
				partyPlaylist.add(allSongs.get(input.nextInt()));
				break;
				
			case 4:
				System.out.println("BYE");
				flag = false;
				break;
				
			default:
				System.out.println("invalid choice");				
		}//end switch
		
		}while(flag);
		
	}//end main
}//end class










