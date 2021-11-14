

/*
EMU COSC 480/592
PKI Project
This class creates a string of length 28 with 9 random numbers plus a date & time stamp.
This functionality was pasted into Certificate.java.
*/
import java.util.*;

public class TestRandom {

	public static void main(String[] args) {
		Random rand = new Random();
		Integer r1 = rand.nextInt(1000000000);
//		System.out.println(r1);
		Date d1 = new Date();
//		System.out.println(d1);
		String s1 = r1.toString() + d1;
		System.out.println("random + timestamp: " + s1);
				
		System.out.println(d1);
		System.out.println("length of entire string: " + d1.toString().length());
		
		
		

	}

}
