package proj1sp16;
import java.util.*;
/**
 * Project 1: BingoCard class
 * 
 * Description: This class contains the instance variables and default constructor needed to create a BingoCard object.
 * It uses the constructors and methods written in the BingoBall and BingoCage classes to manipulate a BingoCard object.
 * It also contains various methods of its own and a toString method.
 * 
 * @author Gurnoor Singh
 */
public class BingoCard {
	
	// Declaring 2D integer and boolean arrays as instance variables
	int[][] multi;
	boolean[][] multiBool;
	/**
	 * Default BingoCard constructor --
	 * Description: Creates an integer and boolean 2D array to store 5 rows and columns. Then initializes an array list
	 * for each column and uses a for loop to add the appropriate range of numbers from 1-75 to each column. It then calls
	 * the shuffle method from the Collections class on each array list to randomize the order in each array list. Using 
	 * column major access, it assigns the appropriate value to the index's of the integer 2D array. Finally it sets the 
	 * middle location of the boolean 2D array to true indicating its already taken.
	 */
	public BingoCard()
	{
		multi = new int[5][5];
		multiBool = new boolean[5][5];

		List<Integer> b = new ArrayList<>();
		List<Integer> i2 = new ArrayList<>();
		List<Integer> n = new ArrayList<>();
		List<Integer> g = new ArrayList<>();
		List<Integer> o = new ArrayList<>();
		
		for (int i = 1; i <= 15; i++)
		{
		    b.add(i);
		    i2.add(i+15);
		    n.add(i+30);
		    g.add(i+45);
		    o.add(i+60);
		}
		Collections.shuffle(b);
		Collections.shuffle(i2);
		Collections.shuffle(n);
		Collections.shuffle(g);
		Collections.shuffle(o);
		
	    for(int col = 0; col < multi[0].length; col++)
	    {
		    for(int row = 0; row < multi.length; row++) 
		    {
	    		multi[row][0] = b.get(row);
	    		multi[row][1] = i2.get(row);
	    		multi[row][2] = n.get(row);
	    		multi[row][3] = g.get(row);
	    		multi[row][4] = o.get(row);
		    }
	    }
	    multiBool[2][2] = true;
	}
	
	/**
	 * posTaken method --
	 * Description: This method marks a location on the card as taken. It initializes an integer and assigns it the
	 * value passed after calling the getNum method on the parameter reference in order to get the number of the ball.
	 * It then goes through the 2D integer array to check if the ballNum is equal to any number on the BingoCard. If 
	 * so it sets the value of the 2D boolean array at those index's to true indicating there is a match. 
	 * @param ball to store a reference to a BingoBall object
	 */
	public void posTaken(BingoBall ball)
	{
		int ballNum = ball.getNum();
		for(int col = 0; col < multi[0].length; col++)
		{
			for(int row = 0; row < multi.length; row++)
			{
				if(ballNum == multi[row][col])
					this.multiBool[row][col] = true;
			}
		}
	}
	
	/**
	 * findBingo method --
	 * Description: This method determines whether or not the player has bingo. It declares 2 integer variables to keep
	 * track of the number of true values in the 2D boolean array. It then goes through the array and checks if each value
	 * vertically or horizontally is true. If so it increments integers horizontal and vertical accordingly. Before going 
	 * to the next column/row, it checks if either integer value is equal to 5 indicating 5 true or bingo. If so it returns
	 * true, if not it reassigns the integer counters back to zero to try the next row/column. If no bingo is found it
	 * will return false.   
	 * @return boolean value if bingo is found or not
	 */
	public boolean findBingo()
	{
	int horizontal = 0;
	int vertical = 0;
	
	for(int col = 0; col < multiBool[0].length; col++)
	{
		for(int row = 0; row < multiBool.length; row++)
		{
		    if(multiBool[row][col] == true)
		    	vertical++;
		    if(multiBool[col][row] == true)
		    	horizontal++;
		}
		
		if(horizontal == 5 || vertical == 5)
			return true;
		else {
			horizontal = 0;
			vertical = 0;
		}
	}
	return false;
	}
	
	/**
	 * displayBool method --
	 * Description: This method initializes and returns a string containing the values stored in the 2D boolean array.
	 * It goes through the boolean array then adds and assigns the value at the current index to the string to be returned. 
	 * @return String reference containing the state of the boolean array.
	 */
	public String displayBool()
	{
		String str = "";
		for(int i = 0; i < this.multiBool.length; i++) 
		{
		    for(int j = 0; j < this.multiBool.length; j++) 
		    {
		        str += (multiBool[i][j] + " ");
		    }
		    str += "\n";
		}
		return str;
	}
	
	/**
	 * displayCardNums method --
	 * Description: This method initializes and returns a string containing the values stored in the 2D integer array.
	 * It goes through the integer array then adds and assigns the value at the current index to the string to be returned. 
	 * @return String reference containing the state of the integer array.
	 */
	public String displayCardNums()
	{
		String str = "";
		for(int i = 0; i < this.multi.length; i++) 
		{
		    for(int j = 0; j < this.multi.length; j++) 
		    {
		        str += (this.multi[i][j] + " ");
		    }
		    str += "\n";
		}
		return str;
	}
	
	/**
	 * toString method --
	 * Description: This method calls the above 2 methods in order to create and return a String containing a combination
	 * of both the BingoCard's integer and boolean values
	 * @return String reference containing the state of the integer and boolean 2D arrays.
	 */
	public String toString()
	{
		String str = "";
		str = this.displayCardNums() + "\n" + this.displayBool();
		return str;
	}
}