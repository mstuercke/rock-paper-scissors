package mstuercke.game;


import mstuercke.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
	private final Player player1;
	private final Player player2;
	private final int totalRounds;
	private final ArrayList<Round> rounds;

	/**
	 * Creates a new game. The rounds will be instantly calculated.
	 *
	 * @param player1     The first player
	 * @param player2     The second player
	 * @param totalRounds The amount of rounds that should be played together
	 */
	Game( Player player1, Player player2, int totalRounds ) {
		this.player1 = player1;
		this.player2 = player2;
		this.totalRounds = totalRounds;
		this.rounds = createRounds();
	}

	private ArrayList<Round> createRounds() {
		ArrayList<Round> rounds = new ArrayList<>();
		for ( int i = 0; i < totalRounds; i++ )
			rounds.add( new Round( this ) );

		return rounds;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	/**
	 * Determines the player, that won the most rounds
	 *
	 * @return winning player. If empty, there is no winner
	 */
	public Optional<Player> getWinner() {
		if ( countWins( getPlayer1() ) > countWins( getPlayer2() ) )
			return Optional.of( getPlayer1() );
		else if ( countWins( getPlayer1() ) < countWins( getPlayer2() ) )
			return Optional.of( getPlayer2() );
		else
			return Optional.empty();
	}

	/**
	 * Counts the quantity, how often the given player won rounds in this game
	 *
	 * @param player the player, that wins should be counted
	 * @return quantity of wins
	 */
	public long countWins( Player player ) {
		return getRounds()
				.stream()
				.map( Round::getWinner )
				.filter( Optional::isPresent )
				.map( Optional::get )
				.filter( winner -> winner.equals( player ) )
				.count();
	}
}
