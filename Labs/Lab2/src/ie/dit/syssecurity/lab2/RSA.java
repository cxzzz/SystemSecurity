package ie.dit.syssecurity.lab2;

import java.util.Random;

public class RSA {
	
	public boolean checkPrime(long num) {
		
		for (long i = 2;  i < Math.sqrt(num); i++) {
			// Number passed in is not prime
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		
		// Generate two large random integers
		long num1 = new Random().nextLong();
		long num2 = new Random().nextLong();
		
		
	}
	
}
