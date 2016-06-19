package proj4sp16;
import java.io.*;
/**
 * <p>Title: The Proj4App Class</p>
 *
 * <p>Description: This class creates a CompanyList object and a StockPortfolio object in order to process the transactions in a text file. It displays the 
 * stocks that are currently owned and then for each transaction processed, the transaction details are displayed. </p>
 * 
 * @author Gurnoor Singh
 */
public class Proj4App {

	public static void main(String[] args) throws IOException {
	
		// Creating a new CompanyList and StockPortfolio object
		CompanyList list = new CompanyList("tickerCompanyData.txt");
		StockPortfolio portfolio = new StockPortfolio(list);
	
		// Testing the toString method in the CompanyList class and displaying the company name using the getCompanyName method
		System.out.println(list.toString());
		System.out.println(list.getCompanyName("CSCO"));
		
		// Declaring and initializing variables to be stored as properties of a stock and a String reference to store the tickerSymbol
		char bS;
		int numShares = 0;
		double price = 0.0;
		String symbol = "";
		
		String line = "";
		String lineBreak = "--------------------------------------------------";
		
		// Creating a new FileReader object to pass to the BufferedReader object in order to read the transaction file
		FileReader file = new FileReader("transactionData.txt");
		BufferedReader br = new BufferedReader(file);
		
		// While a line to read exists, a String reference is modified in order to include the proper range of character for the specified variable. 
		// The details of the transaction are displayed as well as the shares owned for each transaction
	    while ((line = br.readLine()) != null)
	    {
			bS = line.charAt(0);
			
			String cutString = line.substring(2);
			numShares = Integer.parseInt(cutString.substring(0, cutString.indexOf(" ")));
			
			String cutString2 = cutString.substring(cutString.indexOf(" ")+1);
			price = Double.parseDouble(cutString2.substring(0, cutString2.indexOf(" ")));
			
			symbol = cutString2.substring(cutString2.indexOf(" ")+1);
			
			System.out.println("\nTransaction information:");			
			if(bS == 'b')
			{
				System.out.println("Bought " + numShares + " shares of " + list.getCompanyName(symbol) + " stock at $" + price);
			}
			else
			{
				System.out.println("Sold " + numShares + " shares of " + list.getCompanyName(symbol) + " stock at $" + price);
			}
		
			try
			{
				portfolio.transaction(bS, numShares, price, symbol);
			}
			catch(TransactionErrorException ex)
			{
				System.out.println(ex.getMessage());
			}
			System.out.println("\nStocks currently owned:\n" + portfolio.toString() + "\n" + lineBreak);		
	    }
	}
}
