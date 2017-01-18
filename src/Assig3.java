
public class Assig3
{
    

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub

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
    
    public static Card getCard(char value, Suit suit)
    {
    	Card myCard = new Card();
    	return myCard;
    }
    
    public static Card getCard()	//method overload
    {
    	Card myCard = new Card();
       	myCard.value = 'A';
       	String suit = "SPADES"; 
    	return myCard;
    }
}