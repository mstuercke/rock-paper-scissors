package mstuercke.game;


import mstuercke.player.Player;
import mstuercke.player.PlayerFactory;

import java.util.Scanner;

/**
 * This class creates a new Game. All needed parameters will be requested by command-line
 */
public class GameFactory {
	private final Scanner scanner = new Scanner( System.in );

	public Game playGame() {
		Player player1 = new PlayerFactory().createPlayer( "Thor" );
		Player player2 = new PlayerFactory().createPlayer( "Hulk" );
		int rounds = readRounds();

		return Game.play( player1, player2, rounds );
	}

	private int readRounds() {
		System.out.print( "Enter the amount of rounds should be played: " );
		int rounds = scanner.nextInt();
		if ( rounds < 1 ) {
			System.out.println( "Error: Invalid amount of rounds. Please input a value greater or equal to 1." );
			return readRounds(); // recursive call, until valid round was got
		}

		System.out.println();
		return rounds;
	}
}
