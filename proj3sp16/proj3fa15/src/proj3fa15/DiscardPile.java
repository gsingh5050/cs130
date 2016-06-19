package proj3fa15;
/**
 * <p>Title: The DiscardPile class</p>
 *
 * <p>Description: This class represents a pile of discarded playing cards and contains various methods
 * to help manipulate the discard pile</p>
 * 
 * @author Darci Burdge and Gurnoor Singh
 */
public class DiscardPile {

	// Declaring instance variable
	private Node<Card> list;
	
	 /**
     * default constructor which sets the list to null, indicating it does not contain any cards
     */
	public DiscardPile()
	{
		list = null;
	}
	
	/**
	 * addCard method -- Accepts a reference to a Card to be added and passes it as an argument to the 
	 * Node parameterized constructor, Linking them.
	 * @param topCard reference to the Card to be added
	 */
	public void addCard(Card topCard)
	{
		list = new Node<Card>(topCard, list);
	}
	
	/**
	 * removeCard method -- Responsible for removing and returning the top-most card from the discard pile. If the pile isEmpty, 
	 * a DiscardPileException is thrown. The first item is removed using the getItem method on the list and stored in a Card reference.
	 * Then the list reference is assigned to now refer to the next Node.
	 * @return remove reference to the removed top-most Card item
	 */
	public Card removeCard() 
	{
		if(isEmpty())
			throw new DiscardPileException("discard pile empty");
		
		Card remove = list.getItem();
		list = list.getNext();
		
		return remove;
	}
	
	/**
	 * removeCards method -- Responsible for removing and returning, in a card array, the number of cards specified by the user. If that number 
	 * is greater than the size of the discard pile or if the discard pile isEmpty, a DiscardPileException is thrown indicating the pile does not
	 * contain the amount of cards the user wishes to remove. While the num of cards to remove is less than 0, a temp array is assigned the Cards
	 * using the getItem method and list is modified to now refer to the next Node. Finally num is decremented.
	 * @param num refers to the number of cards to be removed 
	 * @return temp refers to an array storing the removed cards
	 */
	public Card[] removeCards(int num) 
	{
		if(num > this.size() || isEmpty())
			throw new DiscardPileException("discard pile empty");
		
		Card[] temp = new Card[num];
	
		while(num > 0)
		{
			temp[num-1] = list.getItem();
			list = list.getNext();
			num--;
		}
		return temp;	
	}
	
	/**
	 * size method -- Determines and returns the number of Cards currently in the discard pile. A temp Node is created and refers to the list.
	 * Then while temp contains an item temp is modified accordingly and the counter is incremented.
	 * @return result refers to the number of cards currently in the discard pile
	 */
	public int size()
	{
		int result = 0;
		Node<Card> temp = list;
		
		while(temp != null)
		{
			temp = temp.getNext();
			result++;
		}
		return result;
	}
	
	/**
	 * isEmpty method -- Determines if the discard pile is empty
	 * @return boolean value of size() == 0, indicating the size 
	 */
	public boolean isEmpty()
	{
		return (size() == 0);
	}
	
	/**
	 * toString method -- Returns the state of the discard pile.
	 * @return String reference containing the Cards from top to bottom
	 */
	public String toString()
	{
		String str = "";
		
		Node<Card> temp = list;
		int pos = 1;
		while(temp != null)
		{
			str += ("Card " + pos + ": " + temp.getItem().toString() + "\n");
			temp = temp.getNext();
			pos++;
		}	
		return str;
	}
}