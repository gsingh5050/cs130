package proj1sp16;
/**
 * Project 1: Proj1Testing class
 * 
 * Description: This class tests methods and constructors written in the BingoBall and BallCage classes
 * 
 * @author Gurnoor Singh
 */
public class Proj1Testing {
	/**
     * Main method --
     * @param args values to be sent to the method
     */
	public static void main(String[] args) {
		
		// Using a for loop to call the parameterized BingoBall constructor with values from 1-75 and testing toString and
		// accessor methods with the appropriate labels
		System.out.println("Testing BingoBall class:");
		for(int i = 1; i < 76; i++)
		{
			BingoBall ball = new BingoBall(i);
			System.out.println("Testing param constructor and toString method: " + ball.toString());
			System.out.println("Testing getNum method: " + ball.getNum());
			System.out.println("Testing getLetter method: " + ball.getLetter());
		}
		
		// Initializing a new cage object by calling default constructor
		BallCage cage = new BallCage();
		
		// Testing toString method by calling it on the cage object and displaying it with a label
		// to verify it has all 75 balls
		System.out.println("\nTesting Ballcage class:\n" + cage.toString());
		
		// Calling ballsRemaining method on cage object and displaying the state of the object
		System.out.println(cage.ballsRemaining());
		
		// Testing randomBingoBall method by displaying the BingoBall returned, calling toString on cage
		// object to verify random ball is no longer in the cage, and then displaying the amount of bingoBalls
		// left in the cage. Repeated 75 times using a for loop to ensure each bingo ball has been chosen from cage
		for(int i = 0; i <  75; i++) {
			System.out.println("Random Ball: " + cage.randomBingoBall().toString());
			System.out.println("Cage afer ball removal: " + cage.toString());
			System.out.println("Balls remaining: " + cage.ballsRemaining());
		}
	}
}
