
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CardCheck {

	@Test
	public void shuffleTest() {
		Deck d = new Deck(1);
		System.out.println(Arrays.toString(d.getPack()));
		Card[] old = d.getPack().clone();
		d.shuffle();
		System.out.println(Arrays.toString(d.getPack()));
		for (int j = 0; j < old.length; j++) {
			assertEquals(Arrays.asList(d.getPack()).contains(old[j]), true);
		}
	}

}
