package test;

import java.util.Random;

public class Sorting {

	public static int[] bSort(int a[]) // Bubble Sort
	{
		int get = 0;
		int set = 0;

		boolean loopSomeMore;
		do {
			loopSomeMore = false;
			for (int j = 0; j < a.length - 1; j++) {
				get++;
				if (a[j] > a[j + 1]) {
					set++;
					// swap a[j] and a[j+1]
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					loopSomeMore = true;
				}
			}
		} while (loopSomeMore);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		int[] t = { get, set };
		System.out.println();
		return t;
	}

	public static void main(String[] args) {

		int runs = 5;
		int[] totals = { 0, 0 };

		for (int j = 0; j < runs; j++) {
			int arraySize = 10;
			int[] array = new int[arraySize];

			Random r = new Random();
			for (int i = 0; i < arraySize; i++) {
				array[i] = r.nextInt(100);
			}
			int[] temp = bSort(array);
			totals[0] += temp[0];
			totals[1] += temp[1];
		} // end for
		
		System.out.println("AVG Gets: " + totals[0]/runs);
		System.out.println("AVG Sets: " + totals[1]/runs);
	}// end main

}
