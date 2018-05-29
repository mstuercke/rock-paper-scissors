package mstuercke.rockpaperscissors.player;


import mstuercke.rockpaperscissors.game.Gesture;

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
		return strategy.nextGesture();
	}
}
