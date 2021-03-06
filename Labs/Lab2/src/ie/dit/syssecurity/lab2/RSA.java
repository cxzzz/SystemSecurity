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
		BigInteger phi = num1.subtract(BigInteger.ONE).multiply(num2.subtract(BigInteger.ONE));
		// Find mod inverse of fi
		
		BigInteger e = BigInteger.probablePrime(512, new Random());
		
		while(!phi.gcd(e).equals(BigInteger.ONE) || e.intValue() > phi.intValue()) {
			e.nextProbablePrime();
		}
		// Find another mod inverse of phi
		BigInteger d = e.modInverse(phi);
		
		// index 0 - public key, index 1 - private key, index 2 - PQ
		result[0] = e;
		result[1] = d;
		result[2] = pq;
		
		// Return public key and private key and pq
		return result;
	}
	
	public static BigInteger encryptMessage(String message, BigInteger key, BigInteger modulo) {
		
		// Convert the message to bytes
		byte[] bytes = message.getBytes();
		
		// Generate the message in BigInteger
		BigInteger newMessage = new BigInteger(bytes);
		
		// Compute and return the message in encrypted status
		return newMessage.modPow(key, modulo);
	}
	
	public static byte[] decryptMessage(BigInteger message, BigInteger key, BigInteger modulo) {
		
		// Decrypt using secret key
		BigInteger newMessage = message.modPow(key, modulo);
		
		// Convert it back to bytes
		byte[] bytes = newMessage.toByteArray();
		
		// Convert the bytes into String and return
		return bytes;
	}
	
	public static void main(String args[]) {
		// Generate two larget random numbers
		BigInteger num1 = BigInteger.probablePrime(512, new Random());
		BigInteger num2 = BigInteger.probablePrime(512, new Random()); // Because might generated same prime number for 2 nums.
		
		String message = "System Security With RSA Algorithm";
		
		// Test the number generated is prime number
		if (num1.isProbablePrime(100) && num2.isProbablePrime(100) && num1 != num2) {
			System.out.println("Numbers are all prime");
			System.out.println("Num1: " + num1);
			System.out.println("Num2: " + num2);

			// Generating the public key and private key
			BigInteger[] keys = generateKey(num1, num2);
			
			// Output the keys to screen
			System.out.println("The public key is: " + keys[0]);
			System.out.println("The private key is: " + keys[1]);
			System.out.println("PQ is: " + keys[2]);
			
			// Encrypt a message
			BigInteger encryptedMessage = encryptMessage(message, keys[0], keys[2]); 
			
			// Output the encryptedMessage to screen
			System.out.println("Encrypted BigInteger: " + encryptedMessage);
			
			// Decrypt the encrypted message
			String decryptedMessage = new String(decryptMessage(encryptedMessage, keys[1], keys[2]));
			
			// Output to screen
			System.out.println("Message is: " + decryptedMessage);
			
			
		} else {
			System.out.println("Not all numbers are prime");
			return;
		}
		
	}
	
}
