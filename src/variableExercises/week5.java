package variableExercises;

import java.util.Scanner;

public class week5 {

	public week5() {
		
	}
	
	public void getSource() {
		String start = "";
		Scanner scan = new Scanner(System.in);
		start = scan.nextLine();
		do {
		Scanner readme = new Scanner(System.in);
		   System.out.println("Enter Two Numbers (Press Enter after each):");
		   int largest;
		   //two variables to hold numbers
		   int n1Add;
		   int n2Add;
		   int n3Add;
		   
		   int n1Mult;
		   int n2Mult;
		   int n3Mult;
		   System.out.println("Please enter the first number");
		   n1Add = readme.nextInt();
		   System.out.println("Please enter the second number");
		   n2Add = readme.nextInt();
		   n3Add = n1Add + n2Add;
		   System.out.println("Total = " + n3Add);
		   
		   System.out.println("Please enter the first number to multiply ");
		   n1Mult = readme.nextInt();
		   System.out.println("Please enter the second number to multiply");
		   n2Mult = readme.nextInt();
		   n3Mult = n1Mult * n2Mult;
		   System.out.println("Total = " + n3Mult);
		   
		   largest = n1Add > n2Add ? n1Add : n2Add;
		   System.out.println("The largest added number is " + largest);
		   
		   largest = n1Mult > n2Mult ? n1Mult : n2Mult;
		   System.out.println("The largest multiplier is " + largest);
		} while(start.equals("go"));

	}
}
