

import java.text.SimpleDateFormat;
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
	/*
	 * Add invalid boolean
	 */

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
	public Certificate(String endDate, String user, String userAlg, String userParams, String userKey) {
		Integer r1 = rand.nextInt(1000000000);
		this.certNo = (r1.toString() + new Date()).replaceAll(" ","");
		this.version = 1;
		this.startDate = new Date();
		this.endDate = endDate;
		this.user = user;
		this.userAlg = userAlg;
		this.userParams = userParams;
		this.userKey = userKey;
	}

	// For future use: when additional versions are included
	public Certificate(Integer version, String endDate, String user, String userAlg, String userParams, String userKey) {
		Integer r1 = rand.nextInt(1000000000);
		this.certNo = (r1.toString() + new Date()).replaceAll(" ","");
		this.version = version;
		this.startDate = new Date();
		this.endDate = endDate;
		this.user = user;
		this.userAlg = userAlg;
		this.userParams = userParams;
		this.userKey = userKey;
	}

	@Override
	public String toString() {
		return "Certificate: certNo=" + certNo + "\nversion=" + version + "\nstartDate=" + startDate + "\nendDate="
				+ endDate + "\nuser=" + user + "\nuserAlg=" + userAlg + "\nuserParams=" + userParams + "\nuserKey="
				+ userKey + "\nValid Date: " + this.dateIsValid() + "\n*************************************************************";
	}

	/*
	Checks that certificate isn't expired by confirming that end date is >= today.
	For now, the date is a string. We can change it to a format in Date class if desired.
	*/
	public boolean dateIsValid() {
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		String currentYMD = new String(ymd.format(new Date())); 
//		System.out.println("Printing YMD from dateIsValid: " + currentYMD);
		if (this.getEndDate().compareTo(currentYMD) >= 0) {
			return true;
		}
		System.out.println("Error: Expired certificate");
		return false;
	}

	/*
	 Method to check for "equality" of two certificates by confirming the same user, userKey.
	 This method is called from contains() in CertificateStore to check if a certificate
	 exists with the user and userKey parameters.
	 */
	public boolean userAndKeyMatch(String user, String userKey) {
		if (this.user.equalsIgnoreCase(user) && this.userKey.equalsIgnoreCase(userKey))
			return true;
		else
			return false;
	}

	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
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

}
