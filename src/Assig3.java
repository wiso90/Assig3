
public class Assig3
{
    

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub

    }
    
    
    
    public static Card getCard(char value, Card.Suit suit)
    {
    	Card myCard = new Card();
    	return myCard;
    }

}

class Card
{
    private char value;
    private Suit suit;
    private boolean errorFlag;
    
    public static enum Suit
    {
    	CLUBS, DIAMONDS, HEARTS, SPADES
    }
}