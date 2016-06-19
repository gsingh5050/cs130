package lists;
import exceptionclasses.*;
/**
 * <p>Title: ArrayOrderedList.java</p>
 *
 * <p>Description: Represents an array implementation of an ordered list.</p>
 * 
 * <p>@author Iris Martinez, Gurnoor Singh
 */
public class ArrayOrderedList<E> extends ArrayList<E> implements OrderedListADT<E>
{
	/**
	 * default constructor -- 
	 * creates an empty list using the default capacity.
	 */
	public ArrayOrderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 * @param initialCapacity the initial size of the list as specified by the user
	 */
	public ArrayOrderedList (int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * add --
	 * adds the specified Comparable item to this list, keeping
	 * the items in sorted order.
	 * @param newItem a reference to the new item to be added to the list  
	 */
	public void add(E item)
	{
		if(count == contents.length)
			expandCapacity();
		
		int pos = count - 1;
		
		while(pos != -1 && ((Comparable)item).compareTo(contents[pos]) < 0)
		{
			contents[pos+1] = contents[pos];
			pos--;
		}
		
		contents[pos+1] = item;
		count++;
	}
	
	/**
	 * find --
	 * overrides the find method in the parent class, ArrayList. The efficiency of this 
	 * method is improved by terminating the linear search once you have gone beyond the
	 * position where the item might be found, in particular in those cases where the item
	 * is not in the list.  
	 * @param target a reference to the item to locate
	 * @return the index of the specified target if it is found; -1 if it
	 * is not found
	 */
	@SuppressWarnings("unchecked")
	protected int find(E target)
	{
		int pos = 0;
		
		while(pos != count && ((Comparable)target).compareTo(contents[pos]) >= 0)
		{
			if(((Comparable)target).compareTo(contents[pos]) == 0)
				return pos;
			else
				pos++;
		}
		
		return -1;	
	}
	
	/**
	 * search --
	 * locates and returns the target from the list if it is found. The search
	 * algorithm used takes advantage of the fact that the data is ordered. For each
	 * iteration, the number of items to search through is decreased by half.
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an ElementNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	public E search(E target)
	{
		int first = 0;
		int last = count-1;
		E temp = null;
		boolean found = false;
		
		if(isEmpty())
			throw new EmptyCollectionException("ArrayList");
		
		while(last != -1 && first != count && !found)
		{
			int midpoint = (first+last)/2;
			
			if(((Comparable)target).compareTo(contents[midpoint]) == 0)
			{
				temp = contents[midpoint];
				found = true;
			}
			else if(((Comparable)target).compareTo(contents[midpoint]) < 0)
			{
				last = midpoint-1;
			}
			else
				first = midpoint+1;
		}
		if(last == -1 || first == count)
			throw new ElementNotFoundException("ArrayOrderedList");
		
		return temp;
	}	
}