import java.util.Scanner;

public class CopyPrice {

	public static void main(String[] args) {
		int copy;
		double price;
		Scanner input = new Scanner(System.in);
        
		System.out.print("How many copies? ");
        copy = input.nextInt();
        input.close();
        
        if (copy <= 30) {
	        if (copy <= 10){
	            price = copy * 0.10;
	        } else {
	            price = ((copy - 10) * 0.09) + 1;
	        }
        } else {
	        price = ((copy - 30) * 0.08) + 2.8;
        }
        
        System.out.print("Total price: " + price + " euros");
	}

}
