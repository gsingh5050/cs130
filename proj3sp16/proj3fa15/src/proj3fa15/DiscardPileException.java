package proj3fa15;
/**
 * <p>Title: DiscardPileException Class</p>
 *
 * <p>Description: Exception Class for use by all Container Classes</p>
 */
@SuppressWarnings("serial")
public class DiscardPileException extends RuntimeException
{
	/**
     * Initializes an DiscardPileException storing the type of the
     * collection (as specified by the user) along with an appropriate message.
	 */
	public DiscardPileException(String collection)
	{
		super(collection + " is empty");
	}
}
