package mstuercke.rockpaperscissors;

import mstuercke.rockpaperscissors.game.Game;
import mstuercke.rockpaperscissors.game.GameFactory;
import mstuercke.rockpaperscissors.game.Round;
import mstuercke.rockpaperscissors.player.Player;

public class Main {
	public static void main( String[] args ) {
		// create game
		Game game = new GameFactory().playGame();

		// print round results
		System.out.println( "Rounds:" );
		System.out.println( "------------------" );
		game.getRounds().forEach( Main::printRound );
		System.out.println();

		// print game results
		System.out.println( "Game results:" );
		System.out.println( "------------------" );
		printGameResults( game );
	}

	private static void printRound( Round round ) {
		// player 1
		System.out.println( String.format( "%s: %s",
				round.getPlayer1().getName(),
				round.getPlayer1Gesture().getName() ) );

		// player 2
		System.out.println( String.format( "%s: %s",
				round.getPlayer2().getName(),
				round.getPlayer2Gesture().getName() ) );

		// winner
		System.out.println( String.format( "Round winner: %s",
				round.getWinner().map( Player::getName ).orElse( "No one" ) ) );
		System.out.println();
	}

	private static void printGameResults( Game game ) {
		// player 1
		System.out.println( String.format( "%s won %s round(s)",
				game.getPlayer1().getName(),
				game.countWins( game.getPlayer1() ) ) );

		// player 2
		System.out.println( String.format( "%s won %s round(s)",
				game.getPlayer2().getName(),
				game.countWins( game.getPlayer2() ) ) );

		// winner
		System.out.println( String.format( "Game winner: %s",
				game.getWinner().map( Player::getName ).orElse( "No one" ) ) );
	}
}
