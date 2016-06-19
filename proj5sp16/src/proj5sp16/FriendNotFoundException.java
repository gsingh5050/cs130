package proj5sp16;
/**
 * Title: FriendNotFoundException Class
 *
 * Description: Exception Class for use by all Container Classes
 * 
 * @author Gurnoor Singh
 */
@SuppressWarnings("serial")
public class FriendNotFoundException extends RuntimeException {
	
	/**
	 * Initializes an FriendNotFoundException storing an appropriate 
	 * message along with the type of the collection (as specified by the user).
	 */
	public FriendNotFoundException(String collection)
	{
		super ("Friend was not found: " + collection);
	}
}
