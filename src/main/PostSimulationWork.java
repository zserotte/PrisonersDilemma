package main;

public class PostSimulationWork {

	public static void replicateAndRemove() {
		int size = (int) (Globals.numPlayers * Globals.percentRemoved);
		int limit = Globals.numPlayers - size;
		int index = 0;
		for (int i = Globals.numPlayers - 1; i >= limit; i--) {
			Player temp = new Player(Globals.players[i].type, Globals.players[i].move);
			Globals.players[index] = temp;
			index++;
		}
	}
	
	public static void printSummary(int generation) {
		double playersLength = Globals.players.length;
		double T4Tpop = Math.round((Globals.numT4T / playersLength) * 100.0);
		double Gpop = Math.round((Globals.numG / playersLength) * 100.0);
		double ACpop = Math.round((Globals.numAC / playersLength) * 100.0);
		double ADpop = Math.round((Globals.numAD / playersLength) * 100.0);
		System.out.println("Generation " + (generation + 1) + " Statistics");
		System.out.println("Percentage of population for each type of player");
		System.out.println("T4T: " + T4Tpop + "% G: " + Gpop + "% AC: " + ACpop + "% AD: " + ADpop + "%");
		int T4Tpay;
		if (Globals.typePayoff.containsKey("T4T")) {
			T4Tpay = Globals.typePayoff.get("T4T");
		} else {
			T4Tpay = 0;
		}
		int Gpay;
		if (Globals.typePayoff.containsKey("Grudger")) {
			Gpay = Globals.typePayoff.get("Grudger");
		} else {
			Gpay = 0;
		}
		int ACpay;
		if (Globals.typePayoff.containsKey("AC")) {
			ACpay = Globals.typePayoff.get("AC");
		} else {
			ACpay = 0;
		}
		int ADpay;
		if (Globals.typePayoff.containsKey("AD")) {
			ADpay = Globals.typePayoff.get("AD");
		} else {
			ADpay = 0;
		}
		int totalPayoff = T4Tpay + Gpay + ACpay + ADpay;
		System.out.println("Sum of the payoff for each type of player");
		System.out.println("T4T: " + T4Tpay + " G: " + Gpay + " AC: " + ACpay + " AD: " + ADpay + " Total: " + totalPayoff);
		double T4Tavg = Math.round((T4Tpay/Globals.numT4T)*100.0)/100.0;
		double Gavg = Math.round((Gpay/Globals.numG)*100.0)/100.0;
		double ACavg = Math.round((ACpay/Globals.numAC)*100.0)/100.0;
		double ADavg = Math.round((ADpay/Globals.numAD)*100.0)/100.0;
		System.out.println("Averge payoff for each type of player");
		System.out.println("T4T: " + T4Tavg + " G: " + Gavg + " AC: " + ACavg + " AD: " + ADavg);
		System.out.println();
		System.out.println(" --- End of generation --- ");
		System.out.println();
	}
	
	public static void resetVariables() {
		Globals.numT4T = 0;
		Globals.numG = 0;
		Globals.numAD = 0;
		Globals.numAC = 0;
		String type;
		char move;
		int multiplier = Globals.numPlayers / 4;
		
		for (int i = 0; i < 4; i++) {
			type = Globals.types[i];
			Globals.typePayoff.put(type, 0);
			for (int j = 0; j < Globals.numPlayers / 4; j++) {
				if (type == "AD") {
					move = 'D';
				} else {
					move = 'C';
				}
				int index = (i * multiplier) + j;
				Globals.players[index].move = move;
				Globals.players[index].payoff = 0;
			}
		}
	}
	
}
