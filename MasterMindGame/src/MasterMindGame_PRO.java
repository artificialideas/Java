import java.util.Scanner;
import java.util.Random;   

public class MasterMindGame_PRO {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Let's Start!");
		
        //Generate random values
        int[] code = new int[4];
        Random randomGenerator = new Random();
        
        for(int i=0;i<4;i++)
        {
        	code[i] = (Math.abs(randomGenerator.nextInt()) % 6) + 1; 
        	System.out.print(code[i]+" ");
        }
        System.out.println();
        
        //Start game
        int[] userCode = new int[4];
        int wellPlaced=0;
        for(int i=0;i<12 && wellPlaced != 4;i++)
        {
        	//Initialization
        	wellPlaced=0;
        	
        	//Get guess
    		System.out.println("(" + (i+1) + "/12) Write your four digit combination: ");
        	for(int j=0;j<4;j++)
        	{
        		userCode[j] = input.nextInt();
        	}
        	String s = input.nextLine(); //Clear the buffer
        	
        	//Check good placed items
        	for(int j = 0;j<4;j++)
        	{
        		if(userCode[j]==code[j])
        		{
        			wellPlaced++;
        			userCode[j] = 0; //Mark the digit as processed
        		}
        	}        	
        	
        	//Check the matching color
        	int goodColor = 0;

        	for(int j=0;j<4;j++)
        	{
        		//Check if the current item is in the combination  
        		int currentColorToCheck = userCode[j];
        		
        		//Check the repetitions of this color in the code
        		int colorInCode=0;
        		for(int k=0;k<4;k++)
        		{
        			if(currentColorToCheck == code[k])
        				colorInCode++;
        		}

        		//Check the repetitions of this color in the userCode
        		int colorInUserCode=0;
        		for(int k=0;k<4;k++)
        		{
        			if(currentColorToCheck == userCode[k])
        			{
        				colorInUserCode++;
        				userCode[k] = 0; //Mark the digit as processed        				
        			}
        		}
        		
        		//The number of the good colors corresponds to the minimum
        		//of both values.
        		goodColor += (Math.min(colorInCode, colorInUserCode));
        	}    
        	
        	for(int j=0;j<wellPlaced;j++)
        		System.out.print("1 ");

        	for(int j=0;j<goodColor;j++)
        		System.out.print("0 ");

        	for(int j=0;j<(4-wellPlaced-goodColor);j++)
        		System.out.print("- ");
        	
            System.out.println();
        }
        
        if(wellPlaced == 4)
        	System.out.println("Well DONE!");
        else 
        	System.out.println("Game Over. Try again!");
	}
}
