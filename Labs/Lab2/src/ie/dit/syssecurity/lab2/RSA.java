package ie.dit.syssecurity.lab2;

import java.math.BigInteger;
import java.util.Random;

/*
 * Program implementing the RSA Algorithm
 * Using BigInteger and try to encrypt and
 * decrypt using the RSA Algorithm
 * 
 * Date: 18/2/2019
 * Author: Chenxi Zhang
 */

public class RSA {
	
	// Implementataion of the RSA Algorithm
	public static BigInteger[] generateKey(BigInteger num1, BigInteger num2) {
		
		BigInteger[] result = new BigInteger[3];
		
		// Calculate result of P and Q
		BigInteger pq = num1.multiply(num2);
		// Calculate o(n) = (p-1) (q-1)
		BigInteger fi = num1.subtract(BigInteger.ONE).multiply(num2.subtract(BigInteger.ONE));
		// Find mod inverse of fi
		BigInteger e = fi.gcd(BigInteger.valueOf(3));
		// Find another mod inverse of fi
		BigInteger d = fi.gcd(BigInteger.valueOf(65537));
		
		// index 0 - public key, index 1 - private key, index 2 - PQ
		result[0] = e;
		result[1] = d;
		result[2] = pq;
		
		// Return public key and private key and pq
		return result;
	}
	
	public static void main(String args[]) {
		// Generate two larget random numbers
		BigInteger num1 = BigInteger.probablePrime(512, new Random());
		BigInteger num2 = num1.nextProbablePrime(); // Because might generated same prime number for 2 nums.
		
		
		// Test the number generated is prime number
		if (num1.isProbablePrime(100) && num1.isProbablePrime(100)) {
			System.out.println("Numbers are all prime");

			// Generating the public key and private key
			BigInteger[] keys = generateKey(num1, num2);
			
			// Output the keys to screen
			System.out.println("The public key is: " + keys[0]);
			System.out.println("The private key is: " + keys[1]);
			System.out.println("PQ is: " + keys[2]);
			
			
		} else {
			System.out.println("Not all numbers are prime");
			return;
		}
		
	}
	
}
