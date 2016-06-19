package proj4sp16;
/**
 * <p>Title: The StockInfo Class</p>
 *
 * <p>Description: This class will represent an object that stores a company's tickerSymbol, number of shares owned of the stock, and its purchase price.
 * It also contains various accessor methods and mutator methods to manipulate the number of shares.</p>
 * 
 * @author Gurnoor Singh
 */
public class StockInfo {

	// Declaring instance variables
	private String tickerSymbol;
	private int numShares;
	private double purchasePrice;
	
	/**
	 * Parameterized StockInfo constructor -- Assigns the values passed as arguments to the instance variables  
	 * @param symbol String reference containing the tickerSymbol
	 * @param shares int reference containing the quantity of shares
	 * @param price double reference containing the purchase price of the stock
	 */
	public StockInfo(String symbol, int shares, double price)
	{
		tickerSymbol = symbol;
		numShares = shares;
		purchasePrice = price;
	}
	
	/**
	 * getTickerSymbol accessor method -- Returns what's stored in the tickerSymbol instance variable
	 * @return tickerSymbol String reference containing tickerSymbol
	 */
	public String getTickerSymbol()
	{
		return tickerSymbol;
	}
	
	/**
	 * getNumShares accessor method -- Returns what's stored in the numShares instance variable
	 * @return numShares int reference containing number of shares
	 */
	public int getNumShares()
	{
		return numShares;
	}
	
	/**
	 * getPurchasePrice accessor method -- Returns what's stored in the purchasPrice instance variable
	 * @return purchasePrice double reference containing the purchase price of the stock
	 */
	public double getPurchasePrice()
	{
		return purchasePrice;
	}
	
	/**
	 * setNumShares mutator method -- Sets the numShares instance variable to the new variable passed as an argument
	 * @param num int reference containing the number of shares to be set
	 */
	public void setNumShares(int num)
	{
		numShares = num;
	}
	
	/**
     * toString -- Returns the state of the StockInfo object which includes the tickerSymbol, numShares, and purchasePrice
     * @return string containing the state of the list
     */
	public String toString()
	{
		return (tickerSymbol + " " + numShares + " " + purchasePrice);
	}
}