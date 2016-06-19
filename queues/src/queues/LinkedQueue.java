package queues;
import exceptionclasses.*;
/**
 * <p>Title: The LinkedQueue Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a linked queue.</p>
 *
 * @author Gurnoor Singh, Matthew George
 */
public class LinkedQueue<E> implements QueueADT<E>
{
	protected Node<E> front, rear; //references to the first and last nodes
	/**
	 * default constructor - creates an empty queue
	 */
	public LinkedQueue()
	{
		front = rear = null;
	}
	
	/**
	 * enqueue method - adds the specified item to the rear of the queue
	 * @param newItem a reference to the item to be added to the queue
	 */
	public void enqueue (E newItem)
	{
		Node <E> temp = new Node<E>(newItem);
		if (isEmpty())
			front = rear = temp;
		else
		{
			rear.setNext(temp);
			rear = rear.getNext();
		}
		
	}

	/**
	 * dequeue method - removes the item at the front of the queue
	 * @return a reference to the item removed from the front of the queue
	 * @throws an EmptyCollectionException if the queue is empty
	 */
	public E dequeue()
	{
		E temp;
		if (!isEmpty())
		{
			temp = front.getItem();
			if (front == rear)
				front = rear = null;
			else 
				front = front.getNext();
		}
		else
			throw new EmptyCollectionException("LinkedQueue");	
		return temp;
		
	}

	/**
	 * front method - returns a reference to the item at the front of the queue
	 * without removing it from the queue
	 * @return a reference to the item at the front of the queue
	 * @throws an EmptyCollectionException if the queue is empty  
	 */
	public E front() 
	{
		if(isEmpty())
			throw new EmptyCollectionException("LinkedQueue");
		return front.getItem();
	}

	/**
	 * isEmpty method - determines whether or not the queue is empty
	 * @return true if the queue is empty; false if the queue is not empty
	 */
	public boolean isEmpty()
	{
		return (front == null);
	}

	/**
	 * size method - returns a count of the number of items in the queue
	 * @return the number of items in the queue
	 */
	public int size()
	{
		int numSize = 0;
		Node<E> temp = front;
		while(temp != null)
		{
			temp = temp.getNext();
			numSize++;
		}
		return numSize;
	}
	
	/**
	 * search method - returns a int based on position where item is found
	 * @param E is the item to be looked for.
	 * @return int reference to store the 1-based position of the found item
	 */
	public int search(E item){
		int pos = 1;
		Node <E> temp = front;
		while (temp != null)
		{
			if (temp.getItem().equals(item))
				return pos;

			temp = temp.getNext();
			pos ++;
		}
		return -1;
	}
	
	/**
	 * removeLast method - method removes last item from the queue and throws ECE if the queue is empty 
	 * @return E item reference that stores the last item from the queue
	 * @throws an EmptyCollectionException if the queue is empty
	 */	
	public E removeLast(){
        Node <E> temp = front;
        int count = 1;
 
        if (size() > 1){
               E end = rear.getItem();
               while (count != size() - 1)
               {
                     temp = temp.getNext();
                     count++;
               }
               rear = temp;
               rear.setNext(null);
               return end;
        }
        else if (size() == 1)
        {
               E end = rear.getItem();
               front = rear = null;
               return end;
        }
        else
               throw new EmptyCollectionException("LinkedQueue");
	}
	
	/**
	 * toString method - returns a String representing the state of the queue
	 * @return a string containing all items in the queue
	 */
	public String toString()
	{
		String str = "";
		Node<E> current = front;
		while (current != null){
			str += current.getItem()+"\n";
			current = current.getNext();
		}
		return str;
	}
}