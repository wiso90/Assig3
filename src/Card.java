
class Card {
	private char value;
	private Suit suit;
	private boolean errorFlag;

	public static enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}
	public final static char[] cardNumber = { '2', '3', '4',
			'5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
	public Card(char value, Suit suit) {
		set(value, suit);
	}

	public Card()
	{
		set('A', Suit.SPADES);
	}

	public boolean set(char value, Suit suit) {
		if (isValid(value, suit)) {
			this.value = value;
			this.suit = suit;
			errorFlag = false;
			return true;
		} else {
			errorFlag = true;
			return false;
		}

	}

	private boolean isValid(char value, Suit suit) {
		for (int i = 0; i < cardNumber.length; i++) {
			if (cardNumber[i] == value) {
				return true;
			}
		}

		return false;
	}

	public String toString() {
		if (errorFlag == false) {
			return value + " of " + suit;
		} else {
			return "ILLEGAL STATE";
		}
	}

	public char getValue() {
		return value;
	}

	public Suit getSuit() {

		return suit;
	}

	public boolean getErrorFlag() {
		return errorFlag;
	}

	// ------------- Individual mutators not needed yet (?) --------------
	public void setValue(char value) {
		this.value = value;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}
