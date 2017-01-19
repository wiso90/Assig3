
public class Assig3
{
    

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub
    	
    	
    	Card myCard = new Card('A', Card.Suit.CLUBS);
    	
    	System.out.println(myCard.toString());

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
    
    public Card(char value, Suit suit)
    {
    	
    	this.value = value;
    	this.suit = suit;
    }
    
    public Card()	//method overload
    {
    	this.value = 'A';
    	this.suit = suit.SPADES;
    }
    
    public boolean set(char value, Suit suit)
    {
    	this.errorFlag = isValid(value, suit);
    	return errorFlag;    	   
    }
    
    private boolean isValid(char value, Suit suit)
    {
    	return true;
    }
    
    public String toString()
    {
    	if (errorFlag == false)
    	{
    		return getValue() + " of " + getSuit();
    	}else{
    		return "ILLEGAL STATE";
    	}
    }
    
    public char getValue()
    {
    	return value;
    }
    
    public String getSuit()
    {
    	switch (suit)
    	{
    	case CLUBS:
    		return "Clubs";
    	case DIAMONDS:
    		return "Diamonds";
    	case HEARTS:
    		return "Hearts";    	
    	}
    	return "Spades";    	
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