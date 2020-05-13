package main;

//References for quick sort algorithm below: https://www.geeksforgeeks.org/quick-sort/

public class QuickSort {

	public static void quickSort(int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int partIndex = partition(lowIndex, highIndex);
			quickSort(lowIndex, partIndex - 1);
			quickSort(partIndex + 1, highIndex);
		}
	}
	
	public static int partition(int lowIndex, int highIndex) {
		Player temp;
		Player pivot = Globals.players[highIndex];
		int startIndex = lowIndex - 1;
		for (int j = lowIndex; j <= highIndex - 1; j++) {
			if (Globals.players[j].payoff < pivot.payoff) {
				startIndex++;
				temp = Globals.players[startIndex];
				Globals.players[startIndex] = Globals.players[j];
				Globals.players[j] = temp;
			}
		}
		temp = Globals.players[startIndex + 1];
		Globals.players[startIndex + 1] = Globals.players[highIndex];
		Globals.players[highIndex] = temp;
		return startIndex + 1;
	}
	
}
