package hospital;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main{
	private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private ArrayList<Lab> labList = new ArrayList<Lab>();
	private ArrayList<Facility> facilityList = new ArrayList<Facility>();
	private ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
	private ArrayList<Staff> staffList = new ArrayList<Staff>();
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main hms = new Main();
		hms.run();
	}
	
	public void run() {
		boolean exit = false;
		while(!exit) {
			displayMenu();
			int choiceClass = validIntInput();
			crudMenu();
			int choiceCRUD = validIntInput();
			switch(choiceClass) {
				case 1:
					staff(choiceCRUD);
					break;
				case 2:
					doctor(choiceCRUD);
					break;
				case 3:
					patient(choiceCRUD);
					break;
				case 4:
					medicine(choiceCRUD);
					break;
				case 5:
					lab(choiceCRUD);
					break;
				case 6:
					facility(choiceCRUD);
					break;
				case 7:
					exit = true;
					break;
			}
			System.out.print("Do you wish to exit(Y/N): ");
			String response = input.next();
			exit = (response.equalsIgnoreCase("Y")) ? true : false;
		}
		input.close();
	}
	
	private void crudMenu() {
		System.out.println("1. Add");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		
	}
	private void displayMenu() {
		System.out.println("\nHospital Management System");
		System.out.println("1. Staff");
        System.out.println("2. Doctor");
        System.out.println("3. Patient");
        System.out.println("4. Medicine");
        System.out.println("5. Lab");
        System.out.println("6. Facility");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
	}
	public void doctorMenu() {
		System.out.println("Select fields to update:");
		System.out.println("1. Name");
		System.out.println("2. Specialization");
		System.out.println("3. Work Time");
		System.out.println("4. Qualification");
		System.out.println("5. Room No.");
		System.out.println("6. All.");
		System.out.print("Enter your choice: ");
}
	private void staffMenu() {
		System.out.println("Select fields to update:");
		System.out.println("1. Name");
		System.out.println("2. Designation");
		System.out.println("3. Sex");
		System.out.println("4. Salary");
		System.out.println("5. All");
		System.out.print("Enter your choice: ");
	}
	private void patientMenu() {
		System.out.println("Select fields to update:");
		System.out.println("1. Name");
		System.out.println("2. Disease");
		System.out.println("3. Sex");
		System.out.println("4. Admit status");
		System.out.println("5. Age.");
		System.out.println("6. All");
		System.out.print("Enter your choice: ");
	}
	private void medicineMenu() {
		System.out.println("Select fields to update:");
		System.out.println("1. Name");
		System.out.println("2. Manufacturer");
		System.out.println("3. Expiry Date");
		System.out.println("4. Cost");
		System.out.println("5. All");
		System.out.print("Enter your choice: ");
	}
	private void labMenu() {
		System.out.println("Select fields to update:");
		System.out.println("1. Lab");
		System.out.println("2. Cost");
		System.out.println("3. All");
		System.out.print("Enter your choice: ");
	}
	
	private Facility findFacility(String key) {
		for(int index = 0; index < facilityList.size(); index++) {
			if (facilityList.get(index).getFacility().equals(key))
				return facilityList.get(index);
		}
		return null;
	}
	private Lab findLab(String key) {
		for(int index = 0; index < labList.size(); index++) {
			if (labList.get(index).getLab() == key)
				return labList.get(index);
		}
		return null;
	}
	private Medicine findMedicine(String key) {
		for(int index = 0; index < medicineList.size(); index++) {
			if (medicineList.get(index).getName().equals(key))
				return medicineList.get(index);
		}
		return null;
	}
	private Patient findPatient(String key) {
		for(int index = 0; index < patientList.size(); index++) {
			if (patientList.get(index).getID().equals(key))
				return patientList.get(index);
		}
		return null;
	}
	private Staff findStaff(String key) {
		for(int index = 0; index < staffList.size(); index++) {
			if (staffList.get(index).getID().equals(key))
				return staffList.get(index);
		}
		return null;
	}
	private Doctor findDoctor(String key) {
		for(int index = 0; index < doctorList.size(); index++) {
			if (doctorList.get(index).getID().equals(key))
				return doctorList.get(index);
		}
		return null;
	}
	
	private void doctor(int choiceCRUD) {
		String doctorId;
		Doctor doctor = new Doctor();
		switch(choiceCRUD) {
			case 1:
				doctor.newDoctor(input);
				doctorList.add(doctor);
				break;
			case 2:
				doctorList.forEach((doctorDummy)->doctorDummy.showDoctorInfo());
				break;
			case 3:
				System.out.print("Enter doctor ID: ");
				doctorId = input.nextLine();
				doctor = findDoctor(doctorId);
				if (doctor != null) {
					doctorMenu();
					doctorUpdate(doctor);
				}
				else 
					System.out.println("Doctor not found!");
				break;
			case 4:
				System.out.print("Enter doctor ID: ");
				doctorId = input.nextLine();
				doctor = findDoctor(doctorId);
				if (doctor != null) {
					staffList.remove(doctor);
					System.out.println("Deleted!");
				}
				else 
					System.out.println("Doctor not found!");
				break;
				
		}
	}
	private void staff(int choiceCRUD) {
		String staffId;
		Staff staff = new Staff();
		switch(choiceCRUD) {
			case 1:
				staff.newStaff(input);
				staffList.add(staff);
				break;
			case 2:
				staffList.forEach((staffDummy)->staffDummy.showStaffInfo());
				break;
			case 3:
				System.out.print("Enter staff ID: ");
				staffId = input.nextLine();
				staff = findStaff(staffId);
				if (staff != null) {
					staffMenu();
					staffUpdate(staff);
				}
				else 
					System.out.println("Staff not found!");
				break;
			case 4:
				System.out.print("Enter staff ID: ");
				staffId = input.nextLine();
				staff = findStaff(staffId);
				if (staff != null) {
					staffList.remove(staff);
					System.out.println("Deleted!");
				}
				else 
					System.out.println("Staff not found!");
				break;
		}
	}
	private void patient(int choiceCRUD) {
		String patientId;
		Patient patient = new Patient();
		switch(choiceCRUD) {
			case 1:
				patient.newPatient(input);
				patientList.add(patient);
				break;
			case 2:
				patientList.forEach((patientDummy)->patientDummy.showPatientInfo());
				break;
			case 3:
				System.out.print("Enter Patient ID: ");
				patientId = input.nextLine();
				patient = findPatient(patientId);
				if (patient != null) {
					patientMenu();
					patientUpdate(patient);
				}
				else
					System.out.println("Patient not found!");
				break;
			case 4:
				System.out.print("Enter Patient ID: ");
				patientId = input.nextLine();
				patient = findPatient(patientId);
				if (patient != null) {
					patientList.remove(patient);
					System.out.println("Deleted!");
				}
				else 
					System.out.println("Patient not found!");
				break;
		}
	}	
	private void medicine(int choiceCRUD) {
		String medicineName;
		Medicine medicine = new Medicine();
		switch(choiceCRUD) {
			case 1:
				medicine.newMedicine(input);
				medicineList.add(medicine);
				break;
			case 2:
				medicineList.forEach((medicineDummy)->medicineDummy.findMedicine());
				break;
			case 3:
				System.out.print("Enter Medicine: ");
				medicineName = input.nextLine();
				medicine = findMedicine(medicineName);
				if (medicine != null) {
					medicineMenu();
					medicineUpdate(medicine);
				}
				else
					System.out.println("Medicine not found!");
				break;
			case 4:
				System.out.print("Enter Medicine: ");
				medicineName = input.nextLine();
				medicine = findMedicine(medicineName);
				if (medicine != null) {
					medicineList.remove(medicine);
					System.out.println("Deleted!");
				}
				else 
					System.out.println("Medicine not found!");
				break;
		}	
	}
	private void lab(int choiceCRUD) {
		String labName;
		Lab lab = new Lab();

		switch(choiceCRUD) {
			case 1:
				lab.newLab(input);
				labList.add(lab);
				break;
			case 2:
				labList.forEach((labDummy)->labDummy.labList());
				break;
			case 3:
				System.out.print("Enter Lab: ");
				labName = input.nextLine();
				lab = findLab(labName);
				if (lab != null) {
					labMenu();
					labUpdate(lab);
				}else
					System.out.println("Lab not found!");
				break;
			case 4:
				System.out.print("Enter Lab: ");
				labName = input.nextLine();
				lab = findLab(labName);
				if (lab != null) {
					labList.remove(lab);
					System.out.println("Deleted!");
				}
				else 
					System.out.println("Lab not found!");
				break;
		}	
	}
	private void facility(int choiceCRUD) {
		String facilityName;
		Facility facility = new Facility();
		switch(choiceCRUD) {
			case 1:
				facility.newFacility(input);
				facilityList.add(facility);
				break;
			case 2:
				facilityList.forEach((facilityDummy)->facilityDummy.showFacility());
				break;
			case 3:
				System.out.print("Enter facility: ");
				facilityName = input.nextLine();
				facility = findFacility(facilityName);
				if (facility != null) {
					System.out.print("Enter new facility: ");
					facility.setFacility(input.nextLine());
				}
				else 
					System.out.print("Facility not found!");
				break;
			case 4:
				System.out.print("Enter Facility: ");
				facilityName = input.nextLine();
				facility = findFacility(facilityName);
				if (facility != null) {
					facilityList.remove(facility);
					System.out.println("Deleted!");
				}else
					System.out.println("Facility not found!");
				break;
		}	
	}
	
	private void doctorUpdate(Doctor doctor) {
		int choice;
		boolean continueChoice = false;
		do {
			choice = validIntInput();
			switch (choice) {
			case 1:
				System.out.print("Enter new doctor name: ");
				doctor.setName(input.nextLine());
				break;
			case 2:
				System.out.print("Enter new doctor specialisation: ");
				doctor.setSpecialist(input.nextLine());
				break;
			case 3:
				System.out.print("Enter new doctor work time: ");
				doctor.setWorkTime(input.nextLine());
				break;
			case 4:
				System.out.print("Enter new doctor qualification: ");
				doctor.setQualification(input.nextLine());
				break;
			case 5:
				System.out.print("Enter new doctor room: ");
				doctor.setRoom(validIntInput());
				break;
			case 6:
				doctor.newDoctor(input);
				break;
			default:
				System.out.println("Choose only the choices given");
			}
			continueChoice = true;
		}while(!continueChoice);
	}
	private void staffUpdate(Staff staff) {
		int choice;
		boolean continueChoice = false;
		do {
			choice = validIntInput();
			switch (choice) {
			case 1:
				System.out.print("Enter new staff name: ");
				staff.setName(input.nextLine());
				break;
			case 2:
				System.out.print("Enter new staff designation: ");
				staff.setDesignation(input.nextLine());
				break;
			case 3:
				System.out.print("Enter new staff sex: ");
				staff.setSex(input.nextLine());
				break;
			case 4:
				System.out.print("Enter new staff salary: ");
				staff.setSalary(validIntInput());
				break;
			case 5:
				staff.newStaff(input);
				break;
			default:
				System.out.println("Choose only the choices given");
			}
			continueChoice = true;
		}while(!continueChoice);
	}
	private void patientUpdate(Patient patient) {
		int choice;
		boolean continueChoice = false;
		do {
			choice = validIntInput();
			switch (choice) {
			case 1:
				System.out.print("Enter new patient name: ");
				patient.setName(input.nextLine());
				break;
			case 2:
				System.out.print("Enter new patient disease: ");
				patient.setDisease(input.nextLine());
				break;
			case 3:
				System.out.print("Enter new patient sex: ");
				patient.setSex(input.nextLine());
				break;
			case 4:
				System.out.print("Enter new patient admit status: ");
				patient.setAdmitStatus(input.nextLine());
				break;
			case 5:
				System.out.print("Enter new patient age: ");
				patient.setAge(validIntInput());
				break;
			case 6:
				patient.newPatient(input);
				break;
			default:
				System.out.println("Choose only the choices given");
			}
			continueChoice = true;
		}while(!continueChoice);
	}
	private void labUpdate(Lab lab) {
		int choice;
		boolean continueChoice = false;
		do {
			choice = validIntInput();
			switch (choice) {
				case 1:
	                System.out.print("Enter new lab name: ");
					lab.setLab(input.nextLine());
					break;
				case 2:
					System.out.print("Enter new lab cost: ");
					lab.setCost(validIntInput());
					break;
				case 3:
					lab.newLab(input);
					break;
				default:
					System.out.println("Choose only the choices given");
			}
			continueChoice = true;
		}while(!continueChoice);
	}
	private void medicineUpdate(Medicine medicine) {
		int choice;
		boolean continueChoice = false;
		do {
			choice = validIntInput();
			switch (choice) {
			case 1:
				System.out.print("Enter new medicine name: ");
				medicine.setName(input.nextLine());
				break;
			case 2:
				System.out.print("Enter new manufacturer name: ");
				medicine.setManufacturer(input.nextLine());
				break;
			case 3:
				System.out.print("Enter new expiry date: ");
				medicine.setExpiryDate(input.nextLine());
				break;
			case 4:
				medicine.newMedicine(input);
			default:
				System.out.println("Choose only the choices given");
			}
			continueChoice = true;
		}while(!continueChoice);
	}
	
	private int validIntInput() {
		boolean correctInput = false;
		int choice=0;
		do {
			try {
				choice = input.nextInt();
				correctInput = true;
			}
			catch(InputMismatchException ex) {
				System.out.println("Try again. (" + "Incorrect input:  an integer is required)");
				input.nextLine(); // discard input
			}
		}while(!correctInput);
		
		return choice;
	}
}
