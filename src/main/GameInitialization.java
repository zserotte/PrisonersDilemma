package main;

import java.util.HashMap;

public class GameInitialization {
	
	public static void initializeGame() {
		
		Globals.players = new Player[Globals.numPlayers];
		Globals.typePayoff = new HashMap<String, Integer>(4);
		Globals.numT4T = 0;
		Globals.numG = 0;
		Globals.numAD = 0;
		Globals.numAC = 0;
		Globals.types = new String[4];
		Globals.types[0] = "T4T";
		Globals.types[1] = "Grudger";
		Globals.types[2] = "AC";
		Globals.types[3] = "AD";
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
				Player player = new Player(type, move);
				Globals.players[(i * multiplier) + j] = player;
			}
		}
	}
}
