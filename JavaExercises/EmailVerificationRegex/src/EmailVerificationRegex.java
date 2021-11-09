import java.util.Scanner;
/*
 * RegEx (regular expression) patterns let us validate data formats
 * We'll do a validation without using the inbuilt APIs java.util.regex
 * More info at: https://howtodoinjava.com/java-regular-expression-tutorials/
 */

public class EmailVerificationRegex {
	//Start by creating a validation method "isValid"
	static boolean isValid(String email) {
		//Only char, numbers, underscore and point (user ID)
		//Only char and numbers + point (URL ID; can be repeated)
		//From 2 to 6 char for domain
		String regex = "^[A-Za-z0-9+_.-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		return email.matches(regex);
	}
	
	public static void main(String[] args) {
		String email;
		Scanner input = new Scanner(System.in);
        
		System.out.print("Your email: ");
        email = input.nextLine();
        input.close();

        //We'll call the isValid() method so we can check if it's a valid ID
        if (isValid(email)) {
        	System.out.println("We have send a verification email to " + email);
        } else {
        	System.out.println(email + " is not a valid email.");
        }
	}

}
