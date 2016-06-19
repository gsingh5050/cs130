package proj3fa15;
/**
 * <p>Title: DeckException Class</p>
 *
 * <p>Description: Exception Class for use by all Container Classes</p>
 */
@SuppressWarnings("serial")
public class DeckException extends RuntimeException
{
	/**
     * Initializes a DeckException storing the type of the
     * collection (as specified by the user) along with an appropriate message.
	 */
	public DeckException(String collection)
	{
		super(collection + " is empty");
	}
}
