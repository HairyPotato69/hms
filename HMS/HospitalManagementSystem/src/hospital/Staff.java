package hospital;
import java.util.Scanner;

public class Staff extends Person{
	private String designation;
	private int salary;
	
	public Staff() {}
	public Staff(String id, String name, String designation, String sex, int salary) {
		super(id, name, sex);
		this.designation = designation;
		this.salary = salary;
	}
	public Staff(String id, String name) {
		super(id, name);
	}
	
	public void newStaff(Scanner input) {
		System.out.print("ID:");
		super.setID(input.nextLine());
		System.out.print("Name:");
		super.setName(input.nextLine());
		System.out.print("Sex:");
		super.setSex(input.nextLine());
		System.out.print("Designation:");
		setDesignation(input.nextLine());
		System.out.print("Salary:");
		setSalary(input.nextInt());
	}
	
	public void showStaffInfo() {
		System.out.printf("ID: %s\n",super.getID());
		System.out.printf("Name: %s\n",super.getName());
		System.out.printf("Designation: %s\n",getDesignation());
		System.out.printf("Sex: %s\n",getSex());
		System.out.printf("Salary: %s\n",getSalary());
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
