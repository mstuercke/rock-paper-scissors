package mstuercke.player;


import mstuercke.game.Gesture;

import java.util.Random;

public class Player {
	private final String name;
	private final Strategy strategy;

	Player( String name, Strategy strategy ) {
		this.name = name;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	/**
	 * Responds a new gesture, calculated with the strategy of the player
	 *
	 * @return new gesture
	 */
	public Gesture nextGesture() {
		switch ( strategy ) {
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
				throw new UnsupportedOperationException( String.format(
						"The strategy %s is not supported", strategy ) );
		}
	}
}
