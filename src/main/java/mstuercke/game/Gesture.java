package mstuercke.game;

/**
 * This enum contains all possible gestures, that could be used in a round
 */
public enum Gesture {
	ROCK( "Rock" ),
	SCISSORS( "Scissors" ),
	PAPER( "Paper" );

	private final String name;

	Gesture( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	boolean losesAgainst( Gesture opponent ) {
		return getWeakness().equals( opponent );
	}

	Gesture getWeakness() {
		switch ( this ) {
			case ROCK:
				return PAPER;
			case SCISSORS:
				return ROCK;
			case PAPER:
				return SCISSORS;
			default:
				throw new UnsupportedOperationException( String.format( "No weakness defined for gesture %s", this ) );
		}
	}
}
