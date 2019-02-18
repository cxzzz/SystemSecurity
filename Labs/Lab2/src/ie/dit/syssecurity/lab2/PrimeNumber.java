package ie.dit.syssecurity.lab2;

import java.util.Scanner;

public class PrimeNumber {

	public static boolean checkPrime(int num) {
		boolean result = true;
		
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static int getGCD(int a, int b) {
		
		int result = a % b;
		
		if (result == 0) {
			return b;
		} else {
			return getGCD(b, result);
		}
	}
	
	public static int[] euclidian(int a, int b) {
		
		int[] result = new int[2];
		
		int gcd = a % b;
		
		if (gcd == 0) {
			
		} 
		
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		
		// Prompt for a number from user
		System.out.print("Please enter a number: ");
		int num = in.nextInt();
		
		boolean result = checkPrime(num);
		
		if (result) {
			System.out.println("The number " + num + " is prime");
		} else {
			System.out.println("The number " + num + " is not prime");
		}
		
		
		System.out.println("Please enter two numbers ");
		int a = in.nextInt();
		int b = in.nextInt();
		
		int gcd = getGCD(a, b);
		
		System.out.println("The GCD of " + a + " and " + b + " is " + gcd);
		
		in.close();
	}

}
