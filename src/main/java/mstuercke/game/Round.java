package mstuercke.game;

import mstuercke.player.Player;

import java.util.Optional;

public class Round {
	private Player player1;
	private Player player2;
	private Gesture player1Gesture;
	private Gesture player2Gesture;

	private Round( Player player1, Player player2 ) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * Creates a new round. The gestures will be instantly calculated.
	 *
	 * @param player1 The first player
	 * @param player2 The second player
	 */
	static Round play( Player player1, Player player2 ) {
		Round round = new Round( player1, player2 );
		round.player1Gesture = player1.nextGesture();
		round.player2Gesture = player2.nextGesture();
		return round;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @return the gesture, that player 1 used in the round
	 */
	public Gesture getPlayer1Gesture() {
		return player1Gesture;
	}

	/**
	 * * @return the gesture, that player 2 used in the round
	 */
	public Gesture getPlayer2Gesture() {
		return player2Gesture;
	}

	/**
	 * Determines the player, that won the round
	 *
	 * @return winning player. If empty, there is no winner
	 */
	public Optional<Player> getWinner() {
		if ( player2Gesture.losesAgainst( player1Gesture ) )
			return Optional.of( player1 );
		else if ( player1Gesture.losesAgainst( player2Gesture ) )
			return Optional.of( player2 );
		else
			return Optional.empty();
	}

}
