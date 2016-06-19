package proj2sp16;
import java.util.Random;
/**
 * <p>Title: The Animal Class</p>
 *
 * <p>Description: This class will represent an Animal object. This is the parent class of the Bear and Fish classes. It contains various 
 * accessor methods and compare methods to return or manipulate an Animal, Bear, and Fish object.</p>
 * 
 * @author Gurnoor Singh
 */
public class Animal {
	
	// Declaring instance variables to be used as properties of an Animal
	private boolean gender;
	private float strength;
	
	// Default Animal constructor
	public Animal()
	{
		Random rand = new Random();
	
		int genderChoice = rand.nextInt(2);
		if(genderChoice == 0)
			gender = true;
		else 
			gender = false;
		
		strength = rand.nextFloat() * (50.0f - 0.0f);
	}
	
	/**
     * getGender method --
     * Returns what's stored in the instance variable gender.
     * @return the state of the boolean instance variable gender
     */
	public boolean getGender()
	{
		return gender;
	}
	
	/**
	 * genderString method --
	 * Checks if the Animal it's being called on has a gender of true(male) or false(female), then
	 * assigning the appropriate gender string to a string reference and returning it.
	 * @return a String reference containing the gender of the Animal
	 */
	public String genderString()
	{
		String str = "";
		if(this.gender == true)
			str = "Male";
		else if(this.gender == false)
			str = "Female";
		
		return str;
	}

	/**
     * getStrength method --
     * Returns what's stored in the instance variable strength.
     * @return the state of the float instance variable strength
     */
	public float getStrength()
	{
		return strength;
	}
	
	/**
     * compareStrength method --
     * Compares the float strength values of the Animal its being called on and the parameter Animal
     * using the compare method in the Float class and storing it in an integer reference. If the compare
     * method returns a number greater than 0, then an integer reference hiLowEqual is set to 2, indicating
     * the object the method is being called on has a higher strength. If it returns a number less than 0,
     * hiLowEqual is set to 1 indicating the parameter Animal's strength is higher. Finally,if their strengths
     * are equal this method sets hiLowEqual to 0, indicating their strengths are equal.
   	 * @param animal to store a reference to an Animal object
     * @return hiLowEqual integer reference indicating who's strength is higher or if equal
     */
	public int compareStrength(Animal animal)
	{
		int hiLowEqual = 0;
    
	    int result = Float.compare(this.strength, animal.strength);
	    
	    if(result > 0) 
	      hiLowEqual = 2;
	    else if(result < 0) 
	      hiLowEqual = 1;
	    else 
	      hiLowEqual = 0;
				
	    return hiLowEqual;
	}
	
	/**
     * compareGender method --
     * Compares the boolean gender values of the Animal its being called on and the parameter Animal.
     * If the Animals have the same boolean gender value, a boolean reference is assigned true. If they 
     * are not the same boolean gender value, the boolean reference is assigned false and returned
     * @param animal to store a reference to an Animal object
     * @return isTrue boolean reference indicating whether both Animals are of the same gender
     */
	public boolean compareGender(Animal animal)
	{
		boolean isTrue = false;
		if(this.gender != animal.gender)
			isTrue = false;
		else if(this.gender == animal.gender)
			isTrue = true;
		
		return isTrue;
	}
	
	/**
     * compareSpecies method --
     * Checks if the Animal object its being called is of the same type(instanceof) as the parameter Animal.
     * If so, it sets a boolean reference to true. Otherwise, it sets it false and returns it.
     * @param animal to store a reference to an Animal object
     * @return isTrue boolean reference indicating whether both Animals are of the same species
     */
	public boolean compareSpecies(Animal animal)
	{
		boolean isTrue = false;
		if((this instanceof Bear && animal instanceof Bear) || (this instanceof Fish && animal instanceof Fish))
			isTrue = true;
		else
			isTrue = false;
		
		return isTrue;
	}
	
	/**
     * bearOrFish method --
     * Checks if the Animal its being called on is an instanceof Bear or a Fish. If its a Bear, a String reference 
     * is assigned "Bear" and returned. Otherwise it is assigned "Fish" and returned.
     * @return str String reference indicating whether the Animal is a Bear or Fish
     */
	public String bearOrFish()
	{
		String str = "";
		if(this instanceof Bear)
			str = "Bear";
		else if(this instanceof Fish)
			str = "Fish";
			
		return str;
	}
}