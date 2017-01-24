
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CardCheck
{

   @Test
   public void shuffleTest()
   {
      Deck d = new Deck(1);
      System.out.println(Arrays.toString(d.getPack()));
      Card[] old = d.getPack().clone();
      d.shuffle();
      System.out.println(Arrays.toString(d.getPack()));
      for (int j = 0; j < old.length; j++)
      {
         assertEquals(Arrays.asList(d.getPack()).contains(old[j]), true);
         assertEquals(false, d.getPack()[j].equals(old[j]));
      }
   }

   @Test
   public void testEqual()
   {
      Card c = new Card('A', Card.Suit.SPADES);
      Card b = new Card('T', Card.Suit.HEARTS);
      Card a = new Card();
      assertEquals(false, c.equals(b));
      assertEquals(true, a.equals(c));
   }

   @Test
   public void errorFlagTest()
   {
      Card a = new Card('X', Card.Suit.CLUBS);
      assertEquals("ILLEGAL STATE", a.toString());

   }

}
