package proj4sp16;
import java.text.*;
/**
 * <p>Title: The StockPortfolio Class</p>
 *
 * <p>Description: This class will keep track of the stocks you own. It represents an object that stores an ArrayUnorderedList that can store StockInfo 
 * objects, a CompanyList object, and a double to keep track of the capital gain/loss of the portfolio over time as transactions are made.</p>
 * 
 * @author Gurnoor Singh
 */
public class StockPortfolio {

	// Declaring instance variables
	private ArrayUnorderedList<StockInfo> stockList;
	private CompanyList companyList;
	private double capitalGain;
	
	/**
	 * Parameterized StockPortfolio constructor -- Creates a new ArrayUnorderedList and assigns the CompanyList object passed as an argument to 
	 * the CompanyList instance variable.  
	 * @param tempList CompanyList reference to be assigned 
	*/
	public StockPortfolio(CompanyList tempList)
	{
		stockList = new ArrayUnorderedList<StockInfo>();
		companyList = tempList;
	}
	
	/**
	 * transaction method -- Accepts the transaction data for a single transaction and is responsible for processing the transaction and updating
	 * the capitalGain instance variable accordingly.
	 * @param buySell char reference containing the letter indicating if buying/selling
	 * @param numShares int reference containing the number of shares to be bought/sold
	 * @param price double reference containing the purchase price of the stock
	 * @param symbol String reference containing the tickerSymbol
	 */
	public void transaction(char buySell, int numShares, double price, String symbol)
	{
		// Check if first char == 'b', indicating a buying transaction. If so creates a new StockInfo object passing in the appropriate parameters
		// as arguments, then adding it to the rear of the list to maintain order
		if(buySell == 'b')
			stockList.addToRear(new StockInfo(symbol, numShares, price));
		// If it's a selling transaction:
		else
		{
			// Initializing an int reference to keep track of the totalShares of a stock. Then loops through the stockList and checks if 
			// the tickerSymbol in the stockList is the same as the tickerSymbol in the parameter indicating a company match. If so, totalShares
			// is incremented using the getNumShares method
			int totalShares = 0;
			for(int i = 0; i < stockList.size(); i++)
				if((stockList.get(i).getTickerSymbol()).equals(symbol))				
					totalShares += stockList.get(i).getNumShares();
				
			// Checking if the number of shares to be sold of a stock is greater than the total shares you own of the stock. If so an exception is thrown. 
			if(numShares > totalShares)
				throw new TransactionErrorException("Stock Portfolio");
				// throw ?
			
			// Initializing an int reference to keep track of the number of shares of a stock after each transaction. Then looping through the list and 
			// checking if the amount of shares to be sold is equal to 0, indicating there is no more shares of a stock to be sold and breaking the loop
			// if so. If there is a company match, checks if the # of shares to be sold is less than the # of shares owned. If so, capitalGain is modified
			// accordingly, the current number of stocks you own of a stock is set accordingly, and the int reference is set to 0 in order to break the loop.
			// If the # of shares to be sold is greater than or equal to the # of shares owned, the int reference and capitalGain is modified accordingly and
			// the stockList item is removed since all shares have been sold.
			int sharesSelling = numShares;
			int i = 0;
			while(i < stockList.size() && sharesSelling != 0)
			{
				if(stockList.get(i).getTickerSymbol().equals(symbol))
				{
					if(sharesSelling < stockList.get(i).getNumShares())
					{
						capitalGain += sharesSelling * (price - stockList.get(i).getPurchasePrice());
						stockList.get(i).setNumShares(stockList.get(i).getNumShares() - sharesSelling);
						sharesSelling = 0;
					}
					else if(sharesSelling >= stockList.get(i).getNumShares())
					{
						sharesSelling = sharesSelling - stockList.get(i).getNumShares();
						capitalGain += stockList.get(i).getNumShares() * (price - stockList.get(i).getPurchasePrice());
						stockList.remove(stockList.get(i));
						i--;
					}		
				}
				i++;
			}
		}
	}
	
	/**
     * toString -- Returns the state of the StockPortfolio object. Loops through the stockList and gets the stock information using
     * accessor methods. The capitalGain is also assigned to the String reference outside of the loop and then returned
     */
	public String toString()
	{
		String str = "";
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		
		for(int i = 0; i < stockList.size(); i++)
		{
			str += companyList.getCompanyName(stockList.get(i).getTickerSymbol()) + ": " + stockList.get(i).getNumShares() + 
					" shares owned, purchased at $" + stockList.get(i).getPurchasePrice() + "\n\n";
		}
		str += "\nCapital gain/loss: $" + df.format(capitalGain) ;
		
		return str;
	}
}