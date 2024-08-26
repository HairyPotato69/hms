package hospital;

import java.util.Scanner;

public class Lab extends Facility{
	private String lab;
	private int cost;
	public Lab() {};
	public Lab(String lab, int cost) {
		this.lab = lab;
		this.cost = cost;
	}
	public void newLab(Scanner input) {
		newFacility(input);
		System.out.println("Lab: ");
		setLab(input.nextLine());
		input.nextLine();
		System.out.println("Cost: ");
		setCost(input.nextInt());
		input.nextLine();
	}
	public void labList() {
		System.out.printf("Lab: %s\n",getLab());
		System.out.printf("Cost: %s\n",getCost());
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
