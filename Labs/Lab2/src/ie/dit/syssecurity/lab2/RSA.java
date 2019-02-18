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
	public static void generateKey() {
		
	}
	
	public static void main(String args[]) {
		// Generate two larget random numbers
		BigInteger num1 = BigInteger.probablePrime(512, new Random());
		BigInteger num2 = BigInteger.probablePrime(512, new Random());
		
		
		// Test the number generated is prime number
		if (num1.isProbablePrime(100) && num1.isProbablePrime(100)) {
			System.out.println("Numbers are all prime");
			
			// Generating the public key and private key
		} else {
			System.out.println("Not all numbers are prime");
			return;
		}
		
	}
	
}
