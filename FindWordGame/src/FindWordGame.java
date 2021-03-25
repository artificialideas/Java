import java.util.Scanner;

public class FindWordGame {

	public static void main(String[] args) {
		String hiddenWord = "europe";
		String shownWord = "------";
		char charUser;
		int lifeCount = 9;
		int letterFound = 0;
		
		// Creating array of string length 
        char[] charHidden = new char[hiddenWord.length()];
        char[] charShown = new char[shownWord.length()];  
        // Copy character by character into array 
        for (int i = 0; i < hiddenWord.length(); i++) { 
        	charHidden[i] = hiddenWord.charAt(i); 
        	charShown[i] = shownWord.charAt(i);
        } 
		
		Scanner input = new Scanner(System.in);

		System.out.println("FIND THE HIDDEN WORD!");
		System.out.println("Find the hidden word before you run out of lives. Good luck!");
		System.out.println(); //give some white space for better reading

		System.out.println("The word is: " + shownWord);
		do {
			System.out.print("Enter a letter: ");
			/*
			 * next() function returns the next token/word in the input as a string and
			 * charAt(0) function returns the first character in that string
			*/
			charUser = input.next().charAt(0);
			
			// .indexOf() returns -1 if there is no occurrence			
			if (hiddenWord.indexOf(charUser) != -1) {
				System.out.println("The word is: ");
				for (int i = 0; i < hiddenWord.length(); i++) {
		        	/* 
		        	 * Search the charUser letter in the charHidden array and
		        	 * change its equal in arrayShown array
		        	 */
					if (charHidden[i] == charUser) {
						char temp = charHidden[i];
				        charHidden[i] = charShown[i];
				        charShown[i] = temp;
				        
				        letterFound++;
					}
					System.out.print(charShown[i]);
				}
			} else {
				if (lifeCount == 0) {
					System.out.println("Oups! You lost a life!");
				}
				lifeCount--;
			}
			System.out.println(); //give some white space for better reading
			System.out.println("You have " + lifeCount + " lives");
			
		} while (!((lifeCount == 0) || (letterFound == hiddenWord.length())));
		
		input.close();
		if (lifeCount == 0) {
			System.out.println("You lost! The hidden word was " + hiddenWord);
		} else {
			System.out.println("Congratulations! You won!");
		}
	}

}
