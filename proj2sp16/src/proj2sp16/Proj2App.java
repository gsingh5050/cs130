package proj2sp16;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * <p>Title: Proj2App class</p>
 *
 * <p>Description: This application class tests various methods and constructors written in the Animal, Bear, and Fish
 * classes. It simulates an ecosystem of Bears and Fish, while also containing a river which is represented as a large
 * array of these Animals. In each time step, an Animal attempts to move into an adjacent array cell or stay where it is.
 * If two animals of the same type and different gender are going to collide, they create a new instance of
 * that type of Animal placed in an empty location on the river. If a Bear and Fish collide, the Bear kills the fish.
 * Also if two Animals of the same type and gender try to collide, only the animal with the larger strength survives.
 * The program asks the user for the size of the river(10-50), and puts size/2 random Animals in random indexes of the
 * river, then displays the initial state of the river along with detailed information of the movement of each animal.
 * Lastly it displays the final state of the river after all Animals have attempted to move.</p>
 *
 * @author Gurnoor Singh
 */
public class Proj2App {
	/**
     * Main method --
     * @param args values to be sent to the method
     */
	public static void main(String[] args) {
			
		// Initializing an Animal array called river to store a default size of 10 Animals. Instantiating a Random object, and
		// initializing integers to keep track of the size of the river and number of attempts at entering the size.
		Animal[] river = new Animal[10];
		Random rand = new Random();
		int size = 0;
		int attempt = 0;
	
		/**
		 * In a try-catch block, looping 3 times to prompt the user for the size of the river using JOptionPane's showInputDialog method. Then checking if user's input
		 * is in the proper range. If so, the size of the river is set to the user entered size and loop is broken. If not in the proper range, it increments attempt variable.
		 * If attempt is equal to 3(Indicating last attempt), then an error message with a label is displayed in a dialog box and program is terminated. If the user attempts to 
		 * click the close/cancel or OK buttons before entering a size, the program counts that as an 1 out of 3 attempts and handles the NumberFormatException by checking 
		 * if the attempt # is less than or equal to 3. If so, it enters a second try-catch block and loops for the length of the remaining attempts to prompt the user for a size.
		 * If size is in proper range, size of the river is set and loop is broken. If not, # of attempts is incremented. This try-catch block is not entered if the # of attempts
		 * at its max. If the user clicks the close/cancel or OK buttons before entering a size again, the # of attempts is incremented and checked if max # of attempts is reached.
		 * If so, the program terminates. If not, another loop is used in a third try-catch block to loop for the remaining # of attempts to prompt the user for a size. If the user
		 * clicks the close/cancel or OK buttons a third time and the # of attempts is at its max, the program displays an error message and terminates.
		 */
		try 
		{	
			for(int i = 0; i < 3; i++)
			{
				size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the size of the river(10-50): ", "Animal River", JOptionPane.PLAIN_MESSAGE));
				if(size <= 50 && size >= 10)
				{
					river = new Animal[size];
					break;
				}
				else
					attempt++;
			}
			if(attempt == 3)
			{
				JOptionPane.showMessageDialog(null, "You failed to enter a valid size for the river, Goodbye.", "Error", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
		catch(NumberFormatException ex)
		{
			attempt++;
			if(attempt < 3)
			{
				try
				{
					for(int i = attempt; i < 3; i++)
					{
						size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the size of the river(10-50): ", "Animal River", JOptionPane.PLAIN_MESSAGE));
						if(size <= 50 && size >= 10)
						{
							river = new Animal[size];
							break;
						}
						else
							attempt++;
					}
				}
				catch(NumberFormatException ex2)
				{
					attempt++;
					if(attempt == 3)
					{
						JOptionPane.showMessageDialog(null, "You failed to enter a valid size for the river, Goodbye.", "Error", JOptionPane.PLAIN_MESSAGE);
						System.exit(0);
					}
					if(attempt < 3)
					{
						try
						{
							for(int i = attempt; i < 3; i++)
							{
								size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the size of the river(10-50): ", "Animal River", JOptionPane.PLAIN_MESSAGE));
								if(size <= 50 && size >= 10)
								{
									river = new Animal[size];
									break;
								}
								else
									attempt++;
							}
						}
						catch(NumberFormatException ex3)
						{
							if(attempt == 3)
							{
								JOptionPane.showMessageDialog(null, "You failed to enter a valid size for the river, Goodbye.", "Error", JOptionPane.PLAIN_MESSAGE);
								System.exit(0);
							}
						}
					}
				}
			}
			if(attempt == 3)
			{
				JOptionPane.showMessageDialog(null, "You failed to enter a valid size for the river, Goodbye.", "Error", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
		if(size > 50 || size < 10)
		{
			JOptionPane.showMessageDialog(null, "You failed to enter a valid size for the river, Goodbye.", "Error", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
		// Looping 3 times for 3 rounds
		for(int round = 1; round < 4; round++)
		{
			// Emptying array before looping again to ensure appropriate # of Animals are stored in the river each round
			for(int x = 0; x < river.length; x++)
				river[x] = null;
		
			// Instantiating an Integer array of the same size as river, then filling it with the indexes to 
			// be selected from and shuffling the array as a list for randomness
			Integer[] array = new Integer[size];
			for(int l = 0; l < array.length; l++)
				array[l] = l;
			
			Collections.shuffle(Arrays.asList(array));
			
			// Initializing an int reference to store the # of Animals to be put in the river to size/2. Then displaying the # of Animals to be put
			// in the river with a label
			int numAnimals = size/2;
			System.out.println("The number of animals to be put in the river is: " + numAnimals + "\n\nRound # " + round);
			
			// Looping numAnimal times to store the correct amount of animal objects, then randomly generating either
			// a 0 or 1 and creating a new random animal based on that random number generated. Then inserting that animal at a
			// random non-repeating index of the river to ensure size/2 animals have been put into the river.
			for(int j = 0; j < numAnimals; j++)
			{	
				int randAnimal = rand.nextInt(2);
				
				if(randAnimal == 1)
					river[array[j]] = new Bear();			
				else 
					river[array[j]] = new Fish();
			}
			
			// Displaying the initial state of the river with a label using a for loop to check if an index contains an Animal or is null.
			// Then displays the corresponding Animal's detailed information or null depending on random Animal positions.
			System.out.println("Initial state of the river:");
			for(int k = 0; k < river.length; k++) 
			{	
				if(river[k] != null)
					System.out.println(river[k].genderString() + " " + river[k].bearOrFish() + " with strength " + river[k].getStrength());
				else
					System.out.println("null");
			}
			System.out.print("\nAnimal Movement:");
			
			/** 
			 * Initializing an integer RightOrStay to store a random number(0-1) to represent the options of Animal at index 0 which are to either move right(0), or stay
			 * in the same place(1) in order to avoid going out of the bounds of the array. Then checking to see if there is an Animal at index 0 and if it's 
			 * moving right or staying. If its staying(1), the program displays a message stating the Animal at a certain index did not move. If the Animal moves right(1),
			 * the program checks if there is an Animal in the first index, if they are of the same species and different genders. If all true, an ArrayList is created and 
			 * filled with all indexes that are null(indicating no Animal). The program checks to make sure that the river is not full and the proper species of Animal is
			 * being created and inserted in a random null index. Then it displays the genders/species/strength/indexes of the Animals who created the new Animal, along with the
			 * new Animal's gender/species/strength/index. Otherwise, if there is an Animal at index 1 of the same species and same gender, the compareStrength method is used and
			 * the Animal with the larger strength value kills the other and moves to it's index. If there is a Bear at index 0 and a Fish at index 1, the bear kills(moves
			 * to the Fish's index) and Fish disappears. If there is an null adjacent cell, the Animal can also just simply move into it. 
			 */
			int RightOrStay = rand.nextInt(2);
			if(river[0] != null)
			{
				// Move right
				if(RightOrStay == 0)
				{
					// New Animal at random null index
					if(river[1] != null && river[0].compareSpecies(river[1]) == true && river[0].compareGender(river[1]) == false)
					{
						List<Integer> nullIndexes = new ArrayList<Integer>();
					
						for(int j = 0; j < river.length; j++)
							if(river[j] == null)
								nullIndexes.add(j);
						
						if(nullIndexes.size() == 0)
							System.out.println("\nNew Animal was not created because the river is full");
						else
						{
							Collections.shuffle(nullIndexes);
									
							int index = nullIndexes.get(0);
							
							if(river[0] instanceof Bear)
								river[index] = new Bear();
							if(river[0] instanceof Fish)
								river[index] = new Fish();
							
							System.out.println("\n" + river[0].genderString() + " " + river[0].bearOrFish() + " with strength " + river[0].getStrength() + " at index 0 and " + 
									river[1].genderString() + " " + river[1].bearOrFish() + " with strength " + river[1].getStrength() + " at index 1 created a new " +
									river[nullIndexes.get(0)].genderString() + " " + river[0].bearOrFish() + " with strength " + river[nullIndexes.get(0)].getStrength() + " at index " + nullIndexes.get(0));
						}
					}
					// Larger strength Animal survives
					else if(river[1] != null && river[0].compareSpecies(river[1]) == true && river[0].compareGender(river[1]) == true)
					{
						if(river[0].compareStrength(river[1]) == 2)
						{
							System.out.println("\n" + river[0].genderString() + " " + river[0].bearOrFish() + " at index " + 0 + " with strength " + river[0].getStrength() + " killed " + river[1].genderString()
									+ " " + river[1].bearOrFish() + " at index " + (1) + " with strength " + river[1].getStrength());
							river[1] = river[0];
							river[0] = null;
						}
						else if(river[0].compareStrength(river[1]) == 1)
						{
							System.out.println("\n" + river[1].genderString() + " " + river[1].bearOrFish() + " at index " + (1) + " with strength " + river[1].getStrength() + " killed " + river[0].genderString()
									+ " " + river[0].bearOrFish() + " at index " + (0) + " with strength " + river[0].getStrength());
							river[0] = river[1];
							river[1] = null;
						}
						else
						{
							System.out.println("\n" + river[1].genderString() + " " + river[1].bearOrFish() + " at index " + (1) + " with strength " + river[1].getStrength() + " has the same strength as the " +
									river[0].genderString() + " " + river[0].bearOrFish() + " at index " + (0) + " with strength " + river[0].getStrength());
						}
					}
					// Bear eats Fish
					else if(river[0] != null && river[1] != null && river[0] instanceof Bear && river[1] instanceof Fish)
					{
						System.out.println("\n" + river[0].genderString() + " Bear with strength " + river[0].getStrength() + " at index 0 ate the " + river[1].genderString() + " Fish with strength " + 
								river[1].getStrength() + " at index 1");
						river[1] = river[0];
						river[0] = null;
					}
					// Empty adjacent cell
					else if(river[1] == null)
					{
						System.out.println("\n" + river[0].genderString() + " " + river[0].bearOrFish() + " with strength " + river[0].getStrength() + " at index 0 moved to index 1");
						river[1] = river[0];
						river[0] = null;
					}
				}
				// If stay:
				else if(RightOrStay == 1)
					System.out.println("\n" + river[0].genderString() + " " + river[0].bearOrFish() + " with strength " + river[0].getStrength() + " at index 0 did not move");
			}
			
			/** 
			 * Looping through indexes (1 - river.length-1) in order to avoid going out of the bounds of the array. Then checking if there is an Animal at index i. If so,
			 * initializing an integer leftRightStay to store a random number(0,1,2) to represent the options of Animal at index i which are to either move left(0), move right(1),
			 * or stay in the same place(2). If its staying(2), the program displays a message stating the Animal at a index i did not move. If its moving(0,1), the program checks 
			 * if the adjacent cell to index i contains an Animal of the same species and different genders. If so, an ArrayList is created and filled with all indexes that are 
			 * null(indicating no Animal). The program checks to make sure that the river is not full and the proper species of Animal is being created and inserted in a random 
			 * null index using instanceof. Then it displays the genders/species/strength/indexes of the Animals who created the new Animal, along with the new Animal's 
			 * gender/species/strength/index. Otherwise, if there is an Animal in an adjacent cell of the same species and same gender, the compareStrength method is used and 
			 * the Animal with the larger strength value kills the other and moves to it's index. If there is a Bear at index i and a Fish in the adjacent cell, the bear 
			 * kills(moves to the Fish's index) and Fish disappears. If there is a null adjacent cell, the Animal can also just simply move into it. 
			 */
			for(int i = 1; i < (river.length - 1); i++)
			{
				if(river[i] != null)
				{
					int leftRightStay = rand.nextInt(3);
					// If move left:
					if(leftRightStay == 0)
					{
						// New Animal at random null index
						if(river[i-1] != null && river[i].compareSpecies(river[i-1]) == true && river[i].compareGender(river[i-1]) == false)
						{
							ArrayList<Integer> nullIndexes = new ArrayList<>();
							
							for(int j = 0; j < river.length; j++)
								if(river[j] == null)
									nullIndexes.add(j);
							 
							if(nullIndexes.size() == 0)
								System.out.println("\nNew Animal was not created because the river is full");
							else
							{
								Collections.shuffle(nullIndexes);
							
								int	index = nullIndexes.get(0);
								
								if(river[i] instanceof Bear)
									river[index] = new Bear();
								if(river[i] instanceof Fish)
									river[index] = new Fish();
								
								System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " with strength " + river[i].getStrength() + " at index " + i + " and " + river[i-1].genderString() + " " + river[i-1].bearOrFish() +
										" with strength " + river[i-1].getStrength() + " at index " + (i-1) + " created a new " + river[nullIndexes.get(0)].genderString() + " " + river[i].bearOrFish() + " with strength " + 
										river[nullIndexes.get(0)].getStrength() + " at index " + nullIndexes.get(0));
							}
						}
						// Larger strength Animal survives
						else if(river[i-1] != null && river[i].compareSpecies(river[i-1]) == true && river[i].compareGender(river[i-1]) == true)
						{
							if(river[i].compareStrength(river[i-1]) == 2)
							{
								System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " at index " + i + " with strength " + river[i].getStrength() + " killed " + river[i-1].genderString() + " " +
										river[i-1].bearOrFish() + " at index " + (i-1) + " with strength " + river[i-1].getStrength());
								river[i-1] = river[i];
								river[i] = null;
							}
							else if(river[i].compareStrength(river[i-1]) == 1)
							{
								System.out.println("\n" + river[i-1].genderString() + " " + river[i-1].bearOrFish() + " at index " + (i-1) + " with strength " + river[i-1].getStrength() + " killed " + river[i-1].genderString() +
										" " + river[i].bearOrFish() + " at index " + (i) + " with strength " + river[i].getStrength());
								river[i] = river[i-1];
								river[i-1] = null;
							}
							else
							{
								System.out.println("\n" + river[i-1].genderString() + " " + river[i-1].bearOrFish() + " at index " + (i-1) + " with strength " + river[i-1].getStrength() + " has the same strength as the " +
								river[i].genderString() + " " + river[i].bearOrFish() + " at index " + (i) + " with strength " + river[i].getStrength());
							}
							
						}
						// Bear eats Fish
						else if(river[i] != null && river[i-1] != null && river[i] instanceof Bear && river[i-1] instanceof Fish)
						{
							System.out.println("\n" + river[i].genderString() + " Bear with strength " + river[i].getStrength() + " at index " + i + " ate the " + river[i-1].genderString() + " Fish with strength " +
									river[i-1].getStrength() + " at index " +(i-1));
							river[i-1] = river[i];
							river[i] = null;
							
						}
						// Empty adjacent cell
						else if(river[i-1] == null)
						{
							System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " with strength " + river[i].getStrength() + " at index " + i + " moved to index " + (i-1));
							river[i-1] = river[i];
							river[i] = null;
						}
					}
					// If move right:
					if(leftRightStay == 1)
					{
						// New Animal at random null index
						if(river[i+1] != null && river[i].compareSpecies(river[i+1]) == true && river[i].compareGender(river[i+1]) == false)
						{
							List<Integer> nullIndexes = new ArrayList<>();
							
							for(int j = 0; j < river.length; j++)
								if(river[j] == null)
									nullIndexes.add(j);
							
							if(nullIndexes.size() == 0)
								System.out.println("\nNew Animal was not created because the river is full");
							else
							{
								Collections.shuffle(nullIndexes);
									
								int index = nullIndexes.get(0);
								
								if(river[i] instanceof Bear)
									river[index] = new Bear();
								if(river[i] instanceof Fish)
									river[index] = new Fish();
								
								System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " with strength " + river[i].getStrength() + " at index " + i + " and " + river[i+1].genderString() + " " +
									river[i+1].bearOrFish() + " with strength " + river[i+1].getStrength() + " at index " + (i+1) + " created a new " + river[nullIndexes.get(0)].genderString() + " " + river[i].bearOrFish() +
									" with strength " + river[nullIndexes.get(0)].getStrength() + " at index " + nullIndexes.get(0));
							}
						}
						// Larger strength Animal survives
						else if(river[i+1] != null && river[i].compareSpecies(river[i+1]) == true && river[i].compareGender(river[i+1]) == true)
						{
							if(river[i].compareStrength(river[i+1]) == 2)
							{
								System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " at index " + i + " with strength " + river[i].getStrength() + " killed " + river[i+1].genderString() + " " +
										river[i+1].bearOrFish() + " at index " + (i+1) + " with strength " + river[i+1].getStrength());
								river[i+1] = river[i];
								river[i] = null;
							}
							else if(river[i].compareStrength(river[i+1]) == 1)
							{
								System.out.println("\n" + river[i+1].genderString() + " " + river[i+1].bearOrFish() + " at index " + (i+1) + " with strength " + river[i+1].getStrength() + " killed " + river[i+1].genderString() +
										" " + river[i].bearOrFish() + " at index " + (i) + " with strength " + river[i].getStrength());
								river[i] = river[i+1];
								river[i+1] = null;
							}
							else
							{
								System.out.println("\n" + river[i+1].genderString() + " " + river[i+1].bearOrFish() + " at index " + (i+1) + " with strength " + river[i+1].getStrength() + " has the same strength as the " +
										river[i].genderString() + " " + river[i].bearOrFish() + " at index " + (i) + " with strength " + river[i].getStrength());
							}
						}
						// Bear eats Fish
						else if(river[i] != null && river[i+1] != null && river[i] instanceof Bear && river[i+1] instanceof Fish)
						{
							System.out.println("\n" + river[i].genderString() + " Bear with strength " + river[i].getStrength() + " at index " + i + " ate the " + river[i+1].genderString() + " Fish with strength " +
									river[i+1].getStrength() + " at index " + (i+1));
							river[i+1] = river[i];
							river[i] = null;
							
						}
						// Empty adjacent cell
						else if(river[i+1] == null)
						{
							System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " with strength " + river[i].getStrength() + " at index " + i + " moved to index " + (i+1));						river[i+1] = river[i];
							river[i] = null;
						}
					}
					// If stay:
					if(leftRightStay == 2)
						System.out.println("\n" + river[i].genderString() + " " + river[i].bearOrFish() + " with strength " + river[i].getStrength() + " at index " + i + " did not move");	
				}
			}
			
			/** 
			 * Initializing an integer LeftOrStay to store a random number(0-1) to represent the options of Animal at river.length-1 which are to either move left(0), or stay
			 * in the same place(1) in order to avoid going out of the bounds of the array. Then checking to see if there is an Animal at river.length-1 and if it's 
			 * moving left or staying. If its staying(1), the program displays a message stating the Animal at a the last index did not move. If the Animal moves left(1),
			 * the program checks if there is an Animal at river.length-2, if they are of the same species and different genders. If all true, an ArrayList is created and 
			 * filled with all indexes that are null(indicating no Animal). The program checks to make sure that the river is not full and the proper species of Animal is
			 * being created and inserted in a random null index. Then it displays the genders/species/strength/indexes of the Animals who created the new Animal, along with the
			 * new Animal's gender/species/strength/index. Otherwise, if there is an Animal at river.length-2 of the same species and same gender, the compareStrength method is used and
			 * the Animal with the larger strength value kills the other and moves to it's index. If there is a Bear at river.length-1 and a Fish at river.length-2, the bear 
			 * kills(moves to the Fish's index) and Fish disappears. If there is an null adjacent cell, the Animal can also just simply move into it. 
			 */
			int leftOrStay = rand.nextInt(2);
			if(river[river.length - 1] != null)
			{
				// If move left
				if(leftOrStay == 0)
				{
					// New Animal at random null index
					if(river[river.length - 2] != null && river[river.length - 1].compareSpecies(river[river.length - 2]) == true && river[river.length - 1].compareGender(river[river.length - 2]) == false)
					{
						List<Integer> nullIndexes = new ArrayList<>();
						
						for(int j = 0; j < river.length; j++)
							if(river[j] == null)
								nullIndexes.add(j);
						
						if(nullIndexes.size() == 0)
							System.out.println("\nNew Animal was not created because the river is full");
						else
						{
							Collections.shuffle(nullIndexes);
							
							int index = nullIndexes.get(0);
							
							if(river[river.length - 1] instanceof Bear)
								river[index] = new Bear();
							if(river[river.length - 1] instanceof Fish)
								river[index] = new Fish();
							
							System.out.println("\n" + river[river.length - 1].genderString() + " " + river[river.length - 1].bearOrFish() + " with strength " + river[river.length -1].getStrength() + " at index " + (river.length - 1) + " and " +
									river[river.length - 2].genderString() + " " + river[river.length - 2].bearOrFish() + " with strength " + river[river.length - 2].getStrength() + " at index " + (river.length - 2) + " created a new " +
									river[nullIndexes.get(0)].genderString() + " " + river[river.length - 1].bearOrFish() + " with strength " + river[nullIndexes.get(0)].getStrength() + " at index " + nullIndexes.get(0));
						}
					}
					// Larger strength Animal survives
					else if(river[river.length - 2] != null && river[river.length - 1].compareSpecies(river[river.length - 2]) == true && river[river.length - 1].compareGender(river[river.length - 2]) == true)
					{
						if(river[river.length - 1].compareStrength(river[river.length - 2]) == 2)
						{
							System.out.println("\n" + river[river.length - 1].genderString() + " " + river[river.length - 1].bearOrFish() + " at index " + (river.length - 1) + " with strength " + river[river.length - 1].getStrength() + " killed " +
									river[river.length - 2].genderString() + " " + river[river.length - 2].bearOrFish() + " at index " + (river.length - 2) + " with strength " + river[river.length - 2].getStrength());
							river[river.length - 2] = river[river.length - 1];
							river[river.length - 1] = null;
						}
						else if(river[river.length - 1].compareStrength(river[river.length - 2]) == 1)
						{
							System.out.println("\n" + river[river.length - 2].genderString() + " " + river[river.length - 2].bearOrFish() + " at index " + (river.length - 2) + " with strength " + river[river.length - 2].getStrength() + " killed " +
									river[river.length - 1].genderString() + " "+ river[river.length - 1].bearOrFish() + " at index " + (river.length - 1) + " with strength " + river[river.length - 1].getStrength());
							river[river.length - 1] = river[river.length - 2];
							river[river.length - 2] = null;
						}
						else
							System.out.println("\n" + river[river.length - 2].genderString() + " " + river[river.length - 2].bearOrFish() + " at index " + (river.length - 2) + " with strength " + river[river.length - 2].getStrength() 
									+ " has the same strength as the " + river[river.length - 1].genderString() + " " + river[river.length - 1].bearOrFish() + " at index " + (river.length - 1) + " with strength " + river[river.length - 1].getStrength());
					}
					// Bear eats Fish
					else if(river[river.length - 1] != null && river[river.length - 2] != null && river[river.length - 1] instanceof Bear && river[river.length - 2] instanceof Fish)
					{
						System.out.println("\n" + river[river.length - 1].genderString() + " Bear at index " + (river.length - 1) + " with strength " + river[river.length - 1].getStrength() + " ate the " + river[river.length - 2].genderString() +
							" Fish at index " + (river.length - 2) + " with strength " + river[river.length - 2].getStrength());
						river[river.length - 2] = river[river.length - 1];
						river[river.length - 1] = null;
					}
					// Empty adjacent cell
					else if(river[river.length - 2] == null)
					{
						System.out.println("\n" + river[river.length - 1].genderString() + " " + river[river.length - 1].bearOrFish() + " with strength " + river[river.length - 1].getStrength() + " at index " + (river.length - 1) + 
								" moved to index " + (river.length - 2));
						river[river.length - 2] = river[river.length - 1];
						river[river.length - 1] = null;
					}
				}
				// If stay:
				if(leftOrStay == 1)
					System.out.println("\n" + river[river.length - 1].genderString() + " " + river[river.length - 1].bearOrFish() + " with strength " + river[river.length - 1].getStrength() + " at index " + (river.length - 1) + " did not move");
			}
			
			// Displaying the Final state of the river
			System.out.println("\n\nFinal state of the river:");
			for(int k = 0; k < river.length; k++) 
			{	
				if(river[k] != null)
					System.out.println(river[k].genderString() + " " + river[k].bearOrFish() + " with strength " + river[k].getStrength());
				else
					System.out.println("null");
			}
			System.out.println("----------------------------------------------------------------------------------------------");
		}
	}
}