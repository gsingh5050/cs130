package proj5sp16;
/**
 * Title: The SFacebook Class
 *
 * Description: This class will represent a SFacebook object the contains an array of Friends and a count variable to determine the
 * number of members in SFacebook. It also contains various accessor methods to modify theMembers of SFacebook.
 * 
 * @author Gurnoor Singh
 */
public class SFacebook {

	// Declaring instance variables
	private Friend[] theMembers;
	private int count;
	
	/**
	 * Default SFacebook constructor -- Creates a new Friend array set to a default size of 15, and sets count to 0 
	 */
	public SFacebook()
	{
		theMembers = new Friend[15];
		count = 0;
	}
	
	/**
	 * addToFacebook -- Creates a new Friend using the values passed as arguments, then assigns it to the end of theMembers array
	 * and increments count
	 * @param name - String reference containing the new Friend's name
	 * @param secLevel - Int reference containing the new Friend's security level
	 */
	public void addToFacebook(String name, int secLevel)
	{
		theMembers[count] = new Friend(name, secLevel);
		count++;
	}
	
	/**
	 * makeFriends -- Checks if the Friend names passed as parameters are not equal. If so, both friends are added to eachother's
	 * FriendLists using the addFriend and findFriend methods
	 * @param name - String reference storing the first Friend's name
	 * @param otherName - String reference storing the other Friend's name
	 */
	public void makeFriends(String name, String otherName)
	{
		if(!name.equals(otherName))
		{
			findFriend(name).addFriend(findFriend(otherName));
			findFriend(otherName).addFriend(findFriend(name));
		}
	}
	
	/**
	 * breakFriendship -- Checks if the Friend names passed as parameters are not equal. If so, both friends are removed from eachother's
	 * FriendLists using the unfriend and findFriend methods
	 * @param name - String reference storing the first Friend's name
	 * @param otherName - String reference storing the other Friend's name
	 */
	public void breakFriendship(String name, String otherName)
	{
		if(!name.equals(otherName))
		{
			findFriend(name).unfriend(findFriend(otherName));
			findFriend(otherName).unfriend(findFriend(name));
		}
	}
	
	/**
	 * getFriends -- Gets the friends of the specified Friend using the findFriend and getFriends methods
	 * @param name - String reference containing the name of the Friend
	 * @return String containing the person's name and their friends
	 */
	public String getFriends(String name)
	{
		return name + " is friends with: " + findFriend(name).getFriends();
	}
	
	/**
	 * getFriendsByLevel -- Gets the friends of the specified Friend and perhaps their Friends depending on their security level
	 * using the findFriend and getFriendsByLevel methods
	 * @param name - String reference containing the name of the Friend
	 * @return String containing the person's Friends and perhaps their friends
	 */
	public String getFriendsByLevel(String name)
	{
		return findFriend(name).getFriendsByLevel();
	}
	
	/**
	 * getFriendStatus -- Gets the status of the 2 Friend's friendship using the findFriend and friendsWith methods
	 * @param name - String reference containing the name of the Friend 
	 * @param otherName - String reference storing the other Friend's name
	 * @return boolean value indicating whether or not 2 people are friends
	 */
	public boolean getFriendStatus(String name, String otherName)
	{
		return findFriend(name).friendsWith(findFriend(otherName));
	}
	
	/**
	 * toString -- Returns the state of the SFacebook object
	 * @return str - String reference containing all member of SFacebook and their friends
	 */
	public String toString()
	{
		String str = "";
		for(int i = 0; i < count; i++)
			str += theMembers[i].getName() + " is friends with: " + theMembers[i].getFriends() + "\n"; 
		
		return str;
	}
	
	/**
	 * findFriend -- If the parameter is not null, loops through theMembers array and checks if a member's name is the same as the parameter name.
	 * If so, that Friend member is returned. If not an exception is thrown. 
	 * @param name - String reference containing the name of the Friend to be found
	 * @return Friend reference to be found
	 */
	public Friend findFriend(String name)
	{
		if(name != null)
			for(int i = 0; i < count; i++)
				if(theMembers[i].getName().equals(name))
					return theMembers[i];
		throw new FriendNotFoundException("SFacebook");
	}
}