package proj1sp16;
import java.util.Random;
/**
 * Project 1: BallCage class
 * 
 * Description: This class contains the instance variables and default constructor needed to create a BallCage object.
 * It uses the BingoBall class to create a cage of bingoBalls.
 * 
 * @author Gurnoor Singh
 */
public class BallCage {

	// Declaring instance variables to store the number of balls in the cage and hold references to several BingoBalls
	private int numBalls;
	private BingoBall[] bingoBalls;
	
	/**
	 * Default BallCage constructor --
	 * Description: Assigns 0 the numBalls since there are no balls yet and creates a BingoBall array with a capacity
	 * of 75 balls. Then loops through the array using for loop to create a new different BingoBall and fill up the array(cage) 
	 * while also incrementing numBalls to reflect every time a ball is added.
	 */
	public BallCage()
	{
		numBalls = 75;
		bingoBalls = new BingoBall[numBalls];
		
		for(int i = 0; i < bingoBalls.length; i++)
		{
			bingoBalls[i] = new BingoBall(i + 1);
		}
	}
	
	/**
	 * randomBingoBall method --
	 * Description: This method first generates a random number between 0 to the amount of balls in the cage
	 * and stores it in an integer index to make sure every time the method is called it will be in the correct
	 * range. Then it creates a new BingoBall object passing in the random index as the index to be selected from 
	 * array. It then loops through the array using a for loop and checks if the random ball is actually in the array.
	 * If so it replaces the randomBall with the last ball in the array and so on. Finally it decrements numBalls accordingly.
	 * @return reference to a random BingoBall object
	 */
	public BingoBall randomBingoBall()
	{
		int index = new Random().nextInt(numBalls);
		BingoBall randomBall = (bingoBalls[index]);
		
		if(bingoBalls[index].toString().equals(randomBall.toString()))
				bingoBalls[index] = bingoBalls[numBalls - 1]; 
		
		numBalls--;
			
		return randomBall;
	}
	
	/**
	 * ballsRemaining method --
	 * Description: An accessor method that returns the number of balls remaining in the cage
	 * @return int numBalls instance variable
	 */
	public int ballsRemaining()
	{
		return numBalls;
	}
	
	/**
	 * toString method --
	 * Description: A toString method that returns a String reference containing all of the balls
	 * in the bingoBalls array(cage) using a for loop and toString method from BingoBall class.
	 * @return String str
	 */
	public String toString()
	{
		String str = "";
		for(int i = 0; i < numBalls; i++)
			str += (bingoBalls[i].toString() + " ");
		return str;
	}
}