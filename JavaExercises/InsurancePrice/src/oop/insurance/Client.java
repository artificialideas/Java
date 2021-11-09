package oop.insurance;
import java.util.Calendar;

public class Client {
	private String name;
	private String surname;
	private int age;
	private int drivingLicense, drivingLicenceYears;

	//Create GET for all the parameters
	//so we can access to them without making public the contained data
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getAge() {
		return age;
	}
	public int getdrivingLicense() {
		return drivingLicense;
	}
	
	//Create SET for all the parameters to work with
	public void setAge(int age) {
		this.age = age;
	}
	public void setDrivingLicence(int drivingLicense) {
		this.drivingLicense = drivingLicense;
		Calendar now = Calendar.getInstance();
		// Subtract the client driving license year
		now.add(Calendar.YEAR, - drivingLicense);
		drivingLicenceYears = now.get(Calendar.YEAR);
	}
	
	//Create Constructors
	public Client(String name, String surname, int age, int drivingLicense) {
		this.name = name;
		this.surname = surname.toUpperCase();
		if (age != 0)
			setAge(age);
		if (drivingLicense > -1)
			setDrivingLicence(drivingLicense);
	}
	//Default constructor
	public Client() {
		name = "Unknown name";
		age = 0;
		drivingLicense = 0;
	}
	
	public void display() {
		System.out.println("Client's full name: " + name + " " + surname);
		if (age != 0)
			System.out.println("Client's age: " + age) ;
		System.out.println("Number of years as a driver: " + drivingLicenceYears);
	}
	
}
