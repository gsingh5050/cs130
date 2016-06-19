package proj3fa15;
/**
 * <p>Title: The Deck class</p>
 *
 * <p>Description: This class represents a Deck of 52 playing cards and a multi-deck containing jokers.  It
 * gets created in order and then must be shuffled to randomize the order of the cards. Cards are 
 * dealt from the top of the deck.</p>
 * 
 * @author Darci Burdge and Gurnoor Singh
 */
public class Deck
{
	// Declaring instance variables 
    private Card[] cards;
    private int numCards;

    /**
     * default constructor which creates the deck of 52 cards (without Jokers) in order
     */
    public Deck()
    {
        numCards = 52;
        cards = new Card[numCards];
        for (int i=0; i<cards.length;i++)
        {
            cards[i] = new Card(i);
        }
    }
    
    /**
     * parameterized constructor which initializes a multi-deck Deck object that may contain jokers. The 
     * number of jokers that will make up the multi-deck are specified by the user. It loops through the array 
     * from 0-cards.length-numJokers and checks if the count variable is less than 52 indicating if count should be reset
     * or not in order to keep passing the proper arguments to the Card constructor. If count is less than 52,
     * the array continues to be filled and count continues to be incremented. Lastly, looping from cards.length-numJokers
     * to cards.length to fill the remaining reserved indexes with jokers
     * @param numDecks to store the # of decks to be made in the multi-deck
     * @param numJokers to store the # of jokers to be added to the multi-deck 
     */
    public Deck(int numDecks, int numJokers)
    {
    	numCards = (52*numDecks+numJokers);
    	cards = new Card[numCards];
    	
    	int count = 0;
    	for (int i=0; i < (cards.length-numJokers); i++)
        {
    		if(count < 52)
    		{
    			cards[i] = new Card(count);
    			count++;
    		}
    		else
    		{
    			count = 0;
    			cards[i] = new Card(count);
    			count++;
    		}
        }
    	for(int j = cards.length-numJokers; j < cards.length; j++)
    		cards[j] = new Card(0).createJoker();
    }
   
    /**
     * shuffleDeck method -- places the cards in the deck in a random order. If the Deck is empty, 
     * a DeckException is thrown.
     */
    public void shuffleDeck()
    {
        Card temp;
        int index;
        
        if(numCards == 0)
        	throw new DeckException("Deck");
        
        for(int i = 0; i < cards.length; i++)
        {
            index = (int)(Math.random()*numCards);
            
            temp = cards[index]; 
	        cards[index] = cards[i];
	        cards[i] = temp;  
        }
    }
    
    /**
     * dealCard method -- deals the top card from the deck and decreases the number
     * of cards in the deck by 1. Throws a DeckException if deck is empty
     * @return a reference to the Card being dealt
     */
    public Card dealCard()
    {
		if (numCards > 0)
		{
			numCards--;
			return cards[numCards];
		}
		else
			throw new DeckException("Deck");
	}
    
    /**
     * cut method -- Generates a random index in the appropriate range and uses it to determine the place where the deck should be cut. 
     * If the deck is empty, a DeckException is thrown. It first checks if the Deck isEmpty. If not, starting from numCards-cutPos to numCards, 
     * it sets the proper index of the temp array to the proper index of the cards array and increments count. Then loops starting from 1 to numCards-cutPos,
     * in order to insert the topDeck in the temp array. Lastly, it sets cards to the newly created temp array and returns the cutPosition.
     * @return a reference to the Card being dealt
     */
    public int cut()
    {
    	int cutPos = (int)(Math.random() * numCards);
    	Card[] topDeck = new Card[cards.length];
    	  
    	int count = 0;
		
    	if(!isEmpty())
    	{
    		for(int i = (numCards-cutPos); i < numCards; i++)
			{
				topDeck[count] = cards[i];
				count++;
			}
			for(int j = 1; j <= (numCards-cutPos); j++)
			{
				topDeck[count] = cards[j-1];
				count++;
			}
			cards = topDeck;
    	}
    	else
    		throw new DeckException("Deck");
    	
    	return cutPos;
    }
    
    /**
     * putCardsInDeck method -- Accepts a reference to a Card array. Checks if it's length + numCards is greater than
     * cards.length indicating that putting cards back into the deck causes it's size to be greater that the max size of the
     * deck and throws a DeckException if so. If not, loops through the number of Cards and checks if the loop variable is less
     * than the max size of the parameter cards array. If so, the temp array is assinged the proper Cards from theCards array and
     * it's indexes are set to null indicating it has been emptied. Then inserting the rest of the values of the cards array in the 
     * temp array, incrementing numCards accordingly, and setting cards to now refer to the new temp array.
     * @param theCards array to be stored in the multiDeck
     */
    public void putCardsInDeck(Card[] theCards) 
    {
		if ((theCards.length + numCards) > cards.length)
			throw new DeckException("Deck");
		
		Card[] temp = new Card[cards.length];

		for (int j = 0; j < numCards; j++)
		{
			if(j < theCards.length)
			{
				temp[j] = theCards[j];
				theCards[j] = null;
			}
			temp[theCards.length + j] = cards[j];
		}

		numCards += theCards.length;
		cards = temp;	
    }
    
    /**
     * isEmpty method -- Determines if the deck is empty
     * @return boolean value of numCards == 0, indicating if the deck is empty or not
     */
    public boolean isEmpty()
    {
    	return (numCards == 0);
    }
    
    /**
     * toString -- returns the state of the deck as a string
     * @return a string containing the cards currently in the deck
     */
    public String toString()
    {
    	String temp = new String();
    	int count = 1;
    	for (int i = numCards-1; i >= 0; i--)
    	{
    		temp += "Card " + count + ": " + cards[i] + "\n";
    		count++;
    	}
    	return temp;
    }
}