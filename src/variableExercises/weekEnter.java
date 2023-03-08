package variableExercises;

import java.util.Scanner;

public class weekEnter {
	static String name;
	static int age;
	
	public weekEnter() {
		String gender;
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your gender, male of female?");
        gender = scan.nextLine();

        
        
        if( gender.equals("f") || gender.equals("F") || gender.equals("female") || 
        		gender.equals("Female") || gender.equals("FEMALE")) {
        	System.out.println("Please enter your name ");
        	name = scan.nextLine();
        	System.out.println("Please enter your age ");
        	age = scan.nextInt();
        	System.out.println("Her name is " + name + " and her age is " + age);
        }
        if( gender.equals("m") || gender.equals("M") || gender.equals("male") 
        		|| gender.equals("Male") || gender.equals("MALE")) {
        	System.out.println("Please enter your name ");
        	name = scan.nextLine();
        	System.out.println("Please enter your age ");
        	age = scan.nextInt();
        	System.out.println("His name is " + name + " and his age is " + age);
        }
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void displayDetails(String name, int age) {
		//definition method right here
	}
}
