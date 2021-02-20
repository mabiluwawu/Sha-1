package tp2crypo;


import java.security.*;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.*;

public class SHA1 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
		System.out.println("Entre le à hasher");
	    Scanner sc = new Scanner(System.in);
	    String npx = sc.nextLine();
	    int x = aleatoireX();
	    //String npx = "mabi luwawu";
	    String phr = haSha1(x,npx);	
	    String y = "03b1663dda6549a0939ffdd712a852e0d4234e6b";
		
 		int r =0;
		for(;phr.compareTo(y)>0; r++) {
			x = aleatoireX();
			phr = haSha1(x,npx);
			
		}
		System.out.println("X = " + x +"\n"+"le nombre de calcul est de :" +r+"\n"+"la phrase hasher est : "+phr);
	}
	
	
	
	public static String haSha1(int n, String nomPrenom) throws NoSuchAlgorithmException {
		
		StringBuffer hexDigest = new StringBuffer();
		String nomId = concatenation_strings_java (nomPrenom,n);
	    
	    
		byte [] input = nomId.getBytes();
		
		MessageDigest SHA1 = MessageDigest.getInstance("SHA-1");
		SHA1.update(input);
		
		byte [] digest = SHA1.digest();	
		
		for(int i =0; i< digest.length; i++) {
			hexDigest.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		
		return hexDigest.toString();
	}
	
	
	public static int aleatoireX() {
		Random random = new Random();
		int nb;
		nb = random.nextInt();
		
		return nb;
	}
	public static String concatenation_strings_java (String s1, int x) {
	     return s1+x;
	 }
}

