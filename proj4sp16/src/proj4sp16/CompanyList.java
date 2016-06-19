package proj4sp16;
import java.io.*;
/**
 * <p>Title: The CompanyList Class</p>
 *
 * <p>Description: This class will represent an object that stores an ArrayUnorderedList that can store TickerSymbol objects which are
 * read from a text file.</p>
 * 
 * @author Gurnoor Singh
 */
public class CompanyList {

	// Declaring instance variable
	private ArrayUnorderedList<TickerSymbol> list;

	/**
	 * Parameterized CompanyList constructor -- Creates a new ArrayUnorderedList that can store TickerSymbol objects. The fileName is
	 * passed as an argument to the FileReader class which is then passed to the BufferedReader class in order to gain access to the file.
	 * A String reference is used to store a new line in the condition for the while loop, which runs until there is no next line to read.
	 * The substring method is used to store the proper range of characters in String references, that are then passed as arguments to 
	 * the TickerSymbol parameterized constructor and added to the rear of the list to maintain order.
	 * @param fileName String reference to store the name of the file to be found and read
	 */
	public CompanyList(String fileName) throws IOException  
	{
		list = new ArrayUnorderedList<TickerSymbol>();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = "";
		
		while((line = br.readLine()) != null)
		{
			String symbol = line.substring(0, line.indexOf(" "));
			String name = line.substring((line.indexOf(" ") + 1));
		
			list.addToRear(new TickerSymbol(symbol, name));
		}	
	}
	
	/**
	 * getCompanyName method -- Locates and returns the actual name of the company. It loops through the size of the list,
	 * and checks if each tickerSymbol is the same as the one to be found in the parameter. If so, it uses the getCompany method to 
	 * store the companyName in a string reference. The trim method is used to eliminate any whitespace before and after each line.
	 * @param symbol String reference containing a tickerSymbol to be found
	 * @return str string reference containing the companyName for the specified tickerSymbol
	 */
	public String getCompanyName(String symbol)
	{
		String str = "";
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getTicker().equals(symbol))
				str = list.get(i).getCompany().trim();
		}
		return str;
	}
	
	/**
     * toString -- Returns the state of the list as a string using the accessor methods defined in the TickerSymbol class in a for loop
     * @return str string reference containing the state of the list
     */
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < list.size(); i++)
			str += list.get(i).getTicker() + " " + list.get(i).getCompany() + "\n";
		
		return str;
	}
}