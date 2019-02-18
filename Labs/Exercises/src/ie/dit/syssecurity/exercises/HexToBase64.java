package ie.dit.syssecurity.exercises;

import java.math.BigInteger;

public class HexToBase64 { 
 
	public static String hexToBinary(String hexString) {
		return new BigInteger("1" + hexString, 16).toString(2).substring(1);
	}
	
	public static String binaryToBase64(String binaryString) {
		
		String base64Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
				
		StringBuffer sb = new StringBuffer();
		
		int j = 6;
		int k = 0;
		
		while (j % binaryString.length() != 0) {
			
			// Get the base64 value by 6 bits
			sb.append(base64Str.charAt(Integer.parseInt(binaryString.substring(k, j), 2)));
				
			k = j;
			j = (j + 6) % binaryString.length();
			
			if (j % binaryString.length() == 0) {
				sb.append(base64Str.charAt(Integer.parseInt(binaryString.substring(k), 2)));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		
		String binaryArray = hexToBinary(hex);
		
		String result = binaryToBase64(binaryArray);
		
		System.out.println(result);
	}

}
