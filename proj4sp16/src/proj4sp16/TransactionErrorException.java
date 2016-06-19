package proj4sp16;
/**
 * <p>Title: TransactionErrorException Class</p>
 *
 * <p>Description: Exception class for a StockPortfolio</p>
 * 
 * <p>@author Gurnoor Singh
 */
@SuppressWarnings("serial")
public class TransactionErrorException extends RuntimeException
{
	/**
     * Initializes an TransactionErrorException storing the type of the
     * collection (as specified by the user) along with an appropriate message.
	 */
	public TransactionErrorException(String collection)
	{
		super ("Transaction could not be processed " + collection);
	}
	
}
