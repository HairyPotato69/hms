package hospital;

import java.util.Scanner;


public class Medicine {
	private String name;
	private String manufacturer;
	private String expiryDate;
	private int cost;
	private int count;
	
	public Medicine() {}
	public Medicine(String name, String manufacturer, String expiryDate, int cost, int count) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.expiryDate = expiryDate;
		this.cost = cost;
		this.count = count;
	}
	
	public void newMedicine(Scanner input) {
		System.out.print("Name:");
		setName(input.nextLine());
		System.out.print("Manufacturer:");
		setManufacturer(input.nextLine());
		System.out.print("Expiry Date:");
		setExpiryDate(input.nextLine());
		System.out.print("Cost:");
		setCost(input.nextInt());
		System.out.print("Count:");
		setCount(input.nextInt());
	}
	public void findMedicine() {
		System.out.printf("Name: %s\n",getName());
		System.out.printf("Manufacturer: %s\n",getManufacturer());
		System.out.printf("Expiry Date: %s\n",getExpiryDate());
		System.out.printf("Cost: %s\n",getCost());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
