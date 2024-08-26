package hospital;

import java.util.Scanner;

public class Patient extends Person{
	private String disease;
	private String admitStatus;
	private int age;
	
	public Patient() {}
	public Patient(String id, String name, String sex, String disease, String admitStatus, int age) {
		super(id, name, sex);
		this.disease = disease;
		this.admitStatus = admitStatus;
		this.age = age;
	}
	public void newPatient(Scanner input) {
		System.out.print("ID:");
		super.setID(input.nextLine());
		System.out.print("Name:");
		super.setName(input.nextLine());
		System.out.print("Sex:");
		super.setName(input.nextLine());
		System.out.print("Disease:");
		setDisease(input.nextLine());
		System.out.print("Admit Status:");
		setAdmitStatus(input.nextLine());
		System.out.print("Age:");
		setAge(input.nextInt());
	}
	public void showPatientInfo() {
		System.out.printf("ID: %s\n",super.getID());
		System.out.printf("Name: %s\n",super.getName());
		System.out.printf("Disease: %s\n",getDisease());
		System.out.printf("Sex: %s\n",getSex());
		System.out.printf("Admit Status: %s\n",getAdmitStatus());
		System.out.printf("Age: %s\n",getAge());
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getAdmitStatus() {
		return admitStatus;
	}
	public void setAdmitStatus(String admitStatus) {
		this.admitStatus = admitStatus;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
