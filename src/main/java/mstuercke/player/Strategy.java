package mstuercke.player;

import mstuercke.game.Gesture;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

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

	/**
	 * Responds a new gesture, based on the strategy
	 *
	 * @return new gesture
	 */
	public Gesture nextGesture() {
		switch ( this ) {
			case RANDOM:
				int gestureOrdinal = new Random().nextInt( Gesture.values().length );
				return Gesture.values()[gestureOrdinal];

			case ROCK_ONLY:
				return Gesture.ROCK;

			case SCISSORS_ONLY:
				return Gesture.SCISSORS;

			case PAPER_ONLY:
				return Gesture.PAPER;

			default:
				throw new UnsupportedOperationException(
						String.format( "The strategy %s is not supported", this ) );
		}
	}
}
