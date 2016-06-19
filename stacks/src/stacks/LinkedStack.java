package stacks;
import exceptionclasses.EmptyCollectionException;

/**
 * <p>Title: The LinkedStack Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a basic stack
 * implemented using a linked list.</p>
 *
 * @author Gurnoor Singh
 */
public class LinkedStack<E> implements StackADT<E> {

	protected Node<E> top;
	
	/**
	 * default constructor - creates an empty stack
	 */
	public LinkedStack()
	{
		top = null;
	}
	
	/**
	 * push method - stores a new item on the top of the stack
	 * @param item a reference to the item to be stored on top of the stack
	 */
	public void push (E element)
	{
		top = new Node<E>(element, top);
	}

	/**
	 * pop method - removes the top-most item from the stack
	 * @return a reference to the item which was stored on top of the stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public E pop()
	{
		if (isEmpty())
			throw new EmptyCollectionException("LinkedStack");

		E result = top.getItem();
		top = top.getNext();

		return result;
	}

	/**
	 * peek method - returns the top-most item on the stack without removing it
	 * @return a reference to the item which is stored on top of the stack
	 * @throws EmptyCollectionException if the stack is empty
	 */    
	public E peek()
	{
		if(isEmpty())
		{
			throw new EmptyCollectionException("LinkedStack");
		}
		
		return top.getItem();
	}
	
	/**
	 * isEmpty method - determines whether or not the stack is empty
	 * @return true if the stack is empty; false if the stack is not empty
	 */
	public boolean isEmpty()
	{
		return (top == null);
	}
	
	/**
	 * size method - returns a count of the number of items in the stack
	 * @return the number of items in the stack
	 */
	public int size() {
		
		int count = 0;
		Node<E> current = top;
		
		while(current != null)
		{
			count++;
			current = current.getNext();
		}
		
		return count;
	}

	/**
	 * search method - returns the 1-based position where an item is on the stack.
	 * If the item is on the stack, the method returns the distance from the top 
	 * of the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare target to the items on the stack. 
	 * @param target a reference to the item to search for
	 * @return the 1-based position from the top of the stack where the item 
	 * is located; returns -1 if the item is not on the stack
	 */
	public int search(E target)
	{
		if(isEmpty())
			return -1;
	
		int pos = 1;
		Node<E> current = top;
	
		while(current != null)
		{
			if(current.getItem().equals(target))
				return pos;
			
			pos++;
			current = current.getNext();
		}
		return -1;
	}
	
	/**
	 * toString method - Creates a new Node to keep track of the current Node in the while loop and assigns top to it.
	 * Then while the current Node is not null, a string reference is assigned the item at current and current is assigned the 
	 * next value. Lastly, returns a String representing the state of the stack
	 * @return a string containing all items in the stack
	 */
	public String toString()
	{
		String str = "";
		Node<E> current = top;
		
		while(current != null)
		{
			str += (current.getItem() + "\n");
			current = current.getNext();
		}
	    return str;
	}
}