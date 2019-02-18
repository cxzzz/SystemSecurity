package ie.dit.syssecurity.exercises;

import java.math.BigInteger;

public class FixedXOR {

	// Function for parsing hex string to binary string
	public static String toBinary(String hexString) {
		return new BigInteger("1" + hexString, 16).toString(2).substring(1); 
	}
	
	// Function for xor'ing two binary strings
	public static String xor(String a, String b) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < a.length(); i++) {
			sb.append(a.charAt(i) ^ b.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1c0111001f010100061a024b53535009181c";
		String b = "686974207468652062756c6c277320657965";
		
		// XOR result in binary
		String xorResult = xor(toBinary(a), toBinary(b));
		
		// Print result of hex by BigInteger
		System.out.println(new BigInteger(xorResult, 2).toString(16));
		
	}

}
