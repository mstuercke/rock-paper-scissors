package mstuercke.game;

import mstuercke.player.Player;

import java.util.Optional;

public class Round {
	private final Game game;
	private Gesture player1Gesture;
	private Gesture player2Gesture;

	Round( Game game ) {
		this.game = game;
		this.player1Gesture = game.getPlayer1().nextGesture();
		this.player2Gesture = game.getPlayer2().nextGesture();
	}

	/**
	 * @return the game, the round belongs to
	 */
	public Game getGame() {
		return game;
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
			return Optional.of( game.getPlayer1() );
		else if ( player1Gesture.losesAgainst( player2Gesture ) )
			return Optional.of( game.getPlayer2() );
		else
			return Optional.empty();
	}

}
