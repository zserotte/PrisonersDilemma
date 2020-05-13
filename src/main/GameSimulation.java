package main;

public class GameSimulation {
	
	public static void simulateGames() {
		for (int i = 0; i < Globals.players.length; i++) {
			if (Globals.players[i].type == "T4T") {
				Globals.numT4T++;
			} else if (Globals.players[i].type == "Grudger") {
				Globals.numG++;
			} else if (Globals.players[i].type == "AC") {
				Globals.numAC++;
			} else {
				Globals.numAD++;
			}
			for (int j = i + 1; j < Globals.players.length; j++) {
				if (i != j) {
					for (int k = 0; k < Globals.games; k++) {
						calculatePayoff(i, j);
						char move1 = Globals.players[i].move;
						char move2 = Globals.players[j].move;
						calculateNextMove(i, move2);
						calculateNextMove(j, move1);
					}
				}
			}
		}
	}
	
	public static void calculatePayoff(int i, int j) {
		int[] payoffs = new int[2];
		Player player1 = Globals.players[i];
		Player player2 = Globals.players[j];
		String type1 = player1.type;
		String type2 = player2.type;
		char move1 = player1.move;
		char move2 = player2.move;
		if (move1 == 'C') {
			if (move2 == 'C') {
				payoffs[0] = 3;
				payoffs[1] = 3;
			} else {
				payoffs[0] = 0;
				payoffs[1] = 5;
			}
		} else {
			if (move2 == 'C') {
				payoffs[0] = 5;
				payoffs[1] = 0;
			} else {
				payoffs[0] = 1;
				payoffs[1] = 1;
			}
		}
		int payoff = Globals.typePayoff.get(type1);
		payoff += payoffs[0];
		Globals.typePayoff.put(type1, payoff);
		Globals.players[i].payoff += payoffs[0];
		payoff = Globals.typePayoff.get(type2);
		payoff += payoffs[1];
		Globals.typePayoff.put(type2, payoff);
		Globals.players[j].payoff += payoffs[1];
	}
	
	public static void calculateNextMove(int index, char opponentMove) {
		Player player = Globals.players[index];
		if (player.type == "Grudger" && opponentMove == 'D') {
			Globals.players[index].move = 'D';
		} else if (player.type == "T4T") {
			Globals.players[index].move = opponentMove;
		}
	}
	
}
