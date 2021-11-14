

import java.util.*;


/*
 EMU COSC 480/592
 PKI Project
 This class simulates the role of the certification authority by instantiating
 and authenticating certificates.
 As of now, it uses X.509 version 1
 */
public class Certificate {

	// Member variables based on the elements of the X.509 version 1 certificates
	private String certNo; // Random int plus current date/time stamp
	private Integer version; // Default sets this to 1
	private Date startDate; // Default sets to time of instantiation
	private String endDate; // Default sets this to 12/31/2099
	private String user; 
	private String userAlg;
	private String userParams;
	private String userKey;

	// Instantiate Random to use in constructors
	Random rand = new Random();

	public Certificate() { // Default constructor creates certificate without a user
		Integer r1 = rand.nextInt(1000000000);
		this.certNo = (r1.toString() + new Date()).replaceAll(" ","");
		this.version = 1;
		this.startDate = new Date();
		this.endDate = "2099-12-31";  // For now end date is a string
		this.user = "";
		this.userAlg = "";
		this.userParams = "";
		this.userKey = "";

	}
	// Constructor that takes user information
	public Certificate(String user, String userAlg, String userParams, String userKey) {
		Integer r1 = rand.nextInt(1000000000);
		this.certNo = (r1.toString() + new Date()).replaceAll(" ","");
		this.version = 1;
		this.startDate = new Date();
		this.endDate = "2099-12-31";
		this.user = user;
		this.userAlg = userAlg;
		this.userParams = userParams;
		this.userKey = userKey;
	}

	// For future use: when additional versions are included
	public Certificate(Integer version, String user, String userAlg, String userParams, String userKey) {
		Integer r1 = rand.nextInt(1000000000);
		this.certNo = (r1.toString() + new Date()).replaceAll(" ","");
		this.version = version;
		this.startDate = new Date();
		this.endDate = "2099-12-31";
		this.user = user;
		this.userAlg = userAlg;
		this.userParams = userParams;
		this.userKey = userKey;
	}


	public String getEndDate() {
		return endDate;
	}
	@Override
	public String toString() {
		return "Certificate: certNo=" + certNo + "\nversion=" + version + "\nstartDate=" + startDate + "\nendDate="
				+ endDate + "\nuser=" + user + "\nuserAlg=" + userAlg + "\nuserParams=" + userParams + "\nuserKey="
				+ userKey + "\nValidity status: " + this.isValid() + "\n*************************************************************";
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserAlg() {
		return userAlg;
	}
	public void setUserAlg(String userAlg) {
		this.userAlg = userAlg;
	}
	public String getUserParams() {
		return userParams;
	}
	public void setUserParams(String userParams) {
		this.userParams = userParams;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public boolean isValid() {
		if (this.getEndDate().equals("2099-12-31")) {
			return true;
		}

		return false;
	}




}
