package main;

public class Main {

	public static void main(String[] args) {
		// Initialize game parameters
		Globals.numPlayers = 100;
		Globals.games = 5;
		Globals.generations = 20;
		
		GameInitialization.initializeGame();
		for (int g = 0; g < Globals.generations; g++) {
			Globals.percentRemoved = g / 100.0;
			GameSimulation.simulateGames();
			PostSimulationWork.printSummary(g);
			QuickSort.quickSort(0, Globals.players.length - 1);
			PostSimulationWork.replicateAndRemove();
			PostSimulationWork.resetVariables();
		}

	}

}
