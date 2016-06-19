package proj5sp16;
/**
 * Title: The Friend Class
 *
 * Description: This class will represent a Friend object with a name, security level, and friendlist.
 * It contains various accessor and mutator methods to manipulate a Friend object.
 * 
 * @author Gurnoor Singh
 */
public class Friend {

	// Declaring instance variables
	private String name;
	private int securityLevel;
	private FriendList friends;
	
	/**
	 * Parameterized Friend constructor -- Creates a new FriendList object and assigns the appropriate parameters
	 * to the instance variables  
	 * @param newName - String reference to store the name
	 * @param secLevel - Int reference to store the security level
	*/
	Friend(String newName, int secLevel)
	{
		name = newName;
		securityLevel = secLevel;
		friends = new FriendList();
	}
	
	/**
	 * getName -- Returns what's stored in the name instance variable
	 * @return name - String instance variable
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * addFriend -- Calls the addToFront method in order to add the newFriend to the front 
	 * of the FriendList
	 * @param newFriend - Friend reference containing new Friend to be added
	 */
	public void addFriend(Friend newFriend)
	{
		friends.addToFront(newFriend);
	}
	
	/**
	 * unFriend -- Calls the remove method in order to remove the oldFriend from the FriendList
	 * @param oldFriend - Friend reference containing Friend to be removed
	 */
	public void unfriend(Friend oldFriend)
	{
		friends.remove(oldFriend);
	}
	
	/**
	 * friendsWith -- Calls the search method to check whether this Friend has the otherFriend
	 * in his/her FriendList
	 * @param otherFriend - Friend reference to search for
	 * @return boolean value indicating if two people are friends or not
	 */
	public boolean friendsWith(Friend otherFriend)
	{
		return friends.search(otherFriend);
	}
	
	/**
	 * getFriends -- Calls the listOfFriends method on the FriendList to get this persons friends
	 * @return a String containing this person's friends
	 */
	public String getFriends()
	{
		return friends.listOfFriends();
	}
	
	/**
	 * getFriendsByLevel -- Checks if this person's FriendList is empty or not, then checks if the person's security level is 1 or 0.
	 * If its 1, loops through the person's friends list and gets the person's friends and the person's friend's friends using the getNextFriend
	 * method and a local Friend variable. If the person's security level is not 1, only the person's friends are returned.
	 * @return str - String reference containing a person's friends by level
	 */
	public String getFriendsByLevel()
	{
		String str = name + " is friends with: " + getFriends();
		Friend current;
		if(!friends.isEmpty())
			if(securityLevel == 1)
			{
				friends.resetList();
				for(int i = 0; i < friends.size(); i++)
				{
					current = friends.getNextFriend();
					str += "and\n" + current.getName() + " is friends with: " + current.getFriends();
				}
			}
		return str;
	}
	
	/**
	 * equals -- Compares the names of this Friend and the otherFriend to determine if they are the same people
	 * @param newFriend - Friend reference to be compared to
	 * @return boolean value indicating two Friend objects are the same people
	 */
	public boolean equals(Friend otherFriend)
	{
		return name.equals(otherFriend.getName());
	}
}