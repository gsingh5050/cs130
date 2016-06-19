package queues;
import exceptionclasses.*;

/**
 * <p>Title: CircularArrayQueue Class</p>
 *
 * <p>Description: Provides basic Queue functionality, including the ability
 * to enqueue and dequeue items to/from the queue, get the front-most item, 
 * determine whether or not the queue is empty, determine the queue's size, 
 * and to get a String representation of the items in the queue.</p>
 *
 * @author Iris Martinez, Gurnoor Singh
 */
public class CircularArrayQueue<E> implements QueueADT<E>
{

	protected int front;
	protected int rear;
	protected E[] contents;
	protected int count;

	/**
	 * default constructor -- creates an empty queue.
	 */
	@SuppressWarnings("unchecked")
	public CircularArrayQueue()
	{
		front = 0;
		rear = 0;
		contents = (E[]) (new Object[100]);
		count = 0;
	}

	/**
	 * parameterized constructor --
	 * creates an empty queue that is initially capable of storing 
	 * 'size' items.
	 * @param size the initial size of the queue as specified by the user
	 */
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int size)
	{
		front = 0;
		rear = 0;
		if (size > 0)
			contents = (E[]) (new Object[size]);
		else
			contents = (E[]) (new Object[100]);
		count = 0;
	}

	/**
	 * enqueue --
	 * stores a new item at the rear of the queue; if the queue becomes
	 * full, it's size is automatically increased to accommodate additional items.
	 * @param newItem a reference to the item to be stored at the rear of the queue
	 */
	public void enqueue(E newItem)
	{
		if(count == contents.length)
			expandCapacity();
		if(isEmpty())
			front = rear = 0;
		else
			rear = (rear + 1) % contents.length;
		
		contents[rear] = newItem;
		count++;
	}

	/**
	 * deQueue -- removes the front-most item from the queue.
	 * @return a reference to the object which was stored at the front of the
	 * queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public E dequeue()
	{
		E temp;
		if (!isEmpty())
		{
			temp = contents[front];
			contents[front] = null;
			
			front = (front + 1) % contents.length;
			count--;
		}
		else
			throw new EmptyCollectionException("CircularArrayQueue");	
		
		return temp;
	}

	/**
	 * front --
	 * returns the item stored at the front of the queue; the queue 
	 * is not modified.
	 * @return a reference to the object which is stored at the front of the queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public E front()
	{
		if (isEmpty())
			throw new EmptyCollectionException("CircularArrayQueue");
		else
			return contents[front];
	}

	/**
	 * isEmpty -- determines whether or not the queue is empty.
	 * @return true if the queue is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}

	/**
	 * count -- returns the count of the number of items in the queue.
	 * @return count
	 */
	public int size()
	{
		return count;
	}

	/**
	 * expandCapacity --
	 * a private method called upon by the enqueue method when the queue 
	 * becomes full; the queue size is doubled to accommodate the storage of
	 * additional items.
	 */
	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		E[] temp = (E[]) (new Object[contents.length*2]);
		
		for(int i = 0; i < contents.length; i++)
		{
			temp[i] = contents[i];
		
		}
		contents = temp;
	}
	
	/**
	 * enqueueFront method --
	 * Accepts an item to be added to the front of the queue and adds it
	 * @param E newItem referring to the new item to be stored at the front of the queue
	 */
	public void enqueueFront(E newItem)
    {
        if (count == contents.length)
        {
            expandCapacity();
            E[] temp = (E[]) (new Object[contents.length]);

            for (int i = 0; i < count; i++)
                temp[i + 1] = contents[i];

            temp[0] = newItem;
            front = 0;
            contents = temp;
        }
        else
        {
            if (front == 0 && contents[front] != null)
                front = contents.length - 1;
            else if (front != 0)
                front--;

            contents[front] = newItem;
        }
        count++;
    }
	
	
	public int countItem(E item)
	{
		int count = 0;
		int tracker = 0;
		for(int i = front; i < tracker; i++)
		{
			
			if(contents[i].equals(item) && contents[i] != null)
				count++;
			
			tracker = i % contents.length;
		}
		return count;
		
		
		
	}
	/**
	 * dequeueRear method --
	 * Removes the item stored at the end of the queue and returns it
	 * @return E the item at the end of the queue to be returned
	 */
	public E dequeueRear()
    {
        if (isEmpty())
            throw new EmptyCollectionException("Queue is empty!");

        E temp = contents[rear];
        contents[rear] = null;
        rear--;
        if (rear == -1)
            rear = contents.length - 1;
        count--;
        return temp;
    }
	
	/**
	 * toString method - returns a String representing the current state of the queue.
	 * @return a String containing all items in the queue
	 */
	public String toString()
	{
		String str = "";
		int temp = front;
		
		for(int i = 0; i < count ; i++)
		{
			str += contents[temp] + "\n";
			temp = (temp + 1) % contents.length;
		}
		return str;
	}
}