package proj4sp16;
/**
 * <p>Title: The TickerSymbol Class</p>
 *
 * <p>Description: This class will represent an object that stores the ticker symbol and the actual name of the company.
 * It also includes accessor methods to return these variables.</p>
 * 
 * @author Gurnoor Singh
 */
public class TickerSymbol {

	// Declaring instance variables
	private String tickerSymbol;
	private String companyName;
	
	/**
	 * Parameterized TickerSymbol constructor -- assigns the values for the ticker symbol and the company name  
	 * @param symbol String reference to store the ticker symbol
	 * @param name String reference to store the company name
	 */
	public TickerSymbol(String symbol, String name)
	{
		tickerSymbol = symbol;
		companyName = name;
	}
	
	/**
	 * getTicker accessor method -- Returns what's stored in the tickerSymbol instance variable
	 * @return tickerSymbol String reference
	 */
	public String getTicker()
	{
		return tickerSymbol;
	}
	
	/**
	 * getCompany accessor method -- Returns what's stored in the companyName instance variable
	 * @return companyName String reference
	 */
	public String getCompany()
	{
		return companyName;
	}
}