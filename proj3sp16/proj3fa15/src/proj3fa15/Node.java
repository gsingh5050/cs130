package proj3fa15;
/**
 * <p>Title: Node Class</p>
 *
 * <p>Description: Defines a node class capable of storing a 
 * reference to an object and a reference to the next node in
 * a linked list. Accessors and mutators are defined for both.</p>
 *
 * @author Darci Burdge
 */
public class Node<Card>
{
  private Card card; 
  private Node<Card> next; 

  /**
   * default constructor - initializes data and next to null 
   */
  public Node()
  {
	  card = null;
	  next = null;
  }
  
  /**
   * parameterized constructor - initializes data to the user 
   * specified value; next is set to null
   * @param newItem the value to be stored in the node
   */
  public Node(Card newCard)
  {
    card = newCard;
    next = null;
  }

  /**
   * parameterized constructor - initializes data and next to user 
   * specified values
   * @param newItem the object reference to be stored in the node
   * @param nextItem the reference to the next node in the list
   */
  public Node(Card newCard, Node<Card> nextCard)
  {
    card = newCard;
    next = nextCard;
  }

  /**
   * setItem - stores a new value in data
   * @param newItem the object reference to be stored in the node
   */
  public void setItem(Card newCard)
  {
    card = newCard;
  }

  /**
   * setNext - stores a new value in next
   * @param nextItem the reference to be stored in next
   */
  public void setNext(Node<Card> nextCard)
  {
    next = nextCard;
  }

  /**
   * getItem - returns the reference stored in data
   * @return a reference to the data stored in the node
   */
  public Card getItem()
  {
    return card;
  }

  
  /**
   * getNext - returns the reference stored in next
   * @return the reference stored in next
   */
  public Node<Card> getNext()
  {
    return next;
  }
}