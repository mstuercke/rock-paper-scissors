package mstuercke.player;

import java.util.Arrays;
import java.util.Optional;

/**
 * This enum contains all strategies, that could be used by a player
 */
public enum Strategy {
	RANDOM( "Random" ),
	ROCK_ONLY( "Rock only" ),
	SCISSORS_ONLY( "Scissors only" ),
	PAPER_ONLY( "Paper only" );

	private final String name;

	Strategy( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Optional<Strategy> getByOrdinal( int ordinal ) {
		return Arrays.stream( Strategy.values() )
				.filter( strategy -> strategy.ordinal() == ordinal )
				.findFirst();
	}

}
