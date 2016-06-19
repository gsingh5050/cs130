package proj3fa15;
/**
 * <p>Title: The Proj3App class</p>
 *
 * <p>Description: This class tests various methods and constructors written in the Card,Deck,DiscardPile,DeckException,
 * and DiscardPileException classes.</p>
 * 
 * @author Gurnoor Singh
 */
public class Proj3App {
	/**
     * <p> Main method</p>
     * @param args values to be sent to the method
     */
	public static void main(String[] args) {
	
	// Instantiating a new Card object to test the createJoker and toString methods on and displaying it's state
	Card joker = new Card(0).createJoker();
	System.out.println("Testing createJoker method:\n" + joker.toString());
		
	// Instantiating a multiDeck object passing in 2 decks, and 4 jokers as arguments and testing the toString method
	Deck multiDeck = new Deck(2,4);
	System.out.println("\nTesting parameterized Deck constructor passing 2 Decks and 4 Jokers as arguments:\n" + multiDeck.toString());
		
	// Testing the shuffleDeck method on the multiDeck and displaying its state
	multiDeck.shuffleDeck();
	System.out.println("Deck after shuffling:\n" + multiDeck.toString());

	// Testing the dealCard method
	System.out.println("Testing dealCard method:\n" + multiDeck.dealCard());
	
	// Displaying the current state of the discard pile after re-instantiating the multiDeck
	multiDeck = new Deck(0,0);
	System.out.println("\nCurrent state of the multi-deck:\n" + multiDeck.toString());
	
	// In a try-catch block, calling the shuffleDeck method on the re-instantiated multiDeck containing no cards in order to 
	// catch and display the DeckException message
	try
	{
		multiDeck.shuffleDeck();
		System.out.println("\nDeck after shuffling:\n" + multiDeck.toString());
	}
	catch(DeckException ex)
	{
		System.out.println("\nCaught DeckException while shuffling deck:\n" + ex.getMessage());
	}
	
	// In a try-catch block, calling the dealCard method on an empty multiDeck to catch and display the DeckException message
	try
	{
		System.out.println("\n" + multiDeck.dealCard());
	}
	catch(DeckException ex)
	{
		System.out.println("\nCaught DeckException while dealing card:\n" + ex.getMessage());
	} 
	
	// In a try-catch block, calling the cut method on an empty multiDeck to catch and display the DeckException message
	try
	{
		System.out.println("\nCut card: Card " + (multiDeck.cut()+1));
	}
	catch(DeckException ex)
	{
		System.out.println("\nCaught DeckException while cutting deck:\n" + ex.getMessage());
	} 
	
	// Re-instantiating the multiDeck to test the cut method on. Also displaying it's state and the card at the cut position
	multiDeck = new Deck(2,2);
	System.out.println("\nRe-instantiated multiDeck:\n" + multiDeck.toString() + "\nCut card: Card " + (multiDeck.cut()+1) + "\n\nDeck after cutting:\n" + multiDeck.toString());
	
	// Testing dealCard method again and displaying the dealt cards in order to call the putCardsInDeck method next
	System.out.println("Dealt cards to be replaced:\n" + multiDeck.dealCard() + "\n" + multiDeck.dealCard() + "\n" + multiDeck.dealCard() 
		+ "\n" + multiDeck.dealCard() + "\n" + multiDeck.dealCard() + "\n\nCards to be added to the deck:");
	
	// Instantiating and filling an array the same size as the amount of cards just dealt(5). And displaying those cards
	Card[] temp = new Card[5];
	for(int i = 0; i < temp.length; i++)
	{
		temp[i] = new Card(i);
		System.out.println(temp[i].toString());
	}
	
	// Calling the putCardsInDeck method passing in the temp array and displaying the multiDeck's state after cards are added to the bottom of the deck. Then 
	// displaying the state of the array passed as an argument to test if all elements were removed properly
	multiDeck.putCardsInDeck(temp);
	System.out.println("\nDeck after putting new cards in:\n" + multiDeck.toString());
	
	System.out.println("State of the array passed as an argument to putCardsInDeck after all elements were removed:");
	for(int j = 0; j < temp.length; j++)
		System.out.println(temp[j]);
	
	// Dealing only one Card and displaying it's state
	System.out.println("\nDealt Card to be replaced:\n" + multiDeck.dealCard());
	
	// In a try-catch block, calling the putCardsInDeck method on an array with a size greater than the maximum size of the deck in order to catch the DeckException
	try
	{
		multiDeck.putCardsInDeck(temp);
		System.out.println("\nDeck after putting new cards in:\n" + multiDeck.toString());
	}
	catch(DeckException ex)
	{
		System.out.println("\nCaught DeckException when putting the amount of cards requested in the deck causes the it's size to be greater than the maximum size.\n");
	}
	
	// Re-instantiating the multiDeck to have 0 decks and jokers and testing the isEmpty method on it. Then re-instantiating it again to have 2 decks and 
	// jokers and testing the isEmpty method again.
	multiDeck = new Deck(0,0);
	System.out.println("Testing isEmpty method on an empty multi-deck: " + multiDeck.isEmpty());
	multiDeck = new Deck(2,2);
	System.out.println("Testing isEmpty method on a full multi-deck: " + multiDeck.isEmpty());
	
	// Testing toString method in the Deck class
	System.out.println("\nTesting toString method on multiDeck with 2 Decks and 2 Jokers:\n" + multiDeck.toString());

	// Dealing 2 cards and displaying the state of the multiDeck
	multiDeck.dealCard();
	multiDeck.dealCard();
	System.out.println("Testing toString method after dealing jokers:\n" + multiDeck.toString());

	// Testing the cut method on the multiDeck that is not full or only contains a few cards
	System.out.println("Testing toString/cut methods after cut at Card " + (multiDeck.cut()+1) + ":\n" + multiDeck.toString());

	// Instantiating a new DiscardPile object and displaying it's state
	DiscardPile discard = new DiscardPile();
	System.out.println("Testing DiscardPile default constructor:\n" + discard.toString());

	// Testing the addCard method passing in 2 cards as arguments to make sure the last card to be added is stored at the top of the discard pile
	Card card1 = new Card(3);	// 3 of clubs
	Card card2 = new Card(4);	// 4 of clubs
	discard.addCard(card1);
	discard.addCard(card2);
	System.out.println("Testing addCard method:\n" + discard.toString());

	// Testing the removeCard method on discard pile and displaying the cards returned. If the discard pile is empty,
	// a DiscardPileException is caught and a message is displayed
	System.out.println("Testing removeCard method:\nRemoved cards:");
	try
	{
		for(int i = 0; i < 3; i++)
			System.out.println(discard.removeCard());
	}
	catch(DiscardPileException ex)
	{
		System.out.println("\nCaught DiscardPileException when calling removeCard on an empty DiscardPile\n");
	}
	
	// Instantiating a new Card object, then adding back 2 Cards to the discard pile and displaying it's state
	Card card3 = new Card(5);
	discard.addCard(card1);
	discard.addCard(card2);
	discard.addCard(card3);
	
	System.out.println("Discard pile after adding back 3 cards:\n" + discard.toString());	
	
	// Calling removeCards method on the discard pile passing in 2 as the amount of cards to be removed from the top of the pile, then 
	// displaying the removed cards array returned along with the state of the discard pile after removal
	Card[] temp2 = discard.removeCards(2);
	
	System.out.println("Testing removeCards:\nCard(s) that were removed:");
	for(int k = 0; k < temp2.length; k++)
		System.out.println(temp2[k].toString());
	
	System.out.println("\nDiscard pile after removing 2 cards:\n" + discard.toString());	

	// In a try-catch block, calling removeCards on the discard pile passing 2 as the amount of cards to be removed again in order to catch a DiscardPileException
	try
	{
		temp2 = discard.removeCards(2);
	}
	catch(DiscardPileException ex)
	{
		System.out.println("Caught DiscardPileException - The discard pile does not contain the number of cards the user wishes to remove\n");
	}
	
	// Displaying the current state of the discard pile
	System.out.println("Current state of the Discard pile:\n" + discard.toString());
	
	// Calling the size method on the discard pile and returning the amount of cards currently in the pile. Then removing the last card and calling it again
	// to make sure the proper amount is still returned
	System.out.println("Testing size method:\nThe Discard pile contains " + discard.size() + " card(s)\n");
	System.out.println("Removed card(s):\n" + discard.removeCard() + "\n\nThe Discard pile contains " + discard.size() + " card(s)");
	
	// Calling isEmpty on the discard pile to check if it contains any cards and displaying the appropriate messages. Then adding back 3 cards and re-testing it
	// to make sure the appropriate amount is returned
	System.out.println("\nTesting isEmpty method on an empty Discard pile:");
	if(discard.isEmpty())
		System.out.println("The discard pile is empty\n");
	else
		System.out.println("The discard pile is not empty\n");
	
	discard.addCard(card1);
	discard.addCard(card2);
	discard.addCard(card3);
	
	System.out.println("Current state of the Discard pile:\n" + discard.toString() + "\nTesting isEmpty method on a Discard pile containing cards:");
	if(discard.isEmpty())
		System.out.println("The discard pile is empty\n");
	else
		System.out.println("The discard pile is not empty\n");
	
	// Calling the toString method on the discard pile to ensure the proper String is returned
	System.out.println("Testing toString method:\n" + discard.toString());
	}
}