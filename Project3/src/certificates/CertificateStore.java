

/*
EMU COSC 480/592
PKI Project
This class holds an arraylist of all certificates.
Initially, we will hard code certificates for the group members. Once the program works with these, 
we will add the ability for users to request/create certificates and other functionality.
*/
import java.util.ArrayList;

public class CertificateStore {
	
	
	public static void main(String[] args) {
		ArrayList<Certificate> certs = new ArrayList<Certificate>();
		Certificate c1 = new Certificate();
		Certificate c2 = new Certificate("Bob Smith", "DH", "These Params", "19d09baa34e");
		c2.setEndDate("2021-10-13");
		certs.add(c1);
		certs.add(c2);
		
		
		for (Certificate c : certs) {
			System.out.println(c);
			
		}
		
	}

}
