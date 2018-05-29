package mstuercke.rockpaperscissors.player;


import java.util.Optional;
import java.util.Scanner;

import static java.util.Arrays.stream;

/**
 * This class creates a new Player. All needed parameters will be requested by command-line
 */
public class PlayerFactory {
	private final Scanner scanner = new Scanner( System.in );

	public Player createPlayer( String name ) {
		printStrategies();

		// repeat loop, until valid strategy was received
		while ( true ) {
			Optional<Strategy> strategy = readStrategy( name );

			if ( strategy.isPresent() ) {
				return new Player( name, strategy.get() );
			} else {
				System.out.println( "Error: Invalid strategy input. Please input the number of the strategy." );
				printStrategies();
				System.out.println();
			}
		}
	}

	private Optional<Strategy> readStrategy( String name ) {
		System.out.print( String.format( "Enter the number of the strategy for Player %s: ", name ) );
		return Strategy.getByOrdinal( scanner.nextInt() );
	}

	private void printStrategies() {
		System.out.println( "Available strategies:" );
		stream( Strategy.values() )
				.map( strategy -> String.format( "%s = %s", strategy.ordinal(), strategy.getName() ) )
				.forEach( System.out::println );
	}
}
