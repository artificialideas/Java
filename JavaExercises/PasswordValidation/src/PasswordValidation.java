import java.util.Scanner;

public class PasswordValidation {
	
	public static void main(String[] args) {
		String password;
		final String SPECIALCHAR = "~!@#$%^&*()_-";
		boolean hasUC = false;  //has an upper case alphabet
		boolean hasSC = false;  //has a special character
		boolean hasNum = false; //has a digit
        String securityLvl = "";

		Scanner input = new Scanner(System.in);

		System.out.println("You may increase your security level by adding at least:");
		System.out.println("One upper case letter, " +
							"one special character ~!@#$%^&*()_- " +
							"and one digit.");
		System.out.println(); //give some white space for better reading
		System.out.print("Enter your selected password: ");
		password = input.nextLine();
		input.close();

		int pwdLength = password.length();
        for (int i = 0; i < pwdLength; i++) {
        	//Store each char on a variable
        	char character = password.charAt(i);
        	
        	if (Character.isUpperCase(character)) {
        		hasUC = true;
        	}
        	if (SPECIALCHAR.contains(Character.toString(character))) {
        		hasSC = true;
        	}
        	if (Character.isDigit(character)) {
        		hasNum = true;
        	}
        }

        //Create security levels
        if ((password != null) && (!password.isEmpty())) {
	        if (pwdLength < 8) {
		        securityLvl = "DANGEROUS";
	        } else { //pwdLength >= 8
		        if ((hasUC == false) || (hasNum == false) || (hasSC == false)) {
		        	securityLvl = "WEAK";
		        }
		        if ((hasUC == true) || (hasNum == true)) {
		        	securityLvl = "AVERAGE";
		        }
				if (((hasUC == true) && (hasNum == true)) || (hasSC == true)) {
		        	securityLvl = "SECURE";
		        }
				if ((hasUC == true) && (hasNum == true) && (hasSC == true)) {
		        	securityLvl = "VERY SECURE";
		        }
	        }
	        System.out.println("Your password security level is: " + securityLvl);
        } else {
        	System.out.println("Oups! You haven't entered any characters.");
        }
	}
	
}