/**
 * 
 * @author Keith
 *
 */
class Hand {
	public static final int MAX_CARDS = 50;

	private Card[] myCards = new Card[MAX_CARDS];
	private int numCards;

	public Hand() {
		this.numCards = 0; // initialize number of cards in hand
	}

	public void resetHand() {
		myCards = new Card[MAX_CARDS];
		this.numCards = 0;
	}

	public boolean takeCard(Card card) {
		if (numCards < MAX_CARDS) {
			Card newCard = new Card(card.getValue(), card.getSuit());

			myCards[numCards] = newCard;
			numCards++;

			return true;

		} else {
			return false;
		}

	}

	public Card playCard() {
		if (numCards > 0) {
			Card playedCard = new Card(myCards[numCards - 1].getValue(), myCards[numCards - 1].getSuit());
			myCards[numCards - 1] = null; // set played card to null
			numCards--;

			return playedCard; // return the card on top of hand
		}

		return null;
	}

	public String toString() // returns entire hand as a string
	{
		String currentHand = "|";

		for (int i = 0; i < numCards; i++) {
			currentHand += myCards[i] + "|";

			if (i % 10 == 9 && i != numCards - 1) // organize cards by rows of
													// 10s
			{
				currentHand += "\n|";
			}
		}

		return currentHand;
	}

	public int getNumCards() // accessor for numCards
	{
		return numCards;
	}

	public Card inspectCard(int k) {
		if (k >= 0 && k < getNumCards()) {
			return myCards[k];
		}

		return new Card('0', Card.Suit.SPADES);
	}
}
