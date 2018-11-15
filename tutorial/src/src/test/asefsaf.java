package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class asefsaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

ArrayList<ArrayList<String>> wordsList = new ArrayList<>();
ArrayList<String> words = new ArrayList<String>();
ArrayList<String> words2 = new ArrayList<String>();
ArrayList<String> words3 = new ArrayList<String>();
words.add("123");
words.add("456");
words.add("789");

words2.add("aadf");
words2.add("sadf");
words2.add("ewt");


words3.add("ASDG");
words3.add("GHGF");
words3.add("34RES");

wordsList.add(words);
wordsList.add(words2);
wordsList.add(words3);

System.out.println(wordsList);
System.out.println(wordsList.get(1).get(2));
	}

}
