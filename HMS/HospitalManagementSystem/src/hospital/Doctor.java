package hospital;

import java.util.Scanner;

public class Doctor extends Staff {
	private String specialist;
	private String workTime;
	private String qualification;
	private int room;
	
	public Doctor() {
		super();
	}
	public Doctor(String id, String name, String specialist, String workTime, String qualification, int room) {
		super(id, name);
		this.specialist = specialist;
		this.workTime = workTime;
		this.qualification = qualification;
		this.room = room;
	}
	public void newDoctor(Scanner input) {
		System.out.print("ID:");
		super.setID(input.nextLine());
		System.out.print("Name:");
		super.setName(input.nextLine());
		System.out.print("Specialist:");
		setSpecialist(input.nextLine());
		System.out.print("Work Time:");
		setWorkTime(input.nextLine());
		System.out.print("Qualification:");
		setQualification(input.nextLine());
		System.out.print("Room number: ");
		setRoom(input.nextInt());
	}
	public void showDoctorInfo() {
		System.out.printf("ID: %s\n",super.getID());
		System.out.printf("Name: %s\n",super.getName());
		System.out.printf("Specialist: %s\n",getSpecialist());
		System.out.printf("Work Time: %s\n",getWorkTime());
		System.out.printf("Qualification: %s\n",getQualification());
		System.out.printf("Room number: %s\n",getRoom());
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
}
