package proj1sp16;
/**
 * Project 1: BingoBall class
 * 
 * Description: This class contains the instance variables and parameterized constructor needed to create a 
 * BingoBall object. It also has accessor methods and a toString method which helps access/manipulate a BingoBall object
 * 
 * @author Gurnoor Singh
 */
public class BingoBall {

	// Declaring instance variables to store the number and letter of a BingoBall
	private int num;
	private char letter;
	
	/**
	 * Parameterized BingoBall constructor --
	 * Description: This constructor assigns the correct values passed by the arguments to the 
	 * num and letter instance variables using if/else if statements to check if they are in the
	 * correct range
	 * @param int ballNum to store value of ball to be checked
	 */
	public BingoBall(int ballNum)
	{
	
		if(ballNum <= 15)
		{
			num = ballNum;
			letter = 'B';
		}
		else if(ballNum <= 30)
		{
			num = ballNum;
			letter = 'I';
		}
		else if(ballNum <= 45)
		{
			num = ballNum;
			letter = 'N';
		}
		else if(ballNum <= 60)
		{
			num = ballNum;
			letter = 'G';
		}
		else if(ballNum <= 75)
		{
			num = ballNum;
			letter = 'O';
		}
		else
			System.out.println("Ball must be between 1-75");
	}
	
	/**
	 * getNum method --
	 * Description: An accessor method that returns the number of the ball
	 * @return int num instance variable
	 */
	public int getNum()
	{
		return num;
	}
	
	/**
	 * getLetter method --
	 * Description: An accessor method that returns the letter of the ball
	 * @return char letter instance variable
	 */
	public char getLetter()
	{
		return letter;
	}
	
	/**
	 * toString method --
	 * Description: A toString method that returns a String reference containing the letter
	 * and number of a BingoBall object
	 * @return String str
	 */
	public String toString()
	{
		String str = "";
		str = letter + Integer.toString(num);
		return str;
	}
}