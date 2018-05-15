package mstuercke.player;


import java.util.Scanner;

import static java.util.Arrays.stream;

/**
 * This class creates a new Player. All needed parameters will be requested by command-line
 */
public class PlayerFactory {
	private final Scanner scanner = new Scanner( System.in );

	public Player createPlayer( String name ) {
		System.out.print( String.format( "Enter the strategy for Player %s (number): ", name ) );
		return Strategy
				.getByOrdinal( scanner.nextInt() )
				.map( strategy -> new Player( name, strategy ) )
				.orElseGet( () -> {
					System.out.println( "Error: Invalid strategy input. Please input the number of the strategy." );
					printStrategies();  // recursive call, until valid strategy was got
					return createPlayer( name );
				} );
	}

	private void printStrategies() {
		System.out.println( "Available strategies:" );
		stream( Strategy.values() )
				.map( strategy -> String.format( "%s = %s", strategy.ordinal(), strategy.getName() ) )
				.forEach( System.out::println );
		System.out.println();
	}
}
