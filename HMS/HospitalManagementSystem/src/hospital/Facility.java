package hospital;

import java.util.Scanner;

public class Facility {
	private String facility;
	public Facility() {}
	public Facility(String facility) {
		this.facility = facility;
	}
	public void newFacility(Scanner input) {
		System.out.print("Facility: ");
		setFacility(input.nextLine());
	}
	
	public void showFacility() {
		System.out.printf("Facility", getFacility());
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	
}
