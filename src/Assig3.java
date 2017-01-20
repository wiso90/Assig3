// Assignment 3: Cards
// Name: Huy Nguyen, Wissawakon Sriwarom, Keith Groves

import java.util.*;


public class Assig3
{
    

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub
    	
    	//----- Card Class testing ------
    	System.out.println("----- Card Class testing ------");
    	
    	Card kingHearts = new Card('K', Card.Suit.HEARTS);
    	Card sevenSpades = new Card('7', Card.Suit.SPADES);
    	Card illegalCard = new Card ('0', Card.Suit.DIAMONDS);
    	
    	System.out.println(kingHearts.toString());
    	System.out.println(sevenSpades.toString());
    	System.out.println(illegalCard.toString());
    	
    	
    	//----- Hand Class testing ------
    	System.out.println("----- Hand Class testing ------");
    	
    	
    	// Dealing cards into hand
    	Hand hand = new Hand();
    	
    	for (int i = 0; i < Hand.MAX_CARDS; i++)
    	{
    		if (i%2 == 1) // if index is odd, then take the king of hearts
    		{
    			hand.takeCard(kingHearts);
    		}  		
    		hand.takeCard(sevenSpades); // else take the 7 of spades
    	}
    	
    	System.out.println(hand.toString()); 
    	
    	
    	//Inspecting cards in hand
    	System.out.println("--- Inspection ---");  	
    	System.out.println(hand.inspectCard(18).toString()); // inspecting the card at index 18 in hand
    	System.out.println(hand.inspectCard(51).toString()); // inspecting the card at non-existent index in hand
    	   	
    	
    	// Playing cards from hand
    	System.out.println("--- Playing cards ---");
    	for (int i = hand.getNumCards(); i > 0; i--)
    	{
    		System.out.println(i + ") Playing: " + hand.playCard().toString());
    	}
    	
    	
    	System.out.println("After playing all cards...");
    	System.out.println("Hand = " + hand.toString()); // should be nothing left in hand to print
    	
    	
    	
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
    											'8', '9', 'T', 'J', 'Q', 'K','A'}; // constant array of valid characters
    
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
	
	private Card[] myCards = new Card[MAX_CARDS];
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
			Card newCard = new Card(card.getValue(), card.getSuit()); 

			myCards[numCards] = newCard;
			numCards++;
			
			return true;
			
		}else{
			return false;
		}
				
	}
	
	public Card playCard()
	{
		if (numCards > 0)
		{
			Card playedCard = new Card (myCards[numCards-1].getValue(), myCards[numCards-1].getSuit());
			myCards[numCards-1] = null; // set played card to null
			numCards--;
			
			return playedCard; // return the card on top of hand
		}
		
		return null;
	}
	
	public String toString() // returns entire hand as a string
	{
		String currentHand = "|";
		
		for (int i = 0; i < numCards; i++)
		{			
			currentHand += myCards[i] + "|";
			
			if (i % 10 == 9 && i != numCards - 1) // organize cards by rows of 10s
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
	
	
	public Card inspectCard(int k)
	{
		if (k >= 0 && k < getNumCards())
		{
			return myCards[k];
		}
		
		return new Card('0', Card.Suit.SPADES);
	}
	
	
	
	
	
	
	
}