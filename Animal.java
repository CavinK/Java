package task;

// Single line comment
/* Multiline comment
 * 
 */

import java.util.Scanner;
import java.util.*;
public class Animal {
	
	public static final double FAVNUMBER = 1.6180;
	
	private String name;
	private int weight;
	private boolean hasOwner = false;
	private byte age;
	private long uniqueID;
	private char favouriteChar;
	private double speed;
	private float height;
	
	protected static int numberOfAnimals = 0;
	
	static Scanner userInput = new Scanner(System.in);

	public Animal() {
		numberOfAnimals++;
		int sumOfNumbers = 5+1;
		System.out.println("5+1=" + sumOfNumbers);
		
		int diffOfNumbers = 5-1;
		System.out.println("5-1=" + diffOfNumbers);
		
		int multOfNumbers = 5*1;
		System.out.println("5*1=" + multOfNumbers);
		
		int divOfNumbers = 5/1;
		System.out.println("5/1=" + divOfNumbers);
		
		int modOfNumbers = 5%3;
		System.out.println("5%3=" + modOfNumbers);
		
		System.out.print("Enter the name: \n");
		
		// hasNextInt, hasNextFloat, hasNextDouble, hasNextBoolean, hasNextByte
		// nextInt, nextFloat, nextDouble
		if (userInput.hasNextLine()) {
			this.setName(userInput.nextLine());
		}
		
		this.setFavouriteChar();
		this.setUniqueID();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isHasOwner() {
		return hasOwner;
	}

	public void setHasOwner(boolean hasOwner) {
		this.hasOwner = hasOwner;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public long getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(long uniqueID) {
		this.uniqueID = uniqueID;
		System.out.println("Unique ID set to: " + this.uniqueID);
	}
	
	public void setUniqueID() { // overloaded
		long minNumber = 1;
		long maxNumber = 1000000;
		
		this.uniqueID = minNumber + (long)(Math.random() * ((maxNumber-minNumber)+1)); // casting 
		String stringNumber = Long.toString(maxNumber); // primitive type 
		//Byte.toString(arg0)
		//Int.toString()		
		int numberString = Integer.parseInt(stringNumber);
	}

	public char getFavouriteChar() {
		return favouriteChar;
	}

	public void setFavouriteChar(char favouriteChar) {
		this.favouriteChar = favouriteChar;
	}
	
	public void setFavouriteChar() { // overloaded
		int randomNumber = (int) (Math.random() * 126) + 1;
		
		this.favouriteChar = (char) randomNumber;
		
		if(randomNumber == 32) {
			System.out.println("Favourite character set to Space");
		} else if(randomNumber == 10) {
			System.out.println("Favourite character set to Newline");
		} else {
			System.out.println("Favourite character set to " + this.favouriteChar);
		}
		
		if((randomNumber>97) && (randomNumber<122)) {
			System.out.println("Favourite character is a lowercase letter");
		}
		
		if(((randomNumber>97) && (randomNumber<122)) || ((randomNumber>64) && (randomNumber<91))) {
			System.out.println("Favourite character is a uppercase letter");
		}
		
		int whichIsBigger = (50>randomNumber) ? 50 : randomNumber;
		switch(randomNumber) {
			case 8:
				System.out.println("Favourite character set to backspace");
				break;
			case 10:
				System.out.println("Favourite character set to backspace");
				break;
			case 11:
				System.out.println("Favourite character set to backspace");
				break;
			case 12:
				System.out.println("Favourite character set to backspace");
				break;
			default:
				System.out.println("None of the above");
				break;
				
		}
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	protected static void countTo(int startingNumber) {
		for(int i = startingNumber; i <= 100; i++) {
			if(i==90) continue;
			System.out.println(i);
		}
	}
	
	protected static String printNumbers(int maxNumbers) {
		int i=1;
		while(i<(maxNumbers/2)) {
			System.out.println(i);
			i++;
			
			if(i==(maxNumbers/2)) break;
		}
		
		Animal.countTo(maxNumbers/2);
		return "End of printNumbers";
	}
	
	protected static void guessMyNumber() {
		int number;
		do {
			System.out.println("Guess Number up to 100");
			while(!userInput.hasNextInt()) {
				String numberEntered = userInput.next();
				System.out.printf("%s is not a number\n", numberEntered); // %d, %f
			}
			number = userInput.nextInt();
		} while(number != 50);
		
	}
	
	public String makeSound() {
		return "Grrrr";
	}
	
	public static void speakAnimal(Animal randAnimal) {
		System.out.println("Animal says " + randAnimal.makeSound());
	}

	public static void main(String[] args) {
		Animal theAnimal = new Animal();
		
		int[] favoriteNumber; // int array
		favoriteNumber = new int[20];
		favoriteNumber[0] = 100;
		
		String[] stringArray = {"Random", "Words", "Here"}; // string array
		for(String word : stringArray) {
			System.out.println(word);
		}
		
		String[][][] arrayName = {{{"000"},{"100"},{"200"},{"300"}},
				{{"010"},{"110"},{"210"},{"310"}},
				{{"020"},{"120"},{"220"},{"320"}}}; // multi-dimensional array 
		for(int i=0; i<arrayName.length; i++)
		{
			for(int j=0; j<arrayName[i].length; j++)
			{
				for(int k=0; k<arrayName[i][j].length; k++)
				{
					System.out.print("| " + arrayName[i][j][k] + " ");
				}
			}
			
			System.out.println("|");
		
		}
		
		String[] cloneOfArray = Arrays.copyOf(stringArray, 3);
		System.out.println(Arrays.toString(cloneOfArray));
		System.out.println(Arrays.binarySearch(cloneOfArray, "Random"));
	}

}
