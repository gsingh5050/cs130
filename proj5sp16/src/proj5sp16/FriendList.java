package proj5sp16;
/**
 * Title: The FriendList Class
 *
 * Description: This class will represent a FriendList object. It uses an empty header Node called first, a currentPos
 * Node, and a counter variable. It also contains various methods to get the properties of a FriendList or to modify it.
 * 
 * @author Gurnoor Singh
 */
public class FriendList {

	// Declaring instance variables
	private Node first;
	private Node currentPos;
	private int count;
	
	/**
	 * Default FriendList constructor -- Assigns first and currentPos to a newly created header Node and sets count to 0 
	*/
	public FriendList()
	{
		first = new Node(null, new Node(null));
		currentPos = first;
		count = 0;
	}
	
	/**
	 * size -- Uses count to determine the size of the FriendList
	 * @return count - int instance variable
	 */
	public int size()
	{
		return count;
	}
	
	/**
	 * isEmpty -- Checks if count = 0, indicating the FriendList is empty
	 * @return boolean value indicating if the FriendList isEmpty
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	/**
	 * addToFront -- Creates a new Node containing the newFriend and links it to the original first Node. Then
	 * uses the setNext method on the header Node to set it as the front Node
	 * @param newFriend - Friend reference to be added to the front 
	 */
	public void addToFront(Friend newFriend)
	{
		first.setNext(new Node(newFriend, first.getNext()));
		count++;
	}
	
	/**
	 * remove -- Resets the FriendList. Then traverses through the FriendList by checking ahead to see if there
	 * is a Friend and using the getNextFriend method. Then looking ahead again to check if the current Friend is equal 
	 * to the Friend to be removed. If so, uses the setNext method on the Node previous to the Node being removed in order
	 * to unlink the Node to be removed. Count is decremented, and the removeFriend is returned. If removeFriend is not found
	 * an exception is thrown
	 * @param removeFriend - Friend reference to be removed
	 * @return removeFriend - Friend reference to be removed
	 */
	public Friend remove(Friend removeFriend)
	{
		resetList();
		while(currentPos.getNext().getFriend() != null)
		{
			if(currentPos.getNext().getFriend().equals(removeFriend))
			{
				currentPos.setNext(currentPos.getNext().getNext());
				count--;
				return removeFriend;
			}
			getNextFriend();
		}
		throw new FriendNotFoundException("FriendList");
	}
	
	/**
	 * resetList -- Sets currentPos back to first(header Node)
	 */
	public void resetList()
	{
		currentPos = first;
	}
	
	/**
	 * getNextFriend -- Used for traversal of the FriendList. Sets the currentPos to the next Node
	 * @return Friend reference containing the next Friend
	 */
	public Friend getNextFriend()
	{
		currentPos = currentPos.getNext();
		return currentPos.getFriend();
	}
	
	/**
	 * search -- Resets the list. Then goes through the FriendList using currentPos and getNextFriend to check if the
	 * specified searchFriend is in the FriendList
	 * @param searchFriend - Friend to be searched for
	 * @return boolean value indicating if the Friend was found or not
	 */
	public boolean search(Friend searchFriend)
	{
		resetList();
		boolean isTrue = false;
		
		while(currentPos.getNext().getFriend() != null)
		{
			if(getNextFriend().equals(searchFriend))
				isTrue = true;
		}
		return isTrue;
	}
	
	/**
	 * listOfFriends -- Resets the list. Goes through the FriendList looking ahead for a null value and assigns the Friends
	 * name to a String reference using the getNextFriend and getName methods 
	 * @return str - String reference containing the listOfFriends
	 */
	public String listOfFriends()
	{
	
		String str = "";
		resetList();
		while(currentPos.getNext().getFriend() != null)
		{
			str += getNextFriend().getName() + " ";
		}
		return str;
	}
}