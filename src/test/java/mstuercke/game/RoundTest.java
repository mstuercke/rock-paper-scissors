package mstuercke.game;

import mstuercke.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static mstuercke.game.Gesture.PAPER;
import static mstuercke.game.Gesture.SCISSORS;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RoundTest {
	private static Player player1;
	private static Player player2;

	@Before
	public void setup() {
		player1 = mock( Player.class );
		player2 = mock( Player.class );
	}

	@Test
	public void player1Wins() {
		Optional<Player> winner = calculateWinner( SCISSORS, PAPER );

		assertTrue( winner.isPresent() );
		assertEquals( player1, winner.get() );
	}

	@Test
	public void player2Wins() {
		Optional<Player> winner = calculateWinner( PAPER, SCISSORS );

		assertTrue( winner.isPresent() );
		assertEquals( player2, winner.get() );
	}

	@Test
	public void noOneWins() {
		Optional<Player> winner = calculateWinner( SCISSORS, SCISSORS );

		assertFalse( winner.isPresent() );
	}

	private Optional<Player> calculateWinner( Gesture player1Gesture, Gesture player2Gesture ) {
		when( player1.nextGesture() ).thenReturn( player1Gesture );
		when( player2.nextGesture() ).thenReturn( player2Gesture );

		return Round.play( player1, player2 ).getWinner();
	}
}
