package proj1sp16;
/**
 * Project 1: Proj1App class
 * 
 * Description: This class tests the methods written in the BingoCard class. It uses the BingoBall, BallCage, and 
 * BingoCard classes to create a bingo game with 2 players each of whom has a bingo card. The game will continue to select
 * random BingoBalls from the BallCage until one or both players have a vertical or horizontal bingo. Finally, it displays 
 * the player's cards, the values of the the random balls selected from the cage, and which player won or if it was a tie 
 * along with the true/false values for the winner(s).
 * 
 * @author Gurnoor Singh
 */
public class Proj1App {
	/**
     * Main method --
     * @param args values to be sent to the method
     */
	public static void main(String[] args) 
	{
		// Initializing 2 string references to store the bingo letters to indicate which columns correspond to what letter
		String bingoStr = "B  I  N  G  O";
		String bingoStr2 = "B     I     N     G     O";
		
		// Declaring a BingoBall object to store a random ball and instantiating 2 BingoCard objects
		// for each player using the default BingoCard constructor
		BingoBall randomBall;
		BingoCard bc = new BingoCard();
		BingoCard bc2 = new BingoCard();

		// Instantiating a new BallCage object
		BallCage cage = new BallCage();
		
		// Using while loop to continue the game until the findBingo method returns true for either players card's 
		// indicating a bingo has been found for a player or both players
		while(bc.findBingo() == false && bc2.findBingo() == false)
		{
			// Calling randomBingoBall method on cage object to generate a random ball to store in a BingoBall reference
			randomBall = cage.randomBingoBall();
			
			// Displaying the random ball with a label then calling the posTaken method on player 1's card to mark a position
			// as taken and determine if players card contains the random ball. Then displays Player 1's BingoCard
			System.out.println("Random ball: " + randomBall.toString() + "\nPlayer 1's card:");
			bc.posTaken(randomBall);
			System.out.println(bingoStr + "\n" + bc.displayCardNums());
			
			// Calling the posTaken method on player 2's card to determine if players card contains the ball number and if so
			// mark a position as taken. Then displaying player 2's BingoCard
			bc2.posTaken(randomBall);
			System.out.println("Player 2's card:\n" + bingoStr + "\n" + bc2.displayCardNums());
		}
		// Using if/else-if statements to check if the findBingo method returns true for either or both player's BingoCards. 
		// If so it displays if player 1 or player 2 won along with the true/false values in the 2D boolean array for the winner(s)
		if(bc.findBingo() == true && bc2.findBingo() == false)
			System.out.println("PLAYER 1 IS THE WINNER!\n"  + bingoStr2 + "\n" + bc.displayBool());
		else if(bc2.findBingo() == true && bc.findBingo() == false)
			System.out.println("PLAYER 2 IS THE WINNER!\n"  + bingoStr2 + "\n" + bc2.displayBool());
		else if(bc.findBingo() == true && bc2.findBingo() == true)
			System.out.println("ITS A TIE!\n" + bingoStr2 + "\n" + bc.displayBool() + "\n" + bingoStr2 + "\n" + bc2.displayBool());
	}
}