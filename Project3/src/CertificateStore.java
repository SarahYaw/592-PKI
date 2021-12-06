

/*
EMU COSC 480/592
PKI Project
This class holds an arraylist of all certificates.
Initially, we will hard code certificates for the group members using the constructor.
Later, we can add file IO capabilities to store & retrieve certificates.
 */
import java.util.ArrayList;
import java.util.HashMap;


public class CertificateStore {

	//	private ArrayList<Certificate> certs = new ArrayList<Certificate>();
	private ArrayList<Certificate> certs;
	//	This HashMap of user and key pairs takes the place of a local .env file to store key
	private HashMap<String, String> userAndKeyList = new HashMap<String, String>();

	public CertificateStore() {
		this.certs = new ArrayList<Certificate>();
	}

	public void createStore() {
		//		All certificates but Brain are valid except "Brain" which is expired
		this.certs.add(new Certificate("2021-12-31", "Brian", "DH", "-g 2849 -n 381"));
		this.certs.add(new Certificate("2021-01-01", "Brain", "DH", "-g 2849 -n 381"));
		this.certs.add(new Certificate("2021-12-31", "Sarah", "DH", "-g 2849 -n 381"));
		this.certs.add(new Certificate("2021-12-31", "Payton", "DH", "-g 2849 -n 381"));
		this.certs.add(new Certificate("2021-12-31", "Fatema", "DH", "-g 2849 -n 381"));
		this.certs.add(new Certificate("2021-12-31", "Yu", "DH", "-g 2849 -n 381"));
		

	}

//	This list of users and public keys simulates local .env folder for keys
	public void createUserAndKeyList() {
		for (Certificate c : this.certs) {
			userAndKeyList.put(c.getUser(), c.getUserPublicKey());
		}

	}
	
	public HashMap<String, String> getUserAndKeyList() {
		return userAndKeyList;
	}


	//	public getCerts

	public ArrayList<Certificate> getCerts() {
		return certs;
	}

	public void setCerts(ArrayList<Certificate> certs) {
		this.certs = certs;
	}

	public void printAllCerts() {
		System.out.println("\n**** Printing all Certificates ****\n");
		for (Certificate c : this.getCerts()) {
			System.out.println(c);
		}
		System.out.println();
	}

	public void printCertSummaries() {
		System.out.println("\n**** Printing Certificate Summaries ****\n");

		for (Certificate c : this.getCerts()) {
			System.out.println(c.getCertNo() + " " + c.getUser());

		}
		System.out.println();
	}
	/*
	A method to check if the CertificateStore object contains a certificate by checking username and key pair.
	then checking if the certificate is expired.
	 */
	public boolean validUserAndKey(String user, String userPublicKey) {

		for (Certificate c : this.certs) {
			System.out.println("Printing c in validUserAndKey from CertificateStore:");
			System.out.println(c);
			if (c.userAndKeyMatch(user, userPublicKey)) {
				
				return(c.dateIsValid());
			}		
		}

		System.out.println("Error: No match for user and key found.");

		return false;  // Temporarily commented out to test *** BPU ***
	}

}