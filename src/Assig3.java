
public class Assig3
{
    

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub
    	
    	//----- Card Class testing ------
    	Card myCard = new Card('K', Card.Suit.HEARTS);
    	Card hisCard = new Card('7', Card.Suit.SPADES);
    	Card herCard = new Card('0', Card.Suit.CLUBS);
    	
    	System.out.println(myCard.toString());
    	System.out.println(hisCard.toString());
    	System.out.println(herCard.toString());

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
    
    public final static char[] cardNumber = {'2', '3', '4', '5', '6', '7', 
    											'8', '9', 'T', 'J', 'Q', 'K','A'};
    
    public Card(char value, Suit suit)
    {    	
    	set(value, suit);
    }
    
    public Card()	//method overload
    {
    	set('A', Suit.SPADES); //default case
    }
    
    public boolean set(char value, Suit suit)
    {
    	if (isValid(value, suit))
    	{
    		this.value = value;
    		this.suit = suit;
    		errorFlag = false;
    		return true;
    	}
    	else 
    	{
    		errorFlag = true;
    		return false;
    	}
	   
    }
    
    private boolean isValid(char value, Suit suit)
    {
    	for (int i = 0; i < cardNumber.length; i++)
    	{
    		if (cardNumber[i] == value)
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public String toString()
    {
    	if (errorFlag == false)
    	{
    		return value + " of " + suit;
    	}else{
    		return "ILLEGAL STATE";
    	}
    }
    
    public char getValue()
    {
    	return value;
    }
    
    public Suit getSuit()
    {
    	
    	return suit;    	
    }
    
    public boolean getErrorFlag()
    {
    	return errorFlag;
    }
    
    
//------------- Individual mutators not needed yet (?) --------------    
    public void setValue(char value)
    {
    	this.value = value;
    }
    
    public void setSuit(Suit suit)
    {
    	this.suit = suit;   	
    }
}


class Hand 
{
	public static final int MAX_CARDS = 50;
	
	private Card[] myCards;
	private int numCards;
	
	public Hand ()
	{
		this.numCards = 0; //initialize number of cards in hand
	}
	public void resetHand()
	{
		this.numCards = 0;
	}

	public boolean takeCard(Card card)
	{
		if (numCards < MAX_CARDS)
		{
			myCards[numCards] = card;
			numCards++;
			
			return true;
		}else{
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}