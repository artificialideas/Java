import java.util.Scanner;

public class EmailVerification {
	
	public static void main(String[] args) {
		String email;
		Scanner input = new Scanner(System.in);
     
		System.out.print("Your email: ");
        email = input.nextLine();
        input.close();
        /* Option 1: using .indexOf()
        * 
		* int indexAt = email.indexOf('@');
		* int indexDot = email.indexOf('.');
		* if (indexAt < indexDot) {
		* 	System.out.print("Your email is valid.");
		* } else {
       	* 	System.out.print("Your email is NOT valid.");
        * }
        */

        //Option 2: using FOR loop
        int validateAt = 0;
        int validateDot = 0;
        int counter = 0;
        boolean isValid;
        for (int i = 0; i < email.length(); i++) {
        	if (email.charAt(i) == '@') {
        		validateAt = i;
        		counter++; //avoid more than 1 @
        		isValid = true;
        	}
        	if (email.charAt(i) == '.') {
        		validateDot = i;
        		isValid = true;
        	}
        }
    	if (((isValid = true) && (counter == 1)) && (validateAt < validateDot)) {
    		System.out.print("Your email is valid.");
    	} else {
    		System.out.print("Your email is NOT valid.");
    	}
	}

}
