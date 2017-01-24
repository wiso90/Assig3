// Assignment 3: Cards
// Name: Huy Nguyen, Wissawakon Sriwarom, Keith Groves

public class Assig3
{

   public static void main(String[] args)
   {

      // ----- Card Class testing ------
      System.out.println("----- Card Class testing ------");

      Card kingHearts = new Card('K', Card.Suit.HEARTS);
      Card sevenSpades = new Card('7', Card.Suit.SPADES);
      Card illegalCard = new Card('0', Card.Suit.DIAMONDS);

      System.out.println(kingHearts.toString());
      System.out.println(sevenSpades.toString());
      System.out.println(illegalCard.toString());

      // ----- Hand Class testing ------
      System.out.println("----- Hand Class testing ------");

      // Dealing cards into hand
      Hand hand = new Hand();

      for (int i = 0; i < Hand.MAX_CARDS; i++)
      {
         if (i % 2 == 1) // if index is odd, then take the king of hearts
         {
            hand.takeCard(kingHearts);
         }
         hand.takeCard(sevenSpades); // else take the 7 of spades
      }

      System.out.println(hand.toString());

      // Inspecting cards in hand
      System.out.println("--- Inspection ---");
      System.out.println(hand.inspectCard(18).toString()); // inspecting the
      // card at index 18
      // in hand
      System.out.println(hand.inspectCard(51).toString()); // inspecting the
      // card at
      // non-existent
      // index in hand

      // Playing cards from hand
      System.out.println("--- Playing cards ---");
      for (int i = hand.getNumCards(); i > 0; i--)
      {
         System.out.println(i + ") Playing: " + hand.playCard().toString());
      }

      System.out.println("After playing all cards...");
      System.out.println("Hand = " + hand.toString()); // should be nothing left
                                                       // in hand to print

      // Printing out a typical deck
      System.out.println("Populating deck...");

      Deck myDeck = new Deck(3);
      myDeck.shuffle();

      for (Card currentCard : myDeck.getPack())
      {
         System.out.println(currentCard.getValue() + " "
            + currentCard.getSuit());
      }
      System.out.println(myDeck.getPack().length);
   }
}
