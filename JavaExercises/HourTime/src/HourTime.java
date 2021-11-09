import java.util.Scanner;

public class HourTime {

	public static void main(String[] args) {
		int hour;
		int min;
		int sec;
        Scanner input = new Scanner(System.in);
        
		System.out.print("Enter the hour: ");
        hour = input.nextInt();
        System.out.print("Enter minutes: ");
        min = input.nextInt();
        System.out.print("Enter seconds: ");
        sec = input.nextInt();
        
        input.close();
        
        sec = sec + 1;
        if (sec >= 60) {
        	min = min + 1;
        	sec = sec - 60;
        	if (min >= 60) {
        		hour = hour + 1;
        		min = min - 60;
        		if (hour >= 24) {
        			hour = hour - 24;
        		}
        	}
        }
        System.out.println("In a second it will be " + hour + ":" + min + ":" + sec);
	}

}
