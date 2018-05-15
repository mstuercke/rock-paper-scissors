package mstuercke.game;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.stream;
import static junit.framework.TestCase.assertTrue;

public class GestureTest {

	@Test
	public void everyGestureHasAWekness() {
		stream( Gesture.values() )
				.map( Gesture::getWeakness )
				.forEach( Assert::assertNotNull );
	}

	@Test
	public void allGesturesLosingAgainstItsWekness() {
		stream( Gesture.values() )
				.forEach( gesture -> assertTrue( gesture.losesAgainst( gesture.getWeakness() ) ) );
	}
}
