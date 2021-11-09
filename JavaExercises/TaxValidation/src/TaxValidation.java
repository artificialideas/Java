import java.util.Scanner;

public class TaxValidation {

	public static void main(String[] args) {
		String sex;
		int age;
		Scanner input = new Scanner(System.in);
        
		System.out.print("Man(M) or Woman(W)? ");
        sex = input.nextLine();
        System.out.print("Age: ");
        age = input.nextInt();
        
        input.close();
        
        if (((sex.compareToIgnoreCase("m") == 0) && (age > 20)) ||
            ((sex.compareToIgnoreCase("w") == 0) && ((age >= 18) && (age <= 35)))) {
        	System.out.println("Must pay the imposed tax.");
        } else {
        	System.out.println("Is exempt of any taxes.");
        }
	}

}
