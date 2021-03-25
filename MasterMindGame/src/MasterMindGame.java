import java.util.Random;
import java.util.Scanner;

public class MasterMindGame {

	public static void main(String[] args) {
		String userGuess;
		int lifeCount = 12;
		int isGoodNum = 0;
		
		Random rnd = new Random();
		int[] rndCode = new int[4];
		for (int i = 0; i < rndCode.length; i++) {
			rndCode[i] = rnd.nextInt(6) + 1; // storing random integers in an array
			/*TEMP*/
			System.out.print(rndCode[i] + " "); //printing each array element
		}
		System.out.println(); //TEMP
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("FIND THE HIDDEN CODE!");
		System.out.println("Enter 4 numbers from 1 to 6.");
		System.out.println("- If the result is 1, one of your numbers are in the good position.");
		System.out.println("- If it's 0, they are in the code but not in the good position."); 
		System.out.println("- An underscore means that they are no in the code.");
		System.out.println("You have 12 lives. Good luck!");
		System.out.println();

		while ((lifeCount != 0) && (isGoodNum != 4)) {
			//reset values
			isGoodNum = 0;
			int isValidNum = 0;
			
			if (lifeCount < 12)
				System.out.println("You have " + lifeCount + " lives");
				
			System.out.print("Enter your code: ");
			userGuess = input.nextLine();
	
			//Prepare our user's string
			userGuess = userGuess.replaceAll(" ", ""); //clean user's white spaces
			String first4char = userGuess.substring(0,4); //use the first 4 values
			char[] userCodeChar = first4char.toCharArray();
			
			//Convert from char to int
			int[] userCode = new int[4];
			for (int i = 0; i < 4; i++) {
				//char value is written with ascii code
				//(ex. 1 is 49 while 0 is 48 --> 49-48=1
				userCode[i] = userCodeChar[i] - '0';
			}
			
			//First validation: good number + good position
			for (int i = 0; i < rndCode.length; i++) {
				if (rndCode[i] == userCode[i]) {
					rndCode[i] *= -1;
					userCode[i] = 0;
					isGoodNum++;
				}
			}
			
			//Second validation: good number + wrong position && wrong number
			for (int i = 0; i < rndCode.length; i++) {
				//Search if the remaining numbers of the userCode array exist in rndCode
				for (int j = 0; j < rndCode.length; j++) {
					if ((userCode[i] == rndCode[j]) && (userCode[i] > 0)) {
						rndCode[j] *= -1;
						userCode[i] = 0;
						isValidNum++;
					}
				}
			}
			
			//Return rndCode values to original for the next round
			for (int k=0; k<rndCode.length; k++)
				rndCode[k] = Math.abs(rndCode[k]);
			
			//Printing results
			for (int j=0; j<isGoodNum; j++)
	    		System.out.print("1 ");
	
	    	for (int j=0; j<isValidNum; j++)
	    		System.out.print("0 ");
	
	    	for (int j=0; j<(4-isGoodNum-isValidNum); j++)
	    		System.out.print("- ");
	    	System.out.println();
	    	
	    	lifeCount--;
		}
		input.close();
		
    	if (isGoodNum == 4)
        	System.out.println("Well DONE!");
        else 
        	System.out.println("Game Over. Try again!");
	}

}
