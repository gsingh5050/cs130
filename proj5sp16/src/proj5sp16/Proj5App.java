package proj5sp16;
import java.io.*;
/**
 * Title: The Proj5App Class
 *
 * Description: This class tests various methods and constructors in the Friend, FriendList, and SFacebook classes.
 * It is responsible for reading and processing the commands from a text file and displaying the appropriate output 
 * for each command.
 * 
 * @author Gurnoor Singh
 */
public class Proj5App {

	public static void main(String[] args) throws IOException {

		// Creating a new FileReader object to pass to the BufferedReader object in order to read the fBData file. Declaring and 
		// initializing a new SFacebook object and variables to store each command line, Friend's names, security levels, and actions
		SFacebook faceBook = new SFacebook();
		FileReader file = new FileReader("fBData.txt");
		BufferedReader br = new BufferedReader(file);
		String line = "";
		String name = "";
		String otherName = "";
		int secLevel;
		char action;
		
		// Loop runs until the command character of the line is X, indicating to terminate the program. The command character
		// is obtained using the charAt method at the beginning of every iteration
		while((line = br.readLine()).charAt(0) != 'X')
		{
			action = line.charAt(0);
			/**
			 * If action = P, creates and adds a new Friend to faceBook. The name of the Friend is obtained using the substring method,
			 * and security level is obtained using the charAt and getNumericalValue methods. The addToFacebook method is then called on faceBook
			 * passing the name and secLevel as arguments and displays information about the command and the effect of the command using the
			 * toString method
			 */
			if(action == 'P')
			{
				name = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
				secLevel = Character.getNumericValue(line.charAt(line.length()-1));
				faceBook.addToFacebook(name, secLevel);
				System.out.println("Command: P - Create new Friend. " + name + " has joined Facebook with a security level of "
					+ secLevel + "\nCurrent state of Facebook:\n" + faceBook.toString());
			}
			/**
			 * If action = F, makes 2 people friends. The name of both Friends are obtained using the substring method, and then passed 
			 * as arguments to the makeFriends method which is called on faceBook. Information about the command and the effect of the command
			 * are displayed using the toString method. This is done in a try-catch block since makeFriends can throw an exception
			 */
			else if(action == 'F')
			{
				try
				{ 
					name = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
					otherName = line.substring(line.lastIndexOf(" ") + 1, line.length());
					faceBook.makeFriends(name, otherName);
					System.out.println("Command: F - Friend. " + name + " and " + otherName + " are now friends" 
						+ "\nCurrent state of Facebook:\n" + faceBook.toString());
				}
				catch(FriendNotFoundException ex)
				{
					System.out.println("Command: F - Friend.\n" + ex.getMessage() + "\n");
				}
			}
			/**
			 * If action = U, unfriend 2 people. The names of both Friends are obtained and passed to the breakFriendship method.
			 * The breakFriendship method can throw an exception so a try-catch block is used. The information about the command
			 * and the effect of the command are displayed using the toString method
			 */
			else if(action == 'U')
			{
				try
				{
					name = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
					otherName = line.substring(line.lastIndexOf(" ") + 1, line.length());
					faceBook.breakFriendship(name, otherName);
					System.out.println("Command: U - Unfriend. " + name + " and " + otherName + " are no longer friends" 
						+ "\nCurrent state of Facebook:\n" + faceBook.toString());
				}
				catch(FriendNotFoundException ex)
				{
					System.out.println("Command: U - Unfriend.\n" + ex.getMessage() + "\n");
				}
			}
			/**
			 * If action = L, list Friends of a member. The getFriends method is called on the Friend obtained by passing the name of the
			 * facebook member to the findFriend method. The findFriend method can throw an exception so a try-catch block is used.
			 * The command and the effect of the command are displayed.
			 */
			else if(action == 'L')
			{
				try
				{
					name = line.substring(line.indexOf(" ") + 1, line.length());
					System.out.println("Command: L - List " + name + "'s friends. \n" + name + " is friends with: " + 
						faceBook.findFriend(name).getFriends() + "\n");
				}
				catch(FriendNotFoundException ex)
				{
					System.out.println("Command: L - List.\n" + ex.getMessage() + "\n");
				}
			}
			/**
			 * If action = Q, check friendship. Displays if 2 friends are friends or not depending on the value 
			 * returned by the getFriendStatus method. The getFriendStatus can throw an exception so a try-catch block is used
			 */
			else if(action == 'Q')
			{
				try
				{
					name = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
					otherName = line.substring(line.lastIndexOf(" ") + 1, line.length());
					System.out.println("Command: Q - Check friendship between " + name + " and " + otherName);
					if(faceBook.getFriendStatus(name, otherName))
						System.out.print(name + " and " + otherName + " are friends\n\n");
					else
						System.out.print(name + " and " + otherName + " are not friends\n\n");
				}
				catch(FriendNotFoundException ex)
				{
					System.out.println("Command: Q - Check friendship between " + name + " and " + otherName + ":\n"+ ex.getMessage() + "\n");
				}
			}
			/**
			 * If action = V, list friends by security level. The faceBook member's friends are displayed and perhaps their 
			 * friends also using the getFriendsByLevel and findFriend methods. These methods can throw an exception so a 
			 * try-catch block is used
			 */
			else if(action == 'V')
			{
				try
				{
					name = line.substring(line.indexOf(" ") + 1, line.length());
					System.out.println("Command: V - List friends by security level.\n" + 
						 faceBook.getFriendsByLevel(name) + "\n");
				}
				catch(FriendNotFoundException ex)
				{
					System.out.println("Command: V - List friends by security level.\n" + ex.getMessage() + "\n");
				}
			}
		}
	}
}