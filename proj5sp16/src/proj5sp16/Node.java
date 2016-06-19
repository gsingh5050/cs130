package proj5sp16;
/**
 * Title: The Node Class
 *
 * Description: This class will represent a Node object that stores a Friend object and a reference to the next Node
 * in the linked list. It also contains accessor and mutator methods.
 * 
 * @author Gurnoor Singh
 */
public class Node {

	// Declaring instance variables
	private Friend data;
	private Node next;
	
	/**
	 * Parameterized Node constructor -- Sets the data for the Node to the newFriend and assigns null to the next Node
	 * @param newFriend - Friend object to be stored
	 */
	Node(Friend newFriend)
	{
		data = newFriend;
		next = null;
	}
	
	/**
	 * Parameterized Node constructor -- Sets the data for the Node to the newFriend and assigns the nextNode parameter to the next Node
	 * @param newFriend - Friend reference to be stored
	 * @param nextNode - Node reference to be stored
	 */
	Node(Friend newFriend, Node nextNode)
	{
		data = newFriend;
		next = nextNode;
	}
	
	/**
	* setFriend - stores a newFriend in data
	* @param newFriend - Friend reference to be stored
	*/
	public void setFriend(Friend newFriend)
	{
		data = newFriend;
	}
	
	/**
	* setNext - stores a new Node reference to the next Node
	* @param nextNode - Node reference to be stored
	*/
	public void setNext(Node nextNode)
	{
		next = nextNode;
	}
	
	/**
	 * getFriend - Returns whats stored in data
	 * @return data - Friend instance variable
	 */
	public Friend getFriend()
	{
		return data;
	}
	
	/**
	 * getNext - Returns whats stored in next
	 * @return next - Node instance variable
	 */
	public Node getNext()
	{
		return next;
	}
}