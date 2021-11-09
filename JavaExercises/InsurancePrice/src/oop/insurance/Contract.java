package oop.insurance;
import java.util.Calendar;

public class Contract {
	private int accidentsNum;
	private int seniorityYear, seniorityYearTotal;
	
	//Create GET for all the parameters
	public int getAccidents() {
		return accidentsNum;
	}
	public int getSeniority() {
		return seniorityYear;
	}
	
	//Create SET for all the parameters to work with
	private void setSeniorityYear(int seniorityYear) {
		this.seniorityYear = seniorityYear;
		Calendar now = Calendar.getInstance();
		// Subtract the client driving license year
		now.add(Calendar.YEAR, - seniorityYear);
		seniorityYearTotal = now.get(Calendar.YEAR);
	}

	//Create rate system
	public void calculateRate(Client client) {
		boolean clientJunior = false;
		boolean clientYoungDriver = false;
		boolean insuranceCond = false;
		int malusPoints = accidentsNum;
		String rateID = "";

		if (client.getAge() < 25)
			clientJunior = true;
		if (client.getdrivingLicense() <= 2)
			clientYoungDriver = true;
		if (seniorityYearTotal >= 5)
			insuranceCond = true;
		
		if ((clientJunior == true) || (clientYoungDriver == true))
			malusPoints++;
		if ((malusPoints < 3) && (insuranceCond == true))
			malusPoints--;
		
		switch (malusPoints) {
			case -1:
				rateID = "Blue";
	        	break;
			case 0:
				rateID = "Green";
				break;
			case 1:
				rateID = "Orange";
				break;
			case 2:
				rateID = "Red";
			    break;
			default:
				System.out.println("You are not eligible for our products.");
		}
		System.out.println("You are eligible for our " + rateID + " tarif.");
	}
	
	//Create Constructors
	public Contract(int accidentsNum, int seniorityYear) {
		this.accidentsNum = accidentsNum;
		setSeniorityYear(seniorityYear);
	}
	//Default constructor
	public Contract() {
		seniorityYear = 0;
		accidentsNum = 0;
	}
	
	public void display() {
		System.out.println("Number of accidents (at fault): " + accidentsNum);
		System.out.println("Years at our company: " + seniorityYearTotal);
	}
}
