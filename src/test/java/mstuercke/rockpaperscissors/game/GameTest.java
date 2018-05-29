package mstuercke.rockpaperscissors.game;

import mstuercke.rockpaperscissors.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GameTest {
	private static Player player1;
	private static Player player2;
	private static Game game;

	@Before
	public void setup() {
		player1 = mock( Player.class );
		player2 = mock( Player.class );

		game = mock( Game.class );
		when( game.getPlayer1() ).thenReturn( player1 );
		when( game.getPlayer2() ).thenReturn( player2 );
	}

	@Test
	public void countCorrectAmoundOfWins() {
		// mock game
		List<Round> rounds = asList(
				simulateWinner( player1 ),
				simulateWinner( player2 ),
				simulateWinner( null ),
				simulateWinner( player1 ) );
		when( game.getRounds() ).thenReturn( rounds );
		when( game.countWins( any() ) ).thenCallRealMethod();

		// assert
		assertEquals( 2, game.countWins( player1 ) );
		assertEquals( 1, game.countWins( player2 ) );
	}

	private Round simulateWinner( Player player ) {
		Round round = mock( Round.class );
		when( round.getWinner() ).thenReturn( Optional.ofNullable( player ) );
		return round;
	}

	@Test
	public void calculatesPlayer1AsWinner() {
		// mock game
		when( game.countWins( player1 ) ).thenReturn( 5L );
		when( game.countWins( player2 ) ).thenReturn( 4L );
		when( game.getWinner() ).thenCallRealMethod();

		// assert
		assertTrue( game.getWinner().isPresent() );
		Assert.assertEquals( player1, game.getWinner().get() );
	}

	@Test
	public void calculatesPlayer2AsWinner() {
		// mock game
		when( game.countWins( player1 ) ).thenReturn( 3L );
		when( game.countWins( player2 ) ).thenReturn( 4L );
		when( game.getWinner() ).thenCallRealMethod();

		// assert
		assertTrue( game.getWinner().isPresent() );
		Assert.assertEquals( player2, game.getWinner().get() );
	}

	@Test
	public void calculatesNooneAsWinner() {
		// mock game
		when( game.countWins( player1 ) ).thenReturn( 4L );
		when( game.countWins( player2 ) ).thenReturn( 4L );
		when( game.getWinner() ).thenCallRealMethod();

		// assert
		assertFalse( game.getWinner().isPresent() );
	}
}
