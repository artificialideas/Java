package oop.insurance;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String name, surname;
		int age, drivingLicense, accidentsNum, seniorityYear;
		Scanner input = new Scanner(System.in);
     
		System.out.print("Name: ");
		name = input.nextLine();
		System.out.print("Surname: ");
		surname = input.nextLine();
		System.out.print("Age: ");
		age = input.nextInt();
		if (age < 18) {
			System.out.println("Client denied. The entered contact is underage.");
			System.exit(-1);
		}
		System.out.print("Driving license year: ");
		drivingLicense = input.nextInt();
		System.out.print("Accidents at fault: ");
		accidentsNum = input.nextInt();
		if (accidentsNum >= 3) {
			System.out.println("Too many accidents. You are not eligible for our products.");
			System.exit(-1);
		}
		System.out.print("Year of our contract: ");
		seniorityYear = input.nextInt();
        input.close();
		System.out.println("-------------------");
        
		Client client = new Client(name, surname, age, drivingLicense);
		Contract contract = new Contract(accidentsNum, seniorityYear);

		client.display();
		contract.display();
		contract.calculateRate(client);
	}
	
}
