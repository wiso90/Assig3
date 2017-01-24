
/**
 * 
 * @author Keith
 *
 */
class Deck
{

   private static final int NUMBER_OF_CARDS = 52;
   public static final int MAX_CARDS = 6 * NUMBER_OF_CARDS;
   private static Card[] masterPack = new Card[NUMBER_OF_CARDS];
   private static boolean emptyMasterPack = true;
   private Card[] cards;
   private int topCard;
   private int numPacks;

   /**
    * a constructor that populates the arrays and assigns initial values to
    * members.
    * 
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      if (emptyMasterPack)
      {
         allocateMasterPack();
      }

   }

   public Deck()
   {
      if (emptyMasterPack)
      {
         allocateMasterPack();
      }

   }

   public void init(int numPacks)
   {

   }

   private static void allocateMasterPack()
   {
      Card.Suit suit;
      for (int i = 0; i < masterPack.length; i++)
      {
         if (i < 13)
         {
            suit = Card.Suit.CLUBS;
         } else if (i < 26)
            suit = Card.Suit.DIAMONDS;
         else if (i < 39)
         {
            suit = Card.Suit.HEARTS;
         } else
         {
            suit = Card.Suit.SPADES;
         }
         // chang suit after every 13th card
         masterPack[i] = new Card(Card.cardNumber[i % 13], suit);
      }
   }

   public Card[] getPack()
   {
      return masterPack;
   }

   public void shuffle()
   {
      Card temp;
      cards = masterPack;

      for (int i = cards.length - 1; i > 0; i--)
      {
         int rand = (int) (Math.random() * i);
         // System.out.println(rand);
         temp = cards[i];
         cards[i] = cards[rand];
         cards[rand] = temp;
      }
      topCard = 0;

   }

   public Card dealCard()
   {
      Card theCard;
      if (topCard < cards.length)
      {
         theCard = cards[topCard];
         topCard++;
      } else
         theCard = null;

      return theCard;
   }

}
